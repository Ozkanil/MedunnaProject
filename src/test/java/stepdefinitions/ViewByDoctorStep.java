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

    @When("user verifies home page")
    public void user_verifies_home_page() {
        // Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));
        Driver.waitAndClick(view.myPagesDropdown);
        view.myPagesDropdown.click();

    }

    @When("user clicks my Inpatients dropdown")
    public void user_clicks_my_inpatients_dropdown() {
        Driver.waitForVisibility(view.myInPatientsDropDown, 5);
        view.myInPatientsDropDown.click();
    }

    @When("user verifies Inpatients page")
    public void user_verifies_in_patients_page() {
        Driver.wait(5);
    }

    @When("user provides from date {string} and to date {string}")
    public void user_provides_from_date_and_to_date(String fromdate, String todate) {
        Driver.waitForVisibility(view.fromDateTextBox, 5);
        Driver.waitForVisibility(view.toDateTextBox, 5);
        view.fromDateTextBox.sendKeys(fromdate);
        view.toDateTextBox.sendKeys(todate);

    }

    @And("user views id number and all patient info")
    public void userViewsIdNumberAndAllPatientInfo() {
        Driver.wait(10);

        Assert.assertTrue(Driver.waitForVisibility(view.patientsId, 3).isDisplayed());

    }
}