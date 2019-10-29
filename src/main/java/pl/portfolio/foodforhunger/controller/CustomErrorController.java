package pl.portfolio.foodforhunger.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletResponse response) {
        switch(response.getStatus()) {
            case 404:
                return "error/404";
            case 403:
                return "error/403";
            case 500:
                return "error/500";
        }
        return "error/default";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
