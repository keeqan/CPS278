package com.moviecheckout.demo;

//Handles transfer data from client and server

public class CheckoutDTO {
    private Long id;
    private String checkoutDate;
    private String returnDate;
    private String movieTitle;
    private String customerName;  


    public CheckoutDTO(Checkout checkout) {
        this.id = checkout.getId();
        this.checkoutDate = checkout.getCheckoutDate().toString();
        this.returnDate = checkout.getReturnDate() == null ? null : checkout.getReturnDate().toString();
        this.movieTitle = checkout.getMovie().getTitle();
        this.customerName = checkout.getCustomer().getName();


        System.out.println("CheckoutDTO movieTitle: " + this.movieTitle); 

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
}
