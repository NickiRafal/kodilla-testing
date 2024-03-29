package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp{
    public static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input"; // [1]
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]";
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://nickirafal.github.io/tasks/");                      // [2]

        WebElement searchField = driver.findElement(By.xpath(XPATH_INPUT));    // [3]

        searchField.sendKeys("New robotic task");

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));  // [2]
        textareaField.sendKeys("The robotic content"); // [4]

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_WAIT_FOR));      // [2]
        Select selectBoard = new Select(selectCombo);                             // [3]
        selectBoard.selectByIndex(1);
    }
}