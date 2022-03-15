package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class UITestItemCreatingAsAdminStepDef {
        SignInPage signInPage = new SignInPage();
        CommonPage commonPage = new CommonPage();
        TestItemsPage testItemsPage = new TestItemsPage();
        CreateANewTestItemPage createANewTestItemPage = new CreateANewTestItemPage();
    @Given("user registers as admin {string} , {string}")
    public void userRegistersAsAdmin(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.waitAndSendText(signInPage.username, username);
        Driver.waitAndSendText(signInPage.password, password);
        Driver.waitAndClick(signInPage.singInButton);
    }

    @Given("user navigates to Test Items page")
    public void userNavigatesToTestItemsPage() {
        Driver.waitAndClick(commonPage.itemsAndTitles);
        Driver.waitAndClick(commonPage.testItemUnderItemAndTest);
    }

    @And("use clicks on Create a new Test Item button")
    public void useClicksOnCreateANewTestItemButton() {
        Driver.waitAndClick(testItemsPage.createANewTestItemButton);
    }

    @And("user will provide credentials {string}, {string}, {string}, {string}, {string}")
    public void userWillProvideCredentials(String name, String description, String price, String def_min_value, String def_max_value) {
        Driver.waitAndSendText(createANewTestItemPage.name, name);
        Driver.waitAndSendText(createANewTestItemPage.description, description);
        Driver.waitAndSendText(createANewTestItemPage.price, price);
        Driver.waitAndSendText(createANewTestItemPage.defMinValue, def_min_value);
        Driver.waitAndSendText(createANewTestItemPage.defMaxValue, def_max_value);
        Driver.waitAndClick(createANewTestItemPage.saveButton);
    }

    @Then("user A new Test Item is created message")
    public void userANewTestItemIsCreatedMessage() {
        assertTrue(Driver.waitForVisibility(testItemsPage.successMessage, 5).isDisplayed());
    }
}
