package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.service.DishService;
import pl.portfolio.foodforhunger.utils.PageOfRows;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/dish")
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @RequestMapping("/details/{id}")
    public String details(Model model, @PathVariable Long id) {
        Dish dish = dishService.getOne(id);
        model.addAttribute("dish", dish);
        return "dish/details";
    }

    @RequestMapping("/browser/{dishPageIdx}")
    public String browser(Model model, @PathVariable int dishPageIdx) {
        Page<Dish> dishPage = dishService.findAll(dishPageIdx, 9);
        PageOfRows<Dish> dishPageOfRows = new PageOfRows<>(dishPage, 3);

        model.addAttribute("dishPage", dishPageOfRows);
        return "dish/browser";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Principal principal) {
        Dish dishToDelete = dishService.getOne(id);
        String loggedUserName = principal.getName();

        if (loggedUserName.equals(dishToDelete.getUser().getUsername())) {
            dishService.delete(dishService.getOne(id));
            return "/user/profile/" + principal.getName();
        }

        return "/403";
    }

    //Method to get image of dish from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        Dish dish = dishService.getOne(id);
        byte[] dishPicture = dish.getDishPicture();

        //If user doesn't have dishPicture insert placeholder.
        if (dishPicture == null) {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/placeholders/placeholder-dish.png");
            dishPicture = fileInputStream.readAllBytes();
        }

        response.getOutputStream().write(dishPicture);
    }
}
