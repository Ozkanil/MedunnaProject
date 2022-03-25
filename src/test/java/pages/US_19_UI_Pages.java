package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_19_UI_Pages {

    public US_19_UI_Pages(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="account-menu")
    public WebElement accountMenu;

    @FindBy (id = "login-item")
    public WebElement loginItem;

    @FindBy(id = "login-item")
    public WebElement signIn;

    @FindBy(id ="username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement submit;

    @FindBy (id="entity-menu")
    public WebElement itemsTitle;

    @FindBy (xpath = "(//a[@href='/staff'])[1]")
    public WebElement dropDownStaff;

    @FindBy(id = "jh-create-entity")
    public WebElement staffPageValidation;

    @FindBy(id = "jh-create-entity")
    public WebElement createStaff;

    @FindBy (id = "useSSNSearch")
    public WebElement useSearchClick;

    @FindBy (id = "searchSSN")
    public WebElement searchSSNBox;

    @FindBy (xpath = "//button[@class='btn btn-secondary']")
    public WebElement searchUserButton;

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement validateFoundUser;

    @FindBy(id = "staff-firstName")
    public WebElement staffFirstName;

    @FindBy(id = "staff-lastName")
    public WebElement staffLastName;

    @FindBy(id = "staff-birthDate")
    public WebElement staffBirthDate;

    @FindBy (id = "staff-phone")
    public WebElement staffPhone;

    @FindBy (id = "staff-adress")
    public WebElement staffAdress;

    @FindBy (id = "staff-description")
    public WebElement staffDescription;

    @FindBy (id = "staff-user")
    public WebElement staffUserDropdown;

    @FindBy (id = "staff-country")
    public WebElement staffCountryDropdown;

    @FindBy (id = "staff-cstate")
    public WebElement staffStateDropdown;

    @FindBy (id = "save-entity")
    public WebElement createStaffSaveButton;

    @FindBy (xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement validateSaveStaffCreation;

    @FindBy (xpath = "(//a[@class='btn btn-primary btn-sm'])[10]")
    public WebElement editStaffButton;

    @FindBy (xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[15]/td[12]")
    public WebElement userSelect;

    @FindBy (xpath = "//tbody//tr[12]//td[12]")
    public WebElement userNameSelect;

    public String printData(int satir, int sutun) {
        String xpath = "//tbody//tr["+satir+"]//td["+sutun+"]";

        String expectedData = Driver.getDriver().findElement(By.xpath(xpath)).getText();

        return expectedData;
    }
}
