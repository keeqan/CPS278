package machine5.example.machine5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/customers/{customerId}/orders")
public class OrderRestController {

    private final OrderService orderService;
    private final CustomerService customerService;

    @Autowired
    public OrderRestController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    // List orders for a customer
    @GetMapping
    public ResponseEntity<List<PizzaOrder>> listOrdersForCustomer(@PathVariable Long customerId) {
        if(!customerService.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }
        List<PizzaOrder> orders = orderService.findOrdersByCustomerId(customerId);
        return ResponseEntity.ok(orders);
    }

    // Get a single order
    @GetMapping("/{orderId}")
    public ResponseEntity<PizzaOrder> getOrderById(@PathVariable Long customerId, @PathVariable Long orderId) {
        if(!customerService.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }
        return orderService.findOrderById(orderId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new order for a customer
    @PostMapping
public ResponseEntity<PizzaOrder> createOrder(@PathVariable Long customerId, @RequestBody PizzaOrder order) {
    return customerService.findCustomerById(customerId).map(customer -> {
        order.setCustomer(customer);
        PizzaOrder savedOrder = orderService.saveOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }).orElse(ResponseEntity.notFound().build());
}
// Method inside OrderRestController

// List all orders in the system
@GetMapping("/all")
public ResponseEntity<List<PizzaOrder>> listAllOrders() {
    List<PizzaOrder> orders = orderService.findAllOrders();
    if(orders.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(orders);
}


    // Update, Delete endpoints for orders can be added here, following similar patterns
}
