package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.service.DishService;
import pl.portfolio.foodforhunger.utils.PageOfRows;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
            dishService.delete(dishToDelete);
            return "redirect:/user/profile/" + principal.getName() + "/0/0";
        }
        return "/403";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("dishToAdd", new Dish());
        return "/dish/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam("dishPhoto") MultipartFile dishPhoto, @Valid @ModelAttribute("dishToAdd") Dish dishToAdd, BindingResult errors, Principal principal) throws IOException {
        String loggedUserUsername = principal.getName();
        if (errors.hasErrors()) {
            return "/dish/add";
        }
        dishService.save(dishToAdd, dishPhoto, loggedUserUsername);
        return "redirect:/user/profile/" + loggedUserUsername + "/0/0";
    }

    //Method to get image of dish from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        byte[] dishPicture = dishService.getDishPictureByDishId(id);
        response.getOutputStream().write(dishPicture);
    }
}
