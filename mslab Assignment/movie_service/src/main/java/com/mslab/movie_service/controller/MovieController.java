package com.mslab.movie_service.controller;

import com.mslab.movie_service.model.Movie;
import com.mslab.movie_service.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/getMovie/{movieID}")
    public Movie getMovie(@PathVariable String movieID){
        return movieService.getMovie(movieID);
    }

    @PostMapping("/insertMovie")
    public Movie createMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/deleteMovie/{movieID}")
    public String deleteMovie(@PathVariable String movieID){
        movieService.deleteMovie(movieID);
        return "Movie Deleted";
    }

    @DeleteMapping("/deleteAllMovies")
    public String deleteAllMovies(){
        movieService.deleteAllMovie();
        return "All Movies Deleted";
    }
}
