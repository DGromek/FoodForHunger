package pl.portfolio.foodforhunger.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.repository.UserRepository;

@Service
@Transactional
public class LoginService {

    private UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userAutentication(String login, String password) {
        User user = userRepository.findByLogin(login);

        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            return null;
        } else {
            return user;
        }
    }
}
