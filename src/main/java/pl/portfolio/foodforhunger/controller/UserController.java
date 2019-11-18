package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.dto.UpdateUserDTO;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.UserService;
import pl.portfolio.foodforhunger.validator.PasswordValidator;

import javax.persistence.Table;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private PasswordValidator passwordValidator;

    @Autowired
    public UserController(UserService userService, PasswordValidator passwordValidator) {
        this.userService = userService;
        this.passwordValidator = passwordValidator;
    }

    @GetMapping("/profile/{username}")
    public String profile(@PathVariable String username, Model model) {
        User user = userService.findByUsername(username);

        if (user == null) {
            return "/error/404";
        }

        model.addAttribute("user", user);
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

        if (!passwordValidator.isPasswordUpdateSuccessful(loggedUser, updateUserDTO, errors)) {
            return "/user/update";
        }

        userService.update(loggedUser, updateUserDTO, avatar);
        return "redirect:/user/profile/" + principal.getName();
    }

    //Method to get avatar from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        byte[] avatar = userService.getUserAvatarByUserId(id);
        response.getOutputStream().write(avatar);
    }
}
