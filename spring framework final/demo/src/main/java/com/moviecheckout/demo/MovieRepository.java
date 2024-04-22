package com.moviecheckout.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//Search Movie Query For Title Or Description

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m WHERE lower(m.title) LIKE lower(concat('%', :searchTerm, '%')) OR lower(m.description) LIKE lower(concat('%', :searchTerm, '%'))")
    List<Movie> findByTitleOrDescriptionContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
