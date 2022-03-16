package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.PatientAppointmentPage;
import pojos.Appointments;
import utilities.Driver;

import static utilities.WriteToTxt.saveAppointData;
import utilities.*;

public class PtientUIAppointmentSteps {
    PatientAppointmentPage appointmentPage = new PatientAppointmentPage();
    Faker faker = new Faker();
    Appointments appointment = new Appointments();
    @Given("user clicks on make an appointment")
    public void user_clicks_on_make_an_appointment() {
        Driver.waitAndClick(appointmentPage.MakeAnAppointmentButton);
    }
    @Given("user provides the appoinment name {string}")
    public void user_provides_the_appoinment_name(String firstname) {
        firstname = faker.name().firstName();
        appointment.setFirstName(firstname);
        Driver.waitAndSendText(appointmentPage.firstnameTextbox, firstname);
    }
    @Given("user provides the appointment lastname {string}")
    public void user_provides_the_appointment_lastname(String lastname) {
        lastname = faker.name().lastName();
        appointment.setLastName(lastname);
        Driver.waitAndSendText(appointmentPage.lastnameTextbox, lastname);
    }
    @Given("user provides ssn and email {string} and {string}")
    public void user_provides_ssn_and_email_and(String ssn, String email) {
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        appointment.setSsn(ssn);
        appointment.setEmail(email);
        Driver.waitAndSendText(appointmentPage.ssnTextbox, ssn);
        Driver.waitAndSendText(appointmentPage.emailTextbox, email);
    }
    @When("user provides the phone number {string}")
    public void user_provides_the_phone_number(String phone) {
        phone = "123-456-4596";
        appointment.setPhone(phone);
        Driver.waitAndSendText(appointmentPage.phoneTextbox, phone);
    }
    @When("user provides the date {string}")
    public void user_provides_the_date(String date) {
        //05-04-2022
//        date = getDate();
        appointment.setStartDate(date);
        Driver.waitAndSendText(appointmentPage.dateTextbox, date+ Keys.ENTER);
    }
    @Then("user requests appointment and verifies the success message")
    public void user_requests_appointment_and_verifies_the_success_message() {
        Driver.waitAndClick(appointmentPage.requestButton);
        saveAppointData(appointment);
        Assert.assertTrue(Driver.waitForVisibility(appointmentPage.successMessageToastContainer, 5).isDisplayed());
    }
}
