package pages.BillsOfMaterialUlku;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ValidetingTheSearchBox {


    public ValidetingTheSearchBox(){

            PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBoxOfBillsOfMaterial;

//    @FindBy(xpath="//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
//    public WebElement IphoneExpected;

    public List<WebElement> getAllresults (){
        return Driver.getDriver().findElements(By.xpath("//td[@class='o_data_cell o_readonly_modifier o_required_modifier']"));
    }

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement checkboxForItem1;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[2]/div/div[1]/button")
    public WebElement printbutton;

    @FindBy(xpath = "(//a[@data-index='0'])[1]")
    public WebElement choosefirst;



}
