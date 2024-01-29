import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Customer Information
        System.out.println("Please enter your information");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();

        // Address Information
        System.out.print("Please enter the street: ");
        String street = scanner.nextLine();
        System.out.print("Please enter city: ");
        String city = scanner.nextLine();
        System.out.print("Please enter state: ");
        String state = scanner.nextLine();
        System.out.print("Please enter zip code: ");
        String zip = scanner.nextLine();

        Customer customer = new Customer(name, new Address(street, city, state, zip));

        // Pizza Order
        System.out.print("How many pizzas do you want to order? ");
        int numberOfPizzas = Integer.parseInt(scanner.nextLine());
        Pizza[] pizzas = new Pizza[numberOfPizzas];

        for (int i = 0; i < numberOfPizzas; i++) {
            System.out.println("Info for pizza-" + (i + 1));

            System.out.print("Please enter the size (S, M, L): ");
            String size = scanner.nextLine();

            System.out.print("Please enter the number of toppings: ");
            int numberOfToppings = Integer.parseInt(scanner.nextLine());

            String[] toppings = new String[numberOfToppings];
            System.out.println("Choices are: Mushroom, Pineapple, Zucchini, Tomato, Spinach, Artichoke");
            for (int j = 0; j < numberOfToppings; j++) {
                System.out.print("Choose topping-" + (j + 1) + ": ");
                toppings[j] = scanner.nextLine();
            }

            pizzas[i] = new Pizza(size, numberOfToppings, toppings);
        }

        // Creating order
        Order order = new Order(customer, pizzas);

        // Displaying order confirmation
        order.displayOrder();

        scanner.close();
    }
}