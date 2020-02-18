package pages;

import Utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class UnbuildOrdersPage {
    public UnbuildOrdersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


}
