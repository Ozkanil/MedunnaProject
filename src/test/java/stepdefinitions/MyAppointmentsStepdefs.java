package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;


public class MyAppointmentsStepdefs {
   // WebDriver driver;
    CommonPage commonPage=new CommonPage();
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
  // SearchPatientOnStaffPage searchPatientOnStaffPage=new SearchPatientOnStaffPage();
    RequestATestPage requestATestPage=new RequestATestPage();


    @Given("user sign in as a {string}")
    public void userSignInAsA(String arg0) {
       Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
//try{
//    Driver.waitForVisibility(commonPage.accountMenu,5);
//    Driver.clickWithJS(commonPage.accountMenu);
//    Driver.clickWithJS(signInPage.signoutButton);
//    Driver.getDriver().navigate().to(ConfigurationReader.getProperty("medunna_signin_url"));
//
//}catch (Exception e){
//
//}
       // Driver.getDriver().get("https://medunna.com/login?page=1&sort=id,asc");
        switch (arg0){
            case "doctor":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("doctor_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                Assert.assertTrue(myAppointmentPageAsDoctor.myAppointment.isDisplayed());
                break;
            case "admin":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("admin_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("admin_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.itemsTitlesDropdown);
                Assert.assertTrue(myAppointmentPageAsDoctor.adminAppointment.isDisplayed());
                break;
            case "patient":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("patient_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("patient_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.patientMyPagesDropdown);
                Assert.assertTrue(myAppointmentPageAsDoctor.myAppointment.isDisplayed());
                break;
            case "staff":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("staff_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("staff_password"));
                Driver.waitAndClick(signInPage.singInButton);
                Driver.waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
                Assert.assertTrue(requestATestPage.searchPatientDropdown.isDisplayed());
                break;
            case "user":
                Driver.waitAndSendText(signInPage.username,ConfigurationReader.getProperty("user_username"));
                Driver.waitAndSendText(signInPage.password,ConfigurationReader.getProperty("user_password"));
                Driver.waitAndClick(signInPage.singInButton);
                break;
            default:
                System.out.println("No such user found");
                break;

    }

    }

    @And("user selects My Appointments item and clicks")
    public void userSelectsMyAppointmentsItemAndClicks() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.myAppointment);
    }


    @When("user on the Appointments page")
    public void userOnTheAppointmentsPage() {
        Driver.waitForVisibility(myAppointmentPageAsDoctor.appointmentHeading,1);
        Assert.assertTrue(myAppointmentPageAsDoctor.appointmentHeading.isDisplayed());
    }

    @Then("user should see list of appointments and time slots")
    public void userShouldSeeListOfAppointmentsAndTimeSlots() {
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.toDateAppointment,1).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.fromDateAppointment,1).isDisplayed());
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.allDataOfAppointmentsTable,1).isDisplayed());
    }

    @And("user selects time slots providing {string} and {string}")
    public void userSelectsTimeSlotsProvidingAnd(String arg0, String arg1) {
        Driver.waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment, arg0);
        Driver.waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment, arg1);
        Driver.wait(1);
        try {
            System.out.println(Driver.waitAndGetText(myAppointmentPageAsDoctor.alertMessage,1));
        } catch (Exception e) {
        }
    }

    @Then("user cliks on the edit button")
    public void userCliksOnTheEditButton() {
        Driver.waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
    }

    @Then("user should see information of the appointment list")
    public void userShouldSeeInformationOfTheAppointmentList() {
       // System.out.println(Driver.waitForVisibility(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).getText());
    Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).
            getText().contains("ID"));
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).
                getText().contains("Start DateTime"));
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).
                getText().contains("End DateTime"));
        Assert.assertTrue(Driver.waitForVisibility(myAppointmentPageAsDoctor.headersOfAppointmentsTable,1).
                getText().contains("Status"));

    }
}
