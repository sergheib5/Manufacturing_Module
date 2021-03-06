package pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "login")
    public WebElement username;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;
    @FindBy(xpath = "(//span[contains(text(),'Manufacturing')])[1]")
    public WebElement usermanufacturingModule;
    @FindBy(xpath = "//span[contains(text(),'Manufacturing')]")
    public WebElement managermanufacturingModule;



}