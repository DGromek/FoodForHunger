package pl.portfolio.foodforhunger.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

import static org.mindrot.jbcrypt.BCrypt.gensalt;
import static org.mindrot.jbcrypt.BCrypt.hashpw;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 15)
    @Column(unique=true)
    private String login;

    @Column(columnDefinition = "BLOB")
    private byte[] avatar;

    @NotEmpty
    @Email
    @Column(unique=true)
    private String email;

    @NotEmpty
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
        this.password = hashpw(password, gensalt());
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }
}
