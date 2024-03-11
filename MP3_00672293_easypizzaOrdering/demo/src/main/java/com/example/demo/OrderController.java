package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@Controller
public class OrderController {

    @GetMapping("/")
    public String showOrderForm(Model model) {
        model.addAttribute("orderForm", new OrderForm());
        return "orderForm"; // Matches the name of the HTML file
    }
    

    @PostMapping("/placeOrder")
    public String placeOrder(@Valid OrderForm orderForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "orderForm";
        }
        // Process the order here
        // For simplicity, directly create an Order object and display it
        Order order = createOrderFromForm(orderForm);
        model.addAttribute("order", order);
        return "orderConfirmation";
    }
    
    // Method to convert OrderForm to Order
    private Order createOrderFromForm(OrderForm orderForm) {
        Address address = new Address(orderForm.getStreet(), orderForm.getCity(), 
                                      orderForm.getState(), orderForm.getZip());
        Customer customer = new Customer(orderForm.getName(), address);
    
        // Assuming orderForm.getToppings() returns a List or Set of toppings
        String[] toppingsArray = orderForm.getToppings().toArray(new String[0]); // Convert toppings to array
    
        Pizza[] pizzas = new Pizza[1]; // Since we're dealing with a single pizza order in this context
        pizzas[0] = new Pizza(orderForm.getSize(), toppingsArray.length, toppingsArray);
    
        return new Order(customer, pizzas);
    }
    
}