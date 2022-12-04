package com.mslab.theaterMovieList_service.controller;


import com.mslab.theaterMovieList_service.model.TheaterMovieList;
import com.mslab.theaterMovieList_service.service.TheaterMovieListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterMovieListController {
    private final TheaterMovieListService theaterMovieListService;

    public TheaterMovieListController(TheaterMovieListService theaterMovieListService) {
        this.theaterMovieListService = theaterMovieListService;
    }

    @GetMapping("/getAllLists")
    public List<TheaterMovieList> getAllLists(){
        return theaterMovieListService.getAllLists();
    }

    @PostMapping("/addMoviesToTheater")
    public TheaterMovieList addMovieToTheater(@RequestBody TheaterMovieList theaterMovieList){
        return theaterMovieListService.createList(theaterMovieList);
    }

    @GetMapping("/getMoviesInTheater/{theaterID}")
    public List<TheaterMovieList> getMoviesInTheater(@PathVariable String theaterID){
        return theaterMovieListService.getMoviesInTheater(theaterID);
    }

    @GetMapping("/getRunningTheaters/{movieID}")
    public List<TheaterMovieList> getRunningTheaters(@PathVariable String movieID){
        return theaterMovieListService.getRunningTheaterName(movieID);
    }
}
