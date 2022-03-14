package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoctorTestItemsPage {

    public DoctorTestItemsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//td[contains(text(),'Glucose')]")
    public WebElement glucose;

    @FindBy(xpath = "//td[contains(text(),'Urea')]")
    public WebElement urea;

    @FindBy(xpath = "//td[contains(text(),'Sodium')]")
    public WebElement sodium;

    @FindBy(xpath = "//a[contains(text(),'1401')]")
    public WebElement id1401;

}
