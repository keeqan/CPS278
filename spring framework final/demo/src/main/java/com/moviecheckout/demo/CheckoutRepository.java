package com.moviecheckout.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
    List<Checkout> findByCustomerId(Long customerId);
    List<Checkout> findByMovieId(Long movieId);
}
