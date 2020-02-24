package pages_tests;

import Utilities.BaseClass;
import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BillsofMaterialsBerfu.BillsOfMaterialsHomePage;
import pages.LoginPage;
import pages.ManufacturingOrders;

import java.util.List;

public class ManufacturingOrders_test_oytun extends BaseClass {

    @BeforeClass
    public void login() {
        LoginTest loginTest = new LoginTest();
        loginTest.loginManager();
    }

    @Test
    public void manufactureCreateOrder() throws InterruptedException {
        Driver.logger = Driver.extent.startTest("Manufacture Create Order");
        ManufacturingOrders manufacturingOrders = new ManufacturingOrders();
        manufacturingOrders.createButton.click();

        Assert.assertTrue(manufacturingOrders.productDropdwon.isEnabled(), "Product button is not Enable ");
        Assert.assertTrue(manufacturingOrders.quatityToProduce.isEnabled(), "Quantity button is not Enable ");
        Assert.assertTrue(manufacturingOrders.billOfMaterials.isEnabled(), "Bill Of Materials button is not Enable ");
        Assert.assertTrue(manufacturingOrders.daedlineStart.isEnabled(), "Product button is not Enable ");
        Assert.assertTrue(manufacturingOrders.responsible.isEnabled(), "Product button is not Enable ");
        Assert.assertTrue(manufacturingOrders.source.isEnabled(), "Source button is not Enable ");


        manufacturingOrders.productDropdwon.sendKeys("Book");
        manufacturingOrders.productDropdwon.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(2000);
        manufacturingOrders.productDropdwon.sendKeys(Keys.ENTER);
        manufacturingOrders.saveButtOn.click();
        String actual = manufacturingOrders.FailText.getText();
        String expect = "Sorry, you are not allowed to access this document. ";

        Assert.assertTrue(actual.contains(expect), "You Can Not Create New Order");
        manufacturingOrders.okayButton.click();
    }


    @Test
    public void delete() throws InterruptedException {
        Driver.logger = Driver.extent.startTest("Delete");

        ManufacturingOrders manufacturingOrders = new ManufacturingOrders();

        List<WebElement> checkbox = Driver.getDriver().findElements(By.xpath("//td[@class='o_list_record_selector']//input[@type='checkbox']"));
       // System.out.println(checkbox.get(1));
        //manufacturingOrders.getAllCheckBoxes().get(3).click();
        Thread.sleep(5000);
        checkbox.get(1).click();

        Assert.assertTrue(manufacturingOrders.actionButton.isEnabled(), "Action button is not Enable ");
        Assert.assertTrue(manufacturingOrders.printButton.isEnabled(), "Print button is not Enable ");
        manufacturingOrders.actionButton.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        manufacturingOrders.deleteButton.click();
        manufacturingOrders.okayButtinForDelete.click();

        String expected = "Cannot delete a manufacturing order not in cancel state";
        Assert.assertTrue(expected.equalsIgnoreCase(manufacturingOrders.actualResult.getText()));

        manufacturingOrders.finishButton.click();

    }
}
