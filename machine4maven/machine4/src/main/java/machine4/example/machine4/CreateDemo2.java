package machine4.example.machine4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo2 {
    public static void main(String[] args) {
        // Set up
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Start 
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        // Fetch by ID
        int customerId = 1; 
        Customer customer = session.get(Customer.class, customerId);
        
        // Create a new order 
        PizzaOrder newOrder = new PizzaOrder();
        newOrder.addPizza(new Pizza("Small", "Hawaiian"));
        customer.addOrder(newOrder);
        
        // Save
        session.save(newOrder);
        
        // Commit 
        session.getTransaction().commit();
        
        // Close
        session.close();
    }
}
