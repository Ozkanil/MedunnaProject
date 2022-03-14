package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPage;
import pages.NewAppointmentPage;
import utilities.Driver;

public class NewAppointmentsteps {

    SearchPatientOnStaffStepDefs searchPatientOnStaffStepDefs=new SearchPatientOnStaffStepDefs();

    CommonPage commonPage =new CommonPage();
    NewAppointmentPage newAppointmentPage =new NewAppointmentPage();

    @Then("user at the home page")
    public void user_at_the_home_page() {
        Driver.waitAndClick(newAppointmentPage.myPagesDropdown,5);
    }
    @Then("user clicks on my pages dropdown")
    public void user_clicks_in_my_pages_dropdown() {
        newAppointmentPage.myPagesDropdown.click();
        Driver.waitAndClick(newAppointmentPage.myPagesDropdown,5);
    }
    @Then("user clicks on Make an Appointments icon")
    public void user_clicks_on_make_an_appointments_icon() throws InterruptedException {

        Driver.waitAndClick(newAppointmentPage.makeAppointment,5);
        //newAppointmentPage.myPagesDropdown.click();

        Driver.waitAndClick(newAppointmentPage.makeAppointment,5);

    }
    @Then("verify Make an Appointmet page")
    public void verify_make_an_appointmet_page() {

        Assert.assertTrue(Driver.waitForVisibility(newAppointmentPage.appointmentVerificationText,5).isDisplayed());
    }
    @Then("user enters  firstname {string}")
    public void user_enters_firstname(String firstname) {
        newAppointmentPage.firstNameTextBox.clear();
        Driver.waitAndSendText(newAppointmentPage.firstNameTextBox,firstname);
    }
    @Then("user enters  lastname {string}")
    public void user_enters_lastname(String lastname) {
        newAppointmentPage.lastNameTextBox.clear();
        Driver.waitAndSendText(newAppointmentPage.lastNameTextBox,lastname);

    }
    @Then("user enters ssn number {string}")
    public void user_enters_ssn_number(String ssn) {

        newAppointmentPage.ssnTextBox.clear();
        Driver.waitAndSendText(newAppointmentPage.ssnTextBox, ssn);
    }
    @Then("user enters email addresse {string}")
    public void user_enters_email_addresse(String email) {
        newAppointmentPage.emailTextBox.clear();
        Driver.waitAndSendText(newAppointmentPage.emailTextBox,email);
    }
    @Then("user enters a phone number {string}")
    public void user_enters_a_phone_number(String phone) {
        newAppointmentPage.phoneTextBox.clear();
        Driver.waitAndSendText(newAppointmentPage.phoneTextBox,phone);
    }
    @Then("user enters  appointment date time {string}")
    public void user_enters_appointment_date_time(String appointmentdatetime) {

        Driver.waitAndSendText(newAppointmentPage.appointmentDateTimeTextBox, appointmentdatetime);
    }
    @Then("user clicks send an appointment request button")
    public void user_clicks_send_an_appointment_request_button() {
        Driver.waitAndClick(newAppointmentPage.sendAndAppointmentRequestButton,5);
        newAppointmentPage.sendAndAppointmentRequestButton.click();
    }

    @Then("user verifies appointment success message")
    public void userVerifiesAppointmentSuccessMessage() {

        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffStepDefs.searchPatientOnStaffPage.saveSuccessAlert, 5).isDisplayed());
    }
}
