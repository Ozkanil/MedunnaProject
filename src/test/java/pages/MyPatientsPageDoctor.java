package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyPatientsPageDoctor {
    public MyPatientsPageDoctor(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[.='Patients'])[2]")
    public WebElement patientsTitle;

    @FindBy(xpath = "(//tr//th)[1]")
    public WebElement IdOnTable;

    @FindBy(xpath = "(//tr//th)[2]")
    public WebElement snnOnTable;

    @FindBy(xpath = "(//tr//th)[3]")
    public WebElement firstNameOnTable;

    @FindBy(xpath = "(//tr//th)[4]")
    public WebElement lastNameOnTable;

    @FindBy(xpath = "(//tr//th)[5]")
    public WebElement birthDateOnTable;

    @FindBy(xpath = "(//tr//th)[6]")
    public WebElement phoneOnTable;

    @FindBy(xpath = "(//tr//th)[7]")
    public WebElement emailOnTable;

    @FindBy(xpath = "(//tr//th)[8]")
    public WebElement genderOnTable;

    @FindBy(xpath = "(//tr//th)[9]")
    public WebElement bloodGroupOnTable;

    @FindBy(xpath = "(//tr//th)[10]")
    public WebElement addressOnTable;

    @FindBy(xpath = "(//tr//th)[11]")
    public WebElement descriptionOnTable;

    @FindBy(xpath = "(//tr//th)[12]")
    public WebElement createdDateOnTable;

    @FindBy(xpath = "(//tr//th)[13]")
    public WebElement countryOnTable;

    @FindBy(xpath = "(//tr//th)[14]")
    public WebElement stateOrCityOnTable;
}
