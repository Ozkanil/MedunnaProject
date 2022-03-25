package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.*;

public class AdminPhysicianPage {

    public AdminPhysicianPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@name='login']")
    public WebElement logInTextBoxAd;

    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administrationDropdown;

    @FindBy(xpath = "//span[text()='User management']")
    public WebElement userManagementButton;

  @FindBy(xpath = "//*[@name='ssn']")
  public WebElement ssnTextBox;

  @FindBy(xpath = "//*[@name='firstName']")
  public WebElement firstNameTextBox;

  @FindBy(xpath = "//*[@name='lastName']")
  public WebElement lastNameTextBox;

  @FindBy(xpath = "//*[@name='login']")
  public WebElement userTextBox;

  @FindBy(xpath = "//*[@name='email']")
  public WebElement emailTextBox;

  @FindBy(xpath = "//*[@id='register-submit']")
  public WebElement registerButton;


  //  @FindBy(xpath = "(//*[@class='page-item'])[last()]")
 //    @FindBy(xpath = "(//li[@class='page-item'])[6]")
    @FindBy(xpath = "(//li[@class='page-item'])[last()]//a")
    public WebElement clickGoToLastInt;

    //((//*[.='Deactivated'])//span)[last()]
    @FindBy(xpath = "(//*[@class='btn btn-danger'])[last()]")
    public WebElement clickLastDeactivatedButton;

    @FindBy(xpath = "((//*[.='Activated'])//span)[last()]")
    public WebElement verifyActivatedUser;

    // edit page start
    @FindBy(xpath = "((//*[.='Edit'])//span)[last()]")
    public WebElement clickLastEditButton;

    @FindBy(xpath = "//span[text()='Create or edit a user']")
    public WebElement verifyEditPage;

    @FindBy(xpath = "//div[@class='form-group'][last()]//*[@id='authorities']//*[contains(text(),'ROLE_PHYSICIAN')]")
    public WebElement physicianRollactivate;

    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement saveRollButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement verifyTextRole;

    @FindBy(id = "user-management-page-heading")
    public WebElement userPageVerifyAdmin;

    @FindBy(xpath = "//a[@class='btn btn-primary float-right jh-create-entity']")
    public WebElement createNewUserBtnAdPg;

    @FindBy(xpath = "//span[text()='Create or edit a user']")
    public WebElement verifyCreateOrEditPg;



//    @FindBy(xpath = "//div[@class='table-responsive']//*[@id='aldoaldoni']")
//    public WebElement deletePhisicialAftRoll;

    //delete page start when log first time and its appears at down
    @FindBy(xpath = "((//*[.='Delete'])//span)[last()-1]")
    public WebElement clickBfrLastDeleteButton;

    @FindBy(xpath = "//div[@class='modal-footer']//span[text()='Delete']")
    public WebElement confirmDeleteButton;


    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitelsDropdown;

    @FindBy(xpath = "//a[@class='dropdown-item']//span[text()='Physician']")
    public WebElement physicianDropdown;

    @FindBy(xpath = "//h2[@id='physician-heading']//span[text()='Physicians']")
    public WebElement physicianPageVerify;

//    @FindBy(xpath = "//a[@class='btn btn-primary float-right jh-create-entity']//span[text()='Create a new Physician']")
//    public WebElement createNewPhysician;
    @FindBy(xpath = "//a[@class='btn btn-primary float-right jh-create-entity']")
    public WebElement createNewPhysician;















}
