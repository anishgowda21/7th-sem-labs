package com.mslab.theater_service.model;



public class Movie {
    public Movie(String movieID, String movie_name, String language) {
        this.movieID = movieID;
        this.movie_name = movie_name;
        this.language = language;
    }
    public Movie(){}

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

    private String movieID;
    private String movie_name;
    private String language;
}
