package pages;

import org.openqa.selenium.By;

public class NewAccountPage {

    private static NewAccountPage instance;

    //Locators
    protected By inptCustomerID = By.xpath("//input[@name='cusid']");
    protected By drpAccountType = By.xpath("//select[@name='selaccount']");
    protected By inptDepositInitial = By.xpath("//input[@name='inideposit']");
    protected By btnSubmit = By.xpath("//input[@value='submit']");
    protected By lblSuccessCreation = By.xpath("//table[@id='account']//p[@class='heading3']");

    //Dynamic controls
    protected  By optAccountType(String accountType) {
        return By.xpath("//select[@name='selaccount']/option[@value='" + accountType + "']");
    }

    protected  By accountInfo(String infoType) {
        return By.xpath("//td[text()='"+ infoType +"']/following-sibling::td");
    }

    public static NewAccountPage getInstance() {
        if(instance == null){
            instance = new NewAccountPage();
        }
        return instance;
    }

    public void addNewAccount(String customerID, String accountType, int depositInitial) {
        BasePage.getDriverInstance().findElement(inptCustomerID).sendKeys(customerID);
        BasePage.getDriverInstance().findElement(drpAccountType).click();
        BasePage.getDriverInstance().findElement(optAccountType(accountType)).click();
        BasePage.getDriverInstance().findElement(inptDepositInitial).sendKeys(Integer.toString(depositInitial));
        BasePage.getDriverInstance().findElement(btnSubmit).click();
    }

    public boolean isSuccessAccountMessageDisplayed() {
        return BasePage.getDriverInstance().findElement(lblSuccessCreation).isDisplayed();
    }

    public String getSuccessAccountMessage() {
        return BasePage.getDriverInstance().findElement(lblSuccessCreation).getText();
    }

    public String getAccountID() {
        return BasePage.getDriverInstance().findElement(accountInfo("Account ID")).getText();
    }

    public String getCustomerID() {
        return BasePage.getDriverInstance().findElement(accountInfo("Customer ID")).getText();
    }

    public String getCustomerName() {
        return BasePage.getDriverInstance().findElement(accountInfo("Customer Name")).getText();
    }

    public String getEmail() {
        return BasePage.getDriverInstance().findElement(accountInfo("Email")).getText();
    }

    public String getAccountType() {
        return BasePage.getDriverInstance().findElement(accountInfo("Account Type")).getText();
    }

    public String getDateOpening() {
        return BasePage.getDriverInstance().findElement(accountInfo("Date of Opening")).getText();
    }

    public int getCurrentAmount() {
        String currentBalance = BasePage.getDriverInstance().findElement(accountInfo("Current Amount")).getText();
        return Integer.valueOf(currentBalance);
    }

}
