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
    @FindBy(xpath = "//*[.='Items&Titles']" )
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "//*[.='Room']" )
    public WebElement roomDropdown;

    @FindBy(xpath = "//*[.='Rooms']" )
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

    @FindBy(xpath ="//tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//a[.='»»']")
    public WebElement lastPage;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
public List<WebElement> invalidFeedbacks;

    @FindBy(xpath = "//input[@name='status']")
    public WebElement statusCheckBox;

    @FindBy(tagName = "select")
    public WebElement roomTypeSelect;

    @FindBy(xpath = "//span/span[.='Edit']")
    public List<WebElement> editElements;

    @FindBy(xpath = "//span/span[.='Delete']")
    public List<WebElement> deleteElements;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionTextBox;

@FindBy(id = "jhi-confirm-delete-room")
    public WebElement deleteConfirm;
}
