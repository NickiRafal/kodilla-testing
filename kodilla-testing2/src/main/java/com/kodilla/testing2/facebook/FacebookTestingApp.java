package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            WebElement cookiesAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-testid='cookie-policy-manage-dialog-accept-button']")));
            cookiesAcceptButton.click();
        } catch (TimeoutException e) {
            System.out.println("Nie znaleziono przycisku akceptacji cookies.");
        }

        try {
            WebElement createAccountLink = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-testid='open-registration-form-button']")));
            createAccountLink.click();
        } catch (TimeoutException e) {
            System.out.println("Nie znaleziono linku do utworzenia nowego konta.");
        }

        try {
            WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='firstname']")));
            firstNameInput.sendKeys("Rafal");

            WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='lastname']")));
            lastNameInput.sendKeys("Nicki");
        } catch (TimeoutException e) {
            System.out.println("Nie udało się wypełnić pól Imię i Nazwisko.");
        }

        try {
            Select daySelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("day"))));
            daySelect.selectByVisibleText("6");

            Select monthSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("month"))));
            monthSelect.selectByVisibleText("sty");

            Select yearSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("year"))));
            yearSelect.selectByVisibleText("1979");
        } catch (TimeoutException e) {
            System.out.println("Nie udało się wypełnić pól daty urodzenia.");
        }

    }
}

