package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.hamcrest.Matchers.hasItems;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import utilities.*;

public class US13_Doctor_Request_Results_StepDef {

    Actions actions;
    Response response;
    CommonPage commonPage = new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();

    @Then("Sign in as a Doctor")
    public void sign_in_as_a_doctor() throws InterruptedException {
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys(ConfigurationReader.getProperty("doctor_username"));
        signInPage.password.sendKeys(ConfigurationReader.getProperty("doctor_password"));
        signInPage.singInButton.click();
//        Thread.sleep(3000);

    }
    @Then("Click the Items&Titles")
    public void click_the_items_titles() {
        Driver.waitAndClickElement(commonPage.itemsAndTitles,10);

    }
    @Then("Click the Test Item")
    public void click_the_test_item() {
        Driver.waitAndClickElement(commonPage.testItemUnderItemAndTest,10);

    }
    @Then("Check the id, name\\(Urea, Sodium, Glucose etc..), default max value, default min value, test, description and the date")
    public void check_the_id_name_urea_sodium_glucose_etc_default_max_value_default_min_value_test_description_and_the_date() {

        DoctorTestItemsPage doctorTestItemsPage=new DoctorTestItemsPage();
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.glucose,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.sodium,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.urea,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.id1401,10).isEnabled());

        doctorTestItemsPage.id1401.click();

        Id_1401_Page id_1401_page=new Id_1401_Page();
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.createdDate,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.defaultMaxValue,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.description,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.testItem1401,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.defaultMinValue,10).isEnabled());

    }

    @Given("user set the url and generate the token for patient page")
    public void userSetTheUrlAndGenerateTheTokenForPatientPage() {

        response = getRequest(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")), ConfigurationReader.getProperty("registrant_endpoint_in_patient"));
        response.prettyPrint();

    }

    @Then("user validate the in patient \\( patient can stay in hospital )")
    public void userValidateTheInPatientPatientCanStayInHospital() {

        response.then().assertThat().body("room.roomType",hasItems("SUITE"));

    }

}
