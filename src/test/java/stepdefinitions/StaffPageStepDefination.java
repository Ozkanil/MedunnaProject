package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.SignInPage;
import pages.StaffInPatientEditPage;
import pages.StaffInPatientPage;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class StaffPageStepDefination extends ReusableMethods {

    CommonPage commonPage=new CommonPage();
    SignInPage signInPage=new SignInPage();
    StaffInPatientPage staffInPatient=new StaffInPatientPage();
    StaffInPatientEditPage staffInPatientEdit=new StaffInPatientEditPage();
    JSUtils jsUtils=new JSUtils();

    @When("User sign in as a Staff at homepage")
    public void user_sign_in_as_a_staff_at_homepage() throws InterruptedException {
        Driver.getDriver().get("https://medunna.com/");
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys("staffmustafaqa");
        signInPage.password.sendKeys("11!!qqQQ");
        signInPage.singInButton.click();
        Thread.sleep(3000);

    }
    @Then("User clicks the In Patient under MY PAGES at homepage")
    public void user_clicks_the_in_patient_under_my_pages_at_homepage() {
        commonPage.myPages.click();
        commonPage.inPatientUnderMyPages.click();


    }

    @Then("User write a date fromDateBox")
    public void user_write_a_date_from_date_box() {
       // staffInPatient.fromDateBox.sendKeys("01/01/2021");

    }
    @Then("User write a date toDateBox")
    public void user_write_a_date_to_date_box() throws InterruptedException {
     //  staffInPatient.toDateBox.sendKeys("01/01/2021");


    }
    @Then("User clicks firts Edit Button")
    public void user_clicks_firts_edit_button() throws InterruptedException {
        Thread.sleep(5000);
        waitForClickablility(staffInPatient.firstEditButton,2).click();
        Thread.sleep(5000);
    }

    @Then("User verifies that he,she is in In patient page at In Patients Page")
    public void userVerifiesThatHeSheIsInInPatientPageAtInPatientsPage() throws InterruptedException {
        waitForVisibility(staffInPatientEdit.createOrEditAInPatientText,10);
        Assert.assertTrue(staffInPatientEdit.createOrEditAInPatientText.isEnabled());
    }
}
