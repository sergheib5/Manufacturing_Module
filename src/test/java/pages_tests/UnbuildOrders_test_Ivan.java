package pages_tests;

import Utilities.BaseClass;
import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnbuildOrdersIVAN.UONewPage;
import pages.UnbuildOrdersIVAN.UOPage;

import java.util.Random;

public class UnbuildOrders_test_Ivan extends BaseClass {
    LoginTest login = new LoginTest();
    UOPage manufactPage = new UOPage();
    UOPage unbuildOrdersPage = new UOPage();
    UOPage createButton = new UOPage();
    UONewPage saveButton = new UONewPage();
    UONewPage productField = new UONewPage();
    UONewPage quantityField = new UONewPage();
    UONewPage discardButton = new UONewPage();
    UONewPage unbuildButton = new UONewPage();


    @BeforeMethod
    public void setup(){
        login.loginManager();
        manufactPage.ManufacturPage.click();
        unbuildOrdersPage.UnbuildOrdersPage.click();
        SeleniumUtil.pause(3);

    }
    //@Test
    public void saveWithEmptyFields(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        saveButton.SaveButton.click();
        String actualResult = saveButton.ErrorMessage.getText();
        String expectResult = "The following fields are invalid:";
        Assert.assertTrue(actualResult.contains(expectResult),"Correct appearance");
    }
  //  @Test
    public void saveWithZeroQuantity(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        saveButton.SaveButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
        Assert.assertTrue(actualResult,"Odo Server Error is DISPLAYED");
    }
    @Test(priority = 1)
    public void saveWithAnyQuantity(){
        Driver.logger = Driver.extent.startTest("saveWith any Quantity Report");
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
//        createButton.CreateButton.click();
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        SeleniumUtil.pause(2);
        quantityField.QuantityField.click();
        quantityField.QuantityField.clear();
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
        quantityField.QuantityField.sendKeys("1");
        saveButton.SaveButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("//div[@class='o_thread_message_content']")).isDisplayed();
        Assert.assertTrue(actualResult,"Unbuild Order created is DISPLAYED");
    }
   // @Test
    public void discardWithEmptyFields(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        discardButton.DiscardButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("(//li[@class='active'])[3]")).isDisplayed();
        Assert.assertTrue(actualResult,"Unbuild Orders is DISPLAYED");
    }
  //  @Test
    public void discardWithBuildOfMaterial(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        discardButton.DiscardButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("//h4[@class='modal-title']")).isDisplayed();
        Assert.assertTrue(actualResult,"Warning is DISPLAYED");
    }
    @Test(priority = 3)
    public void discardWithAnyQuantity(){
        Driver.logger = Driver.extent.startTest("discard with Any Quantity");
        SeleniumUtil.pause(2);
//        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), 30);
//        wait.until(ExpectedConditions.elementToBeClickable(createButton.CreateButton)).click();
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        SeleniumUtil.pause(2);
        quantityField.QuantityField.click();
        quantityField.QuantityField.clear();
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
        quantityField.QuantityField.sendKeys("1");
        discardButton.DiscardButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("//h4[@class='modal-title']")).isDisplayed();
        Assert.assertTrue(actualResult,"Warning is DISPLAYED");
    }
  //  @Test
    public void unbuildWithEmptyFields(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        unbuildButton.UnbuildButton.click();
        String actualResult = unbuildButton.ErrorMessage.getText();
        String expectResult = "The following fields are invalid:";
        Assert.assertTrue(actualResult.contains(expectResult),"Correct appearance");
    }
 //   @Test
    public void UnbuildWithBuildOfMaterial(){
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        unbuildButton.UnbuildButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("//div[@class='modal-content']")).isDisplayed();
        Assert.assertTrue(actualResult,"Odo Server Error is DISPLAYED");
    }
    @Test (priority = 2)
    public void unbuildWithQuantity(){
        Driver.logger = Driver.extent.startTest("unbuild with Quantity Report");
        SeleniumUtil.pause(2);
        createButton.CreateButton.click();
        SeleniumUtil.pause(2);
       // createButton.CreateButton.click();
        productField.ProductField.click();
        Random random = new Random();
        int numOfDropDown = random.nextInt(4)+1;
        Driver.getDriver().findElement(By.xpath("(//li[@class='ui-menu-item'])["+numOfDropDown+"]")).click();
        quantityField.QuantityField.click();
        quantityField.QuantityField.clear();
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
//        quantityField.QuantityField.sendKeys(Keys.BACK_SPACE);
        quantityField.QuantityField.sendKeys("1");
        unbuildButton.UnbuildButton.click();
        boolean actualResult = Driver.getDriver().findElement(By.xpath("(//li[@class='active'])[3]")).isDisplayed();
        Assert.assertTrue(actualResult,"Unbuiled Order Created is DISPLAYED");
    }
}
