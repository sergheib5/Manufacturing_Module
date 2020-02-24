package pages_tests;

import Utilities.BaseClass;
import Utilities.Config;
import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

//    @BeforeMethod
//    public void setUp(){
//        Driver.getDriver().get("http://app.briteerp.com/web/login");
//    }

    LoginPage loginPage = new LoginPage();
    @Test
    public void loginManager(){

        Driver.getDriver().get("http://app.briteerp.com/web/login");
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(loginPage.username)).sendKeys(Config.getProperty("managerLogin"));
        //loginPage.username.sendKeys(Config.getProperty("managerLogin"));
        loginPage.password.sendKeys(Config.getProperty("managerPassword"));
        loginPage.loginBtn.click();
        SeleniumUtil.pause(4);
        loginPage.managermanufacturingModule.click();
    }
    @Test
    public void loginUser(){
       // Driver.logger = Driver.extent.startTest("Login User ");
        Driver.getDriver().get("http://app.briteerp.com/web/login");
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(Config.getProperty("userLogin"));
        loginPage.password.sendKeys(Config.getProperty("userPassword"));
        loginPage.loginBtn.click();
        SeleniumUtil.pause(4);
        loginPage.usermanufacturingModule.click();
    }
}
