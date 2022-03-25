package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import pages.SignInPage;
import pages.US09_patientPage;
import pages.US20_userManagementPage;
import utilities.Driver;

import static org.junit.Assert.*;


public class US20_userManagement {
    SignInPage signinpage = new SignInPage();
    US09_patientPage patient= new US09_patientPage();
    US20_userManagementPage userManagementPage= new US20_userManagementPage();


    @Given("user in on the medunna home page")
    public void user_in_on_the_medunna_home_page() {



    }
    @Given("user clicks on login dropdown")
    public void user_clicks_on_login_dropdown() {
        Driver.getDriver().get("https://www.medunna.com/login");
    }
    @Given("user signs in as admin user name {string} and password as {string}")
    public void user_signs_in_as_admin_user_name_and_password_as(String username, String password) {
        Driver.waitAndSendText(signinpage.username,username);
        Driver.waitAndSendText(signinpage.password,password);
        Driver.waitAndClick(signinpage.singInButton);
    }
    @Given("navigates and clicks administration dropdown")
    public void navigates_and_clicks_administration_dropdown() {
        Driver.waitAndClick(patient.ItemAndTitlesDropDown);
    }
    @Given("clicks user management")
    public void clicks_user_management() {
        Driver.waitAndClick(userManagementPage.dropAdministration);
        Driver.waitAndClick(userManagementPage.dropUserManagement);



    }
    @Given("navigates and clicks the view button of the first user")
    public void navigates_and_clicks_the_view_button_of_the_first_user() {
       //String firstUserLogin= Driver.waitAndGetText(userManagementPage.firstUserLoginName,2);

        //System.out.println(firstUserLogin);
       Driver.waitAndClick(userManagementPage.firstUserLoginNameViewButton,2);
       //String firstUserLoginNameView= Driver.waitAndGetText(userManagementPage.firstUserLoginNameView,2);
       // String firstUserLoginNameView= Driver.waitAndGetText(userManagementPage.firstUserLoginNameView,2);
       // System.out.println(firstUserLoginNameView);
//Driver.selectByVisibleText(,"User");




    }
    @Given("verifies that the registered user info is visible")
    public void verifies_that_the_registered_user_info_is_visible() {
        Driver.waitForVisibility(userManagementPage.userVievTitle,2);

    }
    @Then("user signs out")
    public void user_signs_out() {

        Driver.waitAndClick(patient.logedInUser);
        Driver.waitAndClick(patient.signoutButton);

    }


    @And("navigates and clicks on the create a new user button")
    public void navigatesAndClicksOnTheCreateANewUserButton() {
        Driver.waitAndClick(userManagementPage.navigateToNewUser);
    }

    @And("clicks login box and provides a login")
    public void clicksLoginBoxAndProvidesALogin() {
        Driver.waitAndSendText(userManagementPage.newUserLoginTxt,"userAli");

    }

    @And("clicks the first name box and provides the first name")
    public void clicksTheFirstNameBoxAndProvidesTheFirstName() {
        Driver.waitAndSendText(userManagementPage.newUserFirstNameTxt,"Ali");
    }

    @And("clicks the last name box and provides the last name")
    public void clicksTheLastNameBoxAndProvidesTheLastName() {
        Driver.waitAndSendText(userManagementPage.newUserlastNameTxt,"Veli");
    }

    @And("clicks the email box and provides the email")
    public void clicksTheEmailBoxAndProvidesTheEmail() {
          Driver.waitAndSendText(userManagementPage.newUseremailTxt,"ali@veli.com");
    }

    @And("clicks on the SSN box and provides a valid SSN")
    public void clicksOnTheSSNBoxAndProvidesAValidSSN() {
        Driver.waitAndSendText(userManagementPage.newUserSnnTxt,"333-22-4444");

    }

    @And("clicks on the language dropdown and selects english")
    public void clicksOnTheLanguageDropdownAndSelectsEnglish() {
        Driver.selectAnItemFromDropdown(userManagementPage.newUserDropDownLanguage,"English");

    }

    @And("selects Role_Staff in profiles")
    public void selectsRole_StaffInProfiles() {
        Driver.selectAnItemFromDropdown(userManagementPage.newUserDropDownLanguage,"ROLE_STAFF");
    }

    @And("clicks save button then click last page button")
    public void clicksSaveButtonThenClickLastPageButton() {
        Driver.waitAndClick(userManagementPage.newUserSaveButton);
    }

    @And("on the last page edits the last user as a patient role and saves")
    public void onTheLastPageEditsTheLastUserAsAPatientRoleAndSaves() {

    }

    @And("deletes the patient that has just been edited")
    public void deletesThePatientThatHasJustBeenEdited() {
    }
}
