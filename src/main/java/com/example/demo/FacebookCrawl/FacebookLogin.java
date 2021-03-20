package com.example.demo.FacebookCrawl;

import com.example.demo.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Scanner;

public class FacebookLogin {
    private WebDriver wd;
    FacebookLogin(WebDriver wd){
        this.wd = wd;
        String url = wd.getCurrentUrl();
        System.out.println(url);
        System.out.println(url.matches("(.*)checkpoint(.*)"));
        if(url.matches("(.*)login(.*)")) {
            System.out.println("Some thing error");
        }
        else if(url.matches("(.*)checkpoint(.*)")) {
            System.out.println("Some thing go checkout");
            System.out.println("May two factor authenticate");
            this.twoFactorAuthenticate();
        }
        System.out.println("May login success");
        System.out.println(Selenium.getCookie(wd));
    }
    private void twoFactorAuthenticate(){
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                String code = scanner.nextLine();
                wd.findElement(By.id("approvals_code")).sendKeys(code);
                wd.findElement(By.id("checkpointSubmitButton")).click();
                Selenium.waitForPageLoaded(wd);
                wd.findElement(By.id("checkpointSubmitButton")).click();
                Selenium.waitForPageLoaded(wd);
                wd.findElement(By.id("checkpointSubmitButton")).click();
                Selenium.waitForPageLoaded(wd);
                wd.findElement(By.id("checkpointSubmitButton")).click();
                Selenium.waitForPageLoaded(wd);
                wd.findElement(By.id("checkpointSubmitButton")).click();
                Selenium.waitForPageLoaded(wd);
            }catch(Exception e){
                System.out.println("May error when login follow!");
            }
        }while(wd.getCurrentUrl().matches("(.*)checkpoint(.*)"));

    }
}
