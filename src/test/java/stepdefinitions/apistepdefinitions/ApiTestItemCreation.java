package stepdefinitions.apistepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.TestItem;
import utilities.ConfigurationReader;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveTestItemData;

public class ApiTestItemCreation {
    Faker faker = new Faker();
    TestItem testItem = new TestItem();
    Response response;
    public static RequestSpecification spec;
    @Given("user sets the necessary path parameters")
    public void user_sets_the_necessary_path_parameters() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "c-test-items");
    }
    @Given("user sets the expected data {string}, {string}, {string}, {string}, {string}")
    public void user_sets_the_expected_data(String defMaxVal, String defMinVal, String description, String name, String price) {
        name = faker.name().firstName();
        testItem.setDefaultValMax(defMaxVal);
        testItem.setDefaultValMin(defMinVal);
        testItem.setDescription(description);
        testItem.setName(name);
        testItem.setPrice(Integer.parseInt(price));
    }
    @Given("user send the post request and gets the response")
    public void user_send_the_post_request_and_gets_the_response() {

        String token = generateToken("omradmin", "951753");
        response = given().headers(
                "Authorization",
                "Bearer " + token).given().spec(spec).contentType(ContentType.JSON).body(testItem).when().post("/{first}/{second}");

    }
    @When("user saves the api records to correspondent file")
    public void user_saves_the_api_records_to_correspondent_file() {
        saveTestItemData(testItem);
    }
    @Then("user validates all api records")
    public void user_validates_all_api_records() throws Exception {

        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();

        TestItem actualTestItem = obj.readValue(response.asString(), TestItem.class);

        System.out.println(actualTestItem);
        assertEquals(testItem.getDefaultValMax(), actualTestItem.getDefaultValMax());
        assertEquals(testItem.getDefaultValMin(), actualTestItem.getDefaultValMin());
        assertEquals(testItem.getDescription(), actualTestItem.getDescription());
        assertEquals(testItem.getName(), actualTestItem.getName());
        assertEquals(testItem.getPrice(), actualTestItem.getPrice());
    }
}
