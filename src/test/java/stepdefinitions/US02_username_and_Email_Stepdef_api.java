package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utilities.ConfigurationReader;

import static org.hamcrest.Matchers.hasItems;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;


public class US02_username_and_Email_Stepdef_api {

    Response response;
    @Given("user set the url and generate the token")
    public void user_set_the_url_and_generate_the_token() {
       //  String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWR1bm5hYWRtaW4iLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY0Njk5NjYzOH0.yylp6kWllONpUzaYRWfVJMjwDbWGwbCi2NDqRhJDCWZfQVpTNa8My4iAMfsPAS1nkNfKeJ9QkefhEpPeBh0KeQ";
        response = getRequest(generateToken(), ConfigurationReader.getProperty("registrant_endpoint_all_user"));


        response.prettyPrint();

        response.then().assertThat().body("login",hasItems("doktormustafa"));
    }



    @Then("user validate the email")
    public void user_validate_the_email() {

        response.then().assertThat().body("email",hasItems("doktormustafa@qa.com"));
    }



}
