package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.CommonPage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CrossbrowserStepDefs {

    WebDriver driver;
    SignInPage signInPage=new SignInPage();
    CommonPage commonPage=new CommonPage();

    @When("User navigates to the home page in chrome")
    public void user_navigates_to_the_home_page_in_chrome() throws MalformedURLException {


            driver = new RemoteWebDriver(new URL("http://localhost:4444/"),new ChromeOptions());

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            driver.get("wwww.medunna.com");

        }

    @When("user clicks sign in button at the home page and navigates to sign in page")
    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {

        Driver.waitAndClick( commonPage.accountMenu);
        Driver.waitAndClick( commonPage.signIn);

    }
    @Then("user verifies that sign in page header is visible")
    public void user_verifies_that_sign_in_page_header_is_visible() {

        Driver.waitForVisibility(signInPage.singinPageHeader, 5);
        Assert.assertTrue(signInPage.singinPageHeader.isDisplayed());

    }
    @Then("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {

        signInPage.username.sendKeys(username);
        signInPage.password.sendKeys(password);

    }
    @Then("user clicks sign in button")
    public void user_clicks_sign_in_button() {

        signInPage.singInButton.click();

    }
    @Then("user verifies that sign in is successful")
    public void sser_verifies_that_sign_in_is_successful() {

        Assert.assertTrue(commonPage.accountMenu.isDisplayed());

    }


        @Then("user quits remote driver")
        public void user_quits_remote_driver() {


            driver.quit();

        }

         @When("User navigates to the home page in firefox")
         public void userNavigatesToTheHomePageInFirefox() throws MalformedURLException {


            driver = new RemoteWebDriver(new URL("http://192.168.1.29:4444"),new FirefoxOptions());

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

            driver.get(ConfigurationReader.getProperty("medunna_url"));

        }


    }


