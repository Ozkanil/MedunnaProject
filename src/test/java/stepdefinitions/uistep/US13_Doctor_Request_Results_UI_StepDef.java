package stepdefinitions.uistep;

import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPage;
import pages.MyAppointmentPageAsDoctor;
import pages.SignInPage;

public class US13_Doctor_Request_Results_UI_StepDef {

    Actions actions;
    CommonPage commonPage = new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();


    @Then("Sign in as a Doctor")
    public void sign_in_as_a_doctor() {
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys("MedunnaAdmin");
        signInPage.password.sendKeys("1@qweASD");
        signInPage.singInButton.click();

    }
    @Then("Click the Items&Titles")
    public void click_the_items_titles() {


    }
    @Then("Click the Test Item")
    public void click_the_test_item() {

    }
    @Then("Check the id, name\\(Urea, Sodium, Glucose etc..), default max value, default min value, test, description and the date")
    public void check_the_id_name_urea_sodium_glucose_etc_default_max_value_default_min_value_test_description_and_the_date() {

    }

}
