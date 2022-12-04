package com.mslab.theater_service.model;

public class MovieList {
    public MovieList(String assignmentID, String movieID, String theaterID, Movie movie) {
        this.assignmentID = assignmentID;
        this.movieID = movieID;
        this.theaterID = theaterID;
        this.movie = movie;
    }

    public MovieList(){}

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    private String assignmentID;
    private String movieID;
    private String theaterID;
    private Movie movie;
}
