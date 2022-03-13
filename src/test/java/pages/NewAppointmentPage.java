package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NewAppointmentPage {
    public NewAppointmentPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "account-menu")
    public WebElement loginDropdown;
    @FindBy(id = "account-menu")
    public WebElement signInIcon;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(id = "login-item")
    public WebElement signInButton;
    @FindBy(xpath = "(//li)[7]")
    public WebElement myPagesDropdown;
    @FindBy(linkText = "Make an Appointment")
    public WebElement makeAppointment;
    @FindBy(id = "firstName")
    public WebElement firstNameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastNameTextBox;
    @FindBy(xpath ="//*[@id='ssn']")
    public WebElement ssnTextBox;
    @FindBy(id = "email")
    public WebElement emailTextBox;
    @FindBy(id = "phone")
    public WebElement phoneTextBox;
    @FindBy(id = "appoDate")
    public WebElement appointmentDateTimeTextBox;
    @FindBy(id = "register-submit")
    public WebElement sendAndAppointmentRequestButton;
    @FindBy(xpath = "//h2")
    public WebElement appointmentVerificationText;
}
