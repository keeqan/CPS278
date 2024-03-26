package machine4.example.machine4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        // Set up
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Exmaple customers
        Customer customer1 = new Customer("John", "Doe", "123 Main St", "city", "state", "12345");
        Customer customer2 = new Customer("Jane", "Doe", "321 Main St", "city", "state", "54321");

        // Create orders 
        PizzaOrder order1 = new PizzaOrder();
        order1.addPizza(new Pizza("Large", "Cheese"));
        order1.addPizza(new Pizza("Medium", "Pepperoni"));

        // Assign orders
        customer1.addOrder(order1);

        // Create order 
        PizzaOrder order2 = new PizzaOrder();
        order2.addPizza(new Pizza("Small", "Mushroom"));

        // Assign order 
        customer2.addOrder(order2);

        // Open 
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            // Begin transaction
            transaction = session.beginTransaction();

            // Save the customers 
            session.save(customer1);
            session.save(customer2);

            // Commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
            factory.close();
        }
    }
}
