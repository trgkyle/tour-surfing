package com.example.demo.FacebookCrawl;

import com.example.demo.Selenium;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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
    public void crawlTourStatus(int length) {
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
                System.out.println(feedTag.getAttribute("innerHTML"));
                // image source
                List<WebElement> imagesTag = tourStatus.findElements(By.cssSelector("img"));
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
            }catch(Exception e){
                System.out.println("Error ");
            }
        }
    }

}
