package pl.portfolio.foodforhunger.utils;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import static pl.portfolio.foodforhunger.entity.User.PASSWORD_MINIMUM_LENGTH;

public class UserDTO {

    @NotEmpty(message = "Login nie może być pusty.")
    @Size(min = 5, max = 15, message = "Login musi mieć długość między 5 a 15 znaków.")
    //@Column(unique=true)
    private String username;

    @NotEmpty(message = "Email nie może być pusty.")
    @Email
    //@Column(unique=true)
    private String email;

    @NotEmpty(message = "Hasło nie może być puste.")
    @Size(min = PASSWORD_MINIMUM_LENGTH, message = "Hasło musi mieć minimum 8 znaków")
    private String password;

    private String repeatedPassword;

    private boolean accepted;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public UserDTO() {
    }
}
