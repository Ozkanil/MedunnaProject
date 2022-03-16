package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import pages.SearchPatientOnStaffPage;
import pages.EditPage;
import utilities.Driver;

import java.util.List;
import utilities.*;

public class EditStep {

    SearchPatientOnStaffPage searchPatientOnStaffPage = new SearchPatientOnStaffPage();

    CommonPage commonPage = new CommonPage();
    EditPage editPage = new EditPage();

    @When("user clicks search patient dropdown2")
    public void user_clicks_search_patient_dropdown2() throws InterruptedException {
        editPage.searchPatientDropdown.click();
        Thread.sleep(5);
        // Driver.waitAndClick(EditPage.searchPatientDropdown, 5);
    }

    @Then("user verifies create or edit an appointment pages")
    public void userVerifiesCreateOrEditAnAppointmentPages() throws InterruptedException {
        Thread.sleep(3);
    }

    @And("user provides Anamnesis {string} texbox")
    public void userProvidesAnamnesisTexbox(String anamnesis)  {
        Driver.waitForVisibility(editPage.anamnesisTextBox,3);
    }

    @And("user provides Treatment {string} texbox")
    public void userProvidesTreatmentTexbox(String treatment)  {
        Driver.waitForVisibility(editPage.treatmentTextBox,3);
    }

    @And("user provides Diagnosis {string} texbox")
    public void userProvidesDiagnosisTexbox(String diagnosis) {
        Driver.waitForVisibility(editPage.diagnosisTextBox,3);
    }

    @And("user provides a valid ssn number into search box2")
    public void userProvidesAValidSsnNumberIntoSearchBox2(DataTable ssn) {

        List<String> ssnList = ssn.row(1);
        searchPatientOnStaffPage.patientSSNSearchBox.sendKeys(ssnList.get(0));

    }

    @When("user clicks view button2")
    public void user_clicks_view_button2() {

        editPage.viewButtonOnPatientSearch.click();
        Driver.waitAndClick(searchPatientOnStaffPage.viewButtonOnPatientSearch, 5);

    }

    @And("user clicks sign in button at home page and navigates to sign in page")
    public void userClicksSignInButtonAtHomePageAndNavigatesToSignInPage() {

        commonPage.accountMenu.click();
        Driver.waitForClickablility(commonPage.signIn, 5).click();

    }

    @Then("user verifies sign in page header is visible")
    public void user_verifies_sign_in_page_header_is_visible() throws InterruptedException {

        Thread.sleep(5);

    }

    @Then("user enter a username {string} and password {string}")
    public void user_enter_a_username_and_password(String username, String password) throws InterruptedException {

        Thread.sleep(5);
    }

    @Then("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() throws InterruptedException {

        Thread.sleep(5);

    }

    @Then("user verifies sign in is successful")
    public void user_verifies_sign_in_is_successful() {

        Assert.assertTrue(commonPage.accountMenu.isDisplayed());

    }

    @And("user clicks search patient dropdown")
    public void userClicksSearchPatientDropdown() {
        Driver.waitForVisibility(editPage.searchPatientDropdown,5);
        editPage.searchPatientDropdown.click();

    }

    @When("user provides a valid ssn number in search box")
    public void userProvidesAValidSsnNumberInSearchBox() {
        Driver.waitForVisibility(editPage.patientSSNSearchBox, 5);
    }

    @And("user clicks show appointments button")
    public void userClicksShowAppointmentsButton() {
        Driver.waitForVisibility(editPage.showAppointmentsButton, 5);
        editPage.showAppointmentsButton.click();

    }

    @And("user clicks edit button")
    public void userClicksEditButton() {
        Driver.waitForVisibility(editPage.editButton, 5);
        editPage.editButton.click();

    }

    @Then("user verifies create or edit patient page")
    public void userVerifiesCreateOrEditPatientPage() {

    }

    @And("user provides anamnesis {string}")
    public void userProvidesAnamnesis(String anamnesis) {
        Driver.waitForVisibility(editPage.anamnesisTextBox,5);
    }
    @And("user provides treatment {string}")
    public void userProvidesTreatment(String treatment) {
        Driver.waitForVisibility(editPage.treatmentTextBox,5);
    }
    @And("user provides diagnosis {string}")
    public void userProvidesDiagnosis(String diagnosis) {
        Driver.waitForVisibility(editPage.diagnosisTextBox,5);

    }
    @And("user clicks save button")
    public void userClicksSaveButton (){
        Driver.wait(1);
        Driver.clickWithJS(editPage.saveButton);

    }



}
