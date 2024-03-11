package com.example.demo;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNumberOfToppings() {
        return numberOfToppings;
    }

    public void setNumberOfToppings(int numberOfToppings) {
        this.numberOfToppings = numberOfToppings;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    // Method to format pizza info
    @Override
    public String toString() {
        return size + " " + String.join(" ", toppings);
    }
}
