package pages_tests;

import Utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPageKenje.MainPageKenje;
import pages.ProductsMakmal.*;
import pages_tests.LoginTest;

public class Products_test {
    LoginTest login1 = new LoginTest();
    MainPageKenje main=new MainPageKenje();
    Products products=new Products();
    Create_button_page create_button_page = new Create_button_page();
    New_page_save new_page_save=new New_page_save();
    New_products_page new_products_page=new New_products_page();
    EditButtonPage editButtonPage = new EditButtonPage();

    @BeforeClass
    public void login() {
        login1.loginManager();
    }


    @Test(priority = 0)
    public void checkTitle(){
        main.products.click();
        String actualText =products.productsTitle.getText();
        String expectedText="Products";


        Assert.assertEquals(actualText,expectedText,"title is different");
    }

    @Test (priority = 1)
    public void createProduct(){
        main.products.click();
        String actualText =products.productsTitle.getText();
        String expectedText="Products";


        Assert.assertEquals(actualText,expectedText,"title is different");
//        Assert.assertTrue(Driver.getDriver().getTitle().contains("Products"),"It is not on Product page");
        Assert.assertTrue(create_button_page.createButton.isDisplayed(),"Create button is not displayed");
        create_button_page.createButton.click();
        Assert.assertTrue(new_page_save.can_be_sold.isSelected(),"Is not selected");
        Assert.assertTrue(new_page_save.can_be_purchased.isSelected(),"Is not selected");
        Select select = new Select(new_page_save.dropdownProductype);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Stockable Product","is not selected");
        //   Assert.assertEquals(new_page_save.dropdownCategory.getText(),"All","is not selected"); couldn't do catefory all!!!!!

        new_page_save.inputText.sendKeys("parfum777");
        new_page_save.saveButton.click();
        new_page_save.products.click();
        new_products_page.search.sendKeys("parfum777");
        new_products_page.searchclaicksign.click();
//
//        Actions actions = new Actions(Driver.getDriver());
//        actions.clickAndHold(new_products_page.searchclaicksign).perform();
//        //coulkdn't pause
    }



    @Test (priority = 2)
    public void editButton() throws InterruptedException{
        main.products.click();
        String actualText =products.productsTitle.getText();
        String expectedText="Products";


        Assert.assertEquals(actualText,expectedText,"title is different");
        System.out.println(new_products_page.productanyitem.getText());
        Thread.sleep(5000);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
//        wait.until(ExpectedConditions.elementToBeClickable(new_products_page.productanyitem));
        new_products_page.productanyitem.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleIs("Book - Odoo"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Book - Odoo","Title dismatch");

    }


//    @AfterClass
//    public void closetab() {
//        Driver.quitDriver();
//    }






}

