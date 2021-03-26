package com.example.demo.CrawlerService.ChototCrawl;

import com.example.demo.Entity.Tour;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class Chotot {
    RestTemplate restTemplate = new RestTemplate();
    String tourListSource = "https://gateway.chotot.com/v1/public/ad-listing";
    String tourDetailSource = "https://gateway.chotot.com/v1/public/ad-listing";
    public Chotot() {
    }

    public ChototTour getTourDetail(ChototTour ctt) {
        String url = tourDetailSource+ "/" + ctt.getList_id();
        ChototDetailRes response = restTemplate.getForObject( url , ChototDetailRes.class);
        return response.getAd();
    }
    public List<Tour> getTour(Long tourLength) {
        String keyword = "tour";
        ChototRes response = restTemplate.getForObject( tourListSource+ "?q=" + keyword + "&limit=" + tourLength , ChototRes.class);
        return response.getAds().stream().map(tourChotot -> this.getTourDetail(tourChotot).toTourEntity()).collect(Collectors.toList());
    }
}
