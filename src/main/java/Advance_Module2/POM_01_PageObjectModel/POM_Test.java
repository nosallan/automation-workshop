package Advance_Module2.POM_01_PageObjectModel;

import Advance_Module2.POM_01_PageObjectModel.PageObjects.Home_Page;
import Advance_Module2.POM_01_PageObjectModel.PageObjects.Login_Page;
import Advance_Module2.POM_01_PageObjectModel.PageObjects.Secure_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class POM_Test {

    private static WebDriver driverx;

    public static void main(String[] args) {
        driverx = new ChromeDriver();
        driverx.get("http://the-internet.herokuapp.com/");
        //Home_Page.link_Login(driverx).click();
        Home_Page.click_link_Login(driverx);
        Login_Page.fill_UserName(driverx, "tomsmith");
        Login_Page.fill_Password(driverx, "SuperSecretPassword!");
        Login_Page.click_btn_Login(driverx);
        Secure_Page.link_Logout(driverx).click();
        driverx.quit();
    }
}
