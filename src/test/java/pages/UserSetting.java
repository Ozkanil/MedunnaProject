package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserSetting {
    public UserSetting(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"account-menu\"]")
    public WebElement sigInIcon;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement SignIn;

     @FindBy(xpath = "//*[@id='username']")
    public WebElement username;

      @FindBy(xpath = "//*[@id='password']")
     public WebElement password;
      @FindBy (id = "rememberMe")
      public WebElement rememberMeBtn;

      @FindBy(xpath = "(//*[text()='Sign in'])[3]")
     public WebElement signIn02;

      @FindBy(xpath = "//*[@id=\"account-menu\"]/a/span")
      public WebElement signedInUser;

      @FindBy(xpath = "//*[text()='Settings']")
       public WebElement settings;
      @FindBy(xpath = "//*[text()='Sign out']")
      public WebElement signOut;

      @FindBy(id = "firstName")
      public WebElement firstname;

      @FindBy(id ="lastName")
      public WebElement lastname;

      @FindBy(id ="email")
      public WebElement email;

      @FindBy(xpath = "//*[text()='Save']")
      public WebElement save;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/a/span")
    public WebElement createdUser;

}
