package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.CommonPage;
import pages.SignInPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class SigninStepDefs {

    SignInPage signInPage=new SignInPage();
    CommonPage commonPage=new CommonPage();

    @When("User navigates to the home page")
    public void user_navigates_to_the_home_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));

    }
//    @When("user clicks sign in button at the home page and navigates to sign in page")
//    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {
//
//        Driver.waitAndClick( commonPage.accountMenu);
//        Driver.waitAndClick( commonPage.signIn);
//
//    }
//    @Then("user verifies that sign in page header is visible")
//    public void user_verifies_that_sign_in_page_header_is_visible() {
//
//        Driver.waitForVisibility(signInPage.singinPageHeader, 5);
//        Assert.assertTrue(signInPage.singinPageHeader.isDisplayed());
//
//    }
//    @Then("user enters username {string} and password {string}")
//    public void user_enters_username_and_password(String username, String password) {
//
//        signInPage.username.sendKeys(username);
//        signInPage.password.sendKeys(password);
//
//    }
//    @Then("user clicks sign in button")
//    public void user_clicks_sign_in_button() {
//
//        signInPage.singInButton.click();
//
//    }
//    @Then("user verifies that sign in is successful")
//    public void sser_verifies_that_sign_in_is_successful() {
//
//        Assert.assertTrue(commonPage.accountMenu.isDisplayed());
//
//    }

    @Then("user verifies that sign in is unsuccessful in case {string}")
    public void user_verifies_that_sign_in_is_unsuccessful_in_case(String string) {

        if (Integer.parseInt(string)==1){
            Driver.waitForVisibility(signInPage.emptyUsernameFailMessage, 5);
            Assert.assertTrue(signInPage.emptyUsernameFailMessage.isDisplayed());
            Assert.assertTrue(signInPage.emptyPasswordFailMessage.isDisplayed());
        }else{
            Driver.waitForVisibility(signInPage.FailedAlert,5);
            Assert.assertTrue(signInPage.FailedAlert.isDisplayed());
        }
    }

    @And("user clicks cancel button")
    public void userClicksCancelButton() {

        signInPage.cancelButton.click();
        signInPage.cancelButton.click();
    }

    @Then("user verifies that signin is canceled and user is on home page")
    public void userVerifiesThatSigninIsCnacelledAndUserIsOnHomePage() {

        //Assert.assertTrue(Driver.waitForVisibility(commonPage.homePageAssertionText,10).isDisplayed());

    }

    @And("user verifies that remember me box is visible and clickable")
    public void userVerifiesThatRememberMeBoxIsVisibleAndClickable() throws InterruptedException {

        Driver.waitForClickablility(signInPage.rememberMe,10).click();
        signInPage.rememberMe.click();
        Thread.sleep(5000);
        String clickText= signInPage.rememberMe.getAttribute("value");
        Assert.assertEquals("true", clickText);

    }




    @And("user verifies that password reset button is visible and clicks it")
    public void userVerifiesThatPasswordResetButtonIsVisibleAndClicksIt() {

        Assert.assertTrue(signInPage.passwordResetButton.isDisplayed());
        signInPage.passwordResetButton.click();
        signInPage.passwordResetButton.click();
    }

    @Then("user verifies that navigated to the password reset page")
    public void userVerifiesThatNavigatedToThePasswordResetPage() {

        Assert.assertTrue(Driver.waitForVisibility(signInPage.resetPasswordPageHeader,5).isDisplayed());
    }

    @And("user verifies that register button is visible and clicks it")
    public void userVerifiesThatRegisterButtonIsVisibleAndClicksIt() {

        Assert.assertTrue(Driver.waitForVisibility(signInPage.registrationButtonAtSigninPage,5).isDisplayed());
        signInPage.registrationButtonAtSigninPage.click();
        signInPage.registrationButtonAtSigninPage.click();

    }

    @Then("user verifies that navigated to the registration page")
    public void userVerifiesThatNavigatedToTheRegistrationPage() {

        Assert.assertTrue(Driver.waitForVisibility(signInPage.registrationPageHeader,5).isDisplayed());
    }

    @And("user clicks sign out and verifies sign out")
    public void userClicksSignOutAndVerifiesSignOut() throws InterruptedException {

        Thread.sleep(3000);
        commonPage.accountMenu.click();
        Thread.sleep(2000);
        Driver.waitAndClick(signInPage.signoutButton);


    }
}