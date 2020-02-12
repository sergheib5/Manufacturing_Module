package pages_tests;

import Utilities.Config;
import Utilities.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
    @BeforeClass
    public void setUp(){
        Driver.getDriver().get("http://app.briteerp.com/web/login");
    }


    @Test
    public void loginManager(){
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(Config.getProperty("managerLogin"));
        loginPage.password.sendKeys(Config.getProperty("managerPassword"));
        loginPage.loginBtn.click();
        loginPage.manufacturingModule.click();

    }


}
