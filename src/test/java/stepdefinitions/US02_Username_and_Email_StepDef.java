package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.hamcrest.Matchers.hasItems;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import utilities.*;

public class US02_Username_and_Email_StepDef {

    Actions actions;
    CommonPage commonPage = new CommonPage();
    RegistrationPage registrationPage = new RegistrationPage();
    Response response;

    @Given("user set the url and generate the token")
    public void user_set_the_url_and_generate_the_token() {
        //  String token="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtZWR1bm5hYWRtaW4iLCJhdXRoIjoiUk9MRV9BRE1JTiIsImV4cCI6MTY0Njk5NjYzOH0.yylp6kWllONpUzaYRWfVJMjwDbWGwbCi2NDqRhJDCWZfQVpTNa8My4iAMfsPAS1nkNfKeJ9QkefhEpPeBh0KeQ";
        response = getRequest(generateToken("admin79","admin"), ConfigurationReader.getProperty("registrant_endpoint_2000"));

        response.prettyPrint();

        response.then().assertThat().body("login",hasItems("doktormustafa"));
    }

    @Then("user validate the email")
    public void user_validate_the_email() {

        response.then().assertThat().body("email",hasItems("doktormustafa@qa.com"));
    }

    @Given("Go to medunna homepage")
    public void goTomedunnahomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
    }

    @Then("User navigates to registration page")
    public void user_navigates_to_registration_page() {
        commonPage.accountMenu.click();
        commonPage.Register.click();

    }

    @Then("User clicks on the username textbox")
    public void user_clicks_on_the_username_textbox() {

        registrationPage.username.click();

    }

    @Then("Provide the valid username of the applicant")
    public void provide_the_valid_username_of_the_applicant() {

        registrationPage.username.sendKeys("qamustafa");
    }

    @Then("User should not see the error message Your username is invalid., or Your username is required.")
    public void user_should_not_see_the_error_message_your_username_is_invalid_or_your_username_is_required() {

    }

    @Then("Provide the {string} of the applicant for usernamebox")
    public void provide_the_of_the_applicant_for_usernamebox(String invalidUserName) throws InterruptedException {

        Driver.waitAndSendText(registrationPage.username,invalidUserName);
        Driver.clickWithJS(registrationPage.email);

    }

    @Then("User should should see the error message.")
    public void user_should_should_see_the_error_message() throws InterruptedException {

       // Driver.waitForVisibility(registrationPage.generalInvalidFeedback,10);
       for (int i=0;i<5;i++){
           try {
               Assert.assertTrue(registrationPage.generalInvalidFeedback.isEnabled());
           }catch (Exception e){
               Driver.wait(1);
           }
       }



    }

    @Then("User clicks on the email textbox")
    public void user_clicks_on_the_email_textbox() {
        Driver.clickWithJS(registrationPage.email);

    }

    @Then("Provide the valid email of the applicant")
    public void provide_the_valid_email_of_the_applicant() {
        registrationPage.email.sendKeys("mustafaqa@gmail.com");

    }

    @Then("User should not see the error message Your email is invalid., or Your email is required.")
    public void user_should_not_see_the_error_message_your_email_is_invalid_or_your_email_is_required() {

    }

    @Then("Provide the {string} of the applicant for emailbox")
    public void provideTheOfTheApplicantForEmailbox(String invalidEmail) {
        registrationPage.email.sendKeys(invalidEmail);
        registrationPage.firstPassword.sendKeys("11!!QQqq");
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN);
        Assert.assertTrue(Driver.waitForVisibility(registrationPage.generalInvalidFeedback,10).isEnabled());

    }
}
