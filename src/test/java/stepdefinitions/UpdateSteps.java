package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class UpdateSteps {

    //StatusPage statusPage = new StatusPage();
    UpdatePage updatePage = new UpdatePage();
    //ViewByDoctorPage view = new ViewByDoctorPage();

    @When("user click sign in button at the home page and navigates to sign in page")
    public void user_click_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {
        Driver.waitForVisibility(updatePage.signInButton,5);
       Driver.waitAndClick(updatePage.signInButton,5);

    }
    @And("user verify that Sign in text is visible")
    public void userVerifyThatSignInTextIsVisible() {

    }
        @When("user enters user name {string} and password {string}")
    public void user_enters_user_name_and_password(String username , String password)  {
        updatePage.username.clear();
        Driver.waitAndSendText(updatePage.username,username);
    }

    @When("user clicks Sign in button")
    public void user_clicks_sign_in_button() {
       Driver.waitAndClick(updatePage.signInButton,5);
       updatePage.signInButton.click();
    }

    @Then("user provıdes from date {string} and to date {string}")
    public void user_provıdes_from_date_and_to_date(String fromdate ,String todate) {
       Driver.waitForVisibility(updatePage.fromDateTextBox,5) ;
       Driver.waitForVisibility(updatePage.toDateTextBox,5) ;
    }
    @Then("user schould see and verify all patient information")
    public void userSchouldSeeAndVerifyAllPatientInformation() {
    }
    @Then("user provides staying {string}")
    public void user_provides_staying(String status) {
        Driver.waitForVisibility(updatePage.statusTextBox,5);

    }


    }



