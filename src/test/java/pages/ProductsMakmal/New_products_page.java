package pages.ProductsMakmal;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class New_products_page {

    public New_products_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//input[@class = 'o_searchview_input']")
    public WebElement search;

    @FindBy(xpath = "//span[@class = 'o_searchview_more fa fa-search-plus']")
    public WebElement searchclaicksign;

    @FindBy(xpath = "(//div[@class='oe_kanban_global_click o_kanban_record'])[1]")
    public WebElement productanyitem;



}
