package stepdefinitions.uistep;

import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.*;
import utilities.Driver;

public class US13_Doctor_Request_Results_UI_StepDef {

    Actions actions;
    CommonPage commonPage = new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();


    @Then("Sign in as a Doctor")
    public void sign_in_as_a_doctor() throws InterruptedException {
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys("doktormustafa");
        signInPage.password.sendKeys("11!!qqQQ");
        signInPage.singInButton.click();
        Thread.sleep(3000);

    }
    @Then("Click the Items&Titles")
    public void click_the_items_titles() {
        Driver.waitAndClickElement(commonPage.itemsAndTitles,10);


    }
    @Then("Click the Test Item")
    public void click_the_test_item() {
        commonPage.testItemUnderItemAndTest.click();
    }
    @Then("Check the id, name\\(Urea, Sodium, Glucose etc..), default max value, default min value, test, description and the date")
    public void check_the_id_name_urea_sodium_glucose_etc_default_max_value_default_min_value_test_description_and_the_date() {

        DoctorTestItemsPage doctorTestItemsPage=new DoctorTestItemsPage();
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.glucose,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.sodium,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.urea,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(doctorTestItemsPage.id1401,10).isEnabled());

        doctorTestItemsPage.id1401.click();

        Id_1401_Page id_1401_page=new Id_1401_Page();
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.createdDate,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.defaultMaxValue,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.description,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.testItem1401,10).isEnabled());
        Assert.assertTrue(Driver.waitForVisibility(id_1401_page.defaultMinValue,10).isEnabled());

    }

}
