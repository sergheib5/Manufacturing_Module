package pages.BillsofMaterialsBerfu;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateBillsofMaterialsPage {
    public CreateBillsofMaterialsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


//    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
//    public WebElement ImportButton;

    @FindBy(xpath = "//input[@class='o_input ui-autocomplete-input']")
    public WebElement ProductInput;


    @FindBy(xpath = "//input[@class='o_field_float o_field_number o_field_widget o_input o_required_modifier']")
    public WebElement QuantityInput;



    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input']")
    public WebElement ReferenceInput;


    @FindBy(xpath = "//div[@class='o_radio_item']//input")
    public WebElement ManufactureThisProductRadioButton;


    @FindBy(xpath = "//label[.='Kit']")
    public WebElement KitRadioButton;



    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement SaveButton;


    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement DiscardButton;


    @FindBy(xpath = "//li[@class='ui-menu-item'][1]")
    public WebElement FirstProductInput;





}