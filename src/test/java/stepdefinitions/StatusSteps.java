package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.FindBy;
import pages.CommonPage;
import pages.NewAppointmentPage;
import pages.SearchPatientOnStaffPage;
import pages.StatusPage;
import utilities.Driver;

public class StatusSteps {


    SearchPatientOnStaffPage searchPatientOnStaffPage = new SearchPatientOnStaffPage();
    CommonPage commonPage = new CommonPage();
    StatusPage statusPage = new StatusPage();

  @When  ("user navigates to the home page")
  public  void user_navigates_to_the_home_page() throws InterruptedException {
      Thread.sleep(3);
    }
  @When("user clicks my pages dropdown")
  public void user_clicks_my_pages_dropdown() {

   Driver.waitForVisibility(statusPage.myPagesDropdown,5);
      statusPage.myPagesDropdown.click();
  }
  @And("user types from date {string}")
  public void userTypesFromDate(String fromdate) throws InterruptedException {
  Thread.sleep(3);
  }

  @And("user types to date on {string}")
  public void userTypesToDateOn(String todate) throws InterruptedException {
  Thread.sleep(3);
  }

  @And("user navigates in patient page")
  public void userNavigatesInPatientPage() throws InterruptedException {
  Thread.sleep(3);
  }

  @And("user navigates in create or edit an appointment page")
  public void userNavigatesInCreateOrEditAnAppointmentPage() throws InterruptedException {
      Thread.sleep(3);
  }

  @And("user selects from status text box pending,completed or cancelled")
  public void userSelectsFromStatusTextBoxPendingCompletedOrCancelled() {
        Driver.waitAndClick(statusPage.statusTextBox, 5);
    }



}






