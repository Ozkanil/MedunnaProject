package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;
import utilities.*;

public class RequestATestPage {

    public RequestATestPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[.='Test Items']")
    public WebElement testItemsHeading;

    @FindBy(xpath = "//input[@id = '1401']")
    public WebElement glucoseCheck;

    @FindBy(id = "1402")
    public WebElement ureaCheck;

    @FindBy(id = "1403")
    public WebElement creatinineCheck;

    @FindBy(id = "1404")
    public WebElement sodiumCheck;

    @FindBy(id = "1405")
    public WebElement potassiumCheck;

    @FindBy(id = "1406")
    public WebElement totalProteinCheck;

    @FindBy(id = "1407")
    public WebElement albuminCheck;

    @FindBy(id = "1408")
    public WebElement hemoglobinCheck;

    @FindBy(id = "8161")
    public WebElement cholesterol8Check;

    @FindBy(id = "8162")
    public WebElement cholesterol9Check;

    @FindBy(id = "8163")
    public WebElement vitaminDCheck;

    @FindBy(id = "8165")
    public WebElement albimoCheck;

    @FindBy(xpath = "(//td)[65]")
    public WebElement glucoseCheckBox;

    @FindBy(xpath = "(//td)[2]")
    public WebElement ureaCheckBox;

    @FindBy(xpath = "(//td)[11]")
    public WebElement creatinineCheckBox;

    @FindBy(xpath = "(//td)[20]")
    public WebElement sodiumCheckBox;

    @FindBy(xpath = "(//td)[29]")
    public WebElement potassiumCheckBox;

    @FindBy(xpath = "(//td)[38]")
    public WebElement totalProteinCheckBox;

    @FindBy(xpath = "(//td)[47]")
    public WebElement albuminCheckBox;

    @FindBy(xpath = "(//td)[56]")
    public WebElement hemoglobinCheckBox;

    @FindBy(xpath = "(//td)[74]")
    public WebElement cholesterol8CheckBox;

    @FindBy(xpath = "(//td)[83]")
    public WebElement cholesterol9CheckBox;

    @FindBy(xpath = "(//td)[92]")
    public WebElement vitaminDCheckBox;

    @FindBy(xpath = "(//td)[101]")
    public WebElement albimoCheckBox;

    @FindBy(id="save-entity")
    public WebElement saveButton;

    @FindBy(className = "Toastify__toast-body")
    public WebElement alertElement;

    @FindAll({
            @FindBy(tagName = "input")
    })
    public List<WebElement> allCheckMarks;


    //===========ADMIN APPOINTMENT PAGE=======
    @FindBy(xpath = "//*[span='View']" )
    public WebElement adminViewAppointment;

    @FindBy(xpath = "//*[span='Edit']" )
    public WebElement adminEditAppointment;

    @FindBy(xpath = "//*[span='You are not authorized to access this page.']")
    public WebElement unauthorizedMessage;
    //====Patient appointment page===========
    @FindBy(xpath = "//*[span='Show Tests']" )
    public WebElement patientShowTest;
    //=======Staff=========
    @FindBy(xpath = "//*[span='Search Patient']")
    public WebElement searchPatientDropdown;






}
