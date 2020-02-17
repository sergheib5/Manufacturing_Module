package pages_tests;

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

public class SergheiTest {

    LoginTest loginTest = new LoginTest();
    MainPageKenje mainPageKenje = new MainPageKenje();
    Reporting reporting = new Reporting();
    LoginPage loginPage = new LoginPage();
    Products products = new Products();
    ProductImportFilePage productImportFilePage = new ProductImportFilePage();

    @BeforeClass
    public void setUp() {
        loginTest.loginManager();

    }

    @Test
    public void reportValidate() {
        //validating report page look and buttons visibility
        mainPageKenje.reportManufOrders.click();
        SeleniumUtil.pause(3);
        String actualTitle = reporting.pageTitle.getText();
        String expectedTitle = "Manufacturing Orders";
        Assert.assertEquals(actualTitle, expectedTitle, "title is different");
        Assert.assertTrue(reporting.barChartBtn.isDisplayed(), "bar chart is not displayed");
        Assert.assertTrue(reporting.lineChartBtn.isDisplayed(), "line chart is not displayed");
        Assert.assertTrue(reporting.pieChartBtn.isDisplayed(), "pie chart is not displayed");
        Assert.assertTrue(reporting.measureBtn.isDisplayed(), "measure btn is not displayed");
        Assert.assertTrue(reporting.graphBtn.isDisplayed(), "graph btn is not displayed");
        Assert.assertTrue(reporting.pivotBtn.isDisplayed(), "pivot table is not displayed");
        Assert.assertTrue(reporting.listBtn.isDisplayed(), "list btn is not displayed");
        Assert.assertTrue(reporting.searchBtn.isDisplayed(), "search Btn is not displayed");


    }

    @Test
    public void reportImgValidation() {
        //verifying bar chart type imagine displayed
        mainPageKenje.reportManufOrders.click();

        reporting.barChartBtn.click();
        String barChartExpected = "bar";
        String barChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(barChartImage.contains(barChartExpected), "Bar chart imagine is wrong");
        SeleniumUtil.pause(3);

        //verifying line chart type imagine displayed
        reporting.lineChartBtn.click();
        String lineChartExpected = "line";
        String lineChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(lineChartImage.contains(lineChartExpected), "Line chart imagine is wrong");
        SeleniumUtil.pause(3);

        //verifying pie chart type imagine displayed
        reporting.pieChartBtn.click();
        String pieChartExpected = "pie";
        String pieChartImage = reporting.getImg.getAttribute("class").toLowerCase();
        Assert.assertTrue(pieChartImage.contains(pieChartExpected), "Bar chart imagine is wrong");

    }

    @Test
    public void productsImportBtn() {

        loginTest.loginPage.managermanufacturingModule.click();
        SeleniumUtil.pause(5);
        mainPageKenje.products.click();

        //verification is import Btn is clickable & the format message is displayed
        products.importBtn.click();
        String actualFormatOfTxt = productImportFilePage.formatText.getText();
        String expectedFormatOfTxt = "Select a CSV or Excel file to import.";
        //text displayed about format should be as expected
        Assert.assertTrue(actualFormatOfTxt.contains(expectedFormatOfTxt), "text format allowing is not displayed, or same");
    }



}