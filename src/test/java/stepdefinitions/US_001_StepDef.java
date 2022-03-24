package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CommonPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import utilities.*;

public class US_001_StepDef {
    CommonPage commonPage = new CommonPage();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user is on the common page")
    public void user_is_on_the_common_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));
    }
    @Given("user navigates to registration page")
    public void user_navigates_to_registration_page() {
        Driver.waitAndClick(commonPage.accountMenu);
        Driver.waitAndClick(commonPage.Register);
    }
    @Given("user provides the valid {string} of the applicant")
    public void user_provides_the_valid_of_the_applicant(String snn) {
        Driver.waitAndSendText(registrationPage.ssn, snn);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }


    @Then("should not get any error")
    public void should_not_get_any_error() {

    }

    @Given("user provides the invalid {string} of the applicant")
    public void user_provides_the_invalid_of_the_applicant(String ssn) {
        Driver.waitAndSendText(registrationPage.ssn, ssn);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }
    @Then("there should be displayed Your SSN is invalid message")
    public void there_should_be_displayed_your_ssn_is_invalid_message() {
        assertTrue(registrationPage.invalidSsnFeedback.isDisplayed());
    }

    @Given("user lefts {string} textbox blank")
    public void user_lefts_textbox_blank(String ssn) {
        Driver.waitAndSendText(registrationPage.ssn, ssn);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user types some spaces on {string} textbox")
    public void user_types_some_spaces_on_textbox(String ssn) {
        Driver.waitAndSendText(registrationPage.ssn, ssn);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user provides the valid first name {string} of the applicant")
    public void user_provides_the_valid_first_name_of_the_applicant(String firstName) {
        Driver.waitAndSendText(registrationPage.firstName, firstName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user lefts first name {string} textbox blank")
    public void user_lefts_first_name_textbox_blank(String firstName) {
        Driver.waitAndSendText(registrationPage.firstName, firstName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user types some spaces on first name {string} textbox")
    public void user_types_some_spaces_on_first_name_textbox(String firstName) {
        Driver.waitAndSendText(registrationPage.firstName, firstName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Then("verify Your FirstName is required. message")
    public void verify_your_first_name_is_required_message() {
        assertTrue(registrationPage.invalidfeedback.isDisplayed());
    }

    @Given("user provides the valid last Name {string} of the applicant")
    public void user_provides_the_valid_last_name_of_the_applicant(String lastName) {
        Driver.waitAndSendText(registrationPage.lastName, lastName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user lefts last Name {string} textbox blank")
    public void user_lefts_last_name_textbox_blank(String lastName) {
        Driver.waitAndSendText(registrationPage.lastName, lastName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Given("user types some spaces on last Name {string} textbox")
    public void user_types_some_spaces_on_last_name_textbox(String lastName) {
        Driver.waitAndSendText(registrationPage.lastName, lastName);
        Driver.waitAndClick(registrationPage.registrationTitle);
    }

    @Then("verify Your LastName is required. message")
    public void verify_your_last_name_is_required_message() {
        assertTrue(registrationPage.invalidfeedback.isDisplayed());
    }


    @Given("user provides invalid username {string}")
    public void userProvidesInvalidUsername(String arg0) {
Driver.waitAndSendText(registrationPage.username,arg0);
    }

    @Then("user validates Your username is required. message")
    public void userValidatesYourUsernameIsRequiredMessage() {

    }

    @Then("user validates Your username is invalid. message")
    public void userValidatesYourUsernameIsInvalidMessage() {

    }

    @Given("user provides the invalid email {string}")
    public void userProvidesTheInvalidEmail(String arg0) {

    }

    @Then("user validates This field is invalid")
    public void userValidatesThisFieldIsInvalid() {

    }

    @Then("user validates Your email is required.")
    public void userValidatesYourEmailIsRequired() {

    }

    @Given("user provides the password {string}")
    public void userProvidesThePassword(String arg0) {

    }

    @Then("user validates the password strength {string}")
    public void userValidatesThePasswordStrength(String arg0) {

    }
}
