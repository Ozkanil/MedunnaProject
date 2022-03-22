package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TestItemsPage {

    public TestItemsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[.='Test Items']")
    public WebElement testItemsTitle;

    @FindBy(xpath = "//*[@id='jh-create-entity']")
    public WebElement createANewTestItemButton;

    @FindBy(xpath = "(//th)[1]")
    public WebElement ID;

    @FindBy(xpath = "(//th)[2]")
    public WebElement name;

    @FindBy(xpath = "(//th)[3]")
    public WebElement description;

    @FindBy(xpath = "(//th)[4]")
    public WebElement price;

    @FindBy(xpath = "(//th)[5]")
    public WebElement defMinValue;

    @FindBy(xpath = "(//th)[6]")
    public WebElement defMaxValue;

    @FindBy(xpath = "(//th)[7]")
    public WebElement createdDate;

    public WebElement viewButton(int num){
        String xpath = "(//span//span[.='View'])["+num+"]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement editButton(int num){
        String xpath = "(//span//span[.='Edit'])["+num+"]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement deleteButton(int num){
        String xpath = "(//span//span[.='Delete'])["+num+"]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    @FindBy(xpath = "//*[contains(text(), 'A new Test Item is created')]")
    public WebElement successMessage;

    @FindBy(xpath = "//*[contains(text(), 'A Test Item is deleted')]")
    public WebElement deletedMessage;

}
