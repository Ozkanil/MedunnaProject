package stepdefinitions;

import io.cucumber.java.en.When;
import pages.ViewByDoctorPage;
import utilities.ConfigReader;
import utilities.Driver;

public class ViewByDoctorStep {
       ViewByDoctorPage view=new ViewByDoctorPage();
    @When("User navigates to the home page")
    public void user_navigates_to_the_home_page() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }
    @When("user clicks sign in button at the home page and navigates to sign in page")
    public void user_clicks_sign_in_button_at_the_home_page_and_navigates_to_sign_in_page() {

        view.signInButton.click();
        Driver.waitForClickablility(view.signInButton,5).click();
        view.signInButton.click();
    }
