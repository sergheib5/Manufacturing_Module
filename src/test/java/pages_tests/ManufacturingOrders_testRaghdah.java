package pages_tests;

import Utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPageKenje.MainPageKenje;
import pages.ManufacturingOrders_Raghdah;

public class ManufacturingOrders_testRaghdah {

    LoginTest loginTest = new LoginTest();
    MainPageKenje mainPageKenje = new MainPageKenje();
    ManufacturingOrders_Raghdah manufacturingOrders = new ManufacturingOrders_Raghdah();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);

    @BeforeClass
    public void login() {
        loginTest.loginUser();
    }

    @Test
    public void click() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.createButton)).click();
        Assert.assertTrue(manufacturingOrders.createButton.isDisplayed(), "its not displayed");
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.importButton)).click();
        manufacturingOrders.productBox.click();
        manufacturingOrders.firstProductSelection.click();
        manufacturingOrders.saveButton.click();

        //  wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.firstProductSelection.sendKeys("Book");
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.firstProductSelection.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(5000);
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.firstProductSelection.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        manufacturingOrders.saveButton.click();
        Thread.sleep(3000);
       // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.xButton)).click();
        manufacturingOrders.xButton.click();

       // Assert.assertTrue();




    }
     @Test
    public void importValidation()throws  Exception{
        Thread.sleep(1000);
        manufacturingOrders.importButton.click();

     }
    }


