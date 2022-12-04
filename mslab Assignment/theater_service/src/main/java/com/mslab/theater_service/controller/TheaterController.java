package com.mslab.theater_service.controller;

import com.mslab.theater_service.model.Theater;
import com.mslab.theater_service.service.TheaterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TheaterController {
    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    private final TheaterService theaterService;

    @GetMapping("/getAllTheaters")
    public List<Theater> getAllTheater(){
        return theaterService.getAllTheaters();
    }

    @GetMapping("/getTheater/{theaterID}")
    public Theater getTheater(@PathVariable String theaterID){
        return theaterService.getTheater(theaterID);
    }

    @PostMapping("/addTheater")
    public Theater addTheater(@RequestBody Theater theater){
        return theaterService.addTheater(theater);
    }

    @DeleteMapping("/deleteTheater/{theaterID}")
    public String deleteTheater(@PathVariable String theaterID){
        theaterService.deleteTheater(theaterID);
        return "Theater Deleted";
    }

    @DeleteMapping("/deleteAllTheaters")
    public String deleteAllTheaters(){
        theaterService.deleteAllTheaters();
        return "All theaters deleted";
    }

}
