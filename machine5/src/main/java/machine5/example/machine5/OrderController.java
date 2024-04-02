package machine5.example.machine5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers/{customerId}/orders")
public class OrderController {

    private final OrderService orderService;
    private final CustomerService customerService; 

    @Autowired
    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService; 
    }

    
    @GetMapping("/orderlist") 
    public String listOrdersForCustomer(@PathVariable Long customerId, Model model) {
        List<PizzaOrder> orders = orderService.findOrdersByCustomerId(customerId);
        model.addAttribute("orders", orders);
        return "orders/orderlist"; 
    }

    @GetMapping("/form")
    public String showOrderForm(@PathVariable Long customerId, Model model) {
        PizzaOrder order = new PizzaOrder();
        model.addAttribute("order", order);
        return "orders/orderForm"; 
    }

    @PostMapping
    public String saveOrderForCustomer(@PathVariable Long customerId, @Valid @ModelAttribute PizzaOrder order, BindingResult result) {
        if (result.hasErrors()) {
            return "orders/orderForm"; 
        }
        Customer customer = customerService.findCustomerById(customerId);
        order.setCustomer(customer);
        orderService.saveOrder(order);
        return "redirect:/customers/{customerId}/orders"; 
    }

    
}
