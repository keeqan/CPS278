package machine4.example.machine4;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
    public static void main(String[] args) {
        // Set up Hibernate session factory
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); 
        SessionFactory factory = cfg.buildSessionFactory();
        
        // Start 
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        // Fetch 
        List<Customer> customers = session.createQuery("from Customer").getResultList();
        customers.forEach(System.out::println);
        
        // Prompt 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the customer ID to fetch orders: ");
        int customerId = scanner.nextInt();
        
        // Fetch and print 
        Customer customer = session.get(Customer.class, customerId);
        System.out.println("Orders for customer: " + customer);
        customer.getOrders().forEach(System.out::println);
        
        // Commit 
        session.getTransaction().commit();
        session.close();
    }
}
