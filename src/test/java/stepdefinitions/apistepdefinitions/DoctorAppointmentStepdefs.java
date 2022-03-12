package stepdefinitions.apistepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.DoctorAppointment;
import utilities.ConfigurationReader;

import java.io.IOException;

import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

public class DoctorAppointmentStepdefs  {

 static    DoctorAppointment expectedData;
    Response response;

    @Given("user sends get request to the {string}")
    public void userSendsGetRequestToThe(String arg0) {
        response=getRequest(generateToken(ConfigurationReader.getProperty("doctor_username"),ConfigurationReader.getProperty("doctor_password")),arg0);
         }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int arg0) {
        response.then().statusCode(arg0);
    }


    @And("response format should be {string}")
    public void responseFormatShouldBe(String arg0) {
        response.then().contentType(arg0);
    }

    @And("response body should include expected information")
    public void responseBodyShouldIncludeExpectedInformation() throws IOException {
        ObjectMapper obj=new ObjectMapper();
DoctorAppointment []doctorAppointments=obj.readValue(response.asString(),DoctorAppointment[].class);
        Assert.assertEquals(4,doctorAppointments.length);
        for (DoctorAppointment d:doctorAppointments
             ) {
            switch (d.getId()){
            case 11868:
                /*
                 "id": 11868,
    "startDate": "2022-03-07T00:00:00Z",
    "endDate": "2022-03-07T01:00:00Z",
    "status": "UNAPPROVED"
                 */
                expectedData =new DoctorAppointment(
                        11868,"2022-03-07T00:00:00Z","2022-03-07T01:00:00Z","UNAPPROVED");
                Assert.assertEquals(d.getId(),expectedData.getId());
                Assert.assertEquals(d.getEndDate(),expectedData.getEndDate());
                Assert.assertEquals(d.getStartDate(),expectedData.getStartDate());
                Assert.assertEquals(d.getStatus(),expectedData.getStatus());

                break;

            case 11883:
                /*
                "id": 11883,
    "startDate": "2022-03-08T00:00:00Z",
    "endDate": "2022-03-08T01:00:00Z",
    "status": "CANCELLED",
                 */
                expectedData =new DoctorAppointment(
                        11883,"2022-03-08T00:00:00Z","2022-03-08T01:00:00Z","CANCELLED");
                Assert.assertEquals(d.getId(),expectedData.getId());
                Assert.assertEquals(d.getEndDate(),expectedData.getEndDate());
                Assert.assertEquals(d.getStartDate(),expectedData.getStartDate());
                Assert.assertEquals(d.getStatus(),expectedData.getStatus());
                break;
            case 11885:
                /*
             "id": 11885,
    "startDate": "2022-03-10T00:00:00Z",
    "endDate": "2022-03-10T01:00:00Z",
    "status": "COMPLETED",
                 */
                expectedData =new DoctorAppointment(
                        11885,"2022-03-10T00:00:00Z","2022-03-10T01:00:00Z","COMPLETED");
                Assert.assertEquals(d.getId(),expectedData.getId());
                Assert.assertEquals(d.getEndDate(),expectedData.getEndDate());
                Assert.assertEquals(d.getStartDate(),expectedData.getStartDate());
                Assert.assertEquals(d.getStatus(),expectedData.getStatus());
                break;
                case 13800:
           /* "id": 13800,
                    "startDate": "2022-03-09T00:00:00Z",
                    "endDate": "2022-03-09T01:00:00Z",
                    "status": "PENDING",*/
                    expectedData =new DoctorAppointment(
                            13800,"2022-03-09T00:00:00Z","2022-03-09T01:00:00Z","PENDING");

                    Assert.assertEquals(d.getId(),expectedData.getId());
                    Assert.assertEquals(d.getEndDate(),expectedData.getEndDate());
                    Assert.assertEquals(d.getStartDate(),expectedData.getStartDate());
                    Assert.assertEquals(d.getStatus(),expectedData.getStatus());
                    break;
            default:
                break;

        }



        }


    }




}
