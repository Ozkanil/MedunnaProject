package stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.*;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.OptionalPage;
import pages.SearchPatientOnStaffPage;
import pages.SignInPage;

import utilities.ConfigurationReader;
import utilities.Driver;

public class OptionalSteps {
    WebDriver driver;
    CommonPage commonPage = new CommonPage();
    SignInPage signInPage = new SignInPage();
    OptionalPage optionalPage = new OptionalPage();
    SearchPatientOnStaffPage searchPatientOnStaffPage=new SearchPatientOnStaffPage();

    @When("user navigates to the the home page")
    public void user_navigates_to_the_the_home_page() throws InterruptedException {
//        Thread.sleep(5);
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));

    }

    @When("user clicks in sign in button")
    public void user_clicks_on_sign_in_button(){
        Driver.waitAndClick(commonPage.accountMenu);
        Driver.waitAndClick(commonPage.signIn);

    }
    @When(" enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {

        Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("doctor_username"));
        Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
        Driver.waitAndClick(signInPage.singInButton);

    }
    @When("user clikcs the sign in button and verifies my pages")
    public void user_clikcs_the_sign_in_button_and_verifies_my_pages() {
        Driver.waitForVisibility(optionalPage.signInButton,5);
        optionalPage.signInButton.click();


    }
    @When("user clicks  on my Appointment icon")
    public void user_clicks_on_my_appointment_icon() {
        Driver.waitForVisibility(optionalPage.myAppointment,5);
        optionalPage.myAppointment.click();


    }
    @When("user click on edit button")
    public void user_click_on_edit_button() {

        Driver.waitAndClick(searchPatientOnStaffPage.editButtonUnderShowAppointments);

    }
    @When("user types a text to prescription box is optional")
    public void user_types_a_text_to_prescription_box_is_optional() {

    }
    @Then("user types a text to Description box is optional")
    public void user_types_a_text_to_description_box_is_optional() {

    }

}
