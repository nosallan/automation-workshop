package Advance_Module2.POM_01_PageObjectModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {
    private static WebElement element;

    /*public static WebElement link_Login(WebDriver driver){
        element = driver.findElement(By.cssSelector("#content > ul > li:nth-child(18) > a"));
        return element;
    }*/

    public static void click_link_Login(WebDriver driver){
        element = driver.findElement(By.linkText("Form Authentication"));
        element.click();
    }
}
