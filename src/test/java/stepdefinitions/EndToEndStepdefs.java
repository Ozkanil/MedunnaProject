package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import pojos.Registrant;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.WriteToTxt;

import static utilities.Driver.*;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.ReusableMethods.hover;
import static utilities.WriteToTxt.saveRegistrantData;
import static utilities.WriteToTxt.saveRoomData;

public class EndToEndStepdefs {
    Faker faker=new Faker();
    RegistrationPage registrationPage=new RegistrationPage();
    Registrant registrant;
    String registerPage;
    String adminPage;
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
    CreateOrEditARoomByAdminPage createOrEditARoomByAdminPage=new CreateOrEditARoomByAdminPage();
    String patientPage;
    String phoneNumber;
    SearchPatientOnStaffPage searchPatientOnStaffPage=new SearchPatientOnStaffPage();
    String staffPage;
    String doctorPage;
    AppointmentEditPageForDoctor appointmentEditPageForDoctor=new AppointmentEditPageForDoctor();
    RequestATestPage requestATestPage=new RequestATestPage();
    String roomNumber;
    String createdDate="25/04/2022";
    int price;
    Actions actions=new Actions(getDriver());



    @Given("User registers to the page as a {string}")
    public void userRegistersToThePageAsA(String arg0) {
        String ssn=faker.number().numberBetween(100,899)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        waitAndSendText(registrationPage.ssn,ssn);
        String firstName=arg0+faker.name().firstName();
        String lastName="Endtoend"+faker.name().lastName();
        waitAndSendText(registrationPage.firstName,firstName);
        waitAndSendText(registrationPage.lastName,lastName);
        String userName=firstName+lastName+faker.number().numberBetween(0,1000);
        waitAndSendText(registrationPage.username,userName);
        String email=faker.internet().emailAddress();
        waitAndSendText(registrationPage.email,email);
        String password=lastName+ssn;
        waitAndSendText(registrationPage.firstPassword,password);
        waitAndSendText(registrationPage.secondPassword,password);
        waitAndClick(registrationPage.registerButton);
        waitForVisibility(registrationPage.successMessageToastContainer,5);
        registrant=new Registrant(firstName,lastName,ssn,userName,null,password,email);
        saveRegistrantData(registrant);
        Driver.wait(1);
    }

