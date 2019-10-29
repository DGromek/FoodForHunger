package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.DishRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Transactional
public class DishService {

    private DishRepository dishRepository;
    private UserRepository userRepository;

    @Autowired
    public DishService(DishRepository dishRepository, UserRepository userRepository) {
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
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

    public Dish save(Dish dishToSave, MultipartFile dishPhoto, String authorUsername) throws IOException {
        if (!dishPhoto.isEmpty()) {
            //String[] getFileType = dishPhoto.getName().split("\\.");
            //if ("jpg".equals(getFileType[1]) || "png".equals(getFileType[1]) || "jpeg".equals(getFileType[1])) {
                dishToSave.setDishPicture(dishPhoto.getBytes());
            //}
        }
        dishToSave.setUser(userRepository.findByUsername(authorUsername));
        dishRepository.save(dishToSave);
        return dishToSave;
    }

    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    //Pagination
    public Page<Dish> findAllByUserId(Long userId, int pageId,  int size) {
        return dishRepository.findAllByUserId(userId, PageRequest.of(pageId, size));
    }

    public Page<Dish> findAll(int pageId, int size) { return dishRepository.findAll(PageRequest.of(pageId, size)); }


    public List<Dish> findAllByCity(String city) {
        return dishRepository.findAllByCity(city);
    }

    public List<String> findAllCities() {
        return dishRepository.findAllCities();
    }

    public byte[] getDishPictureByDishId(long id) throws IOException {
        Dish dish = getOne(id);
        byte[] dishPicture = dish.getDishPicture();

        //If user doesn't have dishPicture insert placeholder.
        if (dishPicture == null) {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/placeholders/placeholder-dish.png");
            dishPicture = fileInputStream.readAllBytes();
        }
        return dishPicture;
    }
}
