package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientPageAll {

    public PatientPageAll(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Sign in'])[2]")
    public WebElement signinHeaderVrf;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//span[text()='Sign in'])[3]")
    public WebElement signinButton;

    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement myPagePatient;

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement singOutButton;

    @FindBy(xpath = "//*[text()='SIGN IN AGAIN']")
    public WebElement signInAgainBtn;

    @FindBy(xpath = "(//*[@class='is-untouched is-pristine av-valid form-control'])[1]")
    public WebElement firstNameValue;

    @FindBy(xpath = "(//*[@class='is-untouched is-pristine av-valid form-control'])[2]")
    public WebElement lastNameValue;

    @FindBy(xpath = "(//*[@class='is-untouched is-pristine av-valid form-control'])[3]")
    public WebElement SSNValue;

    @FindBy(xpath = "(//*[@class='is-untouched is-pristine av-valid form-control'])[4]")
    public WebElement emailValue;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointments;

    @FindBy(xpath = "//*[@id='appointment-heading']")
    public WebElement appointmentsTextVrf;

    @FindBy(xpath = "//input[@id='fromDate']")
    public WebElement fromDateBoxApp;

    @FindBy(xpath = "//input[@id='toDate']")
    public WebElement toDateBoxApp;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement daysBetween;


}