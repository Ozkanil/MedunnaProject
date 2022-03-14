package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchPatientOnStaffPage;
import pages.SeeAndEditInfoPage;
import utilities.Driver;

import java.util.List;

public class SeeAndEditInfoSteps {

    SearchPatientOnStaffPage searchPatientOnStaffPage = new SearchPatientOnStaffPage();
    SeeAndEditInfoPage SeeAndEditInfoPage = new SeeAndEditInfoPage();



    @When("user clicks search patient dropdown")
    public void user_clicks_search_patient_dropdown() {

        Driver.waitAndClick(SeeAndEditInfoPage.searchPatientDropdown, 5);
        SeeAndEditInfoPage.searchPatientDropdown.click();
    }
    @And("user clicks show appointment button")
    public void userClicksShowAppointmentButton() {
        SeeAndEditInfoPage.showAppointmentButton.click();
    }
}
