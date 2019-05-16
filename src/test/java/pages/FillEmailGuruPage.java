package pages;

import org.openqa.selenium.By;

public class FillEmailGuruPage {

    private static FillEmailGuruPage instance;

    //Locators
    protected By inptEmailAddress = By.xpath("//input[@name='emailid']");
    protected By btnSubmit = By.xpath("//input[@name='btnLogin']");
    protected By txtUserName = By.xpath("//td[@class='accpage'][contains(text(),'User ID')]/following-sibling::td");
    protected By txtPasswd = By.xpath("//td[@class='accpage'][contains(text(),'Password')]/following-sibling::td");

    public static FillEmailGuruPage getInstance() {
        if(instance == null){
            instance = new FillEmailGuruPage();
        }
        return instance;
    }

    public void fillEmailAddress(String email) {
        BasePage.getDriverInstance().findElement(inptEmailAddress).sendKeys(email);
    }

    public void clickSubmit() {
        BasePage.getDriverInstance().findElement(btnSubmit).click();
    }

    public void fillEmailAndSubmit(String email) {
        fillEmailAddress(email);
        clickSubmit();
    }

    public String getUserName() {
        return BasePage.getDriverInstance().findElement(txtUserName).getText();
    }

    public String getPassword() {
        return BasePage.getDriverInstance().findElement(txtPasswd).getText();
    }
}
