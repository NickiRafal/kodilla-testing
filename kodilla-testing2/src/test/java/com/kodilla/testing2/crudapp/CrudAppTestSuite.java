package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://nickirafal.github.io/tasks/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_SECTION = "/html/body/main/section[1]";
        final String XPATH_TASK_NAME = XPATH_SECTION + "//form//fieldset[1]/input";
        final String XPATH_TASK_CONTENT = XPATH_SECTION + "//form//fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = XPATH_SECTION + "//form//fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {
            System.out.println("Alert nie został znaleziony w czasie oczekiwania.");
        }
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;

        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        WebDriverWait wait = new WebDriverWait(driverTrello, 10);

        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        userField.sendKeys("nicol79@op.pl");

        WebElement loginButton = driverTrello.findElement(By.id("login"));
        loginButton.submit();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        WebElement passwordField = driverTrello.findElement(By.id("password"));
        passwordField.sendKeys("Turbolan12983?");
        driverTrello.findElement(By.id("login-submit")).submit();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class=\"board-tile\"]")));

        driverTrello.findElements(By.xpath("//div[contains(@class, 'board-tile-details-name')]"))
                .stream()
                .filter(div -> div.findElement(By.xpath("./div")).getText().equals("Kodilla Aplication"))
                .findFirst()
                .ifPresent(WebElement::click);

        Thread.sleep(4000);

        result = driverTrello.findElements(By.xpath("//a[@data-testid='card-name']")).stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.equals(taskName));

        driverTrello.close();
        System.out.println(taskName);
        return result;
    }
    private void deleteCrudAppTestTask(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement deleteButton = theForm.findElement(By.xpath(".//button[contains(text(), 'Delete')]"));
                    deleteButton.click();
                });

        Thread.sleep(2000);
    }
    private boolean checkTaskExistsInApp(String taskName) {
        final String XPATH_SECTION = "/html/body/main/section[1]";
        final String XPATH_TASKS = XPATH_SECTION + "//p[@class='datatable__field-value']";

        List<WebElement> tasks = driver.findElements(By.xpath(XPATH_TASKS));

        for (WebElement task : tasks) {
            if (task.getText().equals(taskName)) {
                return true;
            }
        }

        return false;
    }
    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        deleteCrudAppTestTask(taskName);
        Thread.sleep(2000);
        assertFalse(checkTaskExistsInApp(taskName));
    }
}
