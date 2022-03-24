package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.UserSetting;
import utilities.Driver;

public class UserSettingsSteps {

//    UserSetting userPage = new UserSetting();
//
//    @Given("User navigates to {string}")
//    public void user_navigates_to(String url) {
//        Driver.getDriver().get(url);
//    }
//
//    @When("User clicks on SignIn button  on the right top")
//    public void user_clicks_on_sign_in_button_on_the_right_top() {
//        userPage.sigInIcon.click();
//
//
//    }
//    @Then("User clicks on signIn in dropdown list")
//    public void user_clicks_on_sign_in_in_dropdown_list() {
//        userPage.SignIn.click();
//    }
//
//    @Then("User enters username {string}")
//    public void user_enters_username(String username) {
//        Driver.wait(2);
//        userPage.username.sendKeys(username);
//
//    }
//
//    @Then("User enters password {string}")
//    public void user_enters_password(String password) {
//        Driver.wait(2);
//        userPage.password.sendKeys(password);
//
//
//    }
//
//    @Then("User clicks on sign in button")
//    public void user_clicks_on_sign_in_button() {
//        Driver.wait(2);
//        userPage.rememberMeBtn.click();
//        Driver.wait(2);
//        userPage.signIn02.click();
//
//    }
//
//    @Then("User clicks on newly signedIn User")
//    public void user_clicks_on_newly_signed_in_user() {
//        Driver.wait(3);
//        String signInUser=userPage.signedInUser.getText();
//        System.out.println("signInUser1 = " + signInUser);
//        Driver.wait(3);
//        userPage.signedInUser.click();
//    }
//
//    @Then("User clicks on Setting option")
//    public void user_clicks_on_setting_option() {
//        userPage.settings.click();
//        Driver.wait(3);
//
//    }
//    @Then("User clears existing firstname")
//    public void user_clears_existing_firstname() {
//      userPage.firstname.clear();
//        Driver.wait(3);
//    }
//    @Then("User sends a new firstname {string} and verifies isEnabled")
//    public void user_sends_a_new_firstname(String fname) {
//        Driver.wait(3);
//        userPage.firstname.sendKeys(fname + Keys.ENTER);
//        String firstname=  userPage.firstname.getText();
//        System.out.println("firstname = " + firstname);
//        Driver.wait(3);
//        String signInUser=userPage.signedInUser.getText();
//        Assert.assertTrue(signInUser.contains(fname));
//        Assert.assertTrue(userPage.firstname.isEnabled());
//
//
//
//    }
//
//    @Then("User clicks on Save button")
//    public void user_clicks_on_save_button() {
//        userPage.save.click();
//        Driver.wait(3);
//        userPage.signedInUser.click();
//        Driver.wait(2);
//        userPage.signOut.click();
//        Driver.wait(2);
//
//    }
//
//    @Then("User clears existing lastname")
//    public void user_clears_existing_lastname() {
//        userPage.lastname.clear();
//        Driver.wait(3);
//
//    }
//
//    @Then("User clears existing email")
//    public void user_clears_existing_email() {
//        userPage.email.clear();
//        Driver.wait(3);
//    }
//
//    @Then("User sends a new lastname  {string} and verifies isEnabled")
//    public void user_sends_a_new_lastname(String lname) {
//        Driver.wait(1);
//        userPage.lastname.sendKeys(lname +Keys.ENTER);
//        Driver.wait(1);
//        String signInUser=userPage.signedInUser.getText();
//        Assert.assertTrue(signInUser.contains(lname));
//        Assert.assertTrue(userPage.lastname.isEnabled());
//
//    }
//
//    @Then("User sends a new email {string} and verifies isEnabled")
//    public void user_sends_a_new_email(String email) {
//        Driver.wait(3);
//        String emailText=userPage.email.getText();
//        System.out.println("emailText = " + emailText);
//        userPage.email.sendKeys(email+ Keys.ENTER);
//        Driver.wait(3);
//       String signInUser=userPage.createdUser.getText();
//       Assert.assertTrue(email.contains("@gmail.com"));
//       Assert.assertTrue(userPage.email.isEnabled());
//        System.out.println("signInUser = " + signInUser);
//
//    }

}
