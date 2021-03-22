package com.example.demo.CrawlerService.FacebookCrawl;

import com.example.demo.Entity.Tour;
import com.example.demo.Service.Selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Facebook {
    public WebDriver wd;
    private final Selenium sl = new Selenium();
    public Facebook() {
        this.wd = sl.init("https://facebook.com","");
    }
    public Facebook(String cookies) {
        this.wd = sl.init("https://facebook.com",cookies);
    }
    public List<Tour> crawlGroup(Long tourLength) {
        wd.get("https://www.facebook.com/groups/1668792886550957");
//        https://www.facebook.com/groups/1668792886550957
        return this.crawlTourStatus(tourLength);

    }
    public List<Tour> crawlTourStatus(Long length) {
        List<Tour> tourCollect = new ArrayList<Tour>();
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
            try {

                // feed source
                WebElement feedTag = tourStatus.findElement(By.cssSelector("div[data-ad-preview=\"message\"]"));
                try {
                    WebElement seeMoreTag = feedTag.findElement(By.cssSelector("div[role=\"button\"][tabindex=\"0\"]"));
                    seeMoreTag.click();
                }catch(Exception e){
                    System.out.println("No see more");
                }
                System.out.println(feedTag.getAttribute("innerHTML"));
                // image source
                List<WebElement> imagesTag = tourStatus.findElements(By.cssSelector("img[referrerpolicy=\"origin-when-cross-origin\"]"));
                List<String> imagesLink = imagesTag.stream().map(s -> s.getAttribute("src")).collect(Collectors.toList());
                System.out.println(imagesLink);

                // author link
                WebElement authorTag = tourStatus.findElement(By.cssSelector("span > div > a[role=\"link\"][tabindex=\"0\"]"));
                System.out.println(authorTag.getAttribute("href"));
                // post link
                WebElement linkTag = tourStatus.findElement(By.cssSelector("span > span > span > a[role=\"link\"][tabindex=\"0\"]"));
                Actions builder = new Actions(wd);
                Actions hoverOverRegistrar = builder.moveToElement(linkTag);
                hoverOverRegistrar.perform();
                Thread.sleep(3000);
                System.out.println(linkTag.getAttribute("href"));
                tourCollect.add(new Tour(null," ",feedTag.getAttribute("innerHTML"),0, new Date(),"FacebookGroup"," ",false, false,new HashSet<String>(imagesLink),authorTag.getAttribute("href"), linkTag.getAttribute("href")));
            }catch(Exception e){
                System.out.println("Error ");
            }
        }
        return tourCollect;
    }

}
