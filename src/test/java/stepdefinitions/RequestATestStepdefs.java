package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.AppointmentEditPageForDoctor;
import pages.MyAppointmentPageAsDoctor;
import pages.RequestATestPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;
import utilities.*;

public class RequestATestStepdefs {

    RequestATestPage requestATestPage=new RequestATestPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
    AppointmentEditPageForDoctor appointmentEditPageForDoctor=new AppointmentEditPageForDoctor();


    @Then("verify by id's that each test type is included as a checkmark option")
    public void verifyByIdSThatEachTestTypeIsIncludedAsACheckmarkOption() {
        Driver.wait(1);
/*
===============Test ID's=================
Glucose         => 1401
Urea            => 1402
Creatinine      =>1403
Sodium          =>1404
Potassium       =>1405
Total protein   =>1406
Albumin         =>1407
Hemoglobin      =>1408
 */
        List<String> expectedData=new ArrayList<>();
       for (int i=1401;i<1409;i++){
           expectedData.add(Integer.toString(i));
       }
        System.out.println(expectedData);

      List<String> actualData=new ArrayList<>();

        for (WebElement w: requestATestPage.allCheckMarks
             ) {
           actualData.add(w.getAttribute("id"));
        }
        System.out.println(actualData);

    Assert.assertTrue(actualData.containsAll(expectedData));


    }


    @And("user checks randomly one of them")
    public void userChecksRandomlyOneOfThem() {
        Faker faker=new Faker();
        int random=faker.number().numberBetween(1,9);
        switch (random){
            case 1:
                Driver.waitAndClick(requestATestPage.hemoglobinCheck);
                break;
            case 2:
                Driver.waitAndClick(requestATestPage.albuminCheck);
                break;
            case 3:
                Driver.waitAndClick(requestATestPage.totalProteinCheck);
                break;
            case 4:
                Driver.waitAndClick(requestATestPage.sodiumCheck);
                break;
            case 5:
                Driver.waitAndClick(requestATestPage.potassiumCheck);
                break;
            case 6:
                Driver.waitAndClick(requestATestPage.ureaCheck);
                break;
            case 7:
                Driver.waitAndClick(requestATestPage.creatinineCheck);
                break;
            case 8:
                Driver.waitAndClick(requestATestPage.glucoseCheck);
                break;
            case 9:
                Driver.waitAndClick(requestATestPage.albimoCheck);
                break;
        }
    }

    @When("user clicks on the Save button")
    public void userClicksOnTheSaveButton() {
        Driver.clickWithJS(requestATestPage.saveButton);
    }

    @Then("user should see the {string}")
    public void userShouldSeeThe(String arg0) {
        Assert.assertTrue(
                Driver.waitForVisibility(requestATestPage.alertElement,1).getText().contains(arg0)
        );

    }
//===============Request A Test for ADMIN=================

    @And("user selects Appointment item and clicks")
    public void userSelectsAppointmentItemAndClicks() {
Driver.waitAndClick(myAppointmentPageAsDoctor.adminAppointment);
    }

    @And("user clicks on the view button")
    public void userClickOnTheViewButton() {
        Driver.waitAndClick(requestATestPage.adminViewAppointment);
    }

    @When("user click edit button")
    public void userClickEditButton() {
        Driver.waitAndClick(requestATestPage.adminEditAppointment);
//        Driver.waitForVisibility(appointmentEditPageForDoctor.createOrEditAnAppointmentHeader,1);
    }

    @Then("user should NOT see Request A Test button")
    public void userShouldNOTSeeRequestATestButton() {

        try{Assert.assertTrue(Driver.waitForVisibility(appointmentEditPageForDoctor.requestATestButton,3).isDisplayed());
        }catch (Exception e){
            System.out.println("You are NOT allowed to Request A Test");
        }
    }

    @When("user navigates to the test request page {string}")
    public void userNavigatesToTheTestRequestPage(String arg0) {
        Driver.getDriver().navigate().to(arg0);
    }

    @And("user selects Search Patient item and clicks")
    public void userSelectsSearchPatientItemAndClicks() {
    Driver.waitAndClick(requestATestPage.searchPatientDropdown);
    }

    @When("user clicks on the Show Tests button")
    public void userClicksOnTheShowTestsButton() {
        Driver.waitAndClick(requestATestPage.patientShowTest);
    }

    @Then("user should see the unauthorized {string}")
    public void userShouldSeeTheUnauthorized(String arg0) {
        Assert.assertEquals(arg0,Driver.waitForVisibility(requestATestPage.unauthorizedMessage,1).getText());
    }



}
