package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffInPatientPage {

    public StaffInPatientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2[@id='in-patient-heading']")
    public WebElement inPatientsText;

    @FindBy(xpath = "//input[@id='fromDate']")
    public WebElement fromDateBox;


    @FindBy(xpath = "//input[@id='toDate']")
    public WebElement toDateBox;

    @FindBy(xpath = "//span[contains(text(),'ID')]")
    public WebElement idText;

    @FindBy(xpath = "//span[contains(text(),'Start Date')]")
    public WebElement startDateText;

    @FindBy(xpath = "//span[contains(text(),'End Date')]")
    public WebElement endDateDateText;

    @FindBy(xpath = "//span[contains(text(),'Status')]")
    public WebElement statusText;

    @FindBy(xpath = "//span[contains(text(),'Description')]")
    public WebElement descriptionText;

    @FindBy(xpath = "//span[contains(text(),'Created Date')]")
    public WebElement createdDateText;

    @FindBy(xpath = "//span[contains(text(),'Room')]")
    public WebElement roomText;

    @FindBy(xpath = "//span[contains(text(),'Appointment')]")
    public WebElement appointmentText;

    @FindBy(xpath = "(//span[contains(text(),'Patient')])[4]")
    public WebElement patientText;

    @FindBy(xpath = "//tbody/tr[1]/td[10]/div[1]/a[1]/span[1]/span[1]")
    public WebElement firstEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[2]")
    public WebElement seconEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[3]")
    public WebElement thirthEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[4]")
    public WebElement fourthEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[5]")
    public WebElement fifthEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[6]")
    public WebElement sixthEditButton;

    @FindBy(xpath = "(//span[(@class='d-none d-md-inline')])[7]")
    public WebElement seventhEditButton;



}
