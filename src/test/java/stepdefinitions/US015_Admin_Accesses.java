package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pages.*;
import utilities.ConfigurationReader;
import utilities.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.hasItems;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;


public class US015_Admin_Accesses {


    CommonPage commonPage = new CommonPage();
    SignInPage signInPage = new SignInPage();
    AdminPage adminPage = new AdminPage();
    Patient1051Page patientInfos=new Patient1051Page();
    CreateOrEditAPatientByAdminPage createPatient = new CreateOrEditAPatientByAdminPage();
    List<String> statesInUs;
    List<String> firstnameAndLastnameOfNewPatient;
    List<String> theListOfNameOfStatesFromWebTable;
    List<String> theListOfFirstnameAndLastnameOfLastPagesWebTable;

    Faker faker=new Faker();
    Response response;
    public String firstname=faker.name().firstName();
    public String lastname=faker.name().lastName();


    @Given("User signs in as an Admin")
    public void user_signs_in_as_an_admin() throws InterruptedException {
        Driver.getDriver().get("https://medunna.com/");
        commonPage.accountMenu.click();
        commonPage.signIn.click();
        signInPage.username.sendKeys("MedunnaAdmin");
        signInPage.password.sendKeys("1@qweASD");
        Driver.clickWithJS(signInPage.singInButton);
        Thread.sleep(3000);
    }

    @Then("User clicks Patient button under Items&Titles")
    public void user_clicks_patient_button_under_items_titles() {
        commonPage.itemsAndTitles.click();
        adminPage.patientsUnderItemsAndTitles.click();

    }

    @Then("User clicks the Create a new Patient button")
    public void user_clicks_the_create_a_new_patient_button() throws InterruptedException {

        Driver.waitAndClickElement(adminPage.createANewPatient, 10);
        Thread.sleep(3000);
    }

    @Then("User fill out the formula and clicks to Save button")
    public void user_fill_out_the_formula_and_clicks_to_save_button() {

        createPatient.firstName.sendKeys(firstname);
        createPatient.lastName.sendKeys(lastname);
        createPatient.birthDate.sendKeys(faker.date().birthday(21,35).toString());
        createPatient.email.sendKeys(faker.internet().emailAddress());
        createPatient.phone.sendKeys("111-111-1111");
        createPatient.gender.sendKeys("MALE");
        createPatient.bloodGroup.sendKeys("A+");
        createPatient.description.sendKeys(faker.artist().name());
        createPatient.adress.sendKeys(faker.address().fullAddress());
        createPatient.user.sendKeys("system");
        createPatient.country.sendKeys("US" + Keys.ENTER);
        createPatient.stateCity.sendKeys("Alaska" + Keys.ENTER);
        Driver.waitForVisibility(createPatient.saveButton,10);
        Driver.clickWithJS(createPatient.saveButton);


    }

    @Then("User verifies that the new user created Alert")
    public void user_verifies_that_the_new_user_created_alert() {

        Driver.waitForVisibility(createPatient.successCreatedMessage,10);
        Assert.assertTrue(createPatient.successCreatedMessage.isEnabled());

    }

    @Then("User verifies that the new Patient also in Patients Page")
    public void userVerifiesThatTheNewPatientAlsoInPatientsPage() throws InterruptedException {
        Driver.waitForVisibility(adminPage.lastPagelink,10);
        Driver.clickWithJS(adminPage.lastPagelink);
        Thread.sleep(4000);
        firstnameAndLastnameOfNewPatient=new ArrayList<>(Arrays.asList(firstname,lastname));
        theListOfFirstnameAndLastnameOfLastPagesWebTable=new ArrayList<>();
        for (WebElement each:adminPage.listOfAllFirstnameOfCreatedPatientOnTheLastPage) {
            String element=each.getText();
            theListOfFirstnameAndLastnameOfLastPagesWebTable.add(element);
        }

        for (WebElement each:adminPage.listOfAllLastnameOfCreatedPatientOnTheLastPage) {
            String element=each.getText();
            theListOfFirstnameAndLastnameOfLastPagesWebTable.add(element);

        }
        System.out.println(theListOfFirstnameAndLastnameOfLastPagesWebTable.toString());
        System.out.println(firstnameAndLastnameOfNewPatient.toString());
        Assert.assertTrue(theListOfFirstnameAndLastnameOfLastPagesWebTable.containsAll(firstnameAndLastnameOfNewPatient));
        response = getRequest(generateToken(ConfigurationReader.getProperty("admin_username"),ConfigurationReader.getProperty("admin_password")), ConfigurationReader.getProperty("api_getAllPatients"));
        response.prettyPrint();

    }


    @Then("User clicks the first View button between Patients")
    public void user_clicks_the_first_view_button_between_patients() {

        Driver.waitForVisibility(adminPage.firstViewButton,10);
        adminPage.firstViewButton.click();

    }

