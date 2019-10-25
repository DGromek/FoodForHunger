package pl.portfolio.foodforhunger.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.portfolio.foodforhunger.entity.Role;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.RoleRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;
import pl.portfolio.foodforhunger.service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@Component
public class UserFixture {

    private UserService userService;
    private RoleRepository roleRepository;

    @Autowired
    public UserFixture(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    public void initData() throws IOException {
        User user1 = new User();
        FileInputStream fileInputStream;

        user1.setUsername("KuchcikPL");
        user1.setEmail("SampleMail@sample.net");
        user1.setPassword("12345678");

        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_USER"));

        user1.setRoles(roles);

        fileInputStream = new FileInputStream("src/main/resources/static/placeholders/profile-pic.png");

        user1.setAvatar(fileInputStream.readAllBytes());
        user1.setDescription("Lubię gotować i lubię dobrze zjeść. Chcesz się wymienić? Pisz lub dzwoń! Email: kuchcik@gotowanie.pl Telefon: 133 714 213");

        userService.save(user1);

        User user2 = new User();

        user2.setUsername("Smerf_Łasuch");
        user2.setEmail("SŁacuch@sample.net");
        user2.setPassword("12345678");
        user2.setRoles(roles);

        fileInputStream = new FileInputStream("src/main/resources/static/placeholders/profile-pic-2.jpg");

        user2.setAvatar(fileInputStream.readAllBytes());
        user2.setDescription("Najlepsze jedzenie w całej wiosce smerfów! Chcesz poznać najsmerfniejsze smaki na świecie? Napisz: lasuch@smerf.mem");

        userService.save(user2);
    }
}
