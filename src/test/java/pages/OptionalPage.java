package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OptionalPage {

    public OptionalPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[@type='submit'])")
    public WebElement signInButton;
    @FindBy(xpath = "(//li)[7]")
    public WebElement myPagesDropdown;
    @FindBy(xpath = "//*[span='My Appointments']" )
    public WebElement myAppointment;
    @FindBy(xpath ="//*[@class='btn btn-primary']")
    public WebElement editButton;
    @FindBy(xpath = "//*[@id='appointment-prescription']")
    public WebElement prescriptionOfFirstAppointment;
    @FindBy(xpath = "//*[@id='appointment-description']")
    public WebElement descriptionOfFirstAppointment;
}

