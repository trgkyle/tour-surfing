package com.example.demo.Controller;

import com.example.demo.CrawlerService.FacebookCrawl.Facebook;
import com.example.demo.Service.Tour.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(path = "system-config")
public class SystemConfigRestController {
    private final TourService tourService;

    @Autowired
    public SystemConfigRestController(TourService tourService){
        this.tourService = tourService;
    }

    @CrossOrigin
    @GetMapping("/facebook-crawler-active")
    public Boolean activeFacebookCrawler(@RequestParam("crawlerLength") Long crawlerLength) {
        return this.tourService.crawlFacebookTourPost(crawlerLength);
    }

    @CrossOrigin
    @GetMapping("/chotot-crawler-active")
    public Boolean activeChototCrawler(@RequestParam("crawlerLength") Long crawlerLength) {
        return this.tourService.crawlChototTourPost(crawlerLength);
    }

    @CrossOrigin
    @GetMapping("/travelcom-crawler-active")
    public Boolean activeTravelComCrawler(@RequestParam("crawlerLength") Long crawlerLength) {
        return this.tourService.crawlTravelComTourPost(crawlerLength);
    }
}
