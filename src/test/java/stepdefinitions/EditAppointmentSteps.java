package stepdefinitions;

import io.cucumber.java.en.Given;
import pages.*;
import utilities.Driver;

public class EditAppointmentSteps {
    SignInPage signinpage = new SignInPage();
    CommonPage commonPage = new CommonPage();
    CreateOrEditAnAppointmentPage createOrEditAnAppointmentPage = new CreateOrEditAnAppointmentPage();
    AppointmentAdminPage appointmentAdminPage = new AppointmentAdminPage();
    EditPage editPage = new EditPage();

    @Given("user clicks to edit button")
    public void user_clicks_to_edit_button() {
        Driver.waitAndClick(appointmentAdminPage.editButton);

    }
    @Given("user provides Treatment {string} , Diagnosis {string} , Prescription {string}")
    public void user_provides_treatment_diagnosis_prescription(String treatment, String diagnosis, String prescription) {
        Driver.waitAndSendText(editPage.treatment,treatment);
        Driver.waitAndSendText(editPage.diagnosis,diagnosis);
        Driver.waitAndSendText(editPage.prescription,prescription);

    }
}

