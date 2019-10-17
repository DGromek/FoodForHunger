package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.DishRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DishService {

    private DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> findAllByUserId(Long id) {
        return dishRepository.findAllByUserId(id);
    }

    public Dish getOne(Long id) {
        return dishRepository.getOne(id);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    public boolean isOwner(Dish dish, User loggedUser) {
        if (loggedUser.getId().equals(dish.getUser().getId())) {
            return true;
        } else {
            return false;
        }
    }

    public List<Dish> findAllByCity(String city) {
        return dishRepository.findAllByCity(city);
    }

    public List<String> findAllCities() {
        return dishRepository.findAllCities();
    }
}
