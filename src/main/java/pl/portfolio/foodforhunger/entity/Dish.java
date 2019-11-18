package pl.portfolio.foodforhunger.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import pl.portfolio.foodforhunger.validator.HouseNumber;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dish")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nie może być puste!")
    private String name;

    @NotEmpty(message = "Nie może być puste!")
    private String description;

    @Column(columnDefinition="MEDIUMBLOB")
    private byte[] dishPicture;

    @NotEmpty(message = "Nie może być puste!")
    private String city;

    @NotEmpty(message = "Nie może być puste!")
    private String street;

    @NotEmpty(message = "Nie może być puste!")
    @HouseNumber
    private String houseNr;

    private Integer flatNumber;

    @NotNull(message = "Nie może byś puste!")
    @Min(0)
    private Double price;

    @NotNull(message = "Nie może byś puste!")
    @Min(0)
    private Integer portionSize;

    @JsonManagedReference
    @ManyToOne
    private User user;


    public Dish() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getDishPicture() {
        return dishPicture;
    }

    public void setDishPicture(byte[] dishPicture) {
        this.dishPicture = dishPicture;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public void setHouseNr(String houseNr) {
        this.houseNr = houseNr;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(Integer portionSize) {
        this.portionSize = portionSize;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}