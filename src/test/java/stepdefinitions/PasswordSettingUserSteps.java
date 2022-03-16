package stepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.UserSetting;
import utilities.Driver;

public class PasswordSettingUserSteps {
    UserSetting userPage=new UserSetting();
    @Then("User clicks on Password option on the dropdown")
    public void user_clicks_on_password_option_on_the_dropdown() {
        userPage.dropdownPassword.click();
        Driver.wait(1);
    }

    @Then("User enters current password {string}")
    public void user_enters_current_password(String currentPwd) {
        userPage.currentPassword.sendKeys(currentPwd);
        Driver.wait(1);
    }

    @Then("User enters new password {string}")
    public void user_enters_new_password(String newPwd) {
        userPage.newPwd.sendKeys(newPwd);
        Driver.wait(1);
    }


    @Then("User reenters new password {string}")
    public void user_reenters_new_password(String confirmPwd) {
       userPage.confirmPwd.sendKeys(confirmPwd);
    }

    @Then("User clicks on Save Button")
    public void user_clicks_on_save_button() {
userPage.save.click();
    }
    @Then("User verifies the message {string}")
    public void user_verifies_the_message(String messageText) {
        Driver.wait(1);
        String actualMessage=userPage.successMsg.getText();
        Driver.wait(1);
        Assert.assertEquals(messageText,actualMessage);
        Driver.wait(1);

    }

}
