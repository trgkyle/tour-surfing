package com.example.demo.Tour;

import java.util.Date;

public class Tour {
    public String title;
    public String des;
    public long price;
    public Date time_from;
    public String time_count;
    public String[] image;
    public String author;

    public Tour(String title, String des, long price, Date time_from, String time_count, String[] image, String author, String link) {
        this.title = title;
        this.des = des;
        this.price = price;
        this.time_from = time_from;
        this.time_count = time_count;
        this.image = image;
        this.author = author;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getDes() {
        return des;
    }

    public long getPrice() {
        return price;
    }

    public Date getTime_from() {
        return time_from;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public String getTime_count() {
        return time_count;
    }

    public String[] getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setTime_from(Date time_from) {
        this.time_from = time_from;
    }

    public void setTime_count(String time_count) {
        this.time_count = time_count;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Tour(String title, String des, long price, Date time_from, String time_count, String[] image, String link) {
        this.title = title;
        this.des = des;
        this.price = price;
        this.time_from = time_from;
        this.time_count = time_count;
        this.image = image;
        this.link = link;
    }

    public String link;
}
