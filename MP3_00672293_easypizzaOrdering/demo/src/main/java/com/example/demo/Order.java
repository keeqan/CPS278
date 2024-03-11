package com.example.demo;

public class Order {
    private Customer customer;
    private Pizza[] pizzas;

    public Order(Customer customer, Pizza[] pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    // Getter for the customer property
    public Customer getCustomer() {
        return customer;
    }

    // Getter for the pizzas property
    public Pizza[] getPizzas() {
        return pizzas;
    }

    // Optional: Consider removing this method if not used
    // Or modifying it to return a String instead of printing directly
    public void displayOrder() {
        System.out.println("Order Confirmation:");
        System.out.println("Customer [name=" + customer.getName() + ", address=" + customer.getAddress() + "]");
        System.out.println(pizzas.length + " pizza/s:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
    }
}
