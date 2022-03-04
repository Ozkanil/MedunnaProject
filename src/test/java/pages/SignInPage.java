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

    @FindBy(xpath = "//*[@id='rememberMe']")
    public WebElement rememberMe;

    @FindBy(xpath = "(//*[.='Cancel'])[1]]")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement singInButton;

    @FindBy(xpath = "//*[.='Failed to sign in!']")
    public WebElement FailedAlert;

    @FindBy(xpath = "//*[.='Authentication information not correct.']")
    public WebElement failedMessage;

}