package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverInitializer;

import java.util.HashMap;
import java.util.Map;

public class extentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = extentManager.getExtentReports();

    public static ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest saveToReport(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }

    public static void logMessage(String message) {
        getTest().log(Status.INFO, message);
    }

    public static void logMessage(Status status, String message) {
        getTest().log(status, message);
    }

    public static void addScreenShot(String message) {
        WebDriver driver = DriverInitializer.getDriver();

        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void addScreenShot(Status status, String message) {
        WebDriver driver = DriverInitializer.getDriver();
        String base64Image = "data:image/png;base64,"
                + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