    @And("Admin signs in and assign user as a {string}")
    public void adminSignsInAndAssignUserAsA(String arg0) {
        registerPage=getDriver().getWindowHandle();
        try{
            getDriver().switchTo().window(adminPage);
            Driver.wait(1);
        }catch (Exception e){
            getDriver().switchTo().newWindow(WindowType.TAB);
            adminPage=Driver.getDriver().getWindowHandle();
            getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
            doubleClick(signInPage.username);
            waitAndSendText(signInPage.username,ConfigurationReader.getProperty("admin_username"));
            doubleClick(signInPage.password);
            waitAndSendText(signInPage.password,ConfigurationReader.getProperty("admin_password"));
            waitAndClick(signInPage.singInButton);
            Driver.wait(1);
        }


        waitAndClick(myAppointmentPageAsDoctor.adminDropdown);
        waitAndClick(myAppointmentPageAsDoctor.userManagementDropdown);
        Driver.wait(1);
        waitForVisibility(createOrEditARoomByAdminPage.lastPage,3);
        clickWithJS(createOrEditARoomByAdminPage.lastPage);
        actions.sendKeys(Keys.PAGE_UP);
        Driver.wait(1);
        clickWithJS(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
        actions.sendKeys(Keys.PAGE_UP);
        Driver.wait(1);
        waitForVisibility(myAppointmentPageAsDoctor.activatedCheck,1);
        clickWithJS(myAppointmentPageAsDoctor.activatedCheck);
        switch (arg0){
            case "patient":
                waitAndClick(myAppointmentPageAsDoctor.userRolePatient);
                waitAndClick(myAppointmentPageAsDoctor.saveButton);
//                waitAndClick(myAppointmentPageAsDoctor.itemsTitlesDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.patientDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.createANewPatientButton);
//                waitAndSendText(registrationPage.firstName,registrant.getFirstName());
//                waitAndSendText(registrationPage.lastName,registrant.getLastName());
//                waitAndSendText(registrationPage.email,registrant.getEmail());
                break;
            case "staff":
                waitAndClick(myAppointmentPageAsDoctor.userRoleStaff);
                waitAndClick(myAppointmentPageAsDoctor.saveButton);
//                waitAndClick(myAppointmentPageAsDoctor.saveButton);
//                waitAndClick(myAppointmentPageAsDoctor.itemsTitlesDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.staffDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.createANewStaffButton);
//                waitAndClick(myAppointmentPageAsDoctor.useSSNCheckBox);
//                waitAndSendText(myAppointmentPageAsDoctor.patientSSNSearchBox, registrant.getSsn());
//                Driver.wait(1);
//                waitAndClick(myAppointmentPageAsDoctor.searchSSNButton);
                break;
//            case "doctor":
//                waitAndClick(myAppointmentPageAsDoctor.userRoleDoctor);
//                waitAndClick(myAppointmentPageAsDoctor.saveButton);
//                waitAndClick(myAppointmentPageAsDoctor.itemsTitlesDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.physicianDropdown);
//                waitAndClick(myAppointmentPageAsDoctor.createANewPhysicianButton);
//                waitAndClick(myAppointmentPageAsDoctor.useSSNCheckBox);
//                waitAndSendText(myAppointmentPageAsDoctor.patientSSNSearchBox, registrant.getSsn());
//                Driver.wait(1);
//                waitAndClick(myAppointmentPageAsDoctor.searchSSNButton);
//                Driver.wait(1);
//                waitAndSendText(myAppointmentPageAsDoctor.examFeeTextBox, String.valueOf(faker.number().numberBetween(100,500)));


        }


        phoneNumber= String.valueOf(faker.number().numberBetween(1000000000L,9999999999L));
//        System.out.println(phoneNumber);
//        waitAndSendText(myAppointmentPageAsDoctor.phoneTextBox,phoneNumber);

//        Driver.wait(1);
        Driver.wait(2);

    }

    @And("Patient signs in and makes an appointment")
    public void patientSignsInAndMakesAnAppointment() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        patientPage=getDriver().getWindowHandle();
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        waitAndSendText(signInPage.username,registrant.getLogin());
        waitAndSendText(signInPage.password,registrant.getPassword());
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.patientMyPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.patientMakeAnAppointment);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.phoneTextBox,phoneNumber);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.appointmentDate,createdDate);
        waitAndClick(myAppointmentPageAsDoctor.makeAnAppointmentButton);
        Driver.wait(2);
        Driver.getDriver().switchTo().window(registerPage);
        Driver.wait(1);
        Driver.getDriver().navigate().refresh();
        Driver.wait(1);
    }

    @And("The staff signs in and approves the appointment")
    public void theStaffSignsInAndApprovesTheAppointment() {

        getDriver().switchTo().newWindow(WindowType.TAB);
        staffPage=getDriver().getWindowHandle();
//        Driver.wait(1);
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.wait(1);
        waitAndSendText(signInPage.username,registrant.getLogin());
        waitAndSendText(signInPage.password,registrant.getPassword());
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(searchPatientOnStaffPage.searchPatientDropdown);
        Driver.wait(1);

        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
        System.out.println(getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
//        Driver.getDriver().switchTo().window(registerPage);
//        Driver.wait(1);
//        Driver.getDriver().navigate().refresh();
//        Driver.wait(1);

    }

    @And("The staff assigns the appointment to a doctor")
    public void theStaffAssignsTheAppointmentToADoctor() {
//        Driver.getDriver().switchTo().window(staffPage);
//        Driver.wait(1);
//        Driver.getDriver().navigate().refresh();
//        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Select select=new Select(waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
        select.selectByVisibleText("PENDING");
        Driver.wait(1);
        waitAndClick(appointmentEditPageForDoctor.appointmentPhysicianBox);
        waitAndClick(myAppointmentPageAsDoctor.selectDoctorArif);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(1);

    }

    @And("The doctor edits the appointment by asking test results")
    public void theDoctorEditsTheAppointmentByAskingTestResults() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        doctorPage=getDriver().getWindowHandle();
//        Driver.wait(1);
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.wait(1);
        waitAndSendText(signInPage.username,ConfigurationReader.getProperty("doctor_username"));
        waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        Driver.wait(2);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);
        waitAndClick(appointmentEditPageForDoctor.requestATestButton);
        Driver.wait(1);
        waitAndClick(requestATestPage.glucoseCheck);
        Driver.wait(1);
        waitAndClick(requestATestPage.saveButton);
        Driver.wait(1);
        waitAndSendText(appointmentEditPageForDoctor.appointmentAnamnesisBox,"allergic reaction");
        waitAndSendText(appointmentEditPageForDoctor.appointmentTreatmentBox,"nasal sprays");
        waitAndSendText(appointmentEditPageForDoctor.appointmentDiagnosisBox,"Skin Prick Test");
