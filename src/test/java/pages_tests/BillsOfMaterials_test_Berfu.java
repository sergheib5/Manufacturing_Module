package pages_tests;

import Utilities.Driver;
import Utilities.SeleniumUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BillsofMaterialsBerfu.BillsOfMaterialsHomePage;
import pages.BillsofMaterialsBerfu.CreateBillsofMaterialsPage;
import pages.BillsofMaterialsBerfu.ImportFilePage;
import pages.MainPageKenje.MainPageKenje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BillsOfMaterials_test_Berfu {

    LoginTest login = new LoginTest();
    MainPageKenje main=new MainPageKenje();
    CreateBillsofMaterialsPage createMaterialPage = new CreateBillsofMaterialsPage();
    ImportFilePage importFilePage = new ImportFilePage();
    pages.BillsofMaterialsBerfu.BillsOfMaterialsHomePage BillsOfMaterialsHomePage= new BillsOfMaterialsHomePage();


    @BeforeClass
    public void setup(){
        login.loginManager();
    }


    @Test
    public void CreateBillsOfMaterials(){
        //Go to Website as Manager and click Manufacturing module
        //login.loginManager();

        //Click on Bills of Materials button
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(main.managerbillsOfMaterials)).click();

        //Verify Create button is displayed and enabled
        Assert.assertTrue(BillsOfMaterialsHomePage.CreateButton.isDisplayed() && BillsOfMaterialsHomePage.CreateButton.isEnabled());
        Utilities.SeleniumUtil.pause(5);

        //Click on Create button
        BillsOfMaterialsHomePage.CreateButton.click();
        Utilities.SeleniumUtil.pause(5);

        //Verify Quantity button is displayed, enabled
        Assert.assertTrue(createMaterialPage.ProductInput.isDisplayed() && createMaterialPage.ProductInput.isEnabled());

        //Click Product Dropdown Button
        createMaterialPage.ProductInput.click();
        Utilities.SeleniumUtil.pause(4);

        //Choose first product
        createMaterialPage.FirstProductInput.click();

        //Verify Quantity button is displayed, enabled and Clear and Provide Quantity information
        Assert.assertTrue(createMaterialPage.QuantityInput.isDisplayed() && createMaterialPage.QuantityInput.isEnabled());
        createMaterialPage.QuantityInput.clear();
        createMaterialPage.QuantityInput.sendKeys("1.00");

        //Verify Reference button is displayed, enabled and Provide reference information
        Assert.assertTrue(createMaterialPage.ReferenceInput.isDisplayed() && createMaterialPage.ReferenceInput.isEnabled());
        createMaterialPage.ReferenceInput.sendKeys("1234");

        //Verify BoM type radio buttons are displayed and by default manufacture this product is selected.
        Assert.assertTrue(createMaterialPage.ManufactureThisProductRadioButton.isSelected());
        //Verify Save Button is enabled and displayed.
        Assert.assertTrue(createMaterialPage.SaveButton.isEnabled() && createMaterialPage.SaveButton.isDisplayed());
        //Verify Discard Button is enabled and disabled.
        Assert.assertTrue(createMaterialPage.DiscardButton.isEnabled()&& createMaterialPage.DiscardButton.isDisplayed());
        //click to the Save Button
        createMaterialPage.SaveButton.click();

    }

    @Test
    public void Importfile(){
        //Go to Website as Manager and click Manufacturing module
       // login.loginManager();
        //Click on Bills of Materials button
        SeleniumUtil.pause(3);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(main.managerbillsOfMaterials)).click();

        //Verify Import button is displayed and enabled
        SeleniumUtil.pause(3);
        Assert.assertTrue(BillsOfMaterialsHomePage.ImportButton.isDisplayed() && BillsOfMaterialsHomePage.ImportButton.isEnabled());

        // Click Import Button
        BillsOfMaterialsHomePage.ImportButton.click();
        SeleniumUtil.pause(4);

        //After Import click, it shows again create and import buttons
        importFilePage.secondimportbutton.click();


        //Verify Import button is displayed but not enabled
        Assert.assertTrue(importFilePage.ImportButton.isDisplayed());
        Assert.assertFalse(importFilePage.ImportButton.isEnabled());

        //Verify Load file button is displayed and enabled
        Assert.assertTrue(importFilePage.LoadFileButton.isDisplayed());
        Assert.assertTrue(importFilePage.LoadFileButton.isEnabled());

        //Verify Reaload file button is displayed and not enabled
        Assert.assertTrue(importFilePage.ReloadFileButton.isDisplayed());
        Assert.assertFalse(importFilePage.ReloadFileButton.isEnabled());

        //Verify Test Import button displayed but not Enable
        Assert.assertTrue(importFilePage.TestImportButton.isDisplayed());
        Assert.assertFalse(importFilePage.TestImportButton.isEnabled());

        //Verify Cancel button is displayed and enabled
        Assert.assertTrue(importFilePage.CancelButton.isDisplayed());
        Assert.assertTrue(importFilePage.CancelButton.isEnabled());




        //importFilePage.LoadFileButton.sendKeys("/Users/berfu/Downloads/Test Case.xlsx");
    }


    @Test
    public void DeleteMaterial(){
        //Go to Website as Manager and click Manufacturing module
        //login.loginManager();
        //Click on Bills of Materials button
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
        wait.until(ExpectedConditions.visibilityOf(main.managerbillsOfMaterials)).click();

        //Verify check box buttons are Enable
        List<WebElement> list= BillsOfMaterialsHomePage.getAllCheckBoxes();
        SeleniumUtil.pause(2);
        for(int i=0; i< list.size(); i++ ){
            list= BillsOfMaterialsHomePage.getAllCheckBoxes();
            Assert.assertTrue(list.get(i).isEnabled());
        }

        //Verify  one of the Bills of Material is displayed and enabled. Select
        WebElement onecheckbox= BillsOfMaterialsHomePage.getAllCheckBoxes().get(7);
        onecheckbox.click();
        SeleniumUtil.pause(2);

        //click again because it is reset.
//        onecheckbox= BillsOfMaterialsHomePage.getAllCheckBoxes().get(9);
//        onecheckbox.click();

        //SeleniumUtil.pause(2);
        //Verify action button is displayed and enabled.
        Assert.assertTrue(BillsOfMaterialsHomePage.actionsButton.isDisplayed()&& BillsOfMaterialsHomePage.actionsButton.isEnabled() );
        BillsOfMaterialsHomePage.actionsButton.click();
        SeleniumUtil.pause(3);

        //Verify all options under the Actions button are Export, Archive, Unarchive, Delete respectively.
        List<WebElement> l = BillsOfMaterialsHomePage.getAllActionOptions();
        List <String> nameofList= new ArrayList<>();
        for(WebElement each: l){
            nameofList.add(each.getText().trim());
        }
        String [] expected= {"Export","Archive", "Unarchive","Delete"};
        List<String> expectedList= new ArrayList<>(Arrays.asList(expected));
        Assert.assertEquals(nameofList,expectedList);

        //click delete button
        l.get(3).click();

        //Click ok on confirmation alert.
        BillsOfMaterialsHomePage.deleteAlert.click();

    }


}
