package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ViewByDoctorPage {
    public ViewByDoctorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//*[@id='username']")
        public WebElement username;

        @FindBy(xpath = "//*[@id='password']")
        public WebElement password;

        @FindBy(xpath = "//*[@type='submit']")
        public WebElement signInButton;

        @FindBy(xpath = "//*[@id='entity-menu']/a")
        public WebElement myPagesDropdown;

        @FindBy(xpath = "//*[@id='entity-menu']/div/a[3]")
        public WebElement myInPatientsDropDown;

        @FindBy(xpath = "//*[@id='fromDate']")
        public WebElement fromDateTextBox;

        @FindBy(xpath = "//*[@id='toDate']")
        public WebElement toDateTextBox;

        @FindBy(xpath = "//*[@id='app-view-container'][1]")
        public WebElement patientsId;

    @FindBy(xpath = "//*[@id='app-view-container'][2]")
    public WebElement inPatientsStartDate;

    @FindBy(xpath = "//*[@id='app-view-container'][3]")
    public WebElement inPatientsEndDate;

    @FindBy(xpath = "//*[@id='app-view-container'][4]")
    public WebElement inPatientsStatus;

    @FindBy(xpath = "//*[@id='app-view-container'][5]")
    public WebElement inPatientsDescription;

    @FindBy(xpath = "//*[@id='app-view-container'][6]")
    public WebElement inPatientsCreatedDate;

    @FindBy(xpath = "//*[@id='app-view-container'][7]")
    public WebElement inPatientsRoom;

    @FindBy(xpath = "//*[@id='app-view-container'][8]")
    public WebElement inPatientsAppointment;

        @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div/table/tbody/tr/td[10]/div/a")
        public WebElement editButton;

        @FindBy(xpath = "//*[@id='in-patient-startDate']")
        public WebElement StartDateTextBox;

        @FindBy(xpath = "//*[@id='in-patient-endDate']")
        public WebElement EndDateTextBox;

        @FindBy(xpath = "//*[@id='in-patient-description']")
        public WebElement DescriptionTextBox;

        @FindBy(xpath = "//*[@id='in-patient-createdDate']")
        public WebElement CreatedDateTextBox;

        @FindBy(xpath = "//*[@id='in-patient-appointment']")
        public WebElement AppointmentTextBox;

        @FindBy(xpath = "//*[@id='in-patient-status']")
        public WebElement StatusTextBox;

        @FindBy(xpath = "//*[@id='in-patient-room']")
        public WebElement RoomsTextBox;

        @FindBy(xpath = "//*[@id='save-entity']/svg")
        public WebElement saveButton;
    }
