package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigurationReader;
import static org.hamcrest.CoreMatchers.equalTo;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static hooks.Hooks.spec;
public class PatientAppoRegApiSteps {
    Registrant registrant = new Registrant();
    Response response;
    @Given("user sets the necessary path params for appo reg")
    public void user_sets_the_necessary_path_params_for_appo_reg() {
        spec.pathParams("first", "api", "second", "appointments", "third", "patient",10363);
    }
    @When("user sends the get request for appointment registration data")
    public void user_sends_the_get_request_for_appointment_registration_data() {
        response =  getRequest(generateToken(ConfigurationReader.getProperty("staff_username"),ConfigurationReader.getProperty("staff_password")), ConfigurationReader.getProperty("api_appointmentsRegisters"));
        response.prettyPrint();
    }
    @Then("user validates api records of registered appointment")
    public void userValidatesApiRecordsOfRegisteredAppointment() {
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("firstName",equalTo("Quray")).
                body("ssn",equalTo(253-98-1248)).
                body("patient",equalTo(10363));
    }
}
