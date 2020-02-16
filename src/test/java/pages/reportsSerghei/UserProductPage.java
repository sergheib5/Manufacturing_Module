package pages.reportsSerghei;

import Utilities.Config;
import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProductPage {
    public UserProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    String productNum = Config.getProperty("Productnumber");
    String xpathNumberOfProduct = "(//div[@class='oe_kanban_details'])["+productNum+"]";


    @FindBy(xpath = "(//div[@class='oe_kanban_details'])[1]")
    public WebElement selectProduct;

    @FindBy(xpath = "//button[contains(text(), 'Print')]")
    public WebElement printBtn;

    @FindBy(xpath = "//*[contains(text(), 'Products Labels')]")
    public WebElement productsLabel;

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement accountMenu;



}
