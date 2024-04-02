    package machine5.example.machine5;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    import machine5.example.machine5.PizzaOrder; 

    @Repository
    public interface OrderRepository extends JpaRepository<PizzaOrder, Long> {

        List<PizzaOrder> findByCustomerId(Long customerId);
    }
