package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class CreateANewTestItemPage {
    public CreateANewTestItemPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[.='Create or edit a Test Item'])[4]")
    public WebElement createOrEditATestItemTitle;

    @FindBy(xpath = "//*[@id='c-test-item-name']")
    public WebElement name;

    @FindBy(xpath = "//*[@id='c-test-item-description']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='c-test-item-price']")
    public WebElement price;

    @FindBy(xpath = "//*[@id='c-test-item-defaultValMin']")
    public WebElement defMinValue;

    @FindBy(xpath = "//*[@id='c-test-item-defaultValMax']")
    public WebElement defMaxValue;

    @FindBy(xpath = "//*[@id='c-test-item-createdDate']")
    public WebElement createdDate;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id='cancel-save']")
    public WebElement BackButton;




}
