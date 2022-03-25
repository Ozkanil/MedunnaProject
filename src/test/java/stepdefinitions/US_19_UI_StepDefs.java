package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CommonPage;
import pages.RegistrationPage;
import pages.US_19_UI_Pages;
import utilities.ConfigurationReader;
import utilities.Driver;

public class US_19_UI_StepDefs {

    RegistrationPage registrationPage = new RegistrationPage();
    CommonPage commonPage = new CommonPage();
    US_19_UI_Pages us_19_ui_pages = new US_19_UI_Pages();
    Actions actions = new Actions(Driver.getDriver());


    Faker faker = new Faker();
    public String mail=faker.internet().emailAddress();
    public String userName=faker.name().username();
    public String fakeSsn=faker.idNumber().ssnValid();

    @Given("user create a new registrant")
    public void user_create_a_new_registrant() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        Driver.waitAndClick(us_19_ui_pages.accountMenu);
        Driver.waitAndClick(commonPage.Register);
        Driver.waitAndSendText(commonPage.ssn, fakeSsn);
        Driver.waitAndSendText(registrationPage.firstName,"eymen");
        Driver.waitAndSendText(registrationPage.lastName,"arzu");
        Driver.waitAndSendText(registrationPage.username,userName);
        Driver.waitAndSendText(commonPage.email,mail);
        Driver.waitAndSendText(registrationPage.firstPassword,"eymen12345");
        Driver.waitAndSendText(registrationPage.secondPassword,"eymen12345");
        Driver.waitAndClick(registrationPage.registerButton);


    }

    @Given("user logs in as admin {string}, {string}")
    public void user_logs_in_as_admin(String username, String password) {
//           Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));
        Driver.waitAndClick(us_19_ui_pages.accountMenu);
        Driver.waitAndClick(us_19_ui_pages.loginItem);
        Driver.waitAndSendText(us_19_ui_pages.userName, username);
        Driver.waitAndSendText(us_19_ui_pages.password,password);
        Driver.waitAndClick(us_19_ui_pages.submit);

    }
    @Given("user navigates and validate to Staff page")
    public void user_navigates_and_validate_to_staff_page() {

        Driver.waitAndClick(us_19_ui_pages.itemsTitle);
        Driver.waitAndClick(us_19_ui_pages.dropDownStaff);
        Assert.assertTrue(us_19_ui_pages.staffPageValidation.isDisplayed());

    }
    @Given("user create a new Staff and search people using their SSN {string}")
    public void user_create_a_new_staff_and_search_people_using_their_ssn(String ssn) {
        Driver.waitAndClick(us_19_ui_pages.createStaff);
        Driver.waitAndClick(us_19_ui_pages.useSearchClick);
        Driver.waitAndSendText(us_19_ui_pages.searchSSNBox,fakeSsn);
        Driver.waitAndClick(us_19_ui_pages.searchUserButton);

        Driver.wait2(1);

    }
    @Given("User validate to found with search SSN")
    public void user_validate_to_found_with_search_ssn() {
        Assert.assertTrue(us_19_ui_pages.validateFoundUser.isDisplayed());

    }
    @Given("user sends information should be populated")
    public void user_sends_information_should_be_populated() {
        Select dropdown = new Select(us_19_ui_pages.staffUserDropdown);
        Select countryDropdown = new Select(us_19_ui_pages.staffCountryDropdown);
        Select stateDropdown = new Select(us_19_ui_pages.staffStateDropdown);

        Driver.waitAndSendText(us_19_ui_pages.staffBirthDate,"01.01.1985");
        Driver.waitAndSendText(us_19_ui_pages.staffPhone,"123-123-1234");
        Driver.waitAndSendText(us_19_ui_pages.staffAdress, "Yeni mah. 14 sok .NO 15");
        Driver.waitAndSendText(us_19_ui_pages.staffDescription,"Psychological Counselling and Guidance");
        dropdown.selectByVisibleText("eymenadmin");
        Driver.wait2(1);
        countryDropdown.selectByVisibleText("US");
        Driver.wait2(1);
        stateDropdown.selectByVisibleText("Alabama");
        Driver.wait2(1);
        Driver.waitAndClick(us_19_ui_pages.createStaffSaveButton);

    }
    @Then("user validate success message")
    public void user_validate_success_message() {

        Assert.assertTrue(us_19_ui_pages.validateSaveStaffCreation.isDisplayed());

    }
    @Given("User \\(Admin) can select a user from the existing users \\(registered people)")
    public void user_admin_can_select_a_user_from_the_existing_users_registered_people() {

        Assert.assertTrue(Driver.waitForVisibility(us_19_ui_pages.userNameSelect,5).isDisplayed());

    }

    @And("user on Create or edit a Staff Page clicks edit button")
    public void user_on_create_or_edit_a_staff_page_clicks_edit_button() {
        actions.sendKeys(Keys.RIGHT).perform();

        Driver.waitAndClick(us_19_ui_pages.editStaffButton);

    }
    @Given("user edit their information")
    public void user_edit_their_information() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait2(2);
        Select dropdown3 = new Select(us_19_ui_pages.staffCountryDropdown);
        Select dropdown4 = new Select(us_19_ui_pages.staffStateDropdown);

        Driver.wait2(1);
        dropdown3.selectByVisibleText("Turkey");



    }
    @Given("user save their information and validate success message")
    public void user_save_their_information_and_validate_success_message() {

        us_19_ui_pages.createStaffSaveButton.click();
        Assert.assertTrue(us_19_ui_pages.validateSaveStaffCreation.isDisplayed());

    }
    @Given("user delete and save their information")
    public void user_delete_and_save_their_information() {
        Driver.waitAndClick(us_19_ui_pages.editStaffButton);
        Driver.wait2(3);
        us_19_ui_pages.staffDescription.clear();
        Driver.wait2(3);
        Driver.waitAndClick(us_19_ui_pages.createStaffSaveButton);

    }
    @Then("user validate success message2")
    public void user_validate_success_message2() {
        Assert.assertTrue(us_19_ui_pages.validateSaveStaffCreation.isDisplayed());

        Driver.getDriver().quit();
    }
}
