package pages_tests;

import Utilities.BaseClass;
import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPageKenje.MainPageKenje;
import pages.Products;
import pages.reportsSerghei.ProductImportFilePage;
import pages.reportsSerghei.Reporting;
import pages.reportsSerghei.UserProductPage;

public class PrintLabel_As_User extends BaseClass {

    LoginTest loginTest = new LoginTest();
    MainPageKenje mainPageKenje = new MainPageKenje();
    Products products = new Products();
    UserProductPage userProductPage = new UserProductPage();
    @BeforeClass
    public void setUp() {
        //login as a user & click on product field
        loginTest.loginUser();

    }

   @Test
    public void printLabel() {
       Driver.logger = Driver.extent.startTest("Print Label Report");
       SeleniumUtil.pause(3);
       mainPageKenje.products.click();
       //click on the first products
        userProductPage.selectProduct.click();
        //click on the "print" Btn
       WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
       wait.until(ExpectedConditions.visibilityOf(userProductPage.printBtn));
        userProductPage.printBtn.click();
        //print on the option available
        userProductPage.productsLabel.click();
        userProductPage.accountMenu.click();
        //verifying if the load sign is displayed
        Assert.assertTrue(products.loadImportSign.isDisplayed());


    }



}