//        waitAndSendText(appointmentEditPageForDoctor.appointmentPrescriptionBox,"Otrivin");
//        waitAndSendText(appointmentEditPageForDoctor.appointmentDescriptionBox,"Breathing problems");
        Driver.wait(1);
        waitAndClick(appointmentEditPageForDoctor.saveButton);
        Driver.wait(2);

    }

    @And("The staff approves the test request and updates it")
    public void theStaffApprovesTheTestRequestAndUpdatesIt() {
        getDriver().switchTo().window(staffPage);
        Driver.wait(1);
        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
       // System.out.println(getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.showTestsButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.viewTestResults);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.editResultTextBox,"66");
        waitAndSendText(myAppointmentPageAsDoctor.editDescriptionTextBox,"the results are under than min default value");
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);

    }

    @And("The doctor views test results, gives prescription, changes status as completed and request inpatient")
    public void theDoctorViewsTestResultsGivesPrescriptionChangesStatusAsCompletedAndRequestInpatient() {

        getDriver().switchTo().window(doctorPage);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        Driver.wait(2);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);

        waitAndClick(appointmentEditPageForDoctor.showTestResultButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.viewTestResults);
        Driver.wait(2);
        getDriver().navigate().back();
        Driver.wait(1);
        getDriver().navigate().back();
        Driver.wait(1);
        waitForVisibility(appointmentEditPageForDoctor.requestInpatientButton,1);
        clickWithJS(appointmentEditPageForDoctor.requestInpatientButton);
        Driver.wait(1);
        waitAndSendText(appointmentEditPageForDoctor.appointmentPrescriptionBox,"Otrivin");
        waitAndSendText(appointmentEditPageForDoctor.appointmentDescriptionBox,"Breathing problems");
        Select select=new Select(waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
        select.selectByVisibleText("COMPLETED");
        Driver.wait(1);
        waitAndClick(appointmentEditPageForDoctor.saveButton);
        Driver.wait(2);


    }

    @And("Admin create a room for inpatients")
    public void adminCreateARoomForInpatients() {
        Driver.wait(1);
        getDriver().switchTo().window(adminPage);
        waitAndClick(createOrEditARoomByAdminPage.itemsTitlesDropdown);
        clickWithJS(createOrEditARoomByAdminPage.roomDropdown);
        waitAndClick(createOrEditARoomByAdminPage.createANewRoomButton);
        roomNumber=String.valueOf(faker.number().numberBetween(1000,3000));
        waitAndSendText(createOrEditARoomByAdminPage.roomNumberTextBox,roomNumber );
        price=faker.number().numberBetween(100,500);
        Driver.waitAndSendText(createOrEditARoomByAdminPage.priceTextBox,String.valueOf(price));
        Driver.waitAndSendText(createOrEditARoomByAdminPage.createdDateTextBox,createdDate);
        saveRoomData(roomNumber,price,createdDate);


        Driver.clickWithJS(requestATestPage.saveButton);
    }

    @And("The staff approves inpatient request and assigns a room for patient")
    public void theStaffApprovesInpatientRequestAndAssignsARoomForPatient() {
        Driver.wait(1);
        getDriver().switchTo().window(staffPage);
//        getDriver().navigate().refresh();
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.inPatientDropdown);
        Driver.wait(1);

        waitAndClick(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
        Driver.wait(1);
      //  waitAndClick(myAppointmentPageAsDoctor.endDateRoom);

       Select options=new Select( waitForVisibility(searchPatientOnStaffPage.statusDropdownCreateEditAppointment,1));
       options.selectByVisibleText("STAYING");
        Driver.wait(1);
       Select rooms=new Select(myAppointmentPageAsDoctor.roomSelection);
//       rooms.selectByValue("5926");
        rooms.selectByIndex(20);
       Driver.wait(1);
       clickWithJS(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
    }

    @And("The doctor updates status inpatient as discharged")
    public void theDoctorUpdatesStatusInpatientAsDischarged() {
        Driver.wait(1);
        getDriver().switchTo().window(doctorPage);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myInpatientsDropdown);
        Driver.wait(1);
        clickWithJS(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
        Driver.wait(1);
        Select options=new Select( waitForVisibility(searchPatientOnStaffPage.statusDropdownCreateEditAppointment,1));
        options.selectByVisibleText("DISCHARGED");
        Driver.wait(1);
        clickWithJS(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
    }

    @And("The staff views updated status and creates an invoice")
    public void theStaffViewsUpdatedStatusAndCreatesAnInvoice() {
        getDriver().switchTo().window(staffPage);
        Driver.wait(1);
        getDriver().navigate().refresh();
        Driver.wait(1);
//        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
//        waitAndClick(myAppointmentPageAsDoctor.myInpatientsDropdown);
      try{
          hover(myAppointmentPageAsDoctor.h3);
      }catch (Exception e){

      }
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(searchPatientOnStaffPage.searchPatientDropdown);
        Driver.wait(1);
        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.invoice);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.createInvoiceButton);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);



    }

    @When("The patient views the invoice")
    public void thePatientViewsTheInvoice() {
        getDriver().switchTo().window(patientPage);
        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.patientMyPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        waitAndClick(myAppointmentPageAsDoctor.showInvoiceButton);
        Driver.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(3);


    }

    @Then("The patient has an heart attack")
    public void thePatientHasAnHeartAttack() {
    }
}
