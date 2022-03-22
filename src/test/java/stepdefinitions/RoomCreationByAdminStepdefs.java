package stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CreateOrEditARoomByAdminPage;
import pojos.Room;
import pojos.RoomPost;
import utilities.ConfigurationReader;
import utilities.DBUtils;
import utilities.Driver;


import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.*;

import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveRoomData;

public class RoomCreationByAdminStepdefs {

     CreateOrEditARoomByAdminPage createOrEditARoomByAdminPage=new CreateOrEditARoomByAdminPage();
    Faker faker=new Faker();
    Room room;
    Response response;
    RoomPost roomPost;
    static String roomNumber="";
    static int price=0;
    static String createdDate="";
    String query="";

    @And("user navigates page to Rooms page")
    public void userNavigatesPageToRoomsPage() {
      //  Driver.waitAndClick(createOrEditARoomByAdminPage.itemsTitlesDropdown);
        Driver.clickWithJS(createOrEditARoomByAdminPage.roomDropdown);
        assertTrue(Driver.waitForVisibility(createOrEditARoomByAdminPage.roomsHeading,1).isDisplayed());
    }

    @When("user clicks on Create a new Room button")
    public void userClicksOnCreateANewRoomButton() {
        Driver.waitAndClick(createOrEditARoomByAdminPage.createANewRoomButton);
    }

    @Then("verify that user on the {string} page")
    public void verifyThatUserOnThePage(String arg0) {
        assertTrue(Driver.waitForVisibility(createOrEditARoomByAdminPage.createOrEditARoomHeading,1).isDisplayed());

    }

    @Given("user provides a Room Number")
    public void userProvidesARoomNumber() {
        roomNumber=String.valueOf(faker.number().numberBetween(100,300));
        Driver.waitAndSendText(createOrEditARoomByAdminPage.roomNumberTextBox,roomNumber );
    }

    @And("user provides a Price")
    public void userProvidesAPrice() {
        price=faker.number().numberBetween(100,500);
        Driver.waitAndSendText(createOrEditARoomByAdminPage.priceTextBox,String.valueOf(price));

    }

    @And("user sets date as {string}")
    public void userSetsDateAs(String arg0) {
        createdDate=arg0;
        Driver.waitAndSendText(createOrEditARoomByAdminPage.createdDateTextBox,createdDate);
        saveRoomData(roomNumber,price,createdDate);
    }

    @And("verify that Created Date is updated automatically")
    public void verifyThatCreatedDateIsUpdatedAutomatically() {

        Driver.waitForVisibility(createOrEditARoomByAdminPage.roomsHeading,1);
        Driver.clickWithJS(createOrEditARoomByAdminPage.lastPage);
        Driver.wait(1);
        String lastRow=
        createOrEditARoomByAdminPage.allRows.get(createOrEditARoomByAdminPage.allRows.size()-1).getText();

        System.out.println(lastRow);
        Driver.wait(1);
      assertTrue(lastRow.contains(roomNumber));
        assertTrue(lastRow.contains(String.valueOf(price)));
        assertFalse(lastRow.contains(createdDate));

    }


    @Given("user leave blank Room Number field and click enter")
    public void userLeaveBlankRoomNumberFieldAndClickEnter() {
        Driver.waitAndSendText(createOrEditARoomByAdminPage.roomNumberTextBox,""+ Keys.ENTER);

    }

    @And("user should see {string} feedback twice")
    public void userShouldSeeFeedbackTwice(String arg0) {
       assertEquals(arg0,Driver.waitAndGetText(createOrEditARoomByAdminPage.invalidFeedbacks.get(0),1));
        assertEquals(arg0,Driver.waitAndGetText(createOrEditARoomByAdminPage.invalidFeedbacks.get(1),1));

    }

    @When("user clicks on the Room Type dropdown")
    public void userClicksOnTheRoomTypeDropdown() {
        Driver.waitAndClick(createOrEditARoomByAdminPage.roomTypeSelect);
    }

    @Then("user should see options like {string}, {string}, {string}, {string} and {string}")
    public void userShouldSeeOptionsLikeAnd(String arg0, String arg1, String arg2, String arg3, String arg4) {
        Select options=new Select(createOrEditARoomByAdminPage.roomTypeSelect);
        List<String > expectedData=new ArrayList<>();
        expectedData.add(arg0);
        expectedData.add(arg1);
        expectedData.add(arg2);
        expectedData.add(arg3);
        expectedData.add(arg4);
        List<String> actualData=new ArrayList<>();
        for (WebElement w:options.getOptions()
             ) {
            actualData.add(w.getText());
        }
//        System.out.println(expectedData);
//        System.out.println(actualData);
    assertTrue(actualData.containsAll(expectedData));

    }

