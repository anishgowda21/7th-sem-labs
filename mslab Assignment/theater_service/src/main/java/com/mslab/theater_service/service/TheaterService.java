package com.mslab.theater_service.service;

import com.mslab.theater_service.model.Movie;
import com.mslab.theater_service.model.MovieList;
import com.mslab.theater_service.model.Theater;
import com.mslab.theater_service.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TheaterService(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters(){
        return theaterRepository.findAll();

    }

    public Theater getTheater(String theaterID,Boolean nl){
        if (nl){
            return theaterRepository.findById(theaterID).orElse(null);
        }

        Theater theater= theaterRepository.findById(theaterID).orElse(null);
        MovieList[] runningMovies = restTemplate.getForObject("http://localhost:3003/getMoviesInTheater/"+theater.getTheaterID(),MovieList[].class);
        List<MovieList> movies = Arrays.stream(runningMovies).toList();

        List<MovieList> movieLists = movies.stream().map(
                movie ->{
                    ResponseEntity<Movie> forMovie = restTemplate.getForEntity("http://localhost:3001/getMovie/"+movie.getMovieID()+"?nl=true",Movie.class);
                    Movie mov = forMovie.getBody();
                    movie.setMovie(mov);
                    return movie;
                }
                ).collect(Collectors.toList());
        theater.setMovieLists(movieLists);
        return theater;
    }

    public Theater addTheater(Theater theater){
        String randomMovieID = UUID.randomUUID().toString();
        theater.setTheaterID(randomMovieID);
        return theaterRepository.save(theater);
    }

    public void deleteTheater(String theaterID){
        theaterRepository.deleteById(theaterID);
    }

    public void deleteAllTheaters(){
        theaterRepository.deleteAll();
    }

}
