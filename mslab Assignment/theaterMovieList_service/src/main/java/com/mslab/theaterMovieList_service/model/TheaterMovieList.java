package com.mslab.theaterMovieList_service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class TheaterMovieList {
    @Id
    private String assignmentID;

    public String getAssignmentID() {
        return assignmentID;
    }

    public void setAssignmentID(String assignmentID) {
        this.assignmentID = assignmentID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(String theaterID) {
        this.theaterID = theaterID;
    }

    @Column
    private String movieID;

    public TheaterMovieList(String assignmentID, String movieID, String theaterID) {
        this.assignmentID = assignmentID;
        this.movieID = movieID;
        this.theaterID = theaterID;
    }

    public TheaterMovieList(){}

    @Column
    private String theaterID;
}
