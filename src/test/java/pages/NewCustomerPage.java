package pages;

import data_objects.Customer;
import org.openqa.selenium.By;

public class NewCustomerPage {

    private static NewCustomerPage instance;

    //Locators
    protected By inptCustomerName = By.xpath("//input[@name='name']");
    protected By inptBirthDay = By.xpath("//input[@name='dob']");
    protected By btnOkDate = By.id("android:id/button1");
    protected By txtAddress = By.xpath("//textarea[@name='addr']");
    protected By inptCity = By.xpath("//input[@name='city']");
    protected By inptState = By.xpath("//input[@name='state']");
    protected By inptPinNumber = By.xpath("//input[@name='pinno']");
    protected By inptPhoneNumber = By.xpath("//input[@name='telephoneno']");
    protected By inptEmailId = By.xpath("//input[@name='emailid']");
    protected By inptPassword = By.xpath("//input[@name='password']");
    protected By btnSubmit = By.xpath("//input[@value='Submit']");
    protected By btnReset = By.xpath("//input[@value='Reset']");
    protected By lblSuccessCreation = By.xpath("//table[@id='customer']//p[@class='heading3']");


    //Dynamic controls
    protected By customerInfo(String infoType) {
        return By.xpath("//td[text()='"+ infoType +"']/following-sibling::td");
    }

    public static NewCustomerPage getInstance() {
        if(instance == null){
            instance = new NewCustomerPage();
        }
        return instance;
    }

    public void addNewCustomer(Customer newCustomer) {
        // Fill all customer infomation
        BasePage.getDriverInstance().findElement(inptCustomerName).sendKeys(newCustomer.getName());
//        BasePage.getDriverInstance().findElement(inptBirthDay).sendKeys(newCustomer.getBirthdate());
        BasePage.getDriverInstance().findElement(inptBirthDay).click();
        BasePage.getDriverInstance().findElement(btnOkDate).click(); // Handle for date picker on mobile browser
        BasePage.getDriverInstance().findElement(txtAddress).sendKeys(newCustomer.getAddress());
        BasePage.getDriverInstance().findElement(inptCity).sendKeys(newCustomer.getCity());
        BasePage.getDriverInstance().findElement(inptState).sendKeys(newCustomer.getState());
        BasePage.getDriverInstance().findElement(inptPinNumber).sendKeys(newCustomer.getPin());
        BasePage.getDriverInstance().findElement(inptPhoneNumber).sendKeys(newCustomer.getMobileNumber());
        BasePage.getDriverInstance().findElement(inptEmailId).sendKeys(newCustomer.getEmail());
        BasePage.getDriverInstance().findElement(inptPassword).sendKeys(newCustomer.getPassword());

        // Click submit
        BasePage.getDriverInstance().findElement(btnSubmit).click();
    }

    public boolean isSuccessCustomerCreationDisplayed() {
        return BasePage.getDriverInstance().findElement(lblSuccessCreation).isDisplayed();
    }

    public String getSuccessCreationLabel() {
        return BasePage.getDriverInstance().findElement(lblSuccessCreation).getText();
    }

    public String getCustomerId() {
        return BasePage.getDriverInstance().findElement(customerInfo("Customer ID")).getText();
    }

    public String getCustomerName() {
        return BasePage.getDriverInstance().findElement(customerInfo("Customer Name")).getText();
    }

    public String getCustomerGender() {
        return BasePage.getDriverInstance().findElement(customerInfo("Gender")).getText();
    }

    public String getCustomerBrithDate() {
        return BasePage.getDriverInstance().findElement(customerInfo("Birthdate")).getText();
    }

    public String getCustomerAddress() {
        return BasePage.getDriverInstance().findElement(customerInfo("Address")).getText();
    }

    public String getCustomerCity() {
        return BasePage.getDriverInstance().findElement(customerInfo("City")).getText();
    }

    public String getCustomerState() {
        return BasePage.getDriverInstance().findElement(customerInfo("State")).getText();
    }

    public String getCustomerPin() {
        return BasePage.getDriverInstance().findElement(customerInfo("Pin")).getText();
    }

    public String getCustomerMobileNo() {
        return BasePage.getDriverInstance().findElement(customerInfo("Mobile No.")).getText();
    }

    public String getCustomerEmail() {
        return BasePage.getDriverInstance().findElement(customerInfo("Email")).getText();
    }
}
