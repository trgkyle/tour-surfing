package com.example.demo.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    public String title;
    @Column(columnDefinition="TEXT")
    public String des;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long price;
    public Date time_from;
    public String time_count;

    @ElementCollection
    @Column(columnDefinition="TEXT")
    public Set<String> image;

    @Column(columnDefinition="TEXT")
    public String author;

    @Column(columnDefinition="TEXT")
    public String link;

    public Tour(String title, String des, long price, Date time_from, String time_count, Set<String> image, String author, String link) {
//        this.id = id;
        this.title = title;
        this.des = des;
        this.price = price;
        this.time_from = time_from;
        this.time_count = time_count;
        this.image = image;
        this.author = author;
        this.link = link;
    }

    public Tour() {

    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", time_from=" + time_from +
                ", time_count='" + time_count + '\'' +
                ", image=" + image +
                ", author='" + author + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setImage(Set<String> image) {
        this.image = image;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
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

    public String getTime_count() {
        return time_count;
    }

    public Set<String> getImage() {
        return image;
    }

    public String getAuthor() {
        return author;
    }

};
