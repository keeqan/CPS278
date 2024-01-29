public class Order {
    private Customer customer;
    private Pizza[] pizzas;

    public Order(Customer customer, Pizza[] pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
    }

    // Method to display order
    public void displayOrder() {
        System.out.println("Order Confirmation:");
        System.out.println("Customer [name=" + customer.getName() + ", address=" + customer.getAddress() + "]");
        System.out.println(pizzas.length + " pizza/s:");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
    }
}