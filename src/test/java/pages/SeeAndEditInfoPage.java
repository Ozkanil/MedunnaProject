package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SeeAndEditInfoPage {
    public SeeAndEditInfoPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "MY PAGES")
    public WebElement myPagesDropdown;

    @FindBy(linkText = "Search Patient")
    public WebElement searchPatientDropdown;

    @FindBy(xpath= "//h2")
    public WebElement patientsText;

    @FindBy(name="ssn")
    public WebElement patientSSNSearchBox;

    @FindBy(xpath ="//*[@class='btn btn-warning btn-sm']")
    public WebElement showAppointmentButton;

}

