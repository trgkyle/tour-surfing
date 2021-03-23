package com.example.demo.CrawlerService.ChototCrawl;

import com.example.demo.Entity.Tour;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class Chotot {
    RestTemplate restTemplate = new RestTemplate();
    String fooResourceUrl = "https://gateway.chotot.com/v1/public/ad-listing";
    public Chotot() {

    }
    public List<Tour> getTour(Long tourLength) {
        String keyword = "tour";
        ChototRes response = restTemplate.getForObject( fooResourceUrl+ "?q=" + keyword + "&limit=" + tourLength , ChototRes.class);
        return response.getAds().stream().map(tourChotot -> tourChotot.toTourEntity()).collect(Collectors.toList());
    }
}
