package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPage {

    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Patient')]")
    public WebElement patientsUnderItemsAndTitles;

    @FindBy(xpath = "//span[contains(text(),'Create a new Patient')]")
    public WebElement createANewPatient;


    @FindBy(xpath = "((//*[.='View'])//span)[1]")
    public WebElement firstViewButton;

    @FindBy(xpath = "((//*[.='Edit'])//span)[1]")
    public WebElement firstEditButton;

    @FindBy(xpath = "(//*[contains(text(),'Edit')])[2]")
    public WebElement secondEditButton;

    @FindBy(xpath = "((//*[.='Edit'])//span)[1]")
    public WebElement firstDeleteButton;

    @FindBy(xpath = "//a[contains(text(),'38')]")
    public WebElement lastPagelink;

    @FindBy(xpath = "//*[span='Appointment']")
    public WebElement adminAppointment;

}
