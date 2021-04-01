package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotNull
    @Positive
    private Integer houseNumber;

    @NotBlank
    private String streetName;

    @NotBlank
    private String city;

    @NotBlank
    private String country;

    @OneToMany(mappedBy = "customer")
    private Set<ProductOrder> productOrders;

    @NotNull
    private Role role;

    public Customer() {

    }

    public Customer(String email, String firstName, String lastName, Integer houseNumber, String streetName, String city, String country, Role role) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.role = role;
    }

    public String getId() {
        return getEmail();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<ProductOrder> getOrders() {
        return productOrders;
    }

    public void setOrders(Set<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }
}
