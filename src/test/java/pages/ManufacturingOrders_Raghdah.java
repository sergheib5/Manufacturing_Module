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

    @FindBy(xpath = "//*[@id='o_field_input_274']")
    public WebElement productBox;



    @FindBy(xpath = "//*[@id='o_field_input_274']")
    public WebElement firstProductSelection;

    @FindBy(xpath =" //*[@id=\"modal_302\"]/div/div/div[1]/button")
    public  WebElement xButton;



}
