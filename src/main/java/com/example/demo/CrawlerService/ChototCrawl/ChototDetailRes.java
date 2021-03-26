package com.example.demo.CrawlerService.ChototCrawl;

import java.util.List;

public class ChototDetailRes {
    public ChototTour ad;
    public ChototDetailRes() {

    }
    public ChototDetailRes(ChototTour ad) {
        this.ad = ad;
    }

    public ChototTour getAd() {
        return ad;
    }

    public void setAd(ChototTour ad) {
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "ChototDetailRes{" +
                "ad=" + ad +
                '}';
    }
}
