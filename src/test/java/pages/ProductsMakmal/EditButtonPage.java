package pages.ProductsMakmal;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditButtonPage {
        public EditButtonPage(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//button[@accesskey='c']")

        public WebElement createButton;


        @FindBy(xpath = "//button[@accesskey='a']")

        public WebElement clickEdit;


    }

