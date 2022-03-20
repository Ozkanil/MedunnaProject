package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPage {

    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "(//*[@class='dropdown-item'])[2]")
    public WebElement Register;

    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//*[@id='appoDate']")
    public WebElement appointmentDate;

    @FindBy(xpath = "//*[@id='register-submit']")
    public WebElement sendAppointment;

    @FindBy(xpath = "//span[contains(text(),'MY PAGES')]")
    public WebElement myPages;

    @FindBy(xpath = "//span[contains(text(),'In Patient')]")
    public WebElement inPatientUnderMyPages;

    @FindBy(xpath = "//span[contains(text(),'Search Patient')]")
    public WebElement searchPatientUnderMyPages;

        @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement itemsAndTitles;


    @FindBy(xpath = "//*[@data-icon='glasses']")
    public WebElement testItemUnderItemAndTest;

    @FindBy(xpath = "//*[span='Appointment']" )
    public WebElement adminAppointment;

    @FindBy(xpath = "//*[span='My Patients']")
    public WebElement myPatients;

    @FindBy(xpath = "//span[contains(text(),'Sign out')]")
    public WebElement signOut;
}