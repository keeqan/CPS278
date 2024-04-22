package com.moviecheckout.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller that Handles displaying the movies in Thymeleaf

@Controller
@RequestMapping("/movies")
public class MovieViewController {
    private final MovieService movieService;

    public MovieViewController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.findAllMovies());
        return "movies";  
    }

    @PostMapping
    public String addMovie(Movie movie) {
        movieService.saveMovie(movie);
        return "redirect:/movies";  
    }
}
