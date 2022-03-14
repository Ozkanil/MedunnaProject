package stepdefinitions;


import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.PatientPageAll;
import pojos.Appointment;
import utilities.Driver;

public class PatientMakeAppPgSteps {

    PatientPageAll patientPageAll = new PatientPageAll();
    Faker faker = new Faker();
    Appointment appointment = new Appointment();

    @Given("user clicks my page dropdown")
    public void user_clicks_my_page_dropdown() {
        Driver.waitAndClick(patientPageAll.myPagePatient);

    }

    @Given("user verifies the appointment name {string}")
    public void user_verifies_the_appointment_name(String string) {
        Assert.assertTrue(patientPageAll.firstNameValue.isDisplayed());

    }

    @Given("user verifies the appointment lastname {string}")
    public void user_verifies_the_appointment_lastname(String string) {
        Assert.assertTrue(patientPageAll.lastNameValue.isDisplayed());

    }

    @And("user verifies ssn number {string}")
    public void userVerifiesSsnNumber(String ssn) {
        Assert.assertTrue(patientPageAll.SSNValue.isDisplayed());
    }

    @Given("user verifies email address {string}")
    public void user_verifies_email_address(String string) {
        Assert.assertTrue(patientPageAll.emailValue.isDisplayed());

    }


}
