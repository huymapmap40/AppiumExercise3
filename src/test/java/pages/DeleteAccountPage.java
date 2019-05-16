package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteAccountPage {

    private static DeleteAccountPage instance;

    //Locators
    protected By inptAccountID = By.xpath("//input[@name='accountno']");
    protected By btnSubmit = By.xpath("//input[@value='Submit']");

    public static DeleteAccountPage getInstance() {
        if(instance == null){
            instance = new DeleteAccountPage();
        }
        return instance;
    }

    public void deleteAccount(String accountId) {
        BasePage.getDriverInstance().findElement(inptAccountID).sendKeys(accountId);
        BasePage.getDriverInstance().findElement(btnSubmit).click();
        if(BasePage.getWaitInstance().until(ExpectedConditions.alertIsPresent()) != null) {
            BasePage.getDriverInstance().switchTo().alert().accept();
            BasePage.getDriverInstance().switchTo().alert().accept();
        }
    }
}
