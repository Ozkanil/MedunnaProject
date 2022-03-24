package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import pojos.StaffApi;
import utilities.ConfigurationReader;

import static org.hamcrest.Matchers.hasItems;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

public class US_19_API_StepDefs {

    Response response;
    StaffApi staffApi = new StaffApi();


    @Given("user sends the get request for Staff data")
    public void user_sends_the_get_request_for_staff_data() {

        response = getRequest(generateToken(ConfigurationReader.
                                getProperty("admin_username"),
                        ConfigurationReader.getProperty("admin_password")),
                ConfigurationReader.getProperty("staff_endpoint"));

        response.prettyPrint();

        response.then().statusCode(200);


    }
    @Given("user deserializes data to Java for Staff")
    public void user_deserializes_data_to_java_for_staff() {

        response.then().assertThat().body("firstName",hasItems("eymen"));
        response.then().assertThat().body("lastName",hasItems("arzu"));

    }
    @Given("user saves the users data to correspondent files for Staff")
    public void user_saves_the_users_data_to_correspondent_files_for_staff()  {
        //saveAppointmentCreation(staffApi);


    }
}
