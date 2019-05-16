package pages;

import config.DeviceSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class BasePage {

    private static AppiumDriver driverInstance;
    private static WebDriverWait waitInstance;

    public BasePage() {
    }

    public static AppiumDriver getDriverInstance() {
        try {
            if (driverInstance == null){
                DeviceSetup device = new DeviceSetup();
                device.setUp();
                driverInstance = device.getDriver();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driverInstance;
    }

    public static WebDriverWait getWaitInstance() {
        if (waitInstance == null) {
            waitInstance = DeviceSetup.getWait();
        }
        return waitInstance;
    }

    public static void setupTest(String url) {
        System.out.println("Pre-condition");
        getDriverInstance().get(url);
    }

    public static void cleanUpTest() {
        System.out.println("CleanUp");
        getDriverInstance().quit();
    }
}
