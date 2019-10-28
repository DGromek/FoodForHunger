package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.CommentService;
import pl.portfolio.foodforhunger.service.DishService;
import pl.portfolio.foodforhunger.service.UserService;
import pl.portfolio.foodforhunger.utils.PageOfRows;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private DishService dishService;
    private CommentService commentService;

    @Autowired
    public UserController(UserService userService, DishService dishService, CommentService commentService) {
        this.userService = userService;
        this.dishService = dishService;
        this.commentService = commentService;
    }

    @GetMapping("/profile/{username}/{dishPageIdx}/{commentPageIdx}")
    public String profile(@PathVariable String username, @PathVariable int dishPageIdx, @PathVariable int commentPageIdx, Model model) {
        User user = userService.findByUsername(username);

        Page<Dish> dishPage = dishService.findAllByUserId(user.getId(), dishPageIdx, 2);
        Page<Comment> commentPage = commentService.findAllByReceiverId(user.getId(), commentPageIdx, 4);
        PageOfRows<Comment> commentPageOfRows = new PageOfRows<>(commentPage, 2);

        model.addAttribute("user", user);
        model.addAttribute("dishPage", dishPage);
        model.addAttribute("commentPage", commentPageOfRows);
        return "/user/profile";
    }

    //Method to get avatar from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        User user = userService.getOne(id);
        byte[] avatar = user.getAvatar();

        //If user doesn't have avatar insert placeholder.
        if (avatar == null) {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/placeholders/placeholder.png");
            avatar = fileInputStream.readAllBytes();
        }

        response.getOutputStream().write(avatar);
    }
}
