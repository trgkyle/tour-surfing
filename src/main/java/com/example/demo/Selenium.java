package com.example.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.time.Duration;

public class Selenium {

    public WebDriver init(String website) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        try {
            driver.get(website);
//            driver.findElement(By.name("q")).sendKeys("cheese" + Keys.ENTER);
//            WebElement firstResult = wait.until(presenceOfElementLocated(By.cssSelector("h3>div")));
//            System.out.println(firstResult.getAttribute("textContent"));
        }catch(Exception e){
            System.out.println("Error & Quit out");
            driver.quit();
        } finally {
            return driver;
        }
    }
}