    @And("user can set current status for the room")
    public void userCanSetCurrentStatusForTheRoom() {
        Driver.waitAndClick(createOrEditARoomByAdminPage.statusCheckBox);
        assertTrue(createOrEditARoomByAdminPage.statusCheckBox.isSelected());
    }


    @Given("user on the Rooms page")
    public void userOnTheRoomsPage() {
        Driver.getDriver().navigate().back();
        assertTrue(Driver.waitForVisibility(createOrEditARoomByAdminPage.roomsHeading,1).isDisplayed());
    }

    @And("user should see all rooms on the same page")
    public void userShouldSeeAllRoomsOnTheSamePage() {
        Driver.wait(1);
      assertTrue(createOrEditARoomByAdminPage.allRows.size()==20);
        System.out.println(createOrEditARoomByAdminPage.allRows.size());
    }

    @When("user clicks on {string} button for last created room")
    public void userClicksOnButtonForRoomWithIdNumber(String arg0) {
Driver.waitAndClick(createOrEditARoomByAdminPage.lastPage);
Driver.wait(1);
 if(arg0.equals("edit"))  {
     Driver.waitAndClick(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.allRows.size()-1));
 }else if (arg0.equals("delete")){
     Driver.waitAndClick(createOrEditARoomByAdminPage.deleteElements.get(createOrEditARoomByAdminPage.allRows.size()-1));
 }


    }

    @And("user provides {string} as description")
    public void userProvidesAsDescription(String arg0) {
        Driver.waitAndSendText(createOrEditARoomByAdminPage.descriptionTextBox,arg0);
    }

    @And("user confirms delete operation")
    public void userConfirmsDeleteOperation() {
Driver.waitAndClick(createOrEditARoomByAdminPage.deleteConfirm);
    }

    @Given("set the necessary path params")
    public void setTheNecessaryPathParams() {
        spec.pathParams("1","api","2","rooms");
    }

    @And("set the expected data {string}, {int}, {string} and {string}")
    public void setTheExpectedDataAnd(String description, int price, String roomType, String status) {
        Faker faker=new Faker();
        int number=faker.number().numberBetween(300,1000);
        boolean status2=Boolean.parseBoolean(status);
        roomPost= new RoomPost(description,price,number,roomType,status2);
    }
    @Given("set the expected data {string}, {int}, {int}, {string} and {string}")
    public void setTheExpectedDataAnd(String description, int price, int roomNumber, String roomType, String status) {
        boolean status2=Boolean.parseBoolean(status);
        room=new Room(description,price,roomNumber,roomType,status2);

    }

    @Given("set the expected data {string}, {int}, {int}, {string} and {string} for {int}")
    public void setTheExpectedDataAndFor(String description, int price, int roomNumber, String roomType, String status, int roomId) {
        boolean status2=Boolean.parseBoolean(status);
        room=new Room(description,price,roomNumber,roomType,status2);
        room.setId(roomId);
    }
    @When("user sends the {string} request")
    public void userSendsTheRequest(String arg0) throws Exception {
//        ObjectMapper obj=new ObjectMapper();
//        System.out.println(obj.writeValueAsString(room));
        switch (arg0){
            case "POST":
                response=postRequestRoom(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")),
                        ConfigurationReader.getProperty("base_url")+"/api/rooms",roomPost);
                break;
            case "GET":
                response=getRequest(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")),
                        ConfigurationReader.getProperty("base_url")+"/api/rooms");
                break;
            case "PUT":
                response=putRequestRoom(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")),
                        ConfigurationReader.getProperty("base_url")+"/api/rooms",room);
                break;
            default:
                break;
        }
    }

    @Given("user sends the delete request")
    public void userSendsTheDeleteRequest() {
        int id=0;
        try{

            //identify file location
            FileReader fileReader = new FileReader("./src/test/resources/testdata/RoomData.txt");

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine().substring(5,10);
            System.out.println(line);
            id = Integer.parseInt(line);
            System.out.println(id);

        }catch (Exception e){

            e.printStackTrace();

        }

        response=deleteRequest(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")),
                ConfigurationReader.getProperty("base_url")+"/api/rooms/"+id);


    }


    @Then("status code should be {int} for rooms")
    public void statusCodeShouldBeForRooms(int arg0) {
        response.then().statusCode(arg0);
    }
    @Then("verify that the response body should be as an expected")
    public void verifyThatTheResponseBodyShouldBeAsAnExpected() throws Exception {
        ObjectMapper objectMapper=new ObjectMapper();
        Room actualRoom=objectMapper.readValue(response.asString(),Room.class);

        assertEquals(room.getDescription(),actualRoom.getDescription());
        assertEquals(room.getPrice(),actualRoom.getPrice());
        assertEquals(room.getRoomNumber(),actualRoom.getRoomNumber());
        assertEquals(room.getRoomType(),actualRoom.getRoomType());
        assertEquals(room.isStatus(),actualRoom.isStatus());
    }


    @Then("verify that the response body contains all expected data")
    public void verifyThatTheResponseBodyContainsAllExpectedData() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        Room[] rooms = objectMapper.readValue(response.asString(), Room[].class);

        for (Room eachRoom : rooms
        ) {
            if (eachRoom.getRoomNumber() == room.getRoomNumber()) {
                assertEquals(room.getDescription(), eachRoom.getDescription());
                assertEquals(room.getPrice(), eachRoom.getPrice());
                assertEquals(room.getRoomType(), eachRoom.getRoomType());
                assertEquals(room.isStatus(), eachRoom.isStatus());
            }
        }


    }

    @Then("verify that the response body should be as an expected data")
    public void verifyThatTheResponseBodyShouldBeAsAnExpectedData() throws Exception {

        ObjectMapper objectMapper=new ObjectMapper();
        RoomPost actualRoom=objectMapper.readValue(response.asString(),RoomPost.class);

        assertEquals(roomPost.getDescription(),actualRoom.getDescription());
        assertEquals(roomPost.getPrice(),actualRoom.getPrice());
        assertEquals(roomPost.getRoomNumber(),actualRoom.getRoomNumber());
        assertEquals(roomPost.getRoomType(),actualRoom.getRoomType());
        assertEquals(roomPost.isStatus(),actualRoom.isStatus());
        JsonPath jsonPath=response.jsonPath();
        saveRoomData(String.valueOf(jsonPath.getInt("id")), jsonPath.getInt("price"), jsonPath.getString("createdDate") );
}

    @And("verify that the data includes {int}, {int}, {string}, {string}, {string}, {string} information")
    public void verifyThatTheDataIncludesInformation(int id, int roomNumber, String price, String roomType, String status, String description) throws Exception {
        List<Map<String,Object>> actualRoomData= DBUtils.getQueryResultMap(query);
//        System.out.println(actualRoomData);
        System.out.println(price);
Map<String,Object> expectedData=new HashMap<>();

        expectedData.put("price",price);
        expectedData.put("room_number",roomNumber);
        expectedData.put("description",description);
        expectedData.put("id",Long.valueOf(id));
        expectedData.put("room_type",roomType);
        expectedData.put("status",Boolean.parseBoolean(status));
//        List<String> columnNames=DBUtils.getColumnNames(query);
//        System.out.println(columnNames);
//        executeQuery(query);

//    Room room=new Room(description,Integer.valueOf(price.substring(0,3)),roomNumber,roomType,Boolean.parseBoolean(status));
//    room.setId(id);
//        System.out.println(room);


        for (Map<String,Object> eachRoom:actualRoomData
             ) {

            if(eachRoom.get("room_number").equals(expectedData.get("room_number"))){
                System.out.println(eachRoom);
                assertEquals(eachRoom.get("id"),expectedData.get("id"));
                assertEquals(eachRoom.get("room_type"),expectedData.get("room_type"));
                assertEquals(eachRoom.get("status"),expectedData.get("status"));
                assertEquals( eachRoom.get("price").toString(), expectedData.get("price"));
                assertEquals(eachRoom.get("description"),expectedData.get("description"));

                break;

            }

       }

        }


    @When("user selects {string} from the {string} table for {string}")
    public void userSelectsFromTheTableFor(String arg0, String arg1, String arg2) {
       query="Select "+arg0+" from "+arg1+" where "+ arg2;

    }
}