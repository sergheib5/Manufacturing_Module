package pages.MainPageKenje;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPageKenje {

    public MainPageKenje(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-action-id='596']")
    public WebElement reportManufOrders;

    @FindBy(xpath = "//a[@data-action-id='596']")
    public WebElement unbuildOrders;

    @FindBy(xpath = "//a[@data-action-id='603']")
    public WebElement products;

    @FindBy(xpath = "//a[@data-action-id='600']")
    public WebElement billsOfMaterials;

    @FindBy(xpath = "//span[contains(text(),'Bills of Materials')]")
    public WebElement managerbillsOfMaterials;


}
