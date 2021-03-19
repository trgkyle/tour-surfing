package com.example.demo.FacebookCrawl;

import com.example.demo.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Facebook {
    WebDriver wd;
    WebElement we;
    public Facebook() {
        Selenium sl = new Selenium();
        this.wd = sl.init("https://facebook.com");
    }
    public WebDriver normalLogin(String username,String password) {
        try {
            wd.findElement(By.id("email")).sendKeys(username);
            wd.findElement(By.id("pass")).sendKeys(password);
            wd.findElement(By.cssSelector("button[name=\"login\"]")).click();
        }catch(Exception e){
            System.out.println("Error");
        }
        return this.wd;
    }

}
