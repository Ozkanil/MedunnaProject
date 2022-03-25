package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.SearchPatientOnStaffPage;
import utilities.Driver;

import java.util.List;
import utilities.*;

public class SearchPatientOnStaffStepDefs {


    SearchPatientOnStaffPage searchPatientOnStaffPage=new SearchPatientOnStaffPage();


    @When("user clicks my pages")
    public void user_clicks_my_pages() {


        Driver.waitAndClick(searchPatientOnStaffPage.myPagesDropdown, 5);

    }

    @When("user clicks search patient")
    public void user_clicks_search_patient() {

        Driver.waitAndClick(searchPatientOnStaffPage.searchPatientDropdown, 5);

    }

    @And("user provides a valid ssn number into search box")
    public void userProvidesAValidSsnNumberIntoSearchBox(DataTable ssn) throws InterruptedException {

        List<String> ssnList= ssn.row(1);
        searchPatientOnStaffPage.patientSSNSearchBox.sendKeys(ssnList.get(0));
        Thread.sleep(5000);

    }

    @When("user clicks view button")
    public void user_clicks_view_button() {


        Driver.waitAndClick(searchPatientOnStaffPage.viewButtonOnPatientSearch, 5);

    }

    @Then("user verifies patient info is visible")
    public void user_verifies_patient_info_is_visible() {


        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffPage.patientsText,5).isDisplayed());

    }

    @Then("user clicks back button")
    public void user_clicks_back_button() {

    Driver.waitAndClick(searchPatientOnStaffPage.backButtonAtPatientInfo,5);

    }

    @And("user clicks patient edit button")
    public void userClicksPetientEditButton() {

       Driver.waitAndClick(searchPatientOnStaffPage.editButtonOnPatientSearch, 5);
    }

    @Then("user verifies create or edit patient pages")
    public void userVerifiesCreateOrEditPatientPages() {

        Driver.waitForVisibility(searchPatientOnStaffPage.createEditPatientText,5).isDisplayed();
    }

    @And("user provides necessary data to edit patient info")
    public void userProvidesNecessaryDataToEditPatientInfo() {

       searchPatientOnStaffPage.nameBoxInCreateEditPatient.clear();
        searchPatientOnStaffPage.nameBoxInCreateEditPatient.sendKeys(Faker.instance().name().firstName());
        searchPatientOnStaffPage.lastnameBoxCreateEditPatient.clear();
        searchPatientOnStaffPage.lastnameBoxCreateEditPatient.sendKeys(Faker.instance().name().lastName());
        searchPatientOnStaffPage.emailBoxCreateEditPatient.clear();
        searchPatientOnStaffPage.emailBoxCreateEditPatient.sendKeys(Faker.instance().internet().emailAddress());
        searchPatientOnStaffPage.phoneBoxCreateEditPatient.clear();
        searchPatientOnStaffPage.phoneBoxCreateEditPatient.sendKeys("4569875896");

    }

    @And("user click save button")
    public void userClickSaveButton() {
        Driver.waitAndClick(searchPatientOnStaffPage.saveButtonCreateEditPatient,5);
        //searchPatientOnStaffPage.saveButtonCreateEditPatient.click();
    }

    @Then("user verifies patient info update message")
    public void userVerifiesPatientInfoUpdateMessage() {

        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffPage.saveSuccessAlert,5).isDisplayed());
    }



    @And("user click show appointments button")
    public void userClickShowAppointmentsButton() throws InterruptedException {

        Driver.waitAndClick(searchPatientOnStaffPage.showAppointmentsButton,5);
        Thread.sleep(3000);
    }

    @And("user verifies appointments page header")
    public void userVerifiesAppointmentsPageHeader() {

        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffPage.appointmentTextUnderShowAppointments,5).isDisplayed());
    }

    @Then("user verifies create and edit appointments page")
    public void userVerifiesCreateAndEditAppointmentsPage() {

        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffPage.createEditAppointmentText,5).isDisplayed());
    }

    @And("user makes necessary updates")
    public void userMakesNecessaryUpdates() throws InterruptedException {
Driver.wait(1);
        searchPatientOnStaffPage.diagnosisBoxCreateEditAppointment.sendKeys("123");
        searchPatientOnStaffPage.prescriptionBoxCreateEditAppointment.sendKeys("987");
        Thread.sleep(3000);
        new Select(searchPatientOnStaffPage.physicianDropdownCreateEditAppointment).selectByIndex(1);

    }

    @Then("verifies update is successful")
    public void verifiesUpdateIsSuccessful() {

        Assert.assertTrue(Driver.waitForVisibility(searchPatientOnStaffPage.saveSuccessAlert,5).isDisplayed());
    }

    @And("user clicks edit button under appointments")
    public void userClicksEditButtonUnderAppointments() {

        Driver.waitAndClick(searchPatientOnStaffPage.editButtonAppointments,5);
    }
}