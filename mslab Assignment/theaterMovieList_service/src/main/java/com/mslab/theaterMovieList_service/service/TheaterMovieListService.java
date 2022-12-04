package com.mslab.theaterMovieList_service.service;


import com.mslab.theaterMovieList_service.model.TheaterMovieList;
import com.mslab.theaterMovieList_service.repository.TheaterMovieListRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TheaterMovieListService {
    private final TheaterMovieListRepository theaterMovieListRepository;

    public TheaterMovieListService(TheaterMovieListRepository theaterMovieListRepository) {
        this.theaterMovieListRepository = theaterMovieListRepository;
    }

    public List<TheaterMovieList> getAllLists(){
        return theaterMovieListRepository.findAll();
    }

    public TheaterMovieList createList(TheaterMovieList theaterMovieList){
        String randomUuid = UUID.randomUUID().toString();
        theaterMovieList.setAssignmentID(randomUuid);
        return theaterMovieListRepository.save(theaterMovieList);
    }

    public List<TheaterMovieList> getMoviesInTheater(String theaterID){
        return theaterMovieListRepository.findByTheaterID(theaterID);
    }

    public List<TheaterMovieList> getRunningTheaterName(String movieID){
        return theaterMovieListRepository.findByMovieID(movieID);
    }
}
