package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ShowTestResultPage {
    public ShowTestResultPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//*[h2='Tests']")
    public WebElement testHeading;

    @FindBy(xpath = "(//*[tr])[1]")
    public WebElement headersOfTestsTable;

    @FindBy(xpath = "(//*[tr])[2]")
    public WebElement allDataOfTestsTable;

    @FindBy(xpath = "(//*[td])[1]")
    public WebElement firstRowOfTestsTable;

    @FindBy(xpath = "(//*[td])[2])")
    public WebElement secondRowOfTestsTable;

    @FindBy(xpath = "(//*[td])[3])")
    public WebElement thirdRowOfTestsList;

    @FindBy(xpath = "(//*[td])[4])")
    public WebElement forthRowOfTestsList;

    @FindBy(xpath = "(//*[td])[5])")
    public WebElement fifthRowOfOfTestsList;

    @FindBy(xpath = "(//td[.])[1]")
    public WebElement testIdOfFirstTest;

    @FindBy(xpath = "(//td[.])[2]")
    public WebElement testNameOfFirstTest;

    @FindBy(xpath = "(//td[.])[3]")
    public WebElement descriptionOfFirstTest;

    @FindBy(xpath = "(//td[.])[4]")
    public WebElement dateOfFirstTest;

    @FindBy(xpath = "(//td[.])[5]")
    public WebElement createdDateOfFirstTest;

    @FindBy(xpath = "(//td[.])[6]")
    public WebElement appointmentIDOfFirstTest;

    @FindBy(xpath = "(//th[span])[1]")
    public WebElement testIdHeaderOfTestsTable;

    @FindBy(xpath = "(//th[span])[2]")
    public WebElement testNameHeaderOfTestsTable;

    @FindBy(xpath = "(//th[span])[3]")
    public WebElement descriptionHeaderOfTestsTable;

    @FindBy(xpath = "(//th[span])[4]")
    public WebElement dateHeaderOfTestsTable;

    @FindBy(xpath = "(//th[span])[5]")
    public WebElement createdDateHeaderOfTestsTable;

    @FindBy(xpath = "(//th[span])[6]")
    public WebElement appointmentIdHeaderOfTestsTable;

    @FindBy(xpath = "(//*[span='View Results'])[1]" )
    public WebElement viewResultsOfFirstTest;














}
