package pl.portfolio.foodforhunger.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.portfolio.foodforhunger.dto.RegisterUserDTO;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    public static final int PASSWORD_MINIMUM_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Login nie może być pusty.")
    @Size(min = 5, max = 15, message = "Login musi mieć długość między 5 a 15 znaków.")
//    @UniqueUsername
    private String username;

    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] avatar;

    @NotEmpty(message = "Email nie może być pusty.")
    @Email
    private String email;

    @NotEmpty(message = "Hasło nie może być puste.")
    @Size(min = PASSWORD_MINIMUM_LENGTH, message = "Hasło musi mieć minimum 8 znaków")
    private String password;

    @Column(columnDefinition = "text")
    private String description;
    
    private boolean enabled = false;

    @NotNull
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @JsonBackReference
    @OneToMany(mappedBy = "author")
    private List<Comment> authorComments = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "receiver")
    private List<Comment> receiverComments = new ArrayList<>();

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Dish> dishes = new ArrayList<>();

    public User() {
    }

    public User(RegisterUserDTO validatedUser) {
        this.username = validatedUser.getUsername();
        this.email = validatedUser.getEmail();
        this.password = validatedUser.getPassword();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }
}


