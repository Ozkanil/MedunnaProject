package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffHomePage {

    public StaffHomePage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//span[contains(text(),'MY PAGES')]")
    public WebElement myPages;


    @FindBy(xpath = "//span[contains(text(),'In Patient')]")
    public WebElement inPatientUnderMyPages;
}
