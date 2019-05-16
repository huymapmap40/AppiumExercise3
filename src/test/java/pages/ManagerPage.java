package pages;

import org.openqa.selenium.By;

public class ManagerPage {

    private static ManagerPage instance;

    //Locators
    protected By mnNewCustomer = By.xpath("//ul[@class='menusubnav']/li/a[text()='New Customer']");
    protected By mnNewAccount = By.xpath("//ul[@class='menusubnav']/li/a[text()='New Account']");
    protected By mnDeposit = By.xpath("//ul[@class='menusubnav']/li/a[text()='Deposit']");
    protected By mnDeleteAccount = By.xpath("//ul[@class='menusubnav']/li/a[text()='Delete Account']");
    protected By mnDeleteCustomer = By.xpath("//ul[@class='menusubnav']/li/a[text()='Delete Customer']");


    public static ManagerPage getInstance() {
        if(instance == null){
            instance = new ManagerPage();
        }
        return instance;
    }

    public NewCustomerPage gotoNewCustomerPage() {
        BasePage.getDriverInstance().findElement(mnNewCustomer).click();
        return NewCustomerPage.getInstance();
    }

    public NewAccountPage gotoNewAccountPage() {
        BasePage.getDriverInstance().findElement(mnNewAccount).click();
        return NewAccountPage.getInstance();
    }

    public DepositPage gotoDepositPage() {
        BasePage.getDriverInstance().findElement(mnDeposit).click();
        return DepositPage.getInstance();
    }

    public DeleteAccountPage gotoDeleteAccounttPage() {
        BasePage.getDriverInstance().findElement(mnDeleteAccount).click();
        return DeleteAccountPage.getInstance();
    }

    public DeleteCustomerPage gotoDeleteCustomerPage() {
        BasePage.getDriverInstance().findElement(mnDeleteCustomer).click();
        return DeleteCustomerPage.getInstance();
    }
}
