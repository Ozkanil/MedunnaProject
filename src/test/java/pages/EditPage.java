package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditPage {


    public EditPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(linkText = "MY PAGES")
    public WebElement myPagesDropdown;

    @FindBy(linkText = "Search Patient")
    public WebElement searchPatientDropdown;

    @FindBy(xpath = "//h2")
    public WebElement patientsText;

    @FindBy(name = "ssn")
    public WebElement patientSSNSearchBox;

    @FindBy(xpath = "(//*[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButtonOnPatientSearch;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement editButtonAfterView;

    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButtonOnPatientSearch;

    @FindBy(xpath = "(//dd)[1]")
    public WebElement ssnTextAfterView;

    @FindBy(xpath = "//h2")
    public WebElement createEditPatientText;

    @FindBy(name = "cancel-save")
    public WebElement backButtonCreateEditPatient;

    @FindBy(xpath = "(//button)[2]")
    public WebElement saveButtonCreateEditPatient;


    @FindBy(xpath = "//*[@class='btn btn-warning btn-sm']")
    public WebElement showAppointmentsButton;


    @FindBy(xpath = "(//*[@class='btn btn-primary btn-sm'])")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id='appointment-anamnesis']")
    public WebElement anamnesisTextBox;

    @FindBy(xpath= "//*[@id='appointment-treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//*[@id='appointment-diagnosis]")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//*[@id='save-entity']/span")
    public WebElement saveButton;
}