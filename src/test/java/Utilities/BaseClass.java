package Utilities;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class BaseClass {


    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if (result.getStatus() == ITestResult.FAILURE) {

            Driver.logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            Driver.logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this mehtod in to the extent reports using "logger.addScreenCapture" method.
            String screenshotPath = SeleniumUtil.getScreenshot(Driver.getDriver(), result.getName());
            //To add it in the extent report
            Driver.logger.log(LogStatus.FAIL, Driver.logger.addScreenCapture(screenshotPath));

        } else if (result.getStatus() == ITestResult.SKIP) {
            Driver.logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            Driver.logger.log(LogStatus.PASS,  result.getName() + " is Passed!");
        }
        Driver.extent.endTest(Driver.logger);
    }


    @AfterTest
    public void TearDown() {

        Driver.extent.flush();
        Driver.extent.close();

    }
}
