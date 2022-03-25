package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.CommonPage;
import pages.MyPatientsPageDoctor;
import pages.SignInPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;
import utilities.*;
public class MyPatientsSteps {
    SignInPage signInPage = new SignInPage();
    CommonPage commonPage = new CommonPage();
    MyPatientsPageDoctor myPatientsPageDoctor = new MyPatientsPageDoctor();
    @Given("user logs in as doctor")
    public void user_logs_in_as_doctor() {
        Driver.waitAndSendText(signInPage.username, "arifcanpol135");
        Driver.waitAndSendText(signInPage.password, "!2qweASD");
        Driver.waitAndClick(signInPage.singInButton);
    }
    @Given("navigates to my patients page")
    public void navigates_to_my_patients_page() {
        Driver.waitAndClick(commonPage.myPages);
        Driver.waitAndClick(commonPage.myPatients);
        assertTrue(Driver.waitForVisibility(myPatientsPageDoctor.patientsTitle, 5).isDisplayed());

    }
}