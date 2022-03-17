package utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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

//    public static Response postRequest(String token, RequestSpecification spec, ) {
//
//        Response response = given().headers(
//                "Authorization",
//                "Bearer " + token).given().spec(spec).contentType(ContentType.JSON).body(testItem).when().post("/{first}/{second}");
//
//
//        return response;
//
//
//    }

}