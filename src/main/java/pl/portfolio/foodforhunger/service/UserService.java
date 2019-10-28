package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import pl.portfolio.foodforhunger.entity.Role;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.utils.UserDTO;
import pl.portfolio.foodforhunger.repository.RoleRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setEnabled(true);
        user.setRoles(userRoles);
        return userRepository.save(user);
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
