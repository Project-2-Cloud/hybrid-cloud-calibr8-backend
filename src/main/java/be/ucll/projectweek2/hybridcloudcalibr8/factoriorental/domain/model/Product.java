package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "description can't be empty")
    private String title;

    @NotBlank(message = "description can't be empty")
    private String description;

    @NotBlank(message = "thumbnail_url can't be empty")
    private String thumbnail_url;

    @NotNull(message = "Price can't be null")
    @PositiveOrZero(message = "Price should not be negative")
    private Float price;

    @ManyToMany
    private Set<Order> orderList;

    public Product() {

    }

    public Product(Long id, String title, String description, String thumbnail_url, float price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnail_url = thumbnail_url;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Set<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(Set<Order> orderList) {
        this.orderList = orderList;
    }
}
