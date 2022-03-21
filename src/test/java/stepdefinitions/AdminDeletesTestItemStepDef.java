package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestItemsPage;
import utilities.Driver;

import static org.junit.Assert.assertTrue;

public class AdminDeletesTestItemStepDef {
    TestItemsPage testItemsPage = new TestItemsPage();
    @When("user deletes test item")
    public void user_deletes_test_item() {
        Driver.waitAndClick(testItemsPage.deleteButton(18));
    }
    @Then("user validates deleted message")
    public void user_validates_deleted_message() {
        assertTrue(Driver.waitForVisibility(testItemsPage.deletedMessage, 5).isDisplayed());
    }

}
