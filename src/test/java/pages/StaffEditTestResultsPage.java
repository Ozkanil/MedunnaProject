package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


import java.nio.file.WatchEvent;

public class StaffEditTestResultsPage {
    public StaffEditTestResultsPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//*[@class= 'd-none d-md-inline'])[9]")
    public WebElement showTests;

    @FindBy(xpath = "//*[@class= 'd-none d-md-inline'][1]")
    public WebElement viewResults;

    @FindBy(xpath = "//*[@class= 'd-none d-md-inline'][1]")
    public WebElement edit;

    @FindBy(xpath = "//*[@id = 'c-test-result-result' ]")
    public WebElement result;

    @FindBy(xpath = "//*[@id='c-test-result-description']")
    public WebElement description;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='Toastify']")
    public WebElement updateMessage;

}
