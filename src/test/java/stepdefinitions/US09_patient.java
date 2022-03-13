package stepdefinitions;

import pages.US09_patientPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class US09_patient {

    US09_patientPage patient= new US09_patientPage();

    @Given("user goes to {string}")
    public void userGoesTo(String url) {
        Driver.getDriver().get("https://www.medunna.com/login");
    }

    @And("User navigate to and click on Sign In button")
    public void userNavigateToAndClickOnSignInButton() {
        Driver.waitAndClick(patient.singInButton,5);

    }

    @And("User insert username as a Admin acount")
    public void userInsertUsernameAsAAdminAcount() {
        Driver.waitAndSendText(patient.loginUserNameTextbox,"mclara",5);
    }

    @And("User insert password as a AdminPass")
    public void userInsertPasswordAsAAdminPass() {
        patient.loginPasswordTextbox.sendKeys("123abc$");
    }

    @And("User click on Sign In button")
    public void userClickOnSignInButton() {
        Driver.waitAndClick(patient.loginButton);
    }

    @And("User navigate to and click on Item and Title tab")
    public void userNavigateToAndClickOnItemAndTitleTab() {
        Driver.waitAndClick(patient.ItemAndTitlesDropDown);
    }

    @And("User click on Patiente from the dropdown menu")
    public void userClickOnPatienteFromTheDropdownMenu() {
        Driver.waitAndClick(patient.PatientDropDown);
    }

    @And("User click on view button")
    public void userClickOnViewButton() {
        Driver.waitAndClick(patient.ViewButtonPatient1051);
    }

    @Then("User verifies patient information")
    public void userVerifiesPatientInformation() {
        Driver.waitForVisibility(patient.ViewPatienttable,5);
        Driver.waitAndClick(patient.BackButtonPatient1051);

    }

}
