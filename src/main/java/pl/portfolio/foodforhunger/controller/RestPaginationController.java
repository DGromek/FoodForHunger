package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.CommentService;
import pl.portfolio.foodforhunger.service.DishService;
import pl.portfolio.foodforhunger.service.UserService;
import pl.portfolio.foodforhunger.utils.PageOfRows;

@RestController
@RequestMapping("/rest")
public class RestPaginationController {

    private DishService dishService;
    private CommentService commentService;
    private UserService userService;

    @Autowired
    public RestPaginationController(DishService dishService, CommentService commentService, UserService userService) {
        this.dishService = dishService;
        this.commentService = commentService;
        this.userService = userService;
    }

    @GetMapping("/getProfileDishes/{username}/{pageIdx}")
    public Page<Dish> getProfileDishes(@PathVariable String username, @PathVariable int pageIdx) {
        User user = userService.findByUsername(username);
        return dishService.findAllByUserId(user.getId(), pageIdx, 2);
    }

    @GetMapping("/getProfileComments/{username}/{pageIdx}")
    public Page<Comment> getProfileComments(@PathVariable String username, @PathVariable int pageIdx) {
        User user = userService.findByUsername(username);
//        Page<Comment> commentPage = commentService.findAllByReceiverIdOrderByCreatedDesc(user.getId(), pageIdx, 4);
//        return new PageOfRows<>(commentPage, 2);
        return commentService.findAllByReceiverIdOrderByCreatedDesc(user.getId(), pageIdx, 4);
    }
}
