package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManufacturingOrders_Raghdah {

    public ManufacturingOrders_Raghdah(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public WebElement createButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[2]")
    public WebElement importButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[1]")
    public WebElement saveButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[2]")
    public WebElement discardButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]/div[1]/div[1]/button[8]")
    public WebElement cancelButton;
    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement productBox;
    @FindBy(xpath = "//*[@id='o_field_input_274']")
    public WebElement firstProductSelection;
    @FindBy(xpath ="//span[.='Ok']")
    public  WebElement xButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/form/div[1]/div[2]/div/span[1]/label")
    public WebElement loadFileButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/form/div[1]/div[2]/div/span[2]/button")
    public WebElement reloadFileButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/button[2]")
    public WebElement importFileButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/button[1]")
    public WebElement testImport;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/button[3]")
    public WebElement cancelLoadFileButton;
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]/div/input")
    public WebElement referenceCheckBox;


}
