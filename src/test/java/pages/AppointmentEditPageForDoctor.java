package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

public class AppointmentEditPageForDoctor {
    public AppointmentEditPageForDoctor() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[.='Request A Test']")
    public WebElement requestATestButton;

    @FindBy(xpath = "//*[.='Show Test Results']")
    public WebElement showTestResultButton;

    @FindBy(xpath = "//*[.='Request Inpatient']")
    public WebElement requestInpatientButton;

    @FindBy(xpath = "//*[.='Create or Edit an Appointment']")
    public WebElement createOrEditAnAppointmentHeader;

    @FindBy(id="appointment-id")
    public WebElement appointmentIdBox;

    @FindBy(id = "appointment-startDate")
    public WebElement appointmentStartDateBox;

    @FindBy(id = "appointment-endDate")
    public WebElement appointmentEndDateBox;

    @FindBy(id = "appointment-status")
    public WebElement appointmentStatusBox;

    @FindBy(id = "appointment-anamnesis")
    public WebElement appointmentAnamnesisBox;

    @FindBy(id="appointment-treatment")
    public WebElement appointmentTreatmentBox;

    @FindBy(id = "appointment-diagnosis")
    public WebElement appointmentDiagnosisBox;

    @FindBy(id = "appointment-prescription")
    public WebElement appointmentPrescriptionBox;

    @FindBy(id = "appointment-description")
    public WebElement appointmentDescriptionBox;

    @FindBy(id = "appointment-physician")
    public WebElement appointmentPhysicianBox;

    @FindBy(id = "appointment-patient")
    public WebElement appointmentPatientBox;

    @FindBy(id = "cancel-save")
    public WebElement goBackButton;

    @FindBy(id = "save-entity")
    public WebElement saveButton;

    @FindBy(partialLinkText = "The Appointment is updated with identifier" )
    public WebElement successAlertText;

    @FindBy(className = "Toastify__toast-body")
    public WebElement alertElement;








}
