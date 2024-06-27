package Advance_Module2.POM_01_PageObjectModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

    private static WebElement element;

    public static void fill_UserName(WebDriver driver, String username){
        element = driver.findElement(By.id("username"));
        element.clear();
        element.sendKeys(username);
    }

    public static void fill_Password(WebDriver driver,  String password){
        element = driver.findElement(By.id("password"));
        element.clear();
        element.sendKeys(password);
    }

    public static void click_btn_Login(WebDriver driver){
        element = driver.findElement(By.cssSelector("#login > button"));
        element.click();
    }
}
