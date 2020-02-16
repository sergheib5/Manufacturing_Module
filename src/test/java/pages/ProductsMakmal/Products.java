package pages.ProductsMakmal;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
    public Products(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

        @FindBy(xpath = "//li[.='Products']")
//        @FindBy(xpath = "//div[@class="o_control_panel"]//li[@class="active"]]")

        public WebElement productsTitle;










    }


