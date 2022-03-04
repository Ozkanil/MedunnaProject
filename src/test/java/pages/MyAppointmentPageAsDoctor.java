package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyAppointmentPageAsDoctor {
    public MyAppointmentPageAsDoctor() { PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[span='MY PAGES']" )
    public WebElement myPagesDropdown;

    @FindBy(xpath = "//*[span='My Appointments']" )
    public WebElement myAppointment;

    @FindBy(id="appointment-heading")
    public WebElement appointmentHeading;

    @FindBy (id="fromDate")
    public WebElement fromDateAppointment;

    @FindBy (id="toDate")
    public WebElement toDateAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[1])")
    public WebElement patientIdOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[2])")
    public WebElement startDateOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[3])")
    public WebElement endDateOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[4])")
    public WebElement statusOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[5])")
    public WebElement anamnesisOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[6])")
    public WebElement treatmentOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[7])")
    public WebElement diagnosisOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[8])")
    public WebElement prescriptionOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[9])")
    public WebElement descriptionOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[10])")
    public WebElement createdDateOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[11])")
    public WebElement physicianOfFirstAppointment;

    @FindBy(xpath = "(//tbody/tr/td)[12])")
    public WebElement patientNameOfFirstAppointment;

    @FindBy (xpath = "(//td/a)[1]")
    public WebElement clickPhysicianDetailElementOfFirstAppointment;

    @FindBy (xpath = "(//td/a)[2]")
    public WebElement clickPatientDetailElementOfFirstAppointment;

    @FindBy(xpath = "(//*[span='Edit'])[1]" )
    public WebElement editAppointment;






}
