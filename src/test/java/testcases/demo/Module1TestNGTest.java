package testcases.demo;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Module1TestNGTest {
    private AndroidDriver driver;

    @Test
    public void shouldOpenSafari() throws MalformedURLException {

        /**
         * In this section, we will configure our SauceLabs credentials in order to run our tests on saucelabs.com
         */
        String sauceUserName = "huymapmap40";
        String sauceAccessKey = "822a03df-f182-42a7-b8d9-48c5b1efc119";
        String URL = "https://" + sauceUserName + ":" + sauceAccessKey + "@ondemand.saucelabs.com:443/wd/hub";
        /**
         * In this section, we will configure our test to run a specific
         * browser/os combination in Sauce Labs
         */

        DesiredCapabilities capabilities = new DesiredCapabilities();

        //set your user name and access key to run tests in Sauce
        capabilities.setCapability("username", sauceUserName);

        //set your sauce labs access key
        capabilities.setCapability("accessKey", sauceAccessKey);

        //set browser to Safari
        capabilities.setCapability("browserName", "Chrome");

        //set operating system to macOS version 10.13
        capabilities.setCapability("platformName", "Android");

        //set the browser version to 11.1
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("deviceName","Samsung Galaxy S6 GoogleAPI Emulator");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("appiumVersion", "1.9.1");

        //set the build name of the application
        capabilities.setCapability("build", "Onboarding Sample App - Java-TestNG");

        //set your test case name so that it shows up in Sauce Labs
        capabilities.setCapability("name", "1-first-test");

        /**
         * In this section, we will set the WebDriver to a Remote driver to run on sauce, and pass the capabilities
         * we just set. Then we perform som actions on the page before quitting the driver.
         */

        //create a new Remote driver that will allow your test to send
        // commands to the Sauce Labs grid so that Sauce can execute your tests
        /** If you're accessing the EU data center, use the following endpoint:.
         * https://ondemand.eu-central-1.saucelabs.com/wd/hub
         * */
//        driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);
        driver = new AndroidDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);

        //navigate to the url of the Sauce Labs Sample app
        driver.navigate().to("https://www.saucedemo.com");

        //Create an instance of a Selenium explicit wait so that we can dynamically wait for an element
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //wait for the user name field to be visible and store that element into a variable
        By userNameFieldLocator = By.cssSelector("[type='text']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameFieldLocator));

        //type the user name string into the user name field
        driver.findElement(userNameFieldLocator).sendKeys("standard_user");

        //type the password into the password field
        driver.findElement(By.cssSelector("[type='password']")).sendKeys("secret_sauce");

        //hit Login button
        driver.findElement(By.cssSelector("[type='submit']")).click();

        //Synchronize on the next page and make sure it loads
        By inventoryPageLocator = By.id("inventory_container");
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryPageLocator));

        /**
         * In this section, we confirm the test ran correctly, however we don't post the results to saucelabs.com
         */
        //Assert that the inventory page displayed appropriately
        Assert.assertTrue(driver.findElement(inventoryPageLocator).isDisplayed());

        //Here we tear down the WebDriver session
        driver.quit();
    }
}
