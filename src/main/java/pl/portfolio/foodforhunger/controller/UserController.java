package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

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

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable Long id, Model model) {
        User user = userService.findOne(id);
        List<Dish> userDishes = dishService.findAllByUserId(id);
        List<Comment> commentsAboutUser = commentService.findAllByReceiverId(id);

        model.addAttribute("commentsAboutUser", commentsAboutUser);
        model.addAttribute("userDishes", userDishes);
        model.addAttribute("user", user);
        return "/user/profile";
    }

}
