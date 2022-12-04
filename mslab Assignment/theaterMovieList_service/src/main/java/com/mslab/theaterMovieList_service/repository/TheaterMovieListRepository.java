package com.mslab.theaterMovieList_service.repository;

import com.mslab.theaterMovieList_service.model.TheaterMovieList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheaterMovieListRepository extends JpaRepository<TheaterMovieList,String> {

    // Custom finder method to get movie list and theater list

    List<TheaterMovieList> findByMovieID(String movieID);
    List<TheaterMovieList> findByTheaterID(String theaterID);
}
