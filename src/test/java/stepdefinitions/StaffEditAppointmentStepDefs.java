package stepdefinitions;

import com.github.javafaker.App;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentPage;
import pages.CommonPage;
import pages.SearchPatientOnStaffPage;
import pages.SignInPage;
import utilities.Driver;
import utilities.JSUtilities;

import static utilities.WriteToTxt.saveAppointData;


public class StaffEditAppointmentStepDefs {

    AppointmentPage appointmentPage=new AppointmentPage();
    CommonPage commonPage=new CommonPage();
    SignInPage signInPage =new SignInPage();
    SearchPatientOnStaffPage searchPatientOnStaffPage =new SearchPatientOnStaffPage();


    @When("user makes an appointment providing {string} {string} {string} {string} {string} {string}")
    public void user_makes_an_appointment_providing(String firstname, String lastname, String ssn, String email, String phone, String date) throws InterruptedException {


        Driver.waitAndClick(appointmentPage.MakeAnAppointmentButton);
        Driver.waitAndSendText(appointmentPage.firstnameTextbox, firstname);
        Driver.waitAndSendText(appointmentPage.lastnameTextbox, lastname);
        Driver.waitAndSendText(appointmentPage.ssnTextbox, ssn);
        Driver.waitAndSendText(appointmentPage.emailTextbox, email);
        Driver.waitAndSendText(appointmentPage.phoneTextbox, phone);
        Driver.waitAndSendText(appointmentPage.dateTextbox, date+ Keys.ENTER);
        Thread.sleep(5000);
        Driver.waitAndClick(appointmentPage.MakeAnAppointmentButton,5);
        //Assert.assertTrue(Driver.waitForVisibility(appointmentPage.successMessageToastContainer, 5).isDisplayed());

}

    @And("user signs in as staff providing {string} {string}")
    public void userSignsInAsStaffProviding(String username, String password) {

        Driver.waitAndClick( commonPage.accountMenu);
        Driver.waitAndClick( commonPage.signIn);

        signInPage.username.sendKeys(username);
        signInPage.password.sendKeys(password);
        signInPage.singInButton.click();
        Assert.assertTrue(commonPage.accountMenu.isDisplayed());


    }

    @And("user makes necessary updates and sets the status {string}")
    public void userMakesNecessaryUpdatesAndSetsTheStatus(String status) throws InterruptedException {

        Thread.sleep(2000);
        new Select(searchPatientOnStaffPage.statusDropdownCreateEditAppointment).selectByIndex(Integer.parseInt(status));

        searchPatientOnStaffPage.prescriptionBoxCreateEditAppointment.sendKeys("Will be determined");

        JSUtilities.scrollIntoViewJS(searchPatientOnStaffPage.descriptionBoxCreateEditAppointment);

        Driver.waitForVisibility(searchPatientOnStaffPage.descriptionBoxCreateEditAppointment,5).sendKeys("Will be entered later");

        new Select(searchPatientOnStaffPage.physicianDropdownCreateEditAppointment).selectByIndex(11);
        Thread.sleep(3000);
        new Select(searchPatientOnStaffPage.patientDropdownCreateEditAppointment).selectByIndex(1);


    }

    @And("user clicks edit button at the first appointment")
    public void userClicksEditButtonAtTheFirstAppointment() {

       Driver.waitAndClick(searchPatientOnStaffPage.latestAppointment);
    }


    @Then("user verifies that completed option is disabled")
    public void userVerifiesThatCompletedOptionIsDisabled() {

      Assert.assertFalse(searchPatientOnStaffPage.completedDisabled.isEnabled());

    }


    @Then("user verifies that test results are visible")
    public void userVerifiesThatTestResultsAreVisible() {
        
        Assert.assertTrue(searchPatientOnStaffPage.testResultsPage.isDisplayed());
    }

    @And("user clicks view tests")
    public void userClicksViewTests() {

        Driver.waitAndClick(searchPatientOnStaffPage.viewTestsButton);
    }

    @And("user clicks show tests for the given patient")
    public void userClicksShowTestsForTheGivenPatient() {
        Driver.waitAndClick(searchPatientOnStaffPage.showAppointmentButtonJack);

    }
}
