package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchPatientOnStaffPage {


    public SearchPatientOnStaffPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(linkText = "MY PAGES")
    public WebElement myPagesDropdown;

    @FindBy(linkText = "Search Patient")
    public WebElement searchPatientDropdown;

    @FindBy(xpath= "//h2")
    public WebElement patientsText;

    @FindBy(name="ssn")
    public WebElement patientSSNSearchBox;

    @FindBy(xpath = "(//*[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButtonOnPatientSearch;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    public WebElement cancelButtonAfterView;

    @FindBy(xpath ="//*[@class='btn btn-primary']")
    public WebElement editButtonAfterView;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButtonOnPatientSearch;

    @FindBy(xpath = "(//*[@class='btn btn-warning btn-sm'])[1]")
    public WebElement showAppointmentsButton;

    @FindBy(xpath = "//h2")
    public WebElement patientTextAfterViewButton;

    @FindBy(xpath = "(//dd)[1]")
    public WebElement ssnTextAfterView;

    @FindBy(xpath = "//h2")
    public WebElement createEditPatientText;

    @FindBy(name="firstName")
    public WebElement nameBoxInCreateEditPatient;

    @FindBy(name="lastName")
    public WebElement lastnameBoxCreateEditPatient;

    @FindBy(name="birthDate")
    public WebElement birthdateBoxCreateEditPatient;

    @FindBy(name= "email")
    public WebElement emailBoxCreateEditPatient;

    @FindBy(name= "phone")
    public WebElement phoneBoxCreateEditPatient;

    @FindBy(name= "gender")
    public WebElement genderBoxCreateEditPatient;

    @FindBy(name= "bloodGroup")
    public WebElement bloodGroupBoxCreateEditPatient;

    @FindBy(name= "adress")
    public WebElement addressBoxCreateEditPatient;

    @FindBy(name= "description")
    public WebElement descriptionBoxCreateEditPatient;

    @FindBy(name= "user.id")
    public WebElement userBoxCreateEditPatient;

    @FindBy(name= "country.id")
    public WebElement countryBoxCreateEditPatient;

    @FindBy(name= "cstate.id")
    public WebElement stateBoxCreateEditPatient;

    @FindBy(name= "cancel-save")
    public WebElement backButtonCreateEditPatient;

    @FindBy(xpath = "//*[@class='btn btn-info']")
    public WebElement backButtonAtPatientInfo;

    @FindBy(xpath = "(//button)[2]")
    public WebElement saveButtonCreateEditPatient;

    @FindBy(xpath= "//h2")
    public WebElement appointmentTextUnderShowAppointments;

    @FindBy(xpath= "//*[@class='btn btn-warning btn-sm']")
    public WebElement editButtonUnderShowAppointments;

    @FindBy(xpath= "//h2")
    public WebElement createEditAppointmentText;

    @FindBy(name="startDate")
    public WebElement startDateBoxCreateEditAppointment;

    @FindBy(name="endDate")
    public WebElement endDateBoxCreateEditAppointment;

    @FindBy(name="status")
    public WebElement statusDropdownCreateEditAppointment;

    @FindBy(name="anamnesis")
    public WebElement anamnesisBoxCreateEditAppointment;

    @FindBy(name="treatment")
    public WebElement treatmentBoxCreateEditAppointment;

    @FindBy(name="diagnosis")
    public WebElement diagnosisBoxCreateEditAppointment;

    @FindBy(name="prescription")
    public WebElement prescriptionBoxCreateEditAppointment;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionBoxCreateEditAppointment;

    @FindBy(xpath = "//*[@id='appointment-physician']")
    public WebElement physicianDropdownCreateEditAppointment;

    @FindBy(name="patient.id")
    public WebElement patientDropdownCreateEditAppointment;

    @FindBy(id="cancel-save")
    public WebElement cancelButtonCreateEditAppointment;

    @FindBy(id="save-entity")
    public WebElement saveButtonCreateEditAppointment;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-sm']")
    public WebElement showTestsButton;

    @FindBy(id="c-test-heading")
    public WebElement testsTextUnderShowTests;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement saveSuccessAlert;

    @FindBy(xpath = "//*[@class='btn btn-warning btn-sm']")
    public WebElement editButtonAppointments;

    @FindBy(xpath = "//*[@class='btn btn-warning btn-sm']")
    public WebElement latestAppointment;

    @FindBy(xpath = "//option[@value='COMPLETED']")
    public WebElement completedDisabled;

    @FindBy (xpath = "//*[@class='d-none d-md-inline']")
    public WebElement viewTestsButton;

    @FindBy(xpath = "//*[@id='c-test-result-heading']")
    public WebElement testResultsPage;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])[23]")
    public WebElement showAppointmentButtonJack;

}
