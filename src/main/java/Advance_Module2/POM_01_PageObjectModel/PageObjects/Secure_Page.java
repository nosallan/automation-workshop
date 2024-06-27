package Advance_Module2.POM_01_PageObjectModel.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Secure_Page {

    //private static WebElement element;

    public static WebElement link_Logout(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i"));
        return element;
    }
}
