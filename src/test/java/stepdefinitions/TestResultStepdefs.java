package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ShowTestResultPage;
import pages.TestResultsPage;
import utilities.Driver;

import java.util.HashMap;
import java.util.Map;
import utilities.*;

public class TestResultStepdefs {
TestResultsPage testResultsPage=new TestResultsPage();
ShowTestResultPage showTestResultPage=new ShowTestResultPage();


    @Then("user should see Tests")
    public void userShouldSeeTests() {
        Assert.assertTrue(Driver.waitForVisibility(showTestResultPage.testHeading,1).isDisplayed());
    }

    @When("user clicks on View Result button of first test")
    public void userClicksOnViewResultButtonOfFirstTest() {
        Driver.wait(1);
        Driver.clickWithJS(showTestResultPage.viewResultsOfFirstTest);


    }

    @Then("user should see Test Results including all necessary information")
    public void userShouldSeeTestResultsIncludingAllNecessaryInformation() {
        Driver.waitForVisibility(testResultsPage.defMinValueHeader,3);
    /*
    "ID","12065"
    "Name","Total protein"
    "Default Min. Value","6.4"
    "Default Max. Value","8.3"
    "Test","8716"
    "Date","03/03/22 13:34"
     */


        Map<String,String> expectedData=new HashMap<>();
        expectedData.put("ID","12065");
        expectedData.put("Name","Total protein");
        expectedData.put("Default Min. Value","6.4");
        expectedData.put("Default Max. Value","8.3");
        expectedData.put("Test","8716");
        expectedData.put("Date","03/03/22 13:34");

        System.out.println(expectedData);

        Map<String,String> actualData=new HashMap<>();
        actualData.put(
                testResultsPage.idHeader.getText(),
                testResultsPage.idValue.getText());
        actualData.put(
                    testResultsPage.nameHeader.getText(),
                    testResultsPage.nameValue.getText());
        actualData.put(
                    testResultsPage.defMinValueHeader.getText(),
                    testResultsPage.defMinValue.getText());
        actualData.put(
                    testResultsPage.defMaxValueHeader.getText(),
                    testResultsPage.defMaxValue.getText());
        actualData.put(
                    testResultsPage.testHeader.getText(),
                    testResultsPage.testValue.getText());
        actualData.put(
                    testResultsPage.dateHeader.getText(),
                    testResultsPage.dateValue.getText());

        System.out.println(actualData);

        Assert.assertTrue(actualData.equals(expectedData));


    }


}
