package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.AppointmentEditPageForDoctor;
import pages.MyAppointmentPageAsDoctor;
import pages.SignInPage;
import pojos.DoctorAppointment;
import utilities.ConfigurationReader;
import utilities.Driver;

public class DoctorAppointmentEditStepdefs {
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
    AppointmentEditPageForDoctor appointmentEditPageForDoctor=new AppointmentEditPageForDoctor();

    @Given("user on the Create or Edit an Appointment page")
    public void user_on_the_create_or_edit_an_appointment_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.waitAndSendText(signInPage.username, ConfigurationReader.getProperty("doctor_username"));
        Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
        Driver.waitAndClick(signInPage.singInButton);
        Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        Driver.waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        Driver.waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Assert.assertTrue(
                Driver.waitForVisibility(appointmentEditPageForDoctor.createOrEditAnAppointmentHeader,1).isDisplayed()
        );
}


    @And("user verify appointment details like ID,StartDate,EndDate,Status")
    public void userVerifyAppointmentDetailsLikeIDStartDateEndDateStatus() {
        /*
        ID=11885
        Start DateTime=2022-03-10T01:00
        End DateTime=2022-03-10T02:00
        Status=COMPLETED
         */
        DoctorAppointment expectedData=new DoctorAppointment(11885,"2022-03-10T01:00","2022-03-10T02:00","COMPLETED");
            Assert.assertEquals("Expected data does NOT match actual data",
                    Integer.toString(expectedData.getId()),Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentIdBox,1).getAttribute("value"));
                Assert.assertEquals("Expected data does NOT match actual data",expectedData.getStartDate(),
                        Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentStartDateBox,1).getAttribute("value"));
                Assert.assertEquals("Expected data does NOT match actual data",
                        expectedData.getEndDate(),Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentEndDateBox,1).getAttribute("value"));

        Select select=new Select(Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
String actualStatus=select.getFirstSelectedOption().getText();
        Assert.assertEquals("Expected data does NOT match actual data",
                expectedData.getStatus(),actualStatus);
    }

    @And("user types information for {string}, {string}, {string}, {string}, {string}")
    public void userTypesInformationFor(String arg0, String arg1, String arg2, String arg3, String arg4) {

            Driver.waitAndSendText(appointmentEditPageForDoctor.appointmentAnamnesisBox,arg0);

            Driver.waitAndSendText(appointmentEditPageForDoctor.appointmentTreatmentBox,arg1);

            Driver.waitAndSendText(appointmentEditPageForDoctor.appointmentDiagnosisBox,arg2);

            Driver.waitAndSendText(appointmentEditPageForDoctor.appointmentPrescriptionBox,arg3);

            Driver.waitAndSendText(appointmentEditPageForDoctor.appointmentDescriptionBox,arg4);

    }

    @And("user should see three buttons for requesting and showing test and requesting inpatient")
    public void userShouldSeeThreeButtonsForRequestingAndShowingTestAndRequestingInpatient() {
        Assert.assertEquals("No match","Request A Test",appointmentEditPageForDoctor.requestATestButton.getText());
    Assert.assertEquals("No match","Show Test Results",appointmentEditPageForDoctor.showTestResultButton.getText());
    Assert.assertEquals("No match","Request Inpatient",appointmentEditPageForDoctor.requestInpatientButton.getText());

    }

    @And("user should be able to go back without saving")
    public void userShouldBeAbleToGoBackWithoutSaving() {
        Driver.waitAndClick(appointmentEditPageForDoctor.goBackButton);
        Assert.assertEquals("No match","Appointments",myAppointmentPageAsDoctor.appointmentHeading.getText());
        Driver.clickWithJS(myAppointmentPageAsDoctor.editFirstAppointment);

    }

    @And("user saves the changes")
    public void userSavesTheChanges() {
        Assert.assertTrue(
                Driver.waitForVisibility(appointmentEditPageForDoctor.createOrEditAnAppointmentHeader,1).isDisplayed()
        );
        Driver.clickWithJS(appointmentEditPageForDoctor.saveButton);

//        try {
//
//            System.out.println("A" + Driver.waitForVisibility(appointmentEditPageForDoctor.alertElement, 1).getText());
//            System.out.println("B" + Driver.waitForVisibility(myAppointmentPageAsDoctor.alertElement, 1).getText());
//        } catch (Exception e) {
//
//        }
        Assert.assertTrue(
                Driver.waitForVisibility(appointmentEditPageForDoctor.alertElement,1).isDisplayed()
        );


    }
    @And("user changes the status of appointment")
    public void userChangesTheStatusOfAppointment() {
        Select select=new Select(Driver.waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
        String selectedStatus=select.getFirstSelectedOption().getText();
        if(selectedStatus.equals("UNAPPROVED")){
            select.selectByVisibleText("PENDING");
        }else if(selectedStatus.equals("PENDING")){
            select.selectByVisibleText("COMPLETED");
        }else{
            System.out.println("Appointment status can not be changed with this type of status");
        }

    }

    @When("user clicks on the Request A Test button")
    public void userClicksOnTheRequestATestButton() {
Driver.waitAndClick(appointmentEditPageForDoctor.requestATestButton);
Driver.wait(1);
    }

    @When("user clicks on the Show Test Results button")
    public void userClicksOnTheShowTestResultsButton() {
        Driver.clickWithJS(appointmentEditPageForDoctor.showTestResultButton);
        Driver.wait(1);
    }

    @And("user clicks on the Request Inpatient button")
    public void userClicksOnTheRequestInpatientButton() {
        Driver.wait(1);
        Driver.clickWithJS(appointmentEditPageForDoctor.requestInpatientButton);
        System.out.println(Driver.waitForVisibility(appointmentEditPageForDoctor.alertElement,1).getText());
    }



}
