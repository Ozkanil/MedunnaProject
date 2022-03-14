package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StatusPage {

    public StatusPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=login-item]/span")
    public WebElement loginButton;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[@type='submit'])")
    public WebElement signInButton;
    @FindBy(xpath = "//*[.='MY PAGES']")
    public WebElement myPagesDropdown;
    @FindBy(xpath = "(//*[@id='entity-menu']/div/a[1]/span) " )
    public WebElement myAppointmentIcon;
    @FindBy(xpath = "//*[@id=fromDate]")
    public WebElement fromDateTextBox;
    @FindBy(xpath = "//*[@id=toDate]")
    public WebElement toDateTextBox;
    @FindBy(xpath = "(//*[@class=btn btn-primary btn-sm])")
    public WebElement editButton;
    @FindBy(xpath = "(//*[@id='appointment-status']")
    public WebElement statusTextBox;
    @FindBy(xpath = "//*[@id=save-entity]")
    public WebElement saveButton;

}
