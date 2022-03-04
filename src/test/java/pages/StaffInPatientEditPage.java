package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffInPatientEditPage {
    public StaffInPatientEditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Create or edit a In Patient')]")
    public WebElement createOrEditAInPatientText;

    @FindBy(xpath = "//input[@id='in-patient-id']")
    public WebElement idBox;

    @FindBy(xpath = "//input[@id='in-patient-startDate']")
    public WebElement startDateBox;

    @FindBy(xpath = "//input[@id='in-patient-endDate']")
    public WebElement endDateBox;

    @FindBy(xpath = "//input[@id='in-patient-description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@id='in-patient-createdDate']")
    public WebElement createdDateBox;

    @FindBy(xpath = "//select[@id='in-patient-appointment']")
    public WebElement appointmentBox;

    @FindBy(xpath = "//select[@id='in-patient-status']")
    public WebElement statusBox;

    @FindBy(xpath = "//select[@id='in-patient-room']")
    public WebElement roomBox;

    @FindBy(xpath = "//select[@id='in-patient-patient']")
    public WebElement patientBox;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    public WebElement backButton;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;


}
