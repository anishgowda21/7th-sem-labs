package com.mslab.movie_service.model;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Movie {
    @Id
    private String movieID;

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Column
    private String movie_name;
    @Column
    private String language;

    public List<TheaterList> getTheaterLists() {
        return theaterLists;
    }

    public void setTheaterLists(List<TheaterList> theaterLists) {
        this.theaterLists = theaterLists;
    }

    @Transient
    private List<TheaterList> theaterLists = new ArrayList<>();

    public Movie(){}

    public Movie(String movieID, String movie_name, String language,List<TheaterList> theaterLists){
        this.movieID = movieID;
        this.movie_name = movie_name;
        this.language = language;
        this.theaterLists = theaterLists;
    }
}
