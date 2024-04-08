package machine5.example.machine5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<PizzaOrder> findAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<PizzaOrder> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<PizzaOrder> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public PizzaOrder saveOrder(PizzaOrder order) {
        return orderRepository.save(order);
    }

    public PizzaOrder updateOrder(Long orderId, PizzaOrder orderDetails) {
        return orderRepository.findById(orderId).map(order -> {
            // Assume you have setters in your PizzaOrder for updating fields
            // Example: order.setField(orderDetails.getField());
            // Update necessary fields from orderDetails
            return orderRepository.save(order);
        }).orElse(null); // Or throw a custom NotFoundException
    }

    public boolean deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return true;
        }
        return false; // Or throw a custom NotFoundException
    }
}
