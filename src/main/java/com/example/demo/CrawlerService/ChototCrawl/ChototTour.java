package com.example.demo.CrawlerService.ChototCrawl;

import com.example.demo.Entity.Tour;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class ChototTour {
    public ChototTour() {

    }
    public String date;
    public String subject;
    public String body;
    public List<String> images;
    public String phone;

    public long price = 0;
    public String account_id;
    public String ad_id;
    public String list_id;
    public Tour toTourEntity(){
        return new Tour(null,subject,body,price,new Date(),"Chotot"," ", false, false, new HashSet<String>(images),account_id,"https://www.chotot.com/" + this.list_id + ".htm");
    }

    public ChototTour(String date, String subject, String body, List<String> images, String phone, long price, String account_id, String ad_id, String list_id) {
        this.date = date;
        this.subject = subject;
        this.body = body;
        this.images = images;
        this.phone = phone;
        this.price = price;
        this.account_id = account_id;
        this.ad_id = ad_id;
        this.list_id = list_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAd_id() {
        return ad_id;
    }

    public void setAd_id(String ad_id) {
        this.ad_id = ad_id;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }
}
