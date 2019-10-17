package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.CommentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> findAllByReceiverId(Long id) {
        return commentRepository.findAllByReceiverId(id);
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment getOne(Long id) {
        return commentRepository.getOne(id);
    }

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    //Pagination
    public Page<Comment> getPageOfResults(int id, int size) {
        return commentRepository.findAll(PageRequest.of(id, size));
    }

    public boolean isAuthor(Comment commentToDelete, User loggedUser) {
        if (loggedUser.getId().equals(commentToDelete.getAuthor().getId())) {
            return true;
        } else {
            return false;
        }
    }
}
