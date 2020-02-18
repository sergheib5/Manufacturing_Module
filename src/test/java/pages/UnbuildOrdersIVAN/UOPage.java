package pages.UnbuildOrdersIVAN;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UOPage {
    public UOPage(){PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_list_button_add']")
    public WebElement CreateButton;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default o_button_import']")
    public WebElement ImportButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement SearchButton;

    @FindBy(xpath = "//a[@data-menu='415']")
    public WebElement ManufacturPage;

    @FindBy(xpath = "//a[@data-action-id='605']")
    public WebElement UnbuildOrdersPage;


}
