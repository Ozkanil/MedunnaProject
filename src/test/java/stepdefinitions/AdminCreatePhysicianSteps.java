package stepdefinitions;

import com.github.javafaker.*;
import io.cucumber.java.en.*;
import org.junit.*;
import pages.*;
import pojos.*;
import utilities.*;

public class AdminCreatePhysicianSteps {

    Physician physician = new Physician();
    Faker faker = new Faker();
    AdminPhysicianPage adminPhysicianPage = new AdminPhysicianPage();

    @And("user creates physician username {string}")
    public void userCreatesPhysicianUsername(String user) {
       user =faker.name().username();
       physician.setUser(user);
       Driver.waitAndSendText(adminPhysicianPage.userTextBox,user);
    }

    @And("user provides physician firstname and lastname {string} and {string}")
    public void userProvidesPhysicianFirstnameAndLastnameAnd(String firstName, String lastName) {
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();

        physician.setFirstName(firstName);
        physician.setLastName(lastName);

        Driver.waitAndSendText(adminPhysicianPage.firstNameTextBox,firstName);
        Driver.waitAndSendText(adminPhysicianPage.lastNameTextBox,lastName);


    }

    @And("user provides physician email {string}")
    public void userProvidesPhysicianEmail(String email) {
        email = faker.internet().emailAddress();
        physician.setEmail(email);
        Driver.waitAndSendText(adminPhysicianPage.emailTextBox,email);

    }

    @And("user provides physician ssn id {string}")
    public void userProvidesPhysicianSsnId(String ssn) {

        ssn = faker.idNumber().ssnValid();
        physician.setSsn(ssn);
        Driver.waitAndSendText(adminPhysicianPage.ssnTextBox,ssn);
    }

    @And("user cliskc registers button")
    public void userCliskcRegistersButton() {
        Driver.waitAndClick(adminPhysicianPage.registerButton);
    }

    @Then("user clicks administration dropdown button on admin page")
    public void user_clicks_administration_dropdown_button_on_admin_page() {
        Driver.waitAndClick(adminPhysicianPage.administrationDropdown);
    }

    @Then("user clicks user management button on admin page")
    public void user_clicks_user_management_button_on_admin_page() {
        Driver.waitAndClick(adminPhysicianPage.userManagementButton);
    }

    @And("user clicks go to last int page button on admin page")
    public void userClicksGoToLastIntPageButtonOnAdminPage() {
     Driver.wait(1);
        Driver.waitAndClick(adminPhysicianPage.clickGoToLastInt);

//        for (int i=0;i<5;i++){
//            try{
//                Assert.assertTrue(adminPhysicianPage.clickGoToLastInt.isSelected());
//            }catch(Exception e){
//                Driver.wait(3);
//            }
//
//
//        }
        // Driver.waitAndClick(adminPhysicianPage.clickGoToLastInt);
    }

    @Then("user clicks Deactivated button to activate physician on admin page")
    public void user_clicks_deactivated_button_to_activate_physician_on_admin_page() {

     Driver.waitAndClick(adminPhysicianPage.clickLastDeactivatedButton);
     adminPhysicianPage.clickLastDeactivatedButton.click();

//       Select select = new Select(Driver.waitForVisibility(adminPhysicianPage.clickLastDeactivatedButton,1));
//       String selectedStatus= select.getFirstSelectedOption().getText();
//       if(selectedStatus.equals("Deactivated")){
//           select.selectByVisibleText("Activated");
//       }else{
//           System.out.println("Appointment status Activated");
//       }

//        Select select=new Select(Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
//        String selectedStatus=select.getFirstSelectedOption().getText();
//        if(selectedStatus.equals("UNAPPROVED")){
//            select.selectByVisibleText("PENDING");
//        }else if(selectedStatus.equals("PENDING")){
//            select.selectByVisibleText("COMPLETED");
//        }else{
//            System.out.println("Appointment status can not be changed with this type of status");
//        }
//

//        for (int i=0;i<5;i++){
//            try{
//                Assert.assertTrue(adminPhysicianPage.clickLastDeactivatedButton.isSelected());
//            }catch(Exception e){
//                Driver.wait(3);
//            }
//
//
//        }

    }
//    @Then("user verifies physician activated on admin page")
//    public void user_verifies_physician_activated_on_admin_page() {
//        Assert.assertTrue(Driver.waitForVisibility(adminPhysicianPage.verifyActivatedUser,3).isDisplayed());
//    }
    @Then("user clicks edit button on admin page")
    public void user_clicks_edit_button_on_admin_page() {

        Driver.waitAndClick(adminPhysicianPage.clickLastEditButton);
        Assert.assertTrue(Driver.waitForVisibility(adminPhysicianPage.verifyEditPage,3).isDisplayed());
    }
    @Then("user clicks rollPhysician on profiles iframe")
    public void user_clicks_roll_physician_on_profiles_iframe() {
        Driver.wait(3);
        Driver.waitAndClick(adminPhysicianPage.physicianRollactivate);
    }
    @Then("user clicks save physician button")
    public void user_clicks_save_physician_button() {
       Driver.wait(1);
       Driver.clickWithJS(adminPhysicianPage.saveRollButton);
    //   Assert.assertTrue(Driver.waitForVisibility(adminPhysicianPage.verifyTextRole,3).isDisplayed());

    }

    @Given("user verifies user page is visible")
    public void userVerifiesUserPageIsVisible() {
      Assert.assertTrue(Driver.waitForVisibility(adminPhysicianPage.userPageVerifyAdmin,2).isDisplayed());

    }

    @Given("user clicks to create a new user button")
    public void userClicksToCreateANewUserButton() {
        Driver.wait(1);
        Driver.waitAndClick(adminPhysicianPage.createNewUserBtnAdPg);
    }

    @And("user verifies create or edit page visible")
    public void userVerifiesCreateOrEditPageVisible() {

        Driver.waitAndClick(adminPhysicianPage.verifyCreateOrEditPg);
    }

    @And("user clicks delete button on admin page")
    public void userClicksDeleteButtonOnAdminPage() {
        Driver.waitAndClick(adminPhysicianPage.clickBfrLastDeleteButton);
        //adminPhysicianPage.clickBfrLastDeleteButton.click();

    }

    @Then("user clicks confirm deletebutton on admin page")
    public void userClicksConfirmDeletebuttonOnAdminPage() {
        Driver.wait(3);
        Driver.waitAndClick(adminPhysicianPage.confirmDeleteButton);
        //adminPhysicianPage.confirmDeleteButton.click();
    }


    @Given("user clicks items and titles dropdown")
    public void user_clicks_items_and_titles_dropdown() {
        Driver.waitAndClick(adminPhysicianPage.itemsTitelsDropdown);
    }

    @Given("user clicks on physician button on dropdown")
    public void user_clicks_on_physician_button_on_dropdown() {
        Driver.waitAndClick(adminPhysicianPage.physicianDropdown);

    }

    @Given("user verifies physician page is displayed")
    public void user_verifies_physician_page_is_displayed() {
        Driver.waitAndClick(adminPhysicianPage.physicianPageVerify);

    }

    @Given("user clicks on create a new physician button")
    public void user_clicks_on_create_a_new_physician_button() {
        Driver.waitAndClick(adminPhysicianPage.createNewPhysician);
        adminPhysicianPage.createNewPhysician.click();
    }





//    @Then("user verifies success message on admin page")
//    public void user_verifies_success_message_on_admin_page() {
//      Assert.assertTrue(Driver.waitForVisibility(adminPhysicianPage.verifyTextRole,2).isDisplayed());
//
//    }


}
