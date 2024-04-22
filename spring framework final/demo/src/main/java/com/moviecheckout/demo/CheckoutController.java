package com.moviecheckout.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//Rest Controller for handling checkout requests

@RestController
@RequestMapping("/api/checkouts")
public class CheckoutController {

    private static final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping
    public List<Checkout> getAllCheckouts() {   //Checkout List
        return checkoutService.findAllCheckouts();
    }


    @GetMapping("/api/customers/{customerId}/checkouts")
    public ResponseEntity<List<CheckoutDTO>> getCustomerCheckouts(@PathVariable Long customerId) { // Mapping each Checkout to a CheckoutDTO
        List<Checkout> checkouts = checkoutService.findCheckoutsByCustomerId(customerId);
        List<CheckoutDTO> checkoutDTOs = checkouts.stream()
                                                  .map(CheckoutDTO::new) 
                                                  .collect(Collectors.toList());
        return ResponseEntity.ok(checkoutDTOs);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Checkout> getCheckoutById(@PathVariable Long id) { //Checkout by ID
        return checkoutService.findCheckoutById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createCheckout(@RequestBody Checkout checkout) { //creates the checkout
        
        logger.info("Received checkout data: {}", checkout);
        if (checkout.getCustomer() == null || checkout.getMovie() == null || checkout.getCheckoutDate() == null) {
            logger.error("Missing data for checkout: Customer, Movie, or Date is null");
            return ResponseEntity.badRequest().body("Missing data for checkout");
        }
        Long customerId = checkout.getCustomer().getId();
        Long movieId = checkout.getMovie().getId();
        LocalDate checkoutDate = checkout.getCheckoutDate();
        return checkoutService.saveCheckout(customerId, movieId, checkoutDate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> returnMovie(@PathVariable Long id) {
        return checkoutService.returnMovie(id);
    }
}