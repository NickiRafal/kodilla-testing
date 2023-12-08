package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);

        driver.get("https://www.ebay.com/");

        WebElement searchInput = driver.findElement(By.name("_nkw"));
        searchInput.sendKeys("Laptop");
        searchInput.submit();

         driver.quit();
    }
}
