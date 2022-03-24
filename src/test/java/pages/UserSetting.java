package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSetting {

    public UserSetting() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement sigInIcon;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement SignIn;


    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerBtn;

    @FindBy(xpath = "//*[@id='firstPassword']")
    public WebElement newPassword;

    @FindBy(xpath = "//*[@id='strengthBar']/li[1]")
    public WebElement redColor;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(id = "rememberMe")
    public WebElement rememberMeBtn;

    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement signIn02;

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement signedInUser;

    @FindBy(xpath = "//*[text()='Settings']")
    public WebElement settings;
    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOut;

    @FindBy(id = "firstName")
    public WebElement firstname;

    @FindBy(id = "lastName")
    public WebElement lastname;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement save;

    @FindBy(xpath = "//*[@id='account-menu']/a/span")
    public WebElement createdUser;

    @FindBy(xpath = "//*[@id='firstPassword']")
    public WebElement newPwdPlaceholder;
    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
    public WebElement passwordStrength3;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')]")
    public WebElement passwordStrength4;

    @FindBy(xpath = "//*[text()='Password']")
    public WebElement dropdownPassword;

    @FindBy(xpath = "//*[@id='currentPassword']")
    public WebElement currentPassword;

    @FindBy(xpath = "//*[@id='newPassword']")
    public WebElement  newPwd;

    @FindBy(xpath = "//*[@id='confirmPassword']")
    public WebElement confirmPwd;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public WebElement successMsg;
    @FindBy(xpath = "//span[contains(text(),'MY PAGES')]")
    public WebElement myPages;

    @FindBy(xpath = "//span[contains(text(),'Search Patient')]")
    public WebElement searchPatientUnderMyPages;

    @FindBy(xpath = "//*[text()='Show Appointments']")
    public WebElement showAppointmentsBtn;

    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement patientSSN;

    @FindBy(xpath = "(//*[text()='Payment / Invoice Process'])[2]")
    public WebElement  paymentInvoice;

    @FindBy(xpath = "(//*[text()='COMPLETED'])[2]")
    public WebElement statusCompleted;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/a")
    public WebElement showInvoice;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/table/thead/tr[4]/th[2]")
    public WebElement invoiceSSN;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/table/thead/tr[5]/th[2]")
    public WebElement invoiceName;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/table/thead/tr[7]/th[2]")
    public WebElement invoiceCost;

}
