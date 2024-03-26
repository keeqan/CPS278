package machine4.example.machine4;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {
    public static void main(String[] args) {
        // Set up 
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Start 
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        // Fetch
        List<PizzaOrder> orders = session.createQuery("from PizzaOrder").getResultList();
        orders.forEach(System.out::println);
        
        // Prompt 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the order ID to delete: ");
        int orderId = scanner.nextInt();
        
        // Fetch and delete 
        PizzaOrder order = session.get(PizzaOrder.class, orderId);
        session.delete(order);
        
        // Commit 
        session.getTransaction().commit();
        session.close();
    }
}
