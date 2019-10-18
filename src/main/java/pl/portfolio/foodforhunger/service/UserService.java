package pl.portfolio.foodforhunger.service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.entity.UserDTO;
import pl.portfolio.foodforhunger.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User userAuthentication(String login, String password) {
        User user = userRepository.findByLogin(login);

        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            return null;
        } else {
            return user;
        }
    }

    public boolean isRegistrationSuccessful(UserDTO userToRegister, BindingResult errors) {
        boolean isOk = true;

        if (!userToRegister.isAccepted()) {
            errors.rejectValue("accepted", "error.userToRegister", "Musisz zaakceptować warunki użytkowania serwisu.");
            isOk = false;
        }

        if (!userToRegister.getPassword().equals(userToRegister.getRepeatedPassword())) {
            errors.rejectValue("repeatedPassword", "error.userToRegister", "Hasła różnią się.");
            isOk = false;
        }

        return isOk && !errors.hasErrors();
    }
}
