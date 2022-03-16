package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.PatientPageAll;
import pojos.Appointment;
import utilities.Driver;

public class PatientsMyApptsStep {

    PatientPageAll patientPageAll= new PatientPageAll();
    Appointment appointment = new Appointment();

    @Given("user clicks on my appointments")
    public void user_clicks_on_my_appointments() {
        patientPageAll.myAppointments.click();
    }
    @Given("user verifies appointments text")
    public void user_verifies_appointments_text() {
        Assert.assertTrue(patientPageAll.appointmentsTextVrf.isDisplayed());
    }
    @And("user sends the date {string} to from iframe")
    public void userSendsTheDateToFromIframe(String from) {
        // appointment.setFrom(from);
        Driver.waitAndSendText(patientPageAll.fromDateBoxApp,from + Keys.ENTER);
    }

    @And("user sends the date {string} to to iframe")
    public void userSendsTheDateToToIframe(String to) {
        // appointment.setTo(to);
        Driver.waitAndSendText(patientPageAll.toDateBoxApp,to + Keys.ENTER);
    }

    @Then("user verifies success message")
    public void userVerifiesSuccessMessage() {
        Assert.assertFalse(patientPageAll.daysBetween.isDisplayed());

    }
}
