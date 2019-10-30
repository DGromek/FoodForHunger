package pl.portfolio.foodforhunger.dto;

import pl.portfolio.foodforhunger.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static pl.portfolio.foodforhunger.entity.User.PASSWORD_MINIMUM_LENGTH;

public class UpdateUserDTO {

    @Email
    @NotEmpty
    private String email;

    private String description;

    private String oldPassword;

    private String newPassword;

    private String newPasswordRepeated;

    public UpdateUserDTO() {
    }

    public UpdateUserDTO(User loggedUser) {
        this.email = loggedUser.getEmail();
        this.description = loggedUser.getDescription();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordRepeated() {
        return newPasswordRepeated;
    }

    public void setNewPasswordRepeated(String newPasswordRepeated) {
        this.newPasswordRepeated = newPasswordRepeated;
    }
}
