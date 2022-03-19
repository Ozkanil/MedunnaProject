package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CommonPage;
import pages.SignInPage;
import pages.StatusPage;
import pages.ViewByDoctorPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class ViewByDoctorStep {
    ViewByDoctorPage view = new ViewByDoctorPage();

    StatusPage statusPage = new StatusPage();
//
//    @When("user clicks sign in button at the home page and navigates to sign in page")
//    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {
//
//        view.signInButton.click();
//        Driver.waitForClickablility(view.signInButton,5).click();
//        view.signInButton.click();

    @When("user verifies home page")
    public void user_verifies_home_page() {
        // Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));
       Driver.waitAndClick(view.myPagesDropdown);


    }

    @When("user clicks my Inpatients dropdown")
    public void user_clicks_my_inpatients_dropdown() {
      Driver.waitForVisibility(view.myInPatientsDropDown,5);
      view.myInPatientsDropDown.click();
    }
    @When("user verifies Inpatients page")
    public void user_verifies_in_patients_page() {
      Driver.wait(5);
    }
    @When("user provides from date {string} and to date {string}")
    public void user_provides_from_date_and_to_date(String fromdate, String todate) {
        Driver.waitForVisibility(view.fromDateTextBox,5);
        Driver.waitForVisibility(view.toDateTextBox,5);
        view.fromDateTextBox.sendKeys(fromdate);
        view.toDateTextBox.sendKeys(todate);

    }
    @When("user views all patient info")
    public void user_views_all_patient_info() {
        Driver.wait(3);
        Driver.wait(3);
        Assert.assertTrue(Driver.waitForVisibility(view.patientsId,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsStartDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsEndDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsDescription,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsCreatedDate,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsAppointment,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsStatus,3).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(view.inPatientsRoom,3).isDisplayed());

    }
    @Given("user clicks edit button in the patient page")
    public void userClicksEditButtonInThePatientPage() {
        Driver.waitAndClick(view.editButton,5);
        Driver.waitAndClick(view.editButton,3);
        view.editButton.click();

    }
    @And("user can update all patient informations")
    public void userCanUpdateAllPatientInformations() {
        Driver.waitAndClick(view.StartDateTextBox,3);
       ;Driver.waitAndSendText(view.StartDateTextBox,"26-03-2022");
        view.StartDateTextBox.sendKeys(Keys.ARROW_RIGHT);
        Driver.waitAndSendText(view.StartDateTextBox,"02.00Am");


        Driver.waitAndClick(view.EndDateTextBox,3);
        Driver.waitAndSendText(view.EndDateTextBox,"18-04-2022");
        view.EndDateTextBox.sendKeys(Keys.TAB);
        Driver.waitAndSendText(view.EndDateTextBox,"12.30PM");
        Driver.wait(3);

        Driver.waitAndSendText(view.DescriptionTextBox,"parol",3);
        Driver.wait(3);

//
        Driver.clickWithJS(view.CreatedDateTextBox);
        Driver.waitAndSendText(view.CreatedDateTextBox,"25Feb",1);
        view.CreatedDateTextBox.sendKeys(Keys.TAB);
        Driver.waitAndSendText(view.CreatedDateTextBox,"0020220923AM");

        Driver.clickWithJS(view.RoomsTextBox);
        Driver.waitAndSendText(view.RoomsTextBox,"256",1);

    }

    @Then("user clicks save button in create or edit a in patients page")
    public void userClicksSaveButtonInCreateOrEditAInPatientsPage() {
        Driver.waitAndClick(view.saveButton,5);
        Driver.clickWithJS(view.saveButton);
        view.saveButton.click();
        Assert.assertTrue(Driver.waitForVisibility(view.saveButton,2).isDisplayed());
    }
}
