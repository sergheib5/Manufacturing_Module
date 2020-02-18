package pages.UnbuildOrdersIVAN;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class UONewPage {
    public UONewPage(){PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement SaveButton;

    @FindBy(xpath = "//button[@class='btn btn-default btn-sm o_form_button_cancel']")
    public WebElement DiscardButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight']")
    public WebElement UnbuildButton;

    @FindBy(xpath = "//div[@class='o_notification_title']")
    public WebElement ErrorMessage;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement ProductField;

    @FindBy(xpath = "//input[@name='product_qty']")
    public WebElement QuantityField;






}
