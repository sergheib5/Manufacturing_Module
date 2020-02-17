package pages_tests;

import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BillsOfMaterialUlku.ValidetingTheSearchBox;
import pages.MainPageKenje.MainPageKenje;
import java.security.Key;
import java.util.List;

public class BillsOfMaterials_test_Ulku {
    LoginTest login1 = new LoginTest();
    MainPageKenje main=new MainPageKenje();
    ValidetingTheSearchBox search=new ValidetingTheSearchBox();
    @BeforeClass
            public void login() {
        login1.loginUser();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(main.billsOfMaterials)).click();
        SeleniumUtil.pause(5);

    }
    @Test(priority = 0)
    public void click(){
        Assert.assertTrue(main.billsOfMaterials.isEnabled(),"Bills of material button is not workig");
    }
    @Test(priority = 1)
    public void mainPageVerification(){
        main.billsOfMaterials.click();
        SeleniumUtil.pause(5);
        String actual=Driver.getDriver().getTitle();
        SeleniumUtil.pause(5);
        String expected="Bills of Materials - Odoo";
        Assert.assertEquals(actual,expected);
    }

    @Test(priority = 2)
    public void sendValidKeys(){
        main.billsOfMaterials.click();
        SeleniumUtil.pause(3);
        search.searchBoxOfBillsOfMaterial.sendKeys("iphone"+ Keys.ENTER);
        SeleniumUtil.pause(3);
//        search.searchBoxOfBillsOfMaterial.sendKeys("iphone"+ Keys.ENTER);

        SeleniumUtil.pause(3);
       // search.searchBoxOfBillsOfMaterial.sendKeys("iphone"+ Keys.ENTER);

        String expectedResult="iphone";
        SeleniumUtil.pause(5);
        List<WebElement> l= search.getAllresults();

        for(WebElement each: l){
            Assert.assertTrue(each.getText().contains(expectedResult));
        }
    }
    @Test(priority = 3)
    public void printBillsOfMaterial(){


//        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(),30);
//        wait1.until(ExpectedConditions.visibilityOf(search.searchBoxOfBillsOfMaterial)).sendKeys("iphone"+ Keys.ENTER);
        search.searchBoxOfBillsOfMaterial.sendKeys("iphone"+ Keys.ENTER);

        SeleniumUtil.pause(2);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.elementToBeClickable(search.checkboxForItem1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(search.printbutton)).click();

        wait.until(ExpectedConditions.elementToBeClickable(search.choosefirst)).click();
        Assert.assertTrue(true,"Print option is not selected");

    }


}
