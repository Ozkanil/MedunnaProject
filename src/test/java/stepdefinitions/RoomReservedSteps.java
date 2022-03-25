package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RoomReservedSteps {
        ViewByDoctorPage view = new ViewByDoctorPage();
        RoomReservedPage roomReservedPage = new RoomReservedPage();
       //StatusPage statusPage = new StatusPage();

    @When("user navigates to the medunna home page")
    public void user_navigates_to_the_medunna_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));
       Driver.wait(5);
    }
    @When("user clicks sign in icon above the registration icon and navigates to sign in page")
    public void user_clicks_sign_in_icon_above_the_registration_icon_and_navigates_to_sign_in_page() {
       Driver.waitAndClick(roomReservedPage.SignInIcon);
       roomReservedPage.signInButton.click();
    }

    @When("user clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
       Driver.waitAndClick(roomReservedPage.signInButton,5);
       roomReservedPage.signInButton.click();
    }
    @When("user verifies the home page")
    public void user_verifies_the_home_page() {
       Driver.wait(5);
    }
    @When("user clicks my page icon")
    public void user_clicks_my_page_icon() {
       Driver.waitAndClick(roomReservedPage.myPagesDropdown,5);
       roomReservedPage.myPagesDropdown.click();
    }
    @When("user clicks my InPatient icon")
    public void user_clicks_my_ın_patient_icon() {
       Driver.waitAndClick(roomReservedPage.myInPatientsDropDown,5);
       roomReservedPage.myInPatientsDropDown.click();
    }
    @When("user verifies to InPatients page")
    public void user_verifies_to_ın_patients_page() {
       Driver.wait(5);
    }
    @When("user provıdes from date {string} and to date {string} in date text boxes")
    public void user_provıdes_from_date_and_to_date_in_date_text_boxes(String fromdate, String todate) {
        Driver.waitForVisibility(view.fromDateTextBox,5);
        Driver.waitForVisibility(view.toDateTextBox,5);
        view.fromDateTextBox.sendKeys(fromdate);
        view.toDateTextBox.sendKeys(todate);
    }
    @When("user clicks on the edit button")
    public void user_clicks_on_the_edit_button() {
        Driver.waitAndClick(roomReservedPage.editButton,5);
        roomReservedPage.editButton.click();

        }
    @And("user selects room number {string} in room TextBox")
    public void userSelectsRoomNumberInRoomTextBox(String room) {
        Driver.wait(5);
        Driver.selectByIndex(roomReservedPage.roomTextBox,1);
          roomReservedPage.roomTextBox.isSelected();
      }
    @And ("user clicks roomtextbox")
    public void userClicksRoomtextbox() {
        Driver.waitAndClick(roomReservedPage.roomTextBox,5);
        roomReservedPage.roomTextBox.click();
    }

    @Then("user clicks on the save button")
    public void user_clicks_on_the_save_button() {
        Driver.waitAndClick(roomReservedPage.saveButton,5);
        roomReservedPage.saveButton.click();

        }



}

