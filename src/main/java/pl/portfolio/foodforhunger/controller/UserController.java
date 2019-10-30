package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.dto.UpdateUserDTO;
import pl.portfolio.foodforhunger.entity.Comment;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.CommentService;
import pl.portfolio.foodforhunger.service.DishService;
import pl.portfolio.foodforhunger.service.UserService;
import pl.portfolio.foodforhunger.utils.PageOfRows;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


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

        if (user == null) {
            return "/error/404";
        }

        Page<Dish> dishPage = dishService.findAllByUserId(user.getId(), dishPageIdx, 2);
        Page<Comment> commentPage = commentService.findAllByReceiverId(user.getId(), commentPageIdx, 4);
        PageOfRows<Comment> commentPageOfRows = new PageOfRows<>(commentPage, 2);

        model.addAttribute("user", user);
        model.addAttribute("dishPage", dishPage);
        model.addAttribute("commentPage", commentPageOfRows);
        return "/user/profile";
    }

    @GetMapping("/update")
    public String update(Principal principal, Model model) {
        User loggedUser = userService.findByUsername(principal.getName());
        UpdateUserDTO updateUserDTO = new UpdateUserDTO(loggedUser);
        model.addAttribute("updateUserDTO", updateUserDTO);
        return "/user/update";
    }

    @PostMapping("/update")
    public String update(Principal principal, @Valid @ModelAttribute("updateUserDTO") UpdateUserDTO updateUserDTO, @RequestParam("avatar") MultipartFile avatar, BindingResult errors) throws IOException {
        User loggedUser = userService.findByUsername(principal.getName());

        if (!userService.isUpdateSuccessful(loggedUser, updateUserDTO, errors )) {
            return "/user/update";
        }

        userService.update(loggedUser, updateUserDTO, avatar);
        return "redirect:/user/profile/" + principal.getName() + "/0/0";
    }

    //Method to get avatar from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        byte[] avatar = userService.getUserAvatarByUserId(id);
        response.getOutputStream().write(avatar);
    }
}
