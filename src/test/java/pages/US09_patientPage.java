package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US09_patientPage {

    public US09_patientPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
//----------------------------admin----------

    @FindBy(xpath = "//tbody/tr[1]/td[16]/div[1]/a[2]")
    public WebElement adminPatientEdit;

        //---------------

    @FindBy(xpath = "//span[contains(text(),'MY PAGES')]")
    public WebElement staffMyPage;

    @FindBy(xpath = "//span[contains(text(),'Search Patient')]")
    public WebElement staffSearchPatient;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[16]/div[1]/a[2]/span[1]/span[1]")
    public WebElement staffEditButtonPatient;

    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement staffUpdateDescPatient;

    @FindBy(xpath = "//dd[contains(text(),'KBB')]")
    public WebElement staffAfterUpdateDescPatient;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement staffSaveButtonPatient;

    @FindBy(xpath = "//tbody/tr[1]/td[16]/div[1]/a[3]")
    public WebElement adminPatientDeleteButton;

    @FindBy(xpath = "//div[@id='hospitalmsappfrontendApp.patient.delete.question']")
    public WebElement adminPatientDeletePopUp;

    @FindBy(xpath = "//span[contains(text(),'Patients')]")
    public WebElement adminPatientDeleteCancel;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement staffPatientsSearchBox;

    @FindBy(xpath = "//span[contains(text(),'No Patients found')]")
    public WebElement staffPatientsDeleteMsj;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(id = "rememberMe")
    public WebElement rememberMe;

    @FindBy(xpath = "(//*[@type='button'])[3]")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement singInButton;

    @FindBy(xpath = "//*[contains(text(),'Failed')]")
    public WebElement FailedAlert;

    @FindBy(xpath = "//*[.='Authentication information not correct.']")
    public WebElement failedMessage;

    @FindBy(xpath = "(//span)[16]")
    public WebElement singinPageHeader;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[1]")
    public WebElement emptyUsernameFailMessage;

    @FindBy(xpath = "(//*[@class='invalid-feedback'])[2]")
    public WebElement emptyPasswordFailMessage;

    @FindBy(xpath = "(//span)[19]")
    public WebElement passwordResetButton;

    @FindBy(xpath = "//h1")
    public WebElement resetPasswordPageHeader;

    @FindBy(xpath = "(//span)[22]")
    public WebElement registrationButtonAtSigninPage;

    @FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[8]/a[1]")
    public WebElement logedInUser;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-sign-out-alt fa-w-16 fa-fw ']")
    public WebElement signoutButton;

    @FindBy(xpath = "//h2")
    public WebElement signoutMessage;
    //-------------------------oguz
    @FindBy(xpath = "//*[contains(text(),'Items&Titles')]")
    public WebElement itemsTitlesDrowdown;

        //-------------------------

    @FindBy(id="account-menu")
    public WebElement signInIcon;
    @FindBy(xpath="//a[@id='login-item']")
    public WebElement signInButton;

    @FindBy(id="username")
    public WebElement loginUserNameTextbox;
    @FindBy(id="password")
    public WebElement loginPasswordTextbox;
    @FindBy(css="button[type='submit']")
    public WebElement loginButton;

    //-------------------------
    @FindBy(id="entity-menu")
    public WebElement ItemAndTitlesDropDown;

    //  @FindBy(xpath="//a[@class='dropdown-item active']")
    @FindBy(xpath="//body/div[@id='root']/div[1]/div[1]/div[2]/nav[1]/div[1]/ul[1]/li[7]/div[1]/a[1]")
    public WebElement PatientDropDown;

    @FindBy(xpath = "//tbody/tr[1]/td[16]/div[1]/a[1]")
    public WebElement ViewButtonPatient1051;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")
    public WebElement ViewPatienttable;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    public WebElement BackButtonPatient1051;
    //-------------------------patient form---------------------------
    @FindBy(id = "patient-firstName")
    public WebElement firstNameBox;
    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement lastNameBox;
    @FindBy(xpath = "//*[@id='patient-birthDate']")
    public WebElement birthDateBox;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement eMailBox;
    @FindBy(xpath = "//*[@id='patient-phone']")
    public WebElement phoneNumberBox;
    @FindBy(xpath = "//*[@id='patient-gender']")
    public WebElement genderDropDown;
    @FindBy(xpath = "//*[@id='patient-bloodGroup']")
    public WebElement bloodGroupDropDown;
    @FindBy(xpath = "//*[@id='patient-adress']")
    public WebElement addressBox;
    @FindBy(xpath = "//*[@id='patient-description']")
    public WebElement descriptionBox;
    @FindBy(xpath = "//*[@id='patient-user']")
    public WebElement userPatientDropDown;
    @FindBy(xpath = "//*[@id='patient-country']")
    public WebElement countryDropDown;
    @FindBy(id = "patient-cstate")
    public WebElement stateDropDown;
    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;
    @FindBy(xpath = "//*[@id='app-view-container']/div")
    public WebElement savedPatientStaff;
    @FindBy(xpath = "//*[@id='app-view-container']/div")
    public WebElement savedPatientAdmin;
}