    @Then("User verifies that the requeriments")
    public void user_verifies_that_the_requeriments() {

        Assert.assertTrue(patientInfos.ssn.isEnabled());
        Assert.assertTrue(patientInfos.firstName.isEnabled());
        Assert.assertTrue(patientInfos.lastName.isEnabled());
        Assert.assertTrue(patientInfos.birthDate.isEnabled());
        Assert.assertTrue(patientInfos.phone.isEnabled());
        Assert.assertTrue(patientInfos.gender.isEnabled());
        Assert.assertTrue(patientInfos.bloodGroup.isEnabled());
        Assert.assertTrue(patientInfos.description.isEnabled());
        Assert.assertTrue(patientInfos.createdDate.isEnabled());
        Assert.assertTrue(patientInfos.user.isEnabled());
        Assert.assertTrue(patientInfos.country.isEnabled());
        Assert.assertTrue(patientInfos.stateCity.isEnabled());
    }

    @Then("User clicks the first Edit button between Patients button between Patients")
    public void userClicksTheFirstEditButtonBetweenPatientsButtonBetweenPatients() {
        Driver.waitForVisibility(adminPage.firstEditButton,10);
        adminPage.firstEditButton.click();


    }

    @Then("User Verifies the id box")
    public void user_verifies_the_id_box() {

        Driver.waitForVisibility(createPatient.id,10);
        Assert.assertTrue(createPatient.id.isEnabled());
    }

    @Then("User clicks the first Edit button between Patients")
    public void user_clicks_the_first_edit_button_between_patients() {
        Driver.waitForVisibility(adminPage.firstEditButton,10);
        adminPage.firstEditButton.click();

    }

    @Then("User clicks Appointment button under Items&Titles")
    public void userClicksAppointmentButtonUnderItemsTitles() {
        commonPage.itemsAndTitles.click();
        adminPage.adminAppointment.click();
    }

    @Then("User assign a doctor to Patient")
    public void user_assign_a_doctor_to_patient(){

        Driver.waitAndSendText(createPatient.physician,"10505:Johny John");



    }

    @Then("User assign a  Patient  to doctor")
    public void user_assign_a_patient_to_doctor() {
        createPatient.patient.sendKeys("3651");
        Driver.waitForVisibility(createPatient.saveButton,10);
        Driver.clickWithJS(createPatient.saveButton);

    }

    @Then("User verifies the Successfully message")
    public void user_verifies_the_successfully_message() {
        Driver.waitForVisibility(createPatient.successUpdatedMessage,10);
        Assert.assertTrue(createPatient.successUpdatedMessage.isEnabled());

    }

    @Then("User clicks State and City button under Items&Titles")
    public void user_clicks_and_state_city_button_under_items_titles() throws InterruptedException {
        commonPage.itemsAndTitles.click();
        adminPage.stateAndCity.click();
        Thread.sleep(5000);

    }

    @Then("User creates the list of Name of States")
    public void user_creates_the_list_of_name_of_states() throws InterruptedException {
        statesInUs=new ArrayList<>(Arrays.asList("Alaska", "Alabama", "Arkansas", "American Samoa", "Arizona", "California", "Colorado", "Connecticut", "District of Columbia", "Delaware", "Florida", "Georgia", "Guam", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming"));
        theListOfNameOfStatesFromWebTable=new ArrayList<>();

            for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
            }
            if (adminPage.nextPagelink.isEnabled()){
                 Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
                Thread.sleep(3000);
            }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (adminPage.nextPagelink.isEnabled()){
             Driver.clickWithJS(adminPage.nextPagelink);
                Thread.sleep(3000);
        }
        for (WebElement each:adminPage.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }

        System.out.println(theListOfNameOfStatesFromWebTable.toString());
    }

    @Then("User verifies that all State are not in US")
    public void user_verifies_that_all_state_are_not_in_us() {
        Assert.assertTrue(!statesInUs.containsAll(theListOfNameOfStatesFromWebTable));

    }

    @Then("User verifies that all there is no blank between States name")
    public void userVerifiesThatAllThereIsNoBlankBetweenStatesName() {
        Assert.assertTrue(!theListOfNameOfStatesFromWebTable.contains(null));
    }

    @Then("User clicks the first Delete button between Patients")
    public void user_clicks_the_first_delete_button_between_patients() {
        Driver.waitForVisibility(adminPage.firstDeleteButton,10);
        Driver.clickWithJS(adminPage.firstDeleteButton);
        Driver.waitForVisibility(adminPage.confirmationDeleteButton,10);
        Driver.clickWithJS(adminPage.confirmationDeleteButton);
        Driver.waitForVisibility(adminPage.failMessageToastContainer,10);




    }

    @Then("User verifies the fail message")
    public void user_verifies_the_fail_message() {
        Assert.assertTrue(adminPage.failMessageToastContainer.isEnabled());
    }

    @Then("You should report this Bug")
    public void you_should_report_this_bug() {

    }

    @Given("user set the url and generate the token for getting all patients")
    public void userSetTheUrlAndGenerateTheTokenForGettingAllPatients() {
        response = getRequest(generateToken(ConfigurationReader.getProperty("admin_username"),
                        ConfigurationReader.getProperty("admin_password")),
                ConfigurationReader.getProperty("api_getAllPatients"));
        response.prettyPrint();


    }


    @Then("user validate the all infos")
    public void user_validate_the_all_infos() {
        response.then().assertThat().body("firstName",hasItems(firstname));
        response.then().assertThat().body("lastName",hasItems(lastname));

    }


    @Then("User click signout")
    public void userClickSignout() {
        commonPage.accountMenu.click();
        Driver.waitForVisibility(commonPage.signOut,10);
        Driver.clickWithJS(commonPage.signOut);
    }


}
