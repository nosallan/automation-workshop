package Advance_Module1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class testNGTests {
    WebDriver driver;
    String baseUrl = "https://the-internet.herokuapp.com/";

    @BeforeClass
    public void startWebDriver() {
        System.out.println("Before Class");
        this.driver = new ChromeDriver();
    }

    @BeforeMethod
    public void openBrowser() {
        System.out.println("Before Method");
        this.driver.get(this.baseUrl);
        this.driver.findElement(By.linkText("Form Authentication")).click();

        this.driver.findElement(By.id("username")).clear();
        this.driver.findElement(By.id("username")).sendKeys("tomsmith");
        this.driver.findElement(By.name("password")).clear();
        this.driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        WebElement btnSubmit = this.driver.findElement(By.cssSelector("#login > button"));
        btnSubmit.click();
    }

    @Test
    public void testCase1() {
        System.out.println("Test: 01");
        String welcomeMessageExpected = "Welcome to the Secure Area. When you are done click logout below.";
        String welcomeMessage = this.driver.findElement(By.cssSelector("#content > div > h4")).getText();
        if (welcomeMessage.equals(welcomeMessageExpected)) {
            System.out.println("Test Passed!! - Welcome Message is displayed");
        } else {
            System.out.println("Test Failed!! - Welcome Message is not displayed");
        }

    }

    @Test
    public void testCase2() {
        System.out.println("Test: 02");
        if (this.driver.findElement(By.cssSelector("#content > div > a")).isDisplayed()) {
            System.out.println("Test Passed!! - Button is displayed");
        } else {
            System.out.println("Test Failed!! - Button is not displayed");
        }
    }

    @Test
    public void testCase3() {
        System.out.println("Test: 03");
        if (this.driver.getCurrentUrl().equals(this.baseUrl + "secure")) {
            System.out.println("Test Passed!! - URL is OK");
        } else {
            System.out.println("Test Failed!! - URL is not OK, current URL is: " + this.driver.getCurrentUrl());
        }
    }

    @AfterTest
    public void closeBrowser() {
        this.driver.close();
    }

}
