package machine5.example.machine5;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String size;
    
    @ElementCollection
    private List<String> toppings;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private PizzaOrder order;
    
    // Constructors
public Pizza() {}

public Pizza(String size, List<String> toppings) {
    this.size = size;
    this.toppings = toppings;
}

// Getters and Setters
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getSize() {
    return size;
}

public void setSize(String size) {
    this.size = size;
}

public List<String> getToppings() {
    return toppings;
}

public void setToppings(List<String> toppings) {
    this.toppings = toppings;
}

public PizzaOrder getOrder() {
    return order;
}

public void setOrder(PizzaOrder order) {
    this.order = order;
}

}

