package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US015_Admin_Accesses {


    CommonPage commonPage = new CommonPage();
    SignInPage signInPage = new SignInPage();
    AdminPage adminPage = new AdminPage();
    Patient1051Page patientInfos=new Patient1051Page();
    CreateOrEditAPatientByAdminPage createPatient = new CreateOrEditAPatientByAdminPage();
    Faker faker=new Faker();

    public String Firstname=faker.name().firstName();
    public String Lastname=faker.name().lastName();

    @Given("User signs in as an Admin")
    public void user_signs_in_as_an_admin() throws InterruptedException {
        Driver.getDriver().get("https://medunna.com/");
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys("MedunnaAdmin");
        signInPage.password.sendKeys("1@qweASD");
        Driver.clickWithJS(signInPage.singInButton);
        Thread.sleep(3000);
    }

    @Then("User clicks Patient button under Items&Titles")
    public void user_clicks_patient_button_under_items_titles() {
        commonPage.itemsAndTitles.click();
        adminPage.patientsUnderItemsAndTitles.click();

    }

    @Then("User clicks the Create a new Patient button")
    public void user_clicks_the_create_a_new_patient_button() throws InterruptedException {

        Driver.waitAndClickElement(adminPage.createANewPatient, 10);
        Thread.sleep(3000);
    }

    @Then("User fill out the formula and clicks to Save button")
    public void user_fill_out_the_formula_and_clicks_to_save_button() {

        createPatient.firstName.sendKeys(Firstname);
        createPatient.lastName.sendKeys(Lastname);
        createPatient.birthDate.sendKeys(faker.date().birthday(21,35).toString());
        createPatient.email.sendKeys(faker.internet().emailAddress());
        createPatient.phone.sendKeys("111-111-1111");
        createPatient.gender.sendKeys("MALE");
        createPatient.bloodGroup.sendKeys("A+");
        createPatient.description.sendKeys(faker.artist().name());
        createPatient.adress.sendKeys(faker.address().fullAddress());
        createPatient.user.sendKeys("system");
        createPatient.country.sendKeys("US" + Keys.ENTER);
        createPatient.stateCity.sendKeys("Alaska" + Keys.ENTER);
        Driver.waitForVisibility(createPatient.saveButton,10);
        Driver.clickWithJS(createPatient.saveButton);


    }

    @Then("User verifies that the new user created Alert")
    public void user_verifies_that_the_new_user_created_alert() {

        Driver.waitForVisibility(createPatient.successCreatedMessage,10);
        Assert.assertTrue(createPatient.successCreatedMessage.isEnabled());

    }


    @Given("User signs in as an {string},{string}")
    public void user_signs_in_as_an(String username, String password)  {
      /*  Driver.getDriver().get("https://medunna.com/");
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys(username);
        signInPage.password.sendKeys(password);
        Driver.clickWithJS(signInPage.singInButton);
        Thread.sleep(3000);


       */

    }

    @Then("User verifies that there is noPatient button under Items&Titles")
    public void user_verifies_that_there_is_no_patient_button_under_items_titles() {
        //Assert.assertFalse(commonPage.itemsAndTitles.isEnabled());
    }

    @Then("User clicks the first View button between Patients")
    public void user_clicks_the_first_view_button_between_patients() {

        Driver.waitForVisibility(adminPage.firstViewButton,10);
        adminPage.firstViewButton.click();

    }

    @Then("User verifies that the requeriments")
    public void user_verifies_that_the_requeriments() {

        Assert.assertTrue(patientInfos.ssn.isEnabled());
        Assert.assertTrue(patientInfos.firstName.isEnabled());
        Assert.assertTrue(patientInfos.lastName.isEnabled());
        Assert.assertTrue(patientInfos.birthDate.isEnabled());
        Assert.assertTrue(patientInfos.phone.isEnabled());
        Assert.assertTrue(patientInfos.gender.isEnabled());
        Assert.assertTrue(patientInfos.bloodGroup.isEnabled());
        Assert.assertTrue(patientInfos.description.isEnabled());
        Assert.assertTrue(patientInfos.createdDate.isEnabled());
        Assert.assertTrue(patientInfos.user.isEnabled());
        Assert.assertTrue(patientInfos.country.isEnabled());
        Assert.assertTrue(patientInfos.stateCity.isEnabled());
    }

    @Then("User clicks the first Edit button between Patients button between Patients")
    public void userClicksTheFirstEditButtonBetweenPatientsButtonBetweenPatients() {
        Driver.waitForVisibility(adminPage.firstEditButton,10);
        adminPage.firstEditButton.click();


    }

    @Then("User Verifies the id box")
    public void user_verifies_the_id_box() {

        Driver.waitForVisibility(createPatient.id,10);
        Assert.assertTrue(createPatient.id.isEnabled());
    }

    @Then("User clicks the first Edit button between Patients")
    public void user_clicks_the_first_edit_button_between_patients() {
        Driver.waitForVisibility(adminPage.firstEditButton,10);
        adminPage.firstEditButton.click();

    }

    @Then("User clicks Appointment button under Items&Titles")
    public void userClicksAppointmentButtonUnderItemsTitles() {
        commonPage.itemsAndTitles.click();
        adminPage.adminAppointment.click();
    }

    @Then("User assign a doctor to Patient")
    public void user_assign_a_doctor_to_patient(){

        Driver.waitAndSendText(createPatient.physician,"10505:Johny John");



    }

    @Then("User assign a  Patient  to doctor")
    public void user_assign_a_patient_to_doctor() {
        createPatient.patient.sendKeys("3651");
        Driver.waitForVisibility(createPatient.saveButton,10);
        Driver.clickWithJS(createPatient.saveButton);

    }

    @Then("User verifies the Successfuly message")
    public void user_verifies_the_successfuly_message() {
        Driver.waitForVisibility(createPatient.successUpdatedMessage,10);
        Assert.assertTrue(createPatient.successUpdatedMessage.isEnabled());

    }

    @Then("User clicks State and City button under Items&Titles")
    public void user_clicks_and_state_city_button_under_items_titles() {

    }

    @Then("User creates the list of Name of States")
    public void user_creates_the_list_of_name_of_states() {

    }

    @Then("User verifies that all State are in US")
    public void user_verifies_that_all_state_are_in_us() {

    }

    @Then("User clicks the first Delete button between Patients")
    public void user_clicks_the_first_delete_button_between_patients() {

    }

    @Then("User verifies the not Successfuly message")
    public void user_verifies_the_not_successfuly_message() {

    }

    @Then("You should report this Bug")
    public void you_should_report_this_bug() {

    }

    @Then("user validate the all infos")
    public void user_validate_the_all_infos() {

    }


}
