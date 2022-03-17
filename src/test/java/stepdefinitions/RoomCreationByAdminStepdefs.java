package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateOrEditARoomByAdminPage;
import utilities.Driver;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.WriteToTxt.saveRoomData;

public class RoomCreationByAdminStepdefs {

     CreateOrEditARoomByAdminPage createOrEditARoomByAdminPage=new CreateOrEditARoomByAdminPage();
    Faker faker=new Faker();
    static String roomNumber="";
    static int price=0;
    static String createdDate="";

    @And("user navigates page to Rooms page")
    public void userNavigatesPageToRoomsPage() {
        Driver.waitAndClick(createOrEditARoomByAdminPage.itemsTitlesDropdown);
        Driver.waitAndClick(createOrEditARoomByAdminPage.roomDropdown);
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
    }

    @And("verify that Created Date is updated automatically")
    public void verifyThatCreatedDateIsUpdatedAutomatically() {
        saveRoomData(roomNumber,price,createdDate);
        Driver.waitForVisibility(createOrEditARoomByAdminPage.roomsHeading,1);
        List<String> idElements= (List<String>) createOrEditARoomByAdminPage.idElements.stream().map(t-> t.getText());
        System.out.println(idElements);
      //  assertTrue(Driver.waitForVisibility());

    }



}
