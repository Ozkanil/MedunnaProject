package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US20_userManagementPage {

    public US20_userManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Administration')]")
    public WebElement dropAdministration;

    @FindBy(xpath = "//span[contains(text(),'User management')]")
    public WebElement dropUserManagement;

    @FindBy(xpath = "(//table[@class='table table-striped']//td[2]//text())[1]")
    public WebElement firstUserLoginName;

    @FindBy(xpath = "//tbody/tr[@id='system']/td[11]/div[1]/a[1]")
    public WebElement firstUserLoginNameViewButton;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/h2[1]/span[1]")
    public WebElement userVievTitle;

    @FindBy(xpath = " (//div[@class='row']//span)[2]")
    public WebElement firstUserLoginNameView;

    @FindBy(xpath = "//span[contains(text(),'Create a new user')]")
    public WebElement navigateToNewUser;

    @FindBy(xpath = "//input[@id='login']")
    public WebElement newUserLoginTxt;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement newUserFirstNameTxt;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement newUserlastNameTxt;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement newUseremailTxt;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement newUserSnnTxt;

    @FindBy(xpath = "//select[@id='langKey']")
    public WebElement newUserDropDownLanguage;

    @FindBy(xpath = "//option[contains(text(),'ROLE_STAFF')]")
    public WebElement newUserRoleStafList;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    public WebElement newUserSaveButton;






}
