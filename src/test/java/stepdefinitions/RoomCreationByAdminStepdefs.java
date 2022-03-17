package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.CreateOrEditARoomByAdminPage;
import utilities.Driver;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.WriteToTxt.saveRoomData;

public class RoomCreationByAdminStepdefs {

     CreateOrEditARoomByAdminPage createOrEditARoomByAdminPage=new CreateOrEditARoomByAdminPage();
    Faker faker=new Faker();
    static String roomNumber="";
    static int price=0;
    static String createdDate="";

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
}
