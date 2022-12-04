package com.mslab.movie_service.model;


public class Theater {
    public Theater(String theaterID, String theaterName, String location) {
        this.theaterID = theaterID;
        this.theaterName = theaterName;
        this.location = location;
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


    private String theaterID;

    private String theaterName;

    private String location;

}
