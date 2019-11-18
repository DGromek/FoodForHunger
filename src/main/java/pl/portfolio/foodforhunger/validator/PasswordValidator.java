package pl.portfolio.foodforhunger.validator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import pl.portfolio.foodforhunger.dto.RegisterUserDTO;
import pl.portfolio.foodforhunger.dto.UpdateUserDTO;
import pl.portfolio.foodforhunger.entity.User;

@Component
public class PasswordValidator {

    private final BCryptPasswordEncoder passwordEncoder;

    public PasswordValidator(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //Method checks if fields password and repeated password are the same. If not it adds error to BindingResult.
    public boolean arePasswordsTheSame(RegisterUserDTO userToRegister, BindingResult errors) {
        if (!userToRegister.getPassword().equals(userToRegister.getRepeatedPassword())) {
            errors.rejectValue("repeatedPassword", "error.userToRegister", "Hasła różnią się.");
        }
        return !errors.hasErrors();
    }

    //Method validate password update during editing profile account.
    public boolean isPasswordUpdateSuccessful(User loggedUser, UpdateUserDTO updateUserDTO, BindingResult errors) {
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

}
