package machine5.example.machine5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PizzaOrder findOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<PizzaOrder> findOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public PizzaOrder saveOrder(PizzaOrder order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
