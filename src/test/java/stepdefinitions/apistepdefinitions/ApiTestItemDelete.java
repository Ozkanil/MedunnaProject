package stepdefinitions.apistepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigurationReader;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertFalse;
import static utilities.ApiUtils.deleteRequest;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;


public class ApiTestItemDelete {
    public static RequestSpecification spec;
    Response response;
    String endpointToDelete;
    @Given("user sets the necessary path parameters {string}")
    public void user_sets_the_necessary_path_parameters(String id) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        endpointToDelete = ConfigurationReader.getProperty("api_test_items_endpoint") + "/" +id;
    }
    @When("user sends delete request and gets the response")
    public void user_sends_delete_request_and_gets_the_response() {
        response = deleteRequest(generateToken("omradmin", "951753"), endpointToDelete);
    }

    @Then("user validates that the item {string} has been deleted")
    public void userValidatesThatTheItemHasBeenDeleted(String id) {
        response = getRequest(generateToken("omradmin", "951753"),ConfigurationReader.getProperty("api_all_test_items_endpoint"));
        response.then().assertThat().body("id", hasItem(id));
    }
}
