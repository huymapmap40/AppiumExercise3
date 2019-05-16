package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteCustomerPage {

    private static DeleteCustomerPage instance;

    //Locators
    protected By inptCustomerID = By.xpath("//input[@name='cusid']");
    protected By btnSubmit = By.xpath("//input[@value='Submit']");

    public static DeleteCustomerPage getInstance() {
        if(instance == null){
            instance = new DeleteCustomerPage();
        }
        return instance;
    }

    public void deleteCustomer(String customerId) {
        BasePage.getDriverInstance().findElement(inptCustomerID).sendKeys(customerId);
        BasePage.getDriverInstance().findElement(btnSubmit).click();
        if(BasePage.getWaitInstance().until(ExpectedConditions.alertIsPresent()) != null) {
            BasePage.getDriverInstance().switchTo().alert().accept();
            BasePage.getDriverInstance().switchTo().alert().accept();
        }
    }
}
