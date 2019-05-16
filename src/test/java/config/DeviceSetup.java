package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Constant;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

public class DeviceSetup {

    private static DeviceSetup instance;
    private static AppiumDriver driver;
    protected static WebDriverWait wait;
    private String browserName;
    private String platformName;
    private String platformVersion;
    private String deviceName;
    private String deviceOrientation;
    private String appiumVersion;
    private String build; //set the build name of the application
    private String name; //set your test case name so that it shows up in Sauce Labs
    private String remoteAddress;

    public static DeviceSetup getInstance() {
        if(instance == null) {
            instance = new DeviceSetup();
        }
        return instance;
    }

    public String getBrowserName() {
        return browserName;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public void setWait(WebDriverWait wait) {
        DeviceSetup.wait = wait;
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void setDriver(AppiumDriver driver) {
        DeviceSetup.driver = driver;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceOrientation() {
        return deviceOrientation;
    }

    public void setDeviceOrientation(String deviceOrientation) {
        this.deviceOrientation = deviceOrientation;
    }

    public String getAppiumVersion() {
        return appiumVersion;
    }

    public void setAppiumVersion(String appiumVersion) {
        this.appiumVersion = appiumVersion;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }


    private AppiumDriver prepareDevice(String appiumVersion, String browserName, String platformName, String platformVersion,
                                       String deviceName, String deviceOrientation, String build, String name, String remoteAddress) throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.APPIUM_VERSION, appiumVersion);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        caps.setCapability("deviceOrientation", deviceOrientation);
        caps.setCapability("build", build);
        caps.setCapability("name", name);
        caps.setCapability("username", Constant.sauceUserName);
        caps.setCapability("accessKey", Constant.sauceAccessKey);
        driver = new AppiumDriver(new URL(remoteAddress), caps);
        return driver;
    }
    public void setUp() throws MalformedURLException {
        ConfigEnvironment environment = new ConfigEnvironment();
        setAppiumVersion(environment.getEnvironment("appiumVersion"));
        setBrowserName(environment.getEnvironment("browserName"));
        setPlatformName(environment.getEnvironment("platformName"));
        setPlatformVersion(environment.getEnvironment("platformVersion"));
        setDeviceName(environment.getEnvironment("deviceName"));
        setDeviceOrientation(environment.getEnvironment("deviceOrientation"));
        setBuild(environment.getEnvironment("build"));
        setName(environment.getEnvironment("name"));
        setRemoteAddress(environment.getEnvironment("remoteAddress"));
        prepareDevice(getAppiumVersion(),getBrowserName(),getPlatformName(),getPlatformVersion(),getDeviceName(),getDeviceOrientation(),
                getBuild(),getName(),getRemoteAddress());
        wait = new WebDriverWait(driver,15);
    }
}
