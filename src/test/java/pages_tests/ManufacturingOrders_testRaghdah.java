package pages_tests;

import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPageKenje.MainPageKenje;
import pages.ManufacturingOrders_Raghdah;

public class ManufacturingOrders_testRaghdah {

    LoginTest loginTest = new LoginTest();
    MainPageKenje mainPageKenje = new MainPageKenje();
    ManufacturingOrders_Raghdah manufacturingOrders = new ManufacturingOrders_Raghdah();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
    LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void login() {
        loginTest.loginUser();
        SeleniumUtil.pause(5);
    }

    @Test(priority = 4)
    public void createButtonValidation() throws InterruptedException {
        SeleniumUtil.pause(3);
        wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.createButton)).click();
        Assert.assertTrue(manufacturingOrders.createButton.isDisplayed(), "its not displayed");
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.importButton)).click();
        // manufacturingOrders.productBox.click();
        // manufacturingOrders.firstProductSelection.click();
        // manufacturingOrders.saveButton.click();
        //  wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.productBox.sendKeys("Book");
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.productBox.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(5000);
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.firstProductSelection)).click();
        manufacturingOrders.productBox.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        manufacturingOrders.saveButton.click();
        Thread.sleep(3000);
        // wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.xButton)).click();
        manufacturingOrders.xButton.click();
        SeleniumUtil.pause(5);
        loginPage.usermanufacturingModule.click();
    }

    @Test(priority = 1)
    public void importValidation() {
        SeleniumUtil.pause(5);
        loginPage.usermanufacturingModule.click();
        loginPage.usermanufacturingModule.click();
        SeleniumUtil.pause(2);
//        Assert.assertTrue(manufacturingOrders.importButton.isDisplayed(), "its not displayed");
        wait.until(ExpectedConditions.visibilityOf(manufacturingOrders.importButton));
        SeleniumUtil.pause(3);
        manufacturingOrders.importButton.click();
        Assert.assertTrue(manufacturingOrders.loadFileButton.isDisplayed());
//        wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.loadFileButton)).click();
//        Assert.assertTrue(manufacturingOrders.cancelLoadFileButton.isEnabled());
//        manufacturingOrders.cancelLoadFileButton.click();
    }


    @Test(priority = 2)
    public void checkBoxValidation() {
        loginPage.usermanufacturingModule.click();
        wait.until(ExpectedConditions.elementToBeClickable(manufacturingOrders.referenceCheckBox));
        SeleniumUtil.pause(3);
        manufacturingOrders.referenceCheckBox.click();
        SeleniumUtil.pause(3);
        manufacturingOrders.referenceCheckBox.click();

    }


}