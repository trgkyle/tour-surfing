package com.example.demo.CrawlerService.ChototCrawl;

import com.example.demo.Entity.Tour;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

public class ChototTour {
    public ChototTour() {

    }
    public String date;
    public String subject;
    public String body;
    public String image;

    public ChototTour(String date, String subject, String body, String image, long price, String account_id) {
        this.date = date;
        this.subject = subject;
        this.body = body;
        this.image = image;
        this.price = price;
        this.account_id = account_id;
    }

    public long price = 0;
    public String account_id;


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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public String toString() {
        return "ChototTour{" +
                "date='" + date + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                '}';
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Tour toTourEntity(){
        return new Tour(null,subject,body,price,new Date(),"Chotot"," ", false, false, new HashSet<String>(Arrays.asList(image)),account_id,"");
    }
}
