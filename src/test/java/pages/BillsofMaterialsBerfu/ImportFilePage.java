package pages.BillsofMaterialsBerfu;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ImportFilePage {

    public ImportFilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Test Import']")
    public WebElement TestImportButton;

    @FindBy(xpath = "//button[.='Import']")
    public WebElement ImportButton;


    @FindBy(xpath = "//button[.='Cancel']")
    public WebElement CancelButton;


    @FindBy(xpath = "//label[@class='btn btn-primary']")
    public WebElement LoadFileButton;


    @FindBy(xpath = "//button[.='Reload File']")
    public WebElement ReloadFileButton;

    @FindBy(xpath = "//input[@class='oe_import_file_show form-control']")
    public WebElement ImportFileBox;


    @FindBy(xpath = "//button[contains(text(),'Import')]")
    public WebElement secondimportbutton;




}
