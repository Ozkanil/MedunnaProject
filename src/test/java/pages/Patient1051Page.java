package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Patient1051Page {
    public Patient1051Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@id='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//span[@id='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//span[@id='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//span[@id='birthDate']")
    public WebElement birthDate;

    @FindBy(xpath = "//span[@id='phone']")
    public WebElement phone;

    @FindBy(xpath = "//span[@id='gender']")
    public WebElement gender;

    @FindBy(xpath = "//span[@id='bloodGroup']")
    public WebElement bloodGroup;

    @FindBy(xpath = "//span[@id='adress']")
    public WebElement adress;

    @FindBy(xpath = "//span[@id='description']")
    public WebElement description;

    @FindBy(xpath = "//span[@id='createdDate']")
    public WebElement createdDate;

    @FindBy(xpath = "(//span[contains(text(),'User')])[2]")
    public WebElement user;

    @FindBy(xpath = "(//span[contains(text(),'Country')])[2]")
    public WebElement country;

    @FindBy(xpath = "(//span[contains(text(),' State/City')])")
    public WebElement stateCity;

    @FindBy(xpath = "//span[contains(text(),'Edit')]")
    public WebElement editButton;

    @FindBy(xpath = "//span[contains(text(),'Back')]")
    public WebElement backButton;


}
