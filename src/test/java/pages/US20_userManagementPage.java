package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US20_userManagementPage {

    public US20_userManagementPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//tbody/tr[@id='system']/td[2]")
    public WebElement firstUserLoginName;

    @FindBy(xpath = "//tbody/tr[@id='system']/td[11]/div[1]/a[1]")
    public WebElement firstUserLoginNameViewButton;

    @FindBy(xpath = " //span[contains(text(),'system')]")
    public WebElement firstUserLoginNameView;




}
