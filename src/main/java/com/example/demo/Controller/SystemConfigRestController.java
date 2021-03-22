package com.example.demo.Controller;

import com.example.demo.CrawlerService.FacebookCrawl.Facebook;
import com.example.demo.Service.Tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemConfigRestController {
    private final TourService tourService;

    @Autowired
    public SystemConfigRestController(TourService tourService){
        this.tourService = tourService;
    }
    @GetMapping("/system-config/facebook-crawler-active")
    public Boolean activeFacebookCrawler() {
        return this.tourService.crawlFacebookTourPost();
//        return this.tourService.insertTour();
    }
}
