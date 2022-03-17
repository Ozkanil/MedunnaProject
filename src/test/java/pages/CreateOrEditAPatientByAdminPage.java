package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditAPatientByAdminPage {
    public CreateOrEditAPatientByAdminPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@id='patient-firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='patient-id']")
    public WebElement id;

    @FindBy(xpath = "//input[@id='patient-lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='patient-birthDate']")
    public WebElement birthDate;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='patient-phone']")
    public WebElement phone;

    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@id='patient-bloodGroup']")
    public WebElement bloodGroup;

    @FindBy(xpath = "//input[@id='patient-adress']")
    public WebElement adress;

    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement description;

    @FindBy(xpath = "//select[@id='patient-user']")
    public WebElement user;

    @FindBy(xpath = "//select[@id='patient-country']")
    public WebElement country;

    @FindBy(xpath = "//select[@id='patient-cstate']")
    public WebElement stateCity;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement editButton;

    @FindBy(xpath = "//select[@id='patient-cstate']")
    public WebElement backButton;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'A new Patient is created')]")
    public WebElement successCreatedMessage;

    @FindBy(xpath = "//*[@id='appointment-physician']")
    public WebElement physician;

    @FindBy(xpath = "//select[@id='appointment-patient']")
    public WebElement patient;

    @FindBy(xpath = "//div[contains(text(),'The Appointment is updated')]")
    public WebElement successUpdatedMessage;


}
