package com.example.demo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;
public class Selenium {

    public static void waitForPageLoaded(WebDriver wd) {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(wd, 30);
            wait.until(expectation);
        } catch (Exception error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }
    public WebDriver init(String website, String cookies) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        try {
            driver.get(website);
            if(cookies != "") {
                this.setCookie(driver, cookies);
                driver.navigate().refresh();
            }

        }catch(Exception e){
            System.out.println("Error & Quit out");
            driver.quit();
        } finally {
            return driver;
        }
    }

    public static WebDriver setCookie(WebDriver wd,String cookies) {
        try {
            ObjectMapper mapper = new ObjectMapper();
//            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            LinkedHashMap[] allCookies = mapper.readValue(cookies.getBytes(), LinkedHashMap[].class);
            System.out.println(allCookies);
            System.out.println("Is okiiie ???");

            for (LinkedHashMap cookie : allCookies) {
                Cookie ck = new Cookie(cookie.get("name").toString(),cookie.get("value").toString(),cookie.get("domain").toString(),cookie.get("path").toString(),new Date(Long.parseLong(cookie.get("expiry").toString()) * 1000),Boolean.parseBoolean(cookie.get("secure").toString()));
                wd.manage().addCookie(ck);
            }
            System.out.println("done cookie");
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error run parse JSON");
        }
        return wd;
    }

    public static String getCookie(WebDriver wd) {
        Set<Cookie> cookies = wd.manage().getCookies();
        ObjectMapper mapperObj = new ObjectMapper();
        mapperObj.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        try {
            return mapperObj.writeValueAsString(cookies);
        }catch(Exception e){
            System.out.println("Error convert to JSON");
        }
        return "";
    }
}