package pl.portfolio.foodforhunger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    String home() {
        return "home/home";
    }

    @GetMapping("/login")
    String login() {
        return "home/login";
    }

    @GetMapping("/register")
    String register() {
        return "home/register";
    }
}
