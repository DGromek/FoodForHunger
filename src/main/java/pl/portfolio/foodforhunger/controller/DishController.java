package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.service.DishService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

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
