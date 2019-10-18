package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.entity.UserDTO;
import pl.portfolio.foodforhunger.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/home")
    String home() {
        return "home/home";
    }

    @GetMapping("/login")
    String login() {
        return "home/login";
    }

    @PostMapping("/login")
    public String login(Model model, HttpSession session, @RequestParam("login") String login, @RequestParam("password") String password) {
        User user = userService.userAuthentication(login, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            return "redirect:/home";
        }
        model.addAttribute("err", true);
        return "home/login";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("userToRegister", new UserDTO());
        return "home/register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDTO userToRegister, BindingResult errors) {

        if (!userService.isRegistrationSuccessful(userToRegister, errors)) {
            return "home/register";
        }

        User user = new User(userToRegister);
        user.encodePassword();
        userService.save(user);
        return "redirect:/home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedUser");
        return "redirect:/home";
    }
}
