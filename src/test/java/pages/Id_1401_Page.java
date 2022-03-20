package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Id_1401_Page {
    public Id_1401_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[contains(text(),'Default Max. Value')]")
    public WebElement defaultMaxValue;

    @FindBy(xpath = "//span[contains(text(),'Default Min. Value')]")
    public WebElement defaultMinValue;

    @FindBy(xpath = "//b[contains(text(),'1401')]")
    public WebElement testItem1401;

    @FindBy(xpath = "//span[contains(text(),'Description')]")
    public WebElement description;

    @FindBy(xpath = "//span[contains(text(),'Created Date')]")
    public WebElement createdDate;
}
