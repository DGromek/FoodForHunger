package pl.portfolio.foodforhunger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.Dish;
import pl.portfolio.foodforhunger.repository.DishRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

@Component
public class DishFixture {

    private DishRepository dishRepository;
    private UserRepository userRepository;

    @Autowired
    public DishFixture(DishRepository dishRepository, UserRepository userRepository) {
        this.dishRepository = dishRepository;
        this.userRepository = userRepository;
    }

    public void initData() {
        Dish dish1 = new Dish();
        dish1.setName("Ośmiorniczki z parówek");
        dish1.setDescription("Niesamowite, jedyne w swoim rodzaju owoce morza na studencką kieszeń!");
        dish1.setPrice(5.5);
        dish1.setCity("Łódź");
        dish1.setStreet("Piłsudskiego");
        dish1.setHouseNr("56");

        dish1.setUser(userRepository.getOne(1L));
        dishRepository.save(dish1);

        Dish dish2 = new Dish();
        dish2.setName("Kurczak Curry");
        dish2.setDescription("Orientalny smak w niewygórowanej cenie. Spróbuj koniecznie! :)");
        dish1.setPrice(10.5);
        dish2.setCity("Gdynia");
        dish2.setStreet("Aleja Armii Krajowej");
        dish2.setHouseNr("13");

        dish2.setUser(userRepository.getOne(1L));
        dishRepository.save(dish2);

        Dish dish3 = new Dish();
        dish3.setName("Makaron z szpinakiem");
        dish3.setDescription("Studencki klasyk w niewygórowanej cenie.");
        dish3.setPrice(4.2);
        dish3.setCity("Łódź");
        dish3.setStreet("Piotrkowska");
        dish3.setHouseNr("23");

        dish3.setUser(userRepository.getOne(2L));
        dishRepository.save(dish3);
    }
}
