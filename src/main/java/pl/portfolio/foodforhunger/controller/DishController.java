package pl.portfolio.foodforhunger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.service.DishService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

    @RequestMapping("/browser")
    public String browser() {
        return "dish/browser";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Principal principal) {
        Dish dishToDelete = dishService.getOne(id);
        String loggedUserName = principal.getName();

        if (loggedUserName.equals(dishToDelete.getUser().getUsername())) {
            dishService.delete(dishToDelete);
            return "redirect:/user/profile/" + principal.getName();
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
        return "redirect:/user/profile/" + loggedUserUsername;
    }

    @GetMapping("/update/{dishIdx}")
    public String update(Principal principal, Model model, @PathVariable Long dishIdx) {
        Dish dishToUpdate = dishService.getOne(dishIdx);

        if (!principal.getName().equals(dishToUpdate.getUser().getUsername())) {
            return "error/403";
        }

        model.addAttribute("dishToUpdate", dishToUpdate);
        return "dish/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam("dishPhoto") MultipartFile dishPhoto, @Valid @ModelAttribute("dishToUpdate") Dish dishToUpdate, BindingResult errors, Principal principal) throws IOException {
        if (errors.hasErrors()) {
            return "/dish/update/" + dishToUpdate.getId();
        }
        dishService.save(dishToUpdate, dishPhoto);
        return "redirect:/user/profile/" + principal.getName();
    }

    //Method to get image of dish from DB
    @GetMapping("/getImage/{id}")
    public void getImage(@PathVariable long id, HttpServletResponse response) throws IOException {
        byte[] dishPicture = dishService.getDishPictureByDishId(id);
        response.getOutputStream().write(dishPicture);
    }
}
