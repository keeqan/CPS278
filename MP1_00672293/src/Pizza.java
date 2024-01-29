public class Pizza {
    private String size;
    private int numberOfToppings;
    private String[] toppings;

    public Pizza(String size, int numberOfToppings, String[] toppings) {
        this.size = size;
        this.numberOfToppings = numberOfToppings;
        this.toppings = toppings;
    }

    // Getters and Setters
    // Method to format pizza info
    @Override
    public String toString() {
        return size + " " + String.join(" ", toppings);
    }
}
