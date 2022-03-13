package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditAnAppointmentPage {
    public CreateOrEditAnAppointmentPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='appointment-startDate']")
    public WebElement startDateTime;


    @FindBy(xpath = "//*[@id='appointment-endDate']")
    public WebElement endDateTime;

    @FindBy(xpath = "//*[@id='appointment-status']")
    public WebElement status;

    @FindBy(xpath = "//*[@id='appointment-anamnesis']")
    public WebElement anamnesis;

    @FindBy(xpath = "//*[@id='appointment-treatment']")
    public WebElement treatment;

    @FindBy(xpath = "//*[@id='appointment-diagnosis']")
    public WebElement diagnosis;

    @FindBy(xpath = "//*[@id='appointment-prescription']")
    public WebElement prescription;

    @FindBy(xpath = "//*[@id='appointment-description']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='appointment-physician']")
    public WebElement physician;

    @FindBy(xpath = "//*[@id='appointment-patient']")
    public WebElement patient;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveEntity;

    @FindBy(xpath = "//*[@id='cancel-save']")
    public WebElement cancelSave;

    @FindBy(xpath = "(//*[@value='UNAPPROVED'])")
    public WebElement unapprovedOptionOnEditAnAppointment;

    @FindBy(xpath = "(//*[@value='PENDING'])")
    public WebElement pendingOptionOnEditAnAppointment;

    @FindBy(xpath = "(//*[@value='COMPLETED'])")
    public WebElement completedOptionOnEditAnAppointment;

    @FindBy(xpath = "(//*[@value='CANCELLED'])")
    public WebElement cancelledOptionOnEditAnAppointment;

    @FindBy(xpath = "//*[@class='Toastify']")
    public WebElement successMessageToastContainer;

}
