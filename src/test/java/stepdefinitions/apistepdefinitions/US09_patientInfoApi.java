package stepdefinitions.apistepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.asynchttpclient.RequestBuilder;
import utilities.ConfigurationReader;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.*;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

public class US09_patientInfoApi {
    Response response;
    Map<String, Object> expectedData;

    @When("set the Base Url")
    public void setTheBaseUrl() {
        response = getRequest(generateToken("admin79","admin"), ConfigurationReader.getProperty("patient_endpoint"));

    }

    @And("send the GET request and get the response")
    public void sendTheGETRequestAndGetTheResponse() {
        response.prettyPrint();
    }

    @And("set the expected data")
    public void setTheExpectedData() {
        expectedData = new HashMap<>();
        expectedData.put("firstName","John");
        expectedData.put("lastName","Doe");
        expectedData.put("email","john@doe.com");

    }

    @Then("do validation")
    public void doValidation() {
        Map<String, String> actualData= response.as(HashMap.class);
        System.out.println(actualData.toString());
        assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        assertEquals(expectedData.get("lastName"),actualData.get("lastName"));
        assertEquals(expectedData.get("email"),actualData.get("email"));

    }
}
