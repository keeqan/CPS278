package com.moviecheckout.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Controller that Handles displaying the movies in Thymeleaf

@Controller
public class ViewController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/customers")
    public String showCustomers(Model model) {
        List<Customer> customers = customerService.findAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @GetMapping("/movies-view")
    public String showMovies(Model model) {
        List<Movie> movies = movieService.findAllMovies();
        model.addAttribute("movies", movies);
        return "movies";
    }
}
