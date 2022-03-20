package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class AppointmentAdminPage {
    public AppointmentAdminPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "(//*[.='Create a new Appointment']) [1]")
    public WebElement createANewAppointment;

    @FindBy(xpath = "((//*[.='Edit'])//span)[1]")
    public WebElement editButtonInAppointmentsPage;

    @FindBy(xpath = "//*[@id='fromDate']")
    public WebElement fromDataInAppointmentsPage;

    @FindBy(xpath = "//*[@id='toDate']")
    public WebElement toDataInAppointmentsPage;

    @FindBy(xpath = "(//tr//th)[1]")
    public WebElement IdOnAppointmentsTable;

    @FindBy(xpath = "(//tr//th)[2]")
    public WebElement startDateTimeOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[3]")
    public WebElement endDataTimeOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[4]")
    public WebElement statusOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[5]")
    public WebElement anamnesisOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[6]")
    public WebElement treatmentOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[7]")
    public WebElement diagnosisOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[8]")
    public WebElement prescriptionOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[9]")
    public WebElement descriptionOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[10]")
    public WebElement createdDateOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[11]")
    public WebElement physicianOnAppointmentTable;

    @FindBy(xpath = "(//tr//th)[12]")
    public WebElement patientOnAppointmentTable;

    @FindBy(xpath = "((//*[.='View'])//span)[1]")
    public WebElement viewButton;

    @FindBy(xpath = "((//*[.='Edit'])//span)[1]")
    public WebElement editButton;

    @FindBy(xpath = "((//*[.='Delete'])//span)[1]")
    public WebElement deleteButton;

}
