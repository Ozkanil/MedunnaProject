package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "((//*[.='Delete'])//span)[1]")
    public WebElement firstDeleteButton;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']")
    public WebElement confirmationDeleteButton;

    @FindBy(xpath = "//*[@class='Toastify']")
    public WebElement failMessageToastContainer;

    @FindBy(xpath = "//a[contains(text(),'»»')]")
    public WebElement lastPagelink;

    @FindBy(xpath = "(//*[@class='page-link'])[8]")
    public WebElement nextPagelink;

    @FindBy(xpath = "//*[span='Appointment']")
    public WebElement adminAppointment;

    @FindBy(xpath = "//span[contains(text(),'State/City')]")
    public WebElement stateAndCity;

    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement webTable;


    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> listOfAllStates;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> listOfAllFirstnameOfCreatedPatientOnTheLastPage;

    @FindBy(xpath = "//tbody/tr/td[4]")
    public List<WebElement> listOfAllLastnameOfCreatedPatientOnTheLastPage;
}
