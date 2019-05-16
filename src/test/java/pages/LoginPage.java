package pages;

import org.openqa.selenium.By;

public class LoginPage {

    private static LoginPage instance;

    //Locators
    protected By inptUserID = By.xpath("//input[@name='uid']");
    protected By inptPasswd = By.xpath("//input[@name='password']");
    protected By btnLogin = By.xpath("//input[@name='btnLogin']");
    protected By btnReset = By.xpath("//input[@name='btnReset']");

    public static LoginPage getInstance() {
        if(instance == null){
            instance = new LoginPage();
        }
        return instance;
    }

    public ManagerPage loginToManagerPage(String userId, String password) {
        BasePage.getDriverInstance().findElement(inptUserID).sendKeys(userId);
        BasePage.getDriverInstance().findElement(inptPasswd).sendKeys(password);
        BasePage.getDriverInstance().findElement(btnLogin).click();
        return ManagerPage.getInstance();
    }
}
