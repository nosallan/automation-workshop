package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String baseUrl="https://the-internet.herokuapp.com/";
        driver.get(baseUrl);
        WebElement formAuthentication = driver.findElement(By.linkText("Form Authentication"));
        formAuthentication.click();
        // 1 validate the url post form authentication
        if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login")){
            System.out.println(" Url form authentication is correct  " + driver.getCurrentUrl());
        }
        //Get location element from username, password and login
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.className("radius"));
        // 2 clear and send the text in the username and password fields
        username.clear();
        username.sendKeys("tomsmith");
        password.clear();
        password.sendKeys("SuperSecretPassword!");
        login.click();
        // 3 verify the url post login
        if (driver.getCurrentUrl().equals(baseUrl+"secure")) {
            System.out.println("Url post login is correct");
        }
        // 3 verify the message after login
        WebElement positivemessage = driver.findElement(By.id("flash"));
        if (positivemessage.getText().contains("You logged into a secure area!")){
            System.out.println("Correct message: You logged into a secure area! ");
        }
        else
        {
            System.out.println("Incorrect message: " + positivemessage.getText());
        }
        // Get locator of logout button
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        // 4 Click logout button
        logoutButton.click();
        //  verify the url post logout
        if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login")) {
            System.out.println("Url post logout is correct  " + driver.getCurrentUrl());
        }
        // 5 verify the message after login
        WebElement logoutMessage = driver.findElement(By.id("flash"));
        if (logoutMessage.getText().contains("You logged out of the secure area!")){
            System.out.println("Correct message: You logged out of the secure area! ");
        }
        else
        {
            System.out.println("Incorrect message: " + logoutMessage.getText());
        }
        // 6 Login with invalid username and password
        if (driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/login")){
            //Login with invalid username and password
            username.clear();
            username.sendKeys("test1");
            password.clear();
            password.sendKeys("Password!");
            login.click();
        }

        // 7 verify the error message after login with invalid username and password
        WebElement errormessage = driver.findElement(By.id("flash"));
        if (errormessage.getText().contains("Your username is invalid!")){
            System.out.println("Correct message with invalid username and password: Your username is invalid! ");
        }
        else
        {
            System.out.println("Incorrect message: " + errormessage.getText());
        }

        driver.close();

    }
}