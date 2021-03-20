package com.example.demo.FacebookCrawl;

import com.example.demo.Selenium;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Facebook {
    public WebDriver wd;
    private WebElement we;
    private Selenium sl = new Selenium();
    public Facebook() {
        this.wd = sl.init("https://facebook.com","");
    }
    public Facebook(String cookies) {
        this.wd = sl.init("https://facebook.com",cookies);
    }
    public void goGroup() {
        wd.get("https://www.facebook.com/groups/1668792886550957");
        this.crawlTourStatus(4);
//        https://www.facebook.com/groups/1668792886550957

    }
    public void crawlTourStatus(int length){
        List<WebElement> listTourStatus = null;
        try {
            do {
                listTourStatus = wd.findElements(By.cssSelector("div[role=\"feed\"] > div > div> div> div > div[role=\"article\"]"));
                JavascriptExecutor js = ((JavascriptExecutor) wd);
                js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
                Thread.sleep(3000);
            } while (listTourStatus.size() < length);
        }catch(Exception e){
            System.out.println("Error get feed");
        }
        for(WebElement tourStatus : listTourStatus){
            System.out.println(tourStatus);
            List<WebElement> imagesTag = tourStatus.findElements(By.cssSelector("img"));
            List<String> imagesLink = imagesTag.stream().map(s -> s.getAttribute("src")).collect(Collectors.toList());
            System.out.println(imagesLink);


        }
    }

}
