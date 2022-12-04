package com.mslab.movie_service.service;

import com.mslab.movie_service.model.Movie;
import com.mslab.movie_service.model.Theater;
import com.mslab.movie_service.model.TheaterList;
import com.mslab.movie_service.repository.MovieRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private RestTemplate restTemplate;
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovie(String movieId,Boolean nl){

        if (nl){
            return movieRepository.findById(movieId).orElse(null);
        }

        Movie movie = movieRepository.findById(movieId).orElse(null);
        TheaterList[]  runningTheaters = restTemplate.getForObject("http://localhost:3003/getRunningTheaters/"+movie.getMovieID(), TheaterList[].class);

        List<TheaterList> theaters = Arrays.stream(runningTheaters).toList();

        List<TheaterList> theaterLists =  theaters.stream().map(
                theater ->{
                    ResponseEntity<Theater> forTheater = restTemplate.getForEntity("http://localhost:3002/getTheater/"+theater.getTheaterID()+"?nl=true",Theater.class);
                    Theater the = forTheater.getBody();
                    theater.setTheater(the);
                    return theater;
                }
        ).collect(Collectors.toList());

        movie.setTheaterLists(theaterLists);
        return movie;
    }

    public Movie addMovie(Movie movie){
        String randomMovieID = UUID.randomUUID().toString();
        movie.setMovieID(randomMovieID);
        return movieRepository.save(movie);

    }

    public void deleteMovie(String movieId){
        movieRepository.deleteById(movieId);
    }

    public void deleteAllMovie(){
        movieRepository.deleteAll();
    }

}
