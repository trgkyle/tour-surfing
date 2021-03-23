package com.example.demo.Controller;

import com.example.demo.Entity.Tour;
import com.example.demo.Service.Tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
//@RequestMapping(path = "tour-manage")
public class TourManageRestController {
    private final TourService tourService;

    @Autowired
    public TourManageRestController(TourService tourService){
        this.tourService = tourService;
    }

    @CrossOrigin
    @GetMapping("/tours-active")
    public List<Tour> getTourActive() {
        return tourService.getToursActive();
    }

    @CrossOrigin
    @GetMapping("/tours-pending")
    public List<Tour> getTourPending() {
        return tourService.getToursPending();
    }

    @CrossOrigin
    @PostMapping(value = "/censor-tour")
    public Boolean censorTour(@RequestParam("status") Boolean status,@RequestParam("tourID") Long tourID) {
        return tourService.censorTour(tourID,status);
    }
}
