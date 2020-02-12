package pages_tests;

import Utilities.Config;
import Utilities.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("http://app.briteerp.com/web/login");
    }


    @Test
    public void loginManager(){
        Driver.getDriver().get("http://app.briteerp.com/web/login");
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(Config.getProperty("managerLogin"));
        loginPage.password.sendKeys(Config.getProperty("managerPassword"));
        loginPage.loginBtn.click();
        loginPage.manufacturingModule.click();

    }

   @Test
    public void loginUser(){
       Driver.getDriver().get("http://app.briteerp.com/web/login");
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(Config.getProperty("userLogin"));
        loginPage.password.sendKeys(Config.getProperty("userPassword"));
        loginPage.loginBtn.click();
       System.out.println();

    }


}
