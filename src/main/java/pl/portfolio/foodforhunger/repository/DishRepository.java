package pl.portfolio.foodforhunger.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.entity.Dish;

import java.util.List;

@Repository
@Transactional
public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByUserId(Long userId);
    List<Dish> findAllByCity(String city);

    @Query("Select distinct d.city from Dish d")
    List<String> findAllCities();

//    List<Dish> findAllOrderByIdAsc();

//    List<Dish> findAllOrOrderByCity();
//    List<Dish> findAllByOrderByCityDesc();
}
