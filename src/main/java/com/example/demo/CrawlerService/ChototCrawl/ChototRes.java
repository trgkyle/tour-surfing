package com.example.demo.CrawlerService.ChototCrawl;

import java.util.List;

public class ChototRes {
    public ChototRes() {

    }
    public Long variant;
    public Long total;
    public List<ChototTour> ads;

    public ChototRes(Long variant, Long total, List<ChototTour> ads) {
        this.variant = variant;
        this.total = total;
        this.ads = ads;
    }

    public Long getVariant() {
        return variant;
    }

    public void setVariant(Long variant) {
        this.variant = variant;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<ChototTour> getAds() {
        return ads;
    }

    public void setAds(List<ChototTour> ads) {
        this.ads = ads;
    }

    @Override
    public String toString() {
        return "ChototRes{" +
                "variant=" + variant +
                ", total=" + total +
                ", ads=" + ads +
                '}';
    }
}
