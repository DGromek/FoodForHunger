package pl.portfolio.foodforhunger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import pl.portfolio.foodforhunger.dto.UpdateUserDTO;
import pl.portfolio.foodforhunger.entity.Role;
import pl.portfolio.foodforhunger.entity.User;
import pl.portfolio.foodforhunger.dto.RegisterUserDTO;
import pl.portfolio.foodforhunger.repository.RoleRepository;
import pl.portfolio.foodforhunger.repository.UserRepository;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
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

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
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

    public User update(User user, UpdateUserDTO updateUserDTO, MultipartFile avatar) throws IOException {
        String newPassword = updateUserDTO.getNewPassword();
        if (newPassword != null && !"".equals(newPassword)) {
            user.setPassword((passwordEncoder.encode(newPassword)));
        }
        user.setEmail(updateUserDTO.getEmail());
        user.setDescription(updateUserDTO.getDescription());
        if (!avatar.isEmpty()) {
            user.setAvatar(avatar.getBytes());
        }
        return userRepository.save(user);
    }

    public boolean isRegistrationSuccessful(RegisterUserDTO userToRegister, BindingResult errors) {
        if (!userToRegister.getPassword().equals(userToRegister.getRepeatedPassword())) {
            errors.rejectValue("repeatedPassword", "error.userToRegister", "Hasła różnią się.");
        }

        return !errors.hasErrors();
    }

    public boolean isUpdateSuccessful(User loggedUser, UpdateUserDTO updateUserDTO, BindingResult errors) {
        String oldPassword = updateUserDTO.getOldPassword();
        boolean areTheSame = false;
        boolean isCorrectLength = false;

        //Check if password and repeated password are the same.
        if (!updateUserDTO.getNewPassword().equals(updateUserDTO.getNewPasswordRepeated())) {
            errors.rejectValue("newPasswordRepeated", "error.updateUserDTO", "Hasła różnią się!");
        } else {
            areTheSame = true;
        }

        //Check if new password has correct length.
        String newPassword = updateUserDTO.getNewPassword();
        boolean isGiven = "".equals(newPassword);
        if (!isGiven && newPassword.length() < 8) {
            errors.rejectValue("newPassword", "error.updateUserDTO", "Hasło musi mieć minimum 8 znaków długości!");
        } else {
            isCorrectLength = true;
        }

        //If user doesn't want to change password ignore if there is anything.
        if (!"".equals(oldPassword) || (!isGiven && areTheSame && isCorrectLength)) {
            String loggedUserPassword = loggedUser.getPassword();
            if (!passwordEncoder.matches(oldPassword,loggedUserPassword)) { //But given password doesn't match
                errors.rejectValue("oldPassword", "error.updateUserDTO", "Stare hasło jest niepoprawne!");
            }
            if (passwordEncoder.matches(newPassword, loggedUserPassword)) { //Check if user didn't give same password as new one.
                errors.rejectValue("newPassword", "error.updateUserDTO", "Nowe hasło jest takie samo jak stare!");
            }
        }

        return !errors.hasErrors();
    }

    public byte[] getUserAvatarByUserId(long id) throws IOException {
        User user = getOne(id);
        byte[] avatar = user.getAvatar();

        //If user doesn't have avatar insert placeholder.
        if (avatar == null) {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/static/placeholders/placeholder.png");
            avatar = fileInputStream.readAllBytes();
        }
        return avatar;
    }
}
