package com.mslab.theater_service.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table
@Entity
public class Theater {
    public Theater(String theaterID, String theaterName, String location,List<MovieList> movieLists) {
        this.theaterID = theaterID;
        this.theaterName = theaterName;
        this.location = location;
        this.movieLists = movieLists;
    }
    public Theater(){}

    public String getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(String theaterID) {
        this.theaterID = theaterID;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Id
    private String theaterID;
    @Column
    private String theaterName;
    @Column
    private String location;
    @Transient
    private List<MovieList> movieLists = new ArrayList<>();


    public List<MovieList> getMovieLists() {
        return movieLists;
    }

    public void setMovieLists(List<MovieList> movieLists) {
        this.movieLists = movieLists;
    }


}
