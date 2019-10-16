package pl.portfolio.foodforhunger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.UserRepository;

import java.io.FileInputStream;
import java.io.IOException;


@Component
public class UserFixture {

    private UserRepository userRepository;

    @Autowired
    public UserFixture(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void initData() throws IOException {
        User user1 = new User();
        FileInputStream fileInputStream;

        user1.setLogin("KuchcikPL");
        user1.setEmail("SampleMail@sample.net");
        user1.setPassword("1234567");

        fileInputStream = new FileInputStream("C:\\Users\\A754379\\Desktop\\FoodForHunger\\src\\main\\resources\\static\\placeholders\\profile-pic.png");

        user1.setAvatar(fileInputStream.readAllBytes());
        user1.setDescription("Lubię gotować i lubię dobrze zjeść. Chcesz się wymienić? Pisz lub dzwoń! Email: kuchcik@gotowanie.pl Telefon: 133 714 213");

        userRepository.save(user1);

        User user2 = new User();

        user2.setLogin("Smerf_Łasuch");
        user2.setEmail("SŁacuch@sample.net");
        user2.setPassword("1234567");

        fileInputStream = new FileInputStream("C:\\Users\\A754379\\Desktop\\FoodForHunger\\src\\main\\resources\\static\\placeholders\\profile-pic-2.jpg");

        user2.setAvatar(fileInputStream.readAllBytes());
        user2.setDescription("Najlepsze jedzenie w całej wiosce smerfów! Chcesz poznać najsmerfniejsze smaki na świecie? Napisz: lasuch@smerf.mem");

        userRepository.save(user2);
    }
}
