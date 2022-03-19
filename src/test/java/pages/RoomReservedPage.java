package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RoomReservedPage {

    public RoomReservedPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "//*[@id='account-menu']/a")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[@id='login-item']/span")
    public WebElement SignInIcon;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signInButton;

    @FindBy(xpath = "//*[@id='entity-menu']/a")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "//*[@id='entity-menu']/div/a[3]")
    public WebElement myInPatientsDropDown;

    @FindBy(xpath = "//*[@id='fromDate']")
    public WebElement fromDateTextBox;

    @FindBy(xpath = "//*[@id='toDate']")
    public WebElement toDateTextBox;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div/table/tbody/tr/td[10]/div/a")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id='in-patient-room']")
    public WebElement roomTextBox;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;
}

