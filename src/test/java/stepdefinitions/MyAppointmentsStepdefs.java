package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.MyAppointmentPageAsDoctor;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class MyAppointmentsStepdefs {
    WebDriver driver;
    CommonPage commonPage=new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
    @Given("user sign in as a {string}")
    public void userSignInAsA(String arg0) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_sign_in_url"));
        switch (arg0){
            case "doctor":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("doctor_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                Assert.assertTrue(myAppointmentPageAsDoctor.myAppointment.isDisplayed());
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                break;
            case "admin":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("admin_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("admin_password"));
                Driver.waitAndClick(signInPage.singInButton);
                break;
            case "patient":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("patient_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("patient_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                break;
            case "staff":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("staff_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("staff_password"));
                Driver.waitAndClick(signInPage.singInButton);
                break;
            case "user":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("user_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("user_password"));
                Driver.waitAndClick(signInPage.singInButton);
                break;
            default:
                System.out.println("No such user found");
                break;

    }

    }

    @And("user clicks on the MY PAGES dropdown")
    public void userClicksOnTheMYPAGESDropdown() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
    }

    @And("user selects My Appointments item and clicks")
    public void userSelectsMyAppointmentsItemAndClicks() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.myAppointment);
    }

    @When("user on the Appointments page")
    public void userOnTheAppointmentsPage() {
        Driver.waitForVisibility(myAppointmentPageAsDoctor.appointmentHeading,1);
        Assert.assertTrue(myAppointmentPageAsDoctor.appointmentHeading.isDisplayed());
    }

    @Then("user should see list of appointments and time slots")
    public void userShouldSeeListOfAppointmentsAndTimeSlots() {
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.toDateAppointment,1).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.fromDateAppointment,1).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.allDataOfAppointmentsTable,1).isDisplayed());
    }

    @Then("user should see {string} information of the appointment list")
    public void userShouldSeeInformationOfTheAppointmentList(String arg0) {
        Assert.assertTrue(Driver.waitAndGetText(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).contains(arg0));
    }

    @And("user selects time slots providing {string} and {string}")
    public void userSelectsTimeSlotsProvidingAnd(String arg0, String arg1) {
        Driver.waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment, arg0);
        Driver.waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment, arg1);
        Driver.wait(1);
        try {
            System.out.println(Driver.waitAndGetText(myAppointmentPageAsDoctor.alertMessage,1));
        } catch (Exception e) {
        }
    }

    @Then("user cliks on the edit button")
    public void userCliksOnTheEditButton() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
    }
}
