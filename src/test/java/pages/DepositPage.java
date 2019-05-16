package pages;

import org.openqa.selenium.By;

public class DepositPage {

    private static DepositPage instance;

    //Locators
    protected By inptAccountNo = By.xpath("//input[@name='accountno']");
    protected By inptAmount = By.xpath("//input[@name='ammount']");
    protected By inptDescription = By.xpath("//input[@name='desc']");
    protected By btnSubmit = By.xpath("//input[@name='AccSubmit']");
    protected By lblSuccessDeposit = By.xpath("//table[@id='deposit']//p[@class='heading3']");

    // Dynamics control
    protected  By depositInfo(String infoType) {
        return By.xpath("//td[text()='"+ infoType +"']/following-sibling::td");
    }

    public static DepositPage getInstance() {
        if(instance == null){
            instance = new DepositPage();
        }
        return instance;
    }

    public void addNewDeposit(String accountId, int amount, String description) {
        BasePage.getDriverInstance().findElement(inptAccountNo).sendKeys(accountId);
        BasePage.getDriverInstance().findElement(inptAmount).sendKeys(Integer.toString(amount));
        BasePage.getDriverInstance().findElement(inptDescription).sendKeys(description);
        BasePage.getDriverInstance().findElement(btnSubmit).click();
    }

    public boolean isSuccessDepositMessageDisplayed() {
        return BasePage.getDriverInstance().findElement(lblSuccessDeposit).isDisplayed();
    }

    public String getSuccessDepositMessage() {
        return BasePage.getDriverInstance().findElement(lblSuccessDeposit).getText();
    }

    public String getTransactionID() {
        return BasePage.getDriverInstance().findElement(depositInfo("Transaction ID")).getText();
    }

    public String getAccountID() {
        return BasePage.getDriverInstance().findElement(depositInfo("Account No")).getText();
    }

    public String getAmountCredited() {
        return BasePage.getDriverInstance().findElement(depositInfo("Amount Credited")).getText();
    }

    public String getTransactionType() {
        return BasePage.getDriverInstance().findElement(depositInfo("Type of Transaction")).getText();
    }

    public String getDescription() {
        return BasePage.getDriverInstance().findElement(depositInfo("Description")).getText();
    }

    public String getCurrentBalance() {
        return BasePage.getDriverInstance().findElement(depositInfo("Current Balance")).getText();
    }
}
