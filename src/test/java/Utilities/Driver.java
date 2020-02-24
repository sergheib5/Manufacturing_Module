package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){

    }

    private static WebDriver driver;

    public static ExtentReports extent;
    public static ExtentTest logger;

    public static WebDriver getDriver(){
        if(driver ==  null){

           switch (Config.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    if(System.getProperty("os.name").toLowerCase().contains("windows")){
                        throw new WebDriverException("Windows OS does not support safari");
                    }
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;

            }
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

            extent = new ExtentReports(
                    System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
            extent.addSystemInfo("Environment", "QA ENVIRONMENT")
                    .addSystemInfo("User Name", "CODING NINJA");
            extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));


        }
        return driver;
    }

    public static void quitDriver(){
        if(driver !=null)
            driver.quit();
        driver = null;

    }
}

