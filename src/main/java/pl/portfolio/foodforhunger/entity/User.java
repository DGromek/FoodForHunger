package pl.portfolio.foodforhunger.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

@Entity
@Table(name = "user")
public class User {

    static final int PASSWORD_MINIMUM_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Login nie może być pusty.")
    @Size(min = 5, max = 15, message = "Login musi mieć długość między 5 a 15 znaków.")
    @Column(unique=true)
    private String login;

    @Column(columnDefinition = "BLOB")
    private byte[] avatar;

    @NotEmpty(message = "Email nie może być pusty.")
    @Email
    @Column(unique=true)
    private String email;

    @NotEmpty(message = "Hasło nie może być puste.")
    @Size(min = PASSWORD_MINIMUM_LENGTH, message = "Hasło musi mieć minimum 8 znaków")
    private String password;

    @Column(columnDefinition = "text")
    private String description;


    @OneToMany(mappedBy = "author")
    private List<Comment> authorComments = new ArrayList<>();

    @OneToMany(mappedBy = "receiver")
    private List<Comment> receiverComments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Dish> dishes = new ArrayList<>();

    public User() {
    }

    public User(UserDTO validatedUser) {
        this.login = validatedUser.getLogin();
        this.email = validatedUser.getEmail();
        this.password = validatedUser.getPassword();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Comment> getAuthorComments() {
        return authorComments;
    }

    public void setAuthorComments(List<Comment> authorComments) {
        this.authorComments = authorComments;
    }

    public List<Comment> getReceiverComments() {
        return receiverComments;
    }

    public void setReceiverComments(List<Comment> receiverComments) {
        this.receiverComments = receiverComments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public void encodePassword() {
        this.password = hashpw(password, gensalt());
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
