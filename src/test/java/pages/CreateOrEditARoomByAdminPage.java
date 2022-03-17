package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CreateOrEditARoomByAdminPage {

    public CreateOrEditARoomByAdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//*[span='Items&Titles']" )
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "//*[span='Room']" )
    public WebElement roomDropdown;

    @FindBy(xpath = "//h2[.='Rooms']" )
    public WebElement roomsHeading;

    @FindBy(xpath = "//*[.='Create a new Room']")
    public WebElement createANewRoomButton;

    @FindBy(xpath = "//h2[.='Create or edit a Room']")
    public WebElement createOrEditARoomHeading;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumberTextBox;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceTextBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createdDateTextBox;

    @FindBy(xpath ="//td[a]")
    public List<WebElement> idElements;
}
