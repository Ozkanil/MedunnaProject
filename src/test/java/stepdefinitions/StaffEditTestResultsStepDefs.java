package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.AppointmentEditPageForDoctor;
import pages.StaffEditTestResultsPage;
import utilities.Driver;


public class StaffEditTestResultsStepDefs {
    StaffEditTestResultsPage staffEditTestResultsPage = new StaffEditTestResultsPage();
    AppointmentEditPageForDoctor appointmentEditPageForDoctor = new AppointmentEditPageForDoctor();

    @Then("user clicks show tests")
    public void user_clicks_show_tests() {
        Driver.waitAndClick(staffEditTestResultsPage.showTests);
        Driver.wait(1);
    }
    @Then("user click view results")
    public void user_click_view_results() {
        Driver.waitAndClick(staffEditTestResultsPage.viewResults);
        Driver.wait(1);

    }
    @Then("user clicks edit button on test page")
    public void user_clicks_edit_button_on_test_page() {
        Driver.waitAndClick(staffEditTestResultsPage.edit);
        Driver.wait(1);

    }
    @And("user sends value to result box and  description box")
    public void userSendsValueToResultBoxAndDescriptionBox() {
        staffEditTestResultsPage.result.clear();
        Driver.waitAndSendText(staffEditTestResultsPage.result,"123");
        Driver.wait(1);
        staffEditTestResultsPage.description.clear();
        Driver.waitAndSendText(staffEditTestResultsPage.description,"normal");
        Driver.wait(1);

    }
    @Then("user clicks save button and verifies update message")
    public void user_clicks_save_button_and_verifies_update_message() {
        Driver.waitAndClick(staffEditTestResultsPage.saveButton,5);
        Driver.wait(1);
        Assert.assertTrue(staffEditTestResultsPage.updateMessage.isDisplayed());
        Driver.wait(1);

    }
}
