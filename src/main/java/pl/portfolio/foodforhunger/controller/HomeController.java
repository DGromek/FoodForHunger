package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.portfolio.foodforhunger.dto.RegisterUserDTO;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.UserService;

import javax.validation.Valid;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("userToRegister", new RegisterUserDTO());
        return "home/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userToRegister") RegisterUserDTO userToRegister, BindingResult errors) {
        userService.arePasswordsTheSame(userToRegister, errors);
        User user = new User(userToRegister);

        try {
            userService.save(user);
        } catch (DataIntegrityViolationException err) {
            if (err.getLocalizedMessage().contains("UC_email")) {
                errors.rejectValue("email", "error.userToRegister", "Na ten email jest juz zarejestrowane konto!");
            } else {
                errors.rejectValue("username", "error.userToRegister", "Użytkownik o takim loginie już istnieje!");
            }
        }

        if (errors.hasErrors()) {
            return "home/register";
        }
        return "redirect:/";
    }

}