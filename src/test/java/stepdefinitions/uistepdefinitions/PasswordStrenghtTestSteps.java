package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.UserSetting;
import utilities.Driver;

public class PasswordStrenghtTestSteps {

    UserSetting userPage = new UserSetting();

    @Then("User enters four chars password {string}")
    public void user_enters_four_chars_password(String password) {
        userPage.newPassword.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User verifies password chart color is {string}")
    public void user_verifies_password_chart_color_is(String level) {
        colorStrength(level);

    }

    @Then("User enters seven chars two combination {string}")
    public void user_enters_seven_chars_two_combination(String password) {
        userPage.newPassword.sendKeys(password);
        Driver.wait(1);
    }


    @Then("User verifies password  chart color is {string}")
    public void user_verifies_password(String level) {
        colorStrength(level);
    }

    @Then("User enters seven chars three combination {string}")
    public void user_enters_seven_chars_three_combination(String password) {
        userPage.newPassword.sendKeys(password);
        Driver.wait(1);
    }

    @Then("User enters seven chars four combination {string}")
    public void user_enters_seven_chars_four_combination(String password) {
        userPage.newPassword.sendKeys(password);
        Driver.wait(1);

    }

    @Then("User clicks on Register in dropdown list")
    public void user_clicks_on_register_in_dropdown_list() {
        userPage.registerBtn.click();

    }

    @Given("user provides the  password {string}")
    public void user_provides_the_password(String password) {
        Driver.waitAndSendText(userPage.newPwdPlaceholder, password);
    }

    @Then("User validates the password strength {string}")
    public void user_validates_the_password_strength(String level) {
        colorStrength(level);
    }

    public   void colorStrength(String level){
        if (1 == Integer.parseInt(level)) {
            Assert.assertTrue(userPage.passwordStrength1.isDisplayed());
            Driver.wait(2);

        } else if (2 == Integer.parseInt(level)) {
            Assert.assertTrue(userPage.passwordStrength2.isDisplayed());
            Driver.wait(2);
        } else if (3 == Integer.parseInt(level)) {
            Assert.assertTrue(userPage.passwordStrength3.isDisplayed());
            Driver.wait(2);
        } else if (4 == Integer.parseInt(level)) {
            Assert.assertTrue(userPage.passwordStrength4.isDisplayed());
            Driver.wait(2);
        }
    }
}