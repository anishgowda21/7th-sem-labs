package com.mslab.theater_service.service;

import com.mslab.theater_service.model.Theater;
import com.mslab.theater_service.repository.TheaterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheaterService {
    private final TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    public List<Theater> getAllTheaters(){
        return theaterRepository.findAll();

    }

    public Theater getTheater(String theaterID){
        return theaterRepository.findById(theaterID).orElse(null);
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
