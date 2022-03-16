package stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US09_patientPage;
import utilities.Driver;

import static org.junit.Assert.assertFalse;
import utilities.*;


public class US09_patientEdit {
    US09_patientPage patient= new US09_patientPage();
    @When("User signs in as Staff {string}-{string}")
    public void userSignsInAsStaff(String staffName, String staffPass) {
        Driver.getDriver().get("https://www.medunna.com/login");
        Driver.waitAndClick(patient.singInButton,5);
        Driver.waitAndSendText(patient.loginUserNameTextbox,staffName,5);
        patient.loginPasswordTextbox.sendKeys(staffPass);
        Driver.waitAndClick(patient.loginButton);
    }

    @Then("click on MY pages dropdown")
    public void clickOnMYPagesDropdown() {
        Driver.waitAndClick(patient.staffMyPage);
    }

    @Then("click on Search Patient button")
    public void clickOnSearchPatientButton() {
        Driver.waitAndClick(patient.staffSearchPatient);
    }

    @Then("click on edit button on patient info as Staff User")
    public void clickOnEditButtonOnPatientInfoAsStaffUser() {
        Driver.waitAndClick(patient.staffEditButtonPatient);

    }

    @Then("edit the patient informations and click on save button")
    public void editThePatientInformationsAndClickOnSaveButton() {

        Driver.waitAndSendText(patient.staffUpdateDescPatient, Keys.CONTROL+"a",5);
        Driver.waitAndSendText(patient.staffUpdateDescPatient,"KBB",5);
        Driver.waitAndClick(patient.staffSaveButtonPatient);

    }

    @Then("verify patient informations are updated")
    public void verifyPatientInformationsAreUpdated() {
        String str=Driver.waitAndGetText(patient.staffAfterUpdateDescPatient,3);
        System.out.println(str);
    }

    @Then("User signs in as Admin {string}-{string}")
    public void userSignsInAsAdmin(String adminName, String adminPass) {
        Driver.getDriver().get("https://www.medunna.com/login");
        Driver.waitAndClick(patient.singInButton,5);
        Driver.waitAndSendText(patient.loginUserNameTextbox,adminName,5);
        patient.loginPasswordTextbox.sendKeys(adminPass);
        Driver.waitAndClick(patient.loginButton);
    }

    @Then("click on Items&Titiles dropdown")
    public void clickOnItemsTitilesDropdown() {
        Driver.waitAndClick(patient.itemsTitlesDrowdown);
    }

    @Then("click on Patients")
    public void clickOnPatients() {
        Driver.waitAndClick(patient.PatientDropDown);
    }

    @Then("click on edit button on patient info as Admin User")
    public void clickOnEditButtonOnPatientInfoAsAdminUser() {
        Driver.waitAndClick(patient.adminPatientEdit);
    }

    @Then("edit the patient informations and click on save button as Admin")
    public void editThePatientInformationsAndClickOnSaveButtonAsAdmin() {
        Driver.waitAndSendText(patient.staffUpdateDescPatient, Keys.CONTROL+"a",5);
        Driver.waitAndSendText(patient.staffUpdateDescPatient,"KBB",5);
        Driver.waitAndClick(patient.staffSaveButtonPatient);

    }

    @Then("verify patient informations are updated as Admin")
    public void verifyPatientInformationsAreUpdatedAsAdmin() {
        Assert.assertTrue(patient.savedPatientAdmin.isDisplayed());
    }

    @Then("sign out")
    public void signOut() {
        Driver.waitAndClick(patient.logedInUser);
        Driver.waitAndClick(patient.signoutButton);
    }

    @Then("verify Delete button is not dispalyed")
    public void verifyDeleteButtonIsNotDispalyed() {
        String pageSource = Driver.getDriver().getPageSource();
        boolean result = pageSource.contains("delete");
        assertFalse(result);
    }

    @Then("verify Patient Search Box is not visiabte")
    public void verifyPatientSearchBoxIsNotVisiabte() {
        String pageSource = Driver.getDriver().getPageSource();
        boolean result = pageSource.contains("Search");
        assertFalse(result);
    }

    @Then("click on Delete button on the opening alert")
    public void clickOnDeleteButtonOnTheOpeningAlert() {
        //  Assert.assertTrue(patient.adminPatientDeletePopUp.isDisplayed());
    }

    @Then("enter a valid SSN ID in the Patients search box")
    public void enterAValidSSNIDInThePatientsSearchBox() {
        Driver.waitAndSendText(patient.staffPatientsSearchBox,"319-04-4812",2);
    }

    @Then("verify the patient informations are invoked")
    public void verifyThePatientInformationsAreInvoked() {

        Assert.assertTrue(Driver.waitForVisibility(patient.staffEditButtonPatient,1).isDisplayed());

    }

    @Then("click on Delete button on the patient you want to delete")
    public void clickOnDeleteButtonOnThePatientYouWantToDelete() {
        Driver.waitAndClick(patient.adminPatientDeleteButton,2);

    }

    @Then("verify patient is deleted")
    public void verifyPatientIsDeleted() {
        Driver.waitAndClick(patient.adminPatientDeleteCancel,5);

    }
}
