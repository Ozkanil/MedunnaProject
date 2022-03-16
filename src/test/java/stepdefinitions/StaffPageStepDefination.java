package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.SignInPage;
import pages.StaffInPatientEditPage;
import pages.StaffInPatientPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.awt.*;
import java.awt.event.KeyEvent;
import utilities.*;

public class StaffPageStepDefination extends ReusableMethods {

    CommonPage commonPage=new CommonPage();
    SignInPage signInPage=new SignInPage();
    StaffInPatientPage staffInPatient=new StaffInPatientPage();
    StaffInPatientEditPage staffInPatientEdit=new StaffInPatientEditPage();

    Robot robot=new Robot();

    public StaffPageStepDefination() throws AWTException {
    }


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
    @Then("User verifies that he,she is in In patient page at In Patients Page")
    public void userVerifiesThatHeSheIsInInPatientPageAtInPatientsPage() throws InterruptedException {

        Assert.assertTrue(staffInPatient.inPatientsText.isEnabled());
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


    @Then("User verifies that he,she is in In Patients Edit Page")
    public void userVerifiesThatHeSheIsInInPatientsEditPage() {
        waitForVisibility(staffInPatientEdit.createOrEditAInPatientText,10);
        Assert.assertTrue(staffInPatientEdit.createOrEditAInPatientText.isEnabled());
    }

    @When("User clicks the Save Button verify the red alert")
    public void userClicksTheSaveButtonVerifyTheRedAlert() {

        Actions actions=new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        Assert.assertTrue(staffInPatientEdit.saveButton.isEnabled());
        staffInPatientEdit.saveButton.click();
        Assert.assertTrue(Driver.waitForVisibility(staffInPatientEdit.redAlert,10).isDisplayed());
    }
}
