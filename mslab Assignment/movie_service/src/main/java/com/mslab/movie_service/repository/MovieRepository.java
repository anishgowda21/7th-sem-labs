package com.mslab.movie_service.repository;

import com.mslab.movie_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,String> {

}
