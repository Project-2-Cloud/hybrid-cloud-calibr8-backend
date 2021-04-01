package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @PositiveOrZero
    private float totalPrice;

    @NotNull
    @ManyToMany(mappedBy = "productOrderList")
    private Set<Product> products;

    @NotNull
    @ManyToOne
    private Customer customer;

    @NotNull
    private OrderState state;

    @PastOrPresent
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
