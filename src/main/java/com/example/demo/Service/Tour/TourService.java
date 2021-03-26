package com.example.demo.Service.Tour;

import com.example.demo.CrawlerService.ChototCrawl.Chotot;
import com.example.demo.CrawlerService.FacebookCrawl.Facebook;
import com.example.demo.CrawlerService.TravelComCrawler.TravelCom;
import com.example.demo.Entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TourService {
    private final TourRepository tourRes;

    @Autowired
    public TourService(TourRepository tourRes) {
        this.tourRes = tourRes;
    }

    public Boolean censorTour(Long tourID,Boolean status){
        try {
            Tour tour = this.tourRes.getOne(tourID);
            tour.setCensor(true);
            tour.setPublish(status);
            tourRes.save(tour);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public List<Tour> getTours() {
        return this.tourRes.findAll();
    }

    public List<Tour> getToursActive() {
        return this.tourRes.getToursActive();
    }

    public List<Tour> getToursPending() {
        return this.tourRes.getToursPending();
    }

    public Boolean crawlFacebookTourPost(Long tourLength) {
        Facebook fb = new Facebook("[{\"name\":\"datr\",\"value\":\"sexVYO1bzCfC-IPyiL7RLgRg\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1679315890000,\"secure\":true,\"httpOnly\":true},{\"name\":\"c_user\",\"value\":\"100004960057193\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1647779906000,\"secure\":true,\"httpOnly\":false},{\"name\":\"spin\",\"value\":\"r.1003486059_b.trunk_t.1616243909_s.1_v.2_\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616333909000,\"secure\":true,\"httpOnly\":true},{\"name\":\"xs\",\"value\":\"29%3A8iE9V4xxT_mtkg%3A2%3A1616243909%3A10982%3A6337\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1647779906000,\"secure\":true,\"httpOnly\":true},{\"name\":\"fr\",\"value\":\"1QfHtZsqBcqywFJOE.AWXBc29gJUBP4uapa9-MFKBv3yY.BgVeyx.6g.AAA.0.0.BgVezD.AWUx5D9o8Ds\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1624019903000,\"secure\":true,\"httpOnly\":true},{\"name\":\"locale\",\"value\":\"en_US\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616848691000,\"secure\":true,\"httpOnly\":false},{\"name\":\"wd\",\"value\":\"1200x835\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1616848706000,\"secure\":true,\"httpOnly\":false},{\"name\":\"sb\",\"value\":\"sexVYOZbIGaiFJyOvHaPAPWc\",\"path\":\"/\",\"domain\":\".facebook.com\",\"expiry\":1679315909000,\"secure\":true,\"httpOnly\":true}]");
//		Facebook fb2 = new Facebook();
//		fb2.normalLogin("s2hdpks22@gmail.com", "dkm01282046434");
        List<Tour> tourCollect = fb.crawlGroup(tourLength);
        for (Tour tour : tourCollect) {
            try {
                tourRes.save(tour);
            }catch(Exception e){
                System.out.println("Error save");
            }
        }
        fb.quit();
        return true;
    }

    public Boolean crawlChototTourPost(Long tourLength) {
        Chotot ct = new Chotot();
        List<Tour> tourCollect = ct.getTour(tourLength);
        for (Tour tour : tourCollect) {
            try {
                tourRes.save(tour);
            }catch(Exception e){
                System.out.println("Error save");
            }
        }
        return true;
    }

    public Boolean crawlTravelComTourPost(Long tourLength) {
        TravelCom tvc = new TravelCom();
        List<Tour> tourCollect = tvc.getTour(tourLength);
        for (Tour tour : tourCollect) {
            try {
                tourRes.save(tour);
            }catch(Exception e){
                System.out.println("Error save");
            }
        }
        return true;
    }
}
