package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage {

    public SignInPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-sign-out-alt fa-w-16 fa-fw ']")
    public WebElement signoutButton;

    @FindBy(xpath = "//h2")
    public WebElement signoutMessage;

    @FindBy(xpath = "//*[@id='register-title']")
    public WebElement registrationPageHeader;

}
