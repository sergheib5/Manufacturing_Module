package pages_tests;

import Utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPageKenje.MainPageKenje;
import pages.Products;
import pages.reportsSerghei.ProductImportFilePage;
import pages.reportsSerghei.Reporting;
import pages.reportsSerghei.UserProductPage;

public class SergheiTest {

    LoginTest loginTest = new LoginTest();
    MainPageKenje mainPageKenje = new MainPageKenje();
    Reporting reporting = new Reporting();
    LoginPage loginPage = new LoginPage();
    Products products = new Products();
    ProductImportFilePage productImportFilePage = new ProductImportFilePage();
    UserProductPage userProductPage = new UserProductPage();
    @BeforeClass
    public void setUp() {
//        Driver.getDriver().get("http://app.briteerp.com/web/login");
        loginTest.loginManager();

    }

    @Test
    public void reportValidate() {
        mainPageKenje.reportManufOrders.click();
        String actualTitle = reporting.pageTitle.getText();
        String expectedTitle = "Manufacturing Orders";
        Assert.assertEquals(actualTitle, expectedTitle, "title is different");
        Assert.assertTrue(reporting.barChartBtn.isDisplayed(),"bar chart is not displayed");
        Assert.assertTrue(reporting.lineChartBtn.isDisplayed(), "line chart is not displayed");
        Assert.assertTrue(reporting.pieChartBtn.isDisplayed(), "pie chart is not displayed");
        Assert.assertTrue(reporting.measureBtn.isDisplayed(),"measure btn is not displayed");
        Assert.assertTrue(reporting.graphBtn.isDisplayed(),"graph btn is not displayed");
        Assert.assertTrue(reporting.pivotBtn.isDisplayed(),"pivot table is not displayed");
        Assert.assertTrue(reporting.listBtn.isDisplayed(),"list btn is not displayed");
        Assert.assertTrue(reporting.searchBtn.isDisplayed(),"search Btn is not displayed");




    }
    @Test(dependsOnMethods = "reportValidate")
    public void reportImgValidation(){
        reporting.barChartBtn.click();
        String barChartExpected = "bar";
        String barChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(barChartImage.contains(barChartExpected),"Bar chart imagine is wrong");

        reporting.lineChartBtn.click();
        String lineChartExpected = "line";
        String lineChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(lineChartImage.contains(lineChartExpected),"Line chart imagine is wrong");

        reporting.pieChartBtn.click();
        String pieChartExpected = "pie";
        String pieChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(pieChartImage.contains(pieChartExpected),"Bar chart imagine is wrong");
//        loginPage.manufacturingModule.click();

    }
    @Test
    public void productsImportBtn(){
        mainPageKenje.products.click();
        products.importBtn.click();
       String actualFormatOfTxt =  productImportFilePage.formatText.getText();
        System.out.println(actualFormatOfTxt);
       String expectedFormatOfTxt ="Select a CSV or Excel file to import.";
       Assert.assertTrue(actualFormatOfTxt.contains(expectedFormatOfTxt),"text format allowing is not displayed, or same");
//        productImportFilePage.loadBtn.sendKeys("excel file path");
//        productImportFilePage.cancelBtn.click();
      //  products. title should be displayed as Products


    }
   @Test
    public void printLabel() throws InterruptedException{
       loginTest.loginUser();
       Thread.sleep(2000);
       mainPageKenje.products.click();
       //click on the first products
        userProductPage.selectProduct.click();
        userProductPage.printBtn.click();
        userProductPage.productsLabel.click();
        userProductPage.accountMenu.click();


    }



}