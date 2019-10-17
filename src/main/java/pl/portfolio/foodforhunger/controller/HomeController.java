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
import pl.portfolio.foodforhunger.repository.UserRepository;
import pl.portfolio.foodforhunger.service.LoginService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private UserRepository userRepository;
    private LoginService loginService;

    @Autowired
    public HomeController(UserRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
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
    public String login(HttpSession session, @RequestParam("login") String login, @RequestParam("password") String password) {
        User user = loginService.userAutentication(login, password);

        if (user != null) {
            session.setAttribute("loggedUser", user);
            session.removeAttribute("err");
            return "redirect:/home";
        }
        session.setAttribute("err", "err");
        return "/login";
    }

    @GetMapping("/register")
    String register(Model model) {
        model.addAttribute("user", new User());
        return "home/register";
    }

    @PostMapping("/register")
    public String add(@Valid User user, BindingResult errors) {
        if (errors.hasErrors()) {
            return "home/register";
        }
        userRepository.save(user);
        return "redirect:/home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("loggedUser");
        return "redirect:/home";
    }
}
