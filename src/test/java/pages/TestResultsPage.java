package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestResultsPage {

    public TestResultsPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[.='Test Results']")
    public WebElement TestResultsHeading;

    @FindBy(xpath = "(//span)[20]")
    public WebElement idHeader;


    @FindBy(xpath = "//span[.='Name']")
    public WebElement nameHeader;

    @FindBy(xpath = "(//span)[22]")
    public WebElement resultHeader;

    @FindBy(xpath = "//span[.='Default Min. Value']")
    public WebElement defMinValueHeader;

    @FindBy(xpath = "(//span)[24]")
    public WebElement defMaxValueHeader;

    @FindBy(xpath = "(//span)[25]")
    public WebElement testHeader;

    @FindBy(xpath = "(//span)[26]")
    public WebElement descriptionHeader;

    @FindBy(xpath = "(//span)[27]")
    public WebElement dateHeader;

    @FindBy(xpath = "//td[a]")
    public WebElement idValue;

    @FindBy(xpath = "(//td)[2]")
    public WebElement nameValue;

    @FindBy(xpath = "(//td)[3]")
    public WebElement resultValue;

    @FindBy(xpath = "(//td)[4]")
    public WebElement defMinValue;

    @FindBy(xpath = "(//td)[5]")
    public WebElement defMaxValue;

    @FindBy(xpath = "(//td)[6]")
    public WebElement testValue;

    @FindBy(xpath = "(//td)[7]")
    public WebElement descriptionValue;

    @FindBy(xpath = "(//span)[28]")
    public WebElement dateValue;




}
