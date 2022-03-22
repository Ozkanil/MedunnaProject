package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ViewByDoctorPage {
    public ViewByDoctorPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

        @FindBy(xpath = "//*[@id='username']")
        public WebElement username;

        @FindBy(xpath = "//*[@id='password']")
        public WebElement password;

        @FindBy(xpath = "//*[@type='submit']")
        public WebElement signInButton;

        @FindBy(xpath = "//*[@id='entity-menu']/a")
        public WebElement myPagesDropdown;

        @FindBy(xpath = "//*[@id='entity-menu']/div/a[3]")
        public WebElement myInPatientsDropDown;

        @FindBy(xpath = "//*[@id='fromDate']")
        public WebElement fromDateTextBox;

        @FindBy(xpath = "//*[@id='toDate']")
        public WebElement toDateTextBox;

        @FindBy(xpath = "//*[@id='app-view-container'][1]")
        public WebElement patientsId;

        @FindBy(xpath = "//*[@id='save-entity']/svg")
        public WebElement saveButton;
    }
