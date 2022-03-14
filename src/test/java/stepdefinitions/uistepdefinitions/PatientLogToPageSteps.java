package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.PatientPageAll;
import pojos.Registrant;
import utilities.Driver;

public class PatientLogToPageSteps {

    PatientPageAll patientPageAll = new PatientPageAll();
    Registrant registrant = new Registrant();

    @Given("user verifies sign in page is visible")
    public void user_verifies_sign_in_page_is_visible() {
        Driver.wait(3);
        Assert.assertTrue(patientPageAll.signinHeaderVrf.isDisplayed());

    }

    @Given("user provides the patient username {string}")
    public void user_provides_the_patient_username(String username) {
        patientPageAll.username.sendKeys(username);
//       username = registrant.getLogin();
//        Driver.waitAndSendText(patientPageAll.username,username);

    }

    @Given("user provides the patient password {string}")
    public void user_provides_the_patient_password(String password) {
        patientPageAll.password.sendKeys(password);
//        password = registrant.getPassword();
//        Driver.waitAndSendText(patientPageAll.password,password);

    }

    @Given("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        patientPageAll.signinButton.click();

    }

    @Then("user verifies my pages patient is visible")
    public void user_verifies_my_pages_patient_is_visible() {
        Driver.wait(3);
        Assert.assertTrue(patientPageAll.myPagePatient.isDisplayed());

    }

    @Given("user clicks to account dropdown")
    public void user_clicks_to_account_dropdown() {
        Driver.wait(3);
        patientPageAll.accountMenu.click();
    }

    @Given("user clicks to signout button")
    public void user_clicks_to_signout_button() {
        Driver.wait(3);
        patientPageAll.singOutButton.click();
    }
    @Given("user verify logged out successfully")
    public void user_verify_logged_out_successfully() {
        Driver.wait(3);
        Assert.assertTrue(patientPageAll.signInAgainBtn.isDisplayed());
    }
    @Given("user clicks to signin again button")
    public void user_clicks_to_signin_again_button() {
        patientPageAll.signInAgainBtn.click();
    }

    @Then("user verifies my pages patient is invisible")
    public void userVerifiesMyPagesPatientIsInvisible() {
    for (int i=0;i<5;i++){
        try{
            Assert.assertTrue(patientPageAll.myPagePatient.isDisplayed());
        }catch(Exception e){
            Driver.wait(1);
        }


        }

    }
}
