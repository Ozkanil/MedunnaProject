package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAppointmentPageAsDoctor {
    public MyAppointmentPageAsDoctor() { PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath =" (//a[span])[8]")
     public WebElement myAccountDropdownText;

    @FindBy(xpath = "//*[span='MY PAGES']" )
    public WebElement myPagesDropdown;
//=======ADMIN========
    @FindBy(xpath = "//*[span='Items&Titles']" )
    public WebElement itemsTitlesDropdown;
//========PATIENT=======
@FindBy(xpath = "//*[span='MY PAGES(PATIENT)']" )
public WebElement patientMyPagesDropdown;

    @FindBy(xpath = "//*[span='My Appointments']" )
    public WebElement myAppointment;

    @FindBy(xpath = "//*[span='Appointment']" )
    public WebElement adminAppointment;


    @FindBy(id="appointment-heading")
    public WebElement appointmentHeading;

    @FindBy (id="fromDate")
    public WebElement fromDateAppointment;

    @FindBy (id="toDate")
    public WebElement toDateAppointment;

    @FindBy(xpath = "(//*[tr])[1]")
    public WebElement headersOfAppointmentsTable;

    @FindBy(xpath = "(//*[tr])[2]")
    public WebElement allDataOfAppointmentsTable;

    @FindBy(xpath = "(//*[td])[1]")
    public WebElement firstRowOfAppointmentsTable;

    @FindBy(xpath = "(//*[td])[2])")
    public WebElement secondRowOfAppointmentsTable;

    @FindBy(xpath = "(//*[td])[3])")
    public WebElement thirdRowOfAppointmentsList;

    @FindBy(xpath = "(//*[td])[4])")
    public WebElement forthRowOfAppointmentsList;

    @FindBy(xpath = "(//*[td])[5])")
    public WebElement fifthRowOfOfAppointmentsList;

    @FindBy(xpath = "(//td[.])[1]")
    public WebElement patientIdOfFirstAppointment;

    @FindBy(xpath = "(//td[span])[1]")
    public WebElement startDateOfFirstAppointment;

    @FindBy(xpath = "(//td[span])[2]")
    public WebElement endDateOfFirstAppointment;

    @FindBy(xpath = "(//td[span])[3]")
    public WebElement statusOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[5]")
    public WebElement anamnesisOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[6]")
    public WebElement treatmentOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[7]")
    public WebElement diagnosisOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[8]")
    public WebElement prescriptionOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[9]")
    public WebElement descriptionOfFirstAppointment;

    @FindBy(xpath = "(//td[.])[10]")
    public WebElement createdDateOfFirstAppointment;

    @FindBy(xpath = "(//td[a])[1]")
    public WebElement physicianDetailElementOfFirstAppointment;

    @FindBy (xpath = "(//td[a])[2]")
    public WebElement patientDetailElementOfFirstAppointment;

    @FindBy(xpath = "(//*[span='Edit'])[1]" )
    public WebElement editFirstAppointment;

    @FindBy(xpath = "(//th[span])[1]")
    public WebElement patientIdHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[2]")
    public WebElement endDateHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[3]")
    public WebElement statusHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[4]")
    public WebElement startDateHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[5]")
    public WebElement anamnesisHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[6]")
    public WebElement treatmentHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[7]")
    public WebElement diagnosisHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[8]")
    public WebElement prescriptionHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[9]")
    public WebElement descriptionHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[10]")
    public WebElement createdDateHeaderOfAppointmentsTable;

    @FindBy(xpath = "(//th[span])[11]")
    public WebElement physicianNameHeaderOfAppointmentsTable;

    @FindBy (xpath = "(//th[span])[12]")
    public WebElement patientNameHeaderOfAppointmentsTable;

    @FindBy(xpath = "//*[.='Days between begin date and end date must be max 15 days']")
    public WebElement alertMessage;
    @FindBy(className = "Toastify__toast-body")
    public WebElement alertElement;








}
