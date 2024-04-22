package com.moviecheckout.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//Handles creating returning checkouts

@Service
public class CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private CustomerRepository customerRepository;

    private static final Logger logger = LoggerFactory.getLogger(CheckoutService.class);

    public List<Checkout> findAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public List<Checkout> findCheckoutsByCustomerId(Long customerId) {
        return checkoutRepository.findByCustomerId(customerId);
    }

    public Optional<Checkout> findCheckoutById(Long id) {
        return checkoutRepository.findById(id);
    }

    public ResponseEntity<?> saveCheckout(Long customerId, Long movieId, LocalDate checkoutDate) {
        logger.info("Attempting to create a checkout for customer ID: {} and movie ID: {}", customerId, movieId);

        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        Optional<Movie> movieOpt = movieRepository.findById(movieId);

        if (!customerOpt.isPresent() || !movieOpt.isPresent()) {
            logger.warn("Invalid customer ID: {} or movie ID: {}", customerId, movieId);
            return ResponseEntity.badRequest().body("Invalid customer or movie ID.");
        }

        Movie movie = movieOpt.get();
        if (movie.getAvailableCopies() <= 0) {
            logger.warn("No available copies for movie ID: {}", movieId);
            return ResponseEntity.badRequest().body("No available copies of this movie to checkout.");
        }

        movie.setAvailableCopies(movie.getAvailableCopies() - 1);
        movieRepository.save(movie);

        Checkout checkout = new Checkout();
        checkout.setCustomer(customerOpt.get());
        checkout.setMovie(movie);
        checkout.setCheckoutDate(checkoutDate);

        checkoutRepository.save(checkout);
        logger.info("Checkout saved successfully for movie ID: {}", movie.getId());
        return ResponseEntity.ok("Checkout successful.");
    }

    public ResponseEntity<?> returnMovie(Long id) {
        Optional<Checkout> checkoutOpt = checkoutRepository.findById(id);
        if (checkoutOpt.isPresent()) {
            Checkout checkout = checkoutOpt.get();
            Movie movie = checkout.getMovie();
            movie.setAvailableCopies(movie.getAvailableCopies() + 1);
            movieRepository.save(movie);

            checkoutRepository.deleteById(id);
            logger.info("Returned movie and incremented inventory for movie ID: {}", movie.getId());
            return ResponseEntity.ok().build();
        }

        logger.warn("Failed to find checkout ID: {} for return", id);
        return ResponseEntity.notFound().build();
    }
}
