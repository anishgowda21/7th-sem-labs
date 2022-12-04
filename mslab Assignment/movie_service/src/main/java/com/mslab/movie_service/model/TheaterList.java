package com.mslab.movie_service.model;

public class TheaterList {
    public TheaterList(String assignmentID, String movieID, String theaterID,Theater theater) {
        this.assignmentID = assignmentID;
        this.movieID = movieID;
        this.theaterID = theaterID;
        this.theater = theater;
    }

    public TheaterList(){}

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

    private String assignmentID;
    private String movieID;
    private String theaterID;

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    private Theater theater;

}
