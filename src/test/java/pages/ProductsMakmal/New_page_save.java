package pages.ProductsMakmal;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_page_save {
    public New_page_save(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath="(//input[starts-with(@id, 'o_field_input')])[3]")
    public WebElement can_be_sold;

    @FindBy(id="o_field_input_697")
    public WebElement can_be_expensed;

    @FindBy(xpath="(//input[starts-with(@id, 'o_field_input')])[4]")
    public WebElement can_be_purchased ;

    @FindBy(id="o_field_input_699" )
    public WebElement dropdownProductype;

    @FindBy(xpath = "(//input[starts-with(@id, 'o_field_input')])[6]")
    public WebElement dropdownCategory;

    @FindBy(linkText = "All")
    public WebElement firstOneDropdownCategory;

    @FindBy(xpath = "//input[@class = 'o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement inputText;

    @FindBy(xpath = "//button[@class = 'btn btn-primary btn-sm o_form_button_save']")
    public  WebElement saveButton;

    @FindBy(xpath = "(//ol[@class='breadcrumb']/li)[1]")
    public  WebElement products;

   @FindBy(xpath = "(//span[@class='o_field_char o_field_widget o_required_modifier']")
   public  WebElement editedword;

}
