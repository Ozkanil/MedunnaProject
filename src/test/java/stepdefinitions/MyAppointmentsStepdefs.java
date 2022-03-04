package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.MyAppointmentPageAsDoctor;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class MyAppointmentsStepdefs {
    CommonPage commonPage=new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();

    @Given("user sign in as a {string} providing {string} and {string}")
    public void userSignInAsAProvidingAnd(String arg0, String arg1, String arg2) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_sign_in_url"));
        Driver.waitAndSendText(signInPage.username,arg1);
        Driver.waitAndSendText(signInPage.password,arg2);
        Driver.waitAndClick(signInPage.singInButton);

        switch (arg0){
            case "doctor":
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                Assert.assertTrue(myAppointmentPageAsDoctor.myAppointment.isDisplayed());
            break;
            case "admin":
            break;
            case "patient":
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
            break;
            case "staff":
            break;
            case "user":
            break;
            default:
            break;
        }


    }

    @And("user clicks on the MY PAGES dropdown")
    public void userClicksOnTheMYPAGESDropdown() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
    }

    @And("user selects My Appointments item and clicks")
    public void userSelectsMyAppointmentsItemAndClicks() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.);
    }

    @When("user on the Appointments page")
    public void userOnTheAppointmentsPage() {
    }

    @Then("user should see list of appointments and time slots")
    public void userShouldSeeListOfAppointmentsAndTimeSlots() {
    }

    @Then("user should see {string} information of the appointment list")
    public void userShouldSeeInformationOfTheAppointmentList(String arg0) {
    }

    @Then("user closes the application")
    public void userClosesTheApplication() {
    }
}
