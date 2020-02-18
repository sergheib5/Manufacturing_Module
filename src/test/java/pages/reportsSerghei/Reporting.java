package pages.reportsSerghei;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.MainPageKenje.MainPageKenje;

public class Reporting {

    public Reporting(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//li[.='Manufacturing Orders']")
    public WebElement pageTitle;

    @FindBy (xpath = "//button[contains(text(),'Measure')]")
    public WebElement measureBtn;

    @FindBy(xpath = "//button[@data-original-title='Bar Chart']")
    public WebElement barChartBtn;

    @FindBy (xpath = "//button[@data-original-title='Line Chart']")
    public WebElement lineChartBtn;

    @FindBy (xpath = "//button[@data-original-title='Pie Chart']")
    public WebElement pieChartBtn;

    @FindBy (xpath = "//button[@data-original-title='Graph']")
    public WebElement graphBtn;

    @FindBy (xpath = "//button[@data-original-title='Pivot']")
    public WebElement pivotBtn;

    @FindBy (xpath = "//button[@data-original-title='List']")
    public WebElement listBtn;

    @FindBy(css = "div > svg > g")
    public WebElement getImg;

    @FindBy(css = ".o_searchview_input")
    public WebElement searchBtn;











}
