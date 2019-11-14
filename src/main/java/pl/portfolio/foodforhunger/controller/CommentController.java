package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.foodforhunger.dto.CommentDTO;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.CommentService;
import pl.portfolio.foodforhunger.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;
    private UserService userService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Comment> add(@Valid @RequestBody CommentDTO commentDTO, Principal principal) {
        String authorUsername = principal.getName();
        String receiverUsername = commentDTO.getReceiverUsername();

        User author = userService.findByUsername(authorUsername);
        User receiver = userService.findByUsername(receiverUsername);

        Comment commentToAdd = new Comment(commentDTO, author, receiver);

        return new ResponseEntity<>(commentService.save(commentToAdd), HttpStatus.OK);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<Comment> put(@PathVariable Long idx, @Valid @RequestBody CommentDTO commentDTO, Principal principal) {
        String authorUsername = principal.getName();
        Comment commentToUpdate = commentService.getOne(idx);

        //If someone is trying to edit comment he didn't write we send 403.
        if (!authorUsername.equals(commentToUpdate.getAuthor().getUsername())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        commentToUpdate.setRating(commentDTO.getRating());
        commentToUpdate.setContent(commentDTO.getContent());

        return new ResponseEntity<>(commentService.save(commentToUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<Comment> delete(@PathVariable Long idx, Principal principal) {
        Comment commentToDelete = commentService.getOne(idx);

        //If someone is trying to delete comment he didn't write we send 403.
        if (!principal.getName().equals(commentToDelete.getAuthor().getUsername())) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }

        commentService.delete(commentToDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
