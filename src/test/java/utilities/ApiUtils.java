package utilities;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Room;
import pojos.RoomPost;

import static io.restassured.RestAssured.given;

public class ApiUtils {


    public static Response getRequest(String token, String endpoint) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);


        return response;


    }

    public static Response deleteRequest(String token, String endpoint){
        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(endpoint);
        return  response;
    }

    public static Response postRequestRoom(String token, String endpoint, RoomPost room) throws Exception {

        ObjectMapper obj=new ObjectMapper();


        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).body(obj.writeValueAsString(room)).when().post(endpoint);
        return  response;


    }


    public static Response putRequestRoom(String token, String endpoint,Room room) throws Exception {

        ObjectMapper obj=new ObjectMapper();


        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).body(obj.writeValueAsString(room)).when().put(endpoint);
        return  response;


    }

}