package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.Driver;

public class AppointmentAdminSteps {
    SignInPage signinpage = new SignInPage();
    CommonPage commonPage = new CommonPage();
    CreateOrEditAnAppointmentPage createOrEditAnAppointmentPage = new CreateOrEditAnAppointmentPage();
    AppointmentAdminPage appointmentAdminPage = new AppointmentAdminPage();
MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();

    @Given("user logs in as admin {string},{string}")
    public void user_logs_in_as_admin(String username, String password) {
        Driver.waitAndSendText(signinpage.username,username);
        Driver.waitAndSendText(signinpage.password,password);
        Driver.waitAndClick(signinpage.singInButton);
    }
    @Given("user navigates to appointment page")
    public void user_navigates_to_appointment_page() {
       Driver.waitAndClick(myAppointmentPageAsDoctor.itemsTitlesDropdown);
       Driver.waitAndClick(myAppointmentPageAsDoctor.adminAppointment);
    }
    @Given("user clicks to Create a new Appointment button")
    public void user_clicks_to_create_a_new_appointment_button() {
        Driver.waitAndClick(appointmentAdminPage.createANewAppointment);

    }
    @Given("user provides start date time and end date time")
    public void user_provides_start_date_time_and_end_date_time() {
        Driver.waitAndSendText(createOrEditAnAppointmentPage.startDateTime,"26-07-2022 09:15");
        Driver.waitAndSendText(createOrEditAnAppointmentPage.endDateTime,"29-07-2022 11:30");

    }
    @Given("user chooses status {string}")
    public void user_chooses_status(String string) {
        Driver.waitAndClick(createOrEditAnAppointmentPage.status);
        Driver.waitAndClick(createOrEditAnAppointmentPage.pendingOptionOnEditAnAppointment);

    }
    @Given("user provides Anamnesis {string} , Treatment {string} , Diagnosis {string} , Prescription {string} , Description {string}")
    public void user_provides_anamnesis_treatment_diagnosis_prescription_description(String anamnesis, String treatment, String diagnosis, String Prescription, String Description) {
        Driver.waitAndSendText(createOrEditAnAppointmentPage.anamnesis, anamnesis);
        Driver.waitAndSendText(createOrEditAnAppointmentPage.treatment, treatment);
        Driver.waitAndSendText(createOrEditAnAppointmentPage.diagnosis, diagnosis);
        Driver.waitAndSendText(createOrEditAnAppointmentPage.prescription, Prescription);
        Driver.waitAndSendText(createOrEditAnAppointmentPage.description, Description);

    }
    @Given("user chooses Physician {string}, Patient {string}")
    public void user_chooses_physician_patient(String physician, String patient) {
       Driver.selectByValue(createOrEditAnAppointmentPage.physician,physician);
       Driver.selectByValue(createOrEditAnAppointmentPage.patient,patient);


    }
    @When("user click on save button")
    public void user_click_on_save_button() {
        Driver.waitAndClick(createOrEditAnAppointmentPage.saveEntity);

    }
    @Then("user validates success message")
    public void user_validates_success_message() {
        Assert.assertTrue( Driver.waitForVisibility(createOrEditAnAppointmentPage.successMessageToastContainer,5).isDisplayed());

    }
}
