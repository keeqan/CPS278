package machine4.example.machine4;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "size")
    private String size;

    @Column(name = "topping")
    private String topping;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "order_id")
    private PizzaOrder pizzaOrder;

    public Pizza() {
    }

    public Pizza(String size, String topping) {
        this.size = size;
        this.topping = topping;
    }

    // Getters and Setters 

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getSize() {
    return size;
}

public void setSize(String size) {
    this.size = size;
}

public String getTopping() {
    return topping;
}

public void setTopping(String topping) {
    this.topping = topping;
}

public PizzaOrder getPizzaOrder() {
    return pizzaOrder;
}

public void setPizzaOrder(PizzaOrder pizzaOrder) {
    this.pizzaOrder = pizzaOrder;
}


}
