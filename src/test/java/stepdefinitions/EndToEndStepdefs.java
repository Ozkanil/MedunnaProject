package stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import pojos.*;
import pojos.DoctorAppointment;
import utilities.ConfigurationReader;
import utilities.Driver;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.ApiUtils.deleteRequest;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.DBUtils.*;
import static utilities.Driver.*;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.ReusableMethods.hover;
import static utilities.WriteToTxt.saveRegistrantData;
import static utilities.WriteToTxt.saveRoomData;

public class EndToEndStepdefs {
    Faker faker=new Faker();
    RegistrationPage registrationPage=new RegistrationPage();
    Registrant registrant;
    java.lang.String registerPage;
    java.lang.String adminPage;
    SignInPage signInPage=new SignInPage();
    MyAppointmentPageAsDoctor myAppointmentPageAsDoctor=new MyAppointmentPageAsDoctor();
    CreateOrEditARoomByAdminPage createOrEditARoomByAdminPage=new CreateOrEditARoomByAdminPage();
    java.lang.String patientPage;
    java.lang.String phoneNumber;
    SearchPatientOnStaffPage searchPatientOnStaffPage=new SearchPatientOnStaffPage();
    java.lang.String staffPage;
    java.lang.String doctorPage;
    AppointmentEditPageForDoctor appointmentEditPageForDoctor=new AppointmentEditPageForDoctor();
    RequestATestPage requestATestPage=new RequestATestPage();
    java.lang.String roomNumber;
    java.lang.String createdDate="06/05/2022";
    int price;
    Actions actions=new Actions(getDriver());
    Response response;
    DoctorAppointment doctorAppointment =new DoctorAppointment();
    Inpatient inpatient=new Inpatient();
    Invoice invoice;


    @Given("User registers to the page as a {string}")
    public void userRegistersToThePageAsA(java.lang.String arg0) throws InterruptedException {
        java.lang.String ssn=faker.number().numberBetween(100,899)+"-"+faker.number().numberBetween(10,99)+"-"+faker.number().numberBetween(1000,9999);
        waitAndSendText(registrationPage.ssn,ssn);
        java.lang.String firstName=arg0+faker.name().firstName();
        java.lang.String lastName="Endtoend"+faker.name().lastName();
        waitAndSendText(registrationPage.firstName,firstName);
        waitAndSendText(registrationPage.lastName,lastName);
        java.lang.String userName=firstName+lastName+faker.number().numberBetween(0,1000);
        waitAndSendText(myAppointmentPageAsDoctor.usernameTextBox,userName);
        java.lang.String email=faker.internet().emailAddress();
        waitAndSendText(registrationPage.email,email);
        java.lang.String password=lastName+ssn;
        waitAndSendText(registrationPage.firstPassword,password);
        waitAndSendText(registrationPage.secondPassword,password);
        waitAndClick(registrationPage.registerButton);
        waitForVisibility(registrationPage.successMessageToastContainer,5);
        registrant=new Registrant(firstName,lastName,ssn,userName,null,password,email);
        saveRegistrantData(registrant);
        Driver.wait(1);
        Thread.sleep(5000);
    }

    @And("Admin signs in and assign user as a {string}")
    public void adminSignsInAndAssignUserAsA(java.lang.String arg0) throws InterruptedException {
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

        Thread.sleep(5000);
        waitAndClick(myAppointmentPageAsDoctor.adminDropdown);
        waitAndClick(myAppointmentPageAsDoctor.userManagementDropdown);
        Driver.wait(1);
        waitForVisibility(createOrEditARoomByAdminPage.lastPage,3);
        clickWithJS(createOrEditARoomByAdminPage.lastPage);
        actions.sendKeys(Keys.PAGE_UP);
        Driver.wait(1);
        clickWithJS(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
//        actions.sendKeys(Keys.PAGE_UP);
//        actions.sendKeys(Keys.ARROW_UP);
        Driver.wait(1);
        Thread.sleep(1000);
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


        phoneNumber= java.lang.String.valueOf(faker.number().numberBetween(1000000000L,9999999999L));
//        System.out.println(phoneNumber);
//        waitAndSendText(myAppointmentPageAsDoctor.phoneTextBox,phoneNumber);

//        Driver.wait(1);
//        Driver.wait(2);
        Thread.sleep(2000);

    }

    @And("Patient signs in and makes an appointment")
    public void patientSignsInAndMakesAnAppointment() throws InterruptedException {
        getDriver().switchTo().newWindow(WindowType.TAB);
        patientPage=getDriver().getWindowHandle();
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        waitAndSendText(signInPage.username,registrant.getLogin());
        waitAndSendText(signInPage.password,registrant.getPassword());
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        Thread.sleep(2000);
        waitAndClick(myAppointmentPageAsDoctor.patientMyPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.patientMakeAnAppointment);
        Driver.wait(1);
        Thread.sleep(2000);
        waitAndSendText(myAppointmentPageAsDoctor.phoneTextBox,phoneNumber);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(myAppointmentPageAsDoctor.appointmentDate,createdDate);
        waitAndClick(myAppointmentPageAsDoctor.makeAnAppointmentButton);
        Driver.wait(2);
        Thread.sleep(2000);
        Driver.getDriver().switchTo().window(registerPage);
        Driver.wait(1);
        Driver.getDriver().navigate().refresh();
        Driver.wait(1);
        Thread.sleep(2000);
    }

    @And("The staff signs in and approves the appointment")
    public void theStaffSignsInAndApprovesTheAppointment() throws InterruptedException {

        getDriver().switchTo().newWindow(WindowType.TAB);
        staffPage=getDriver().getWindowHandle();
//        Driver.wait(1);
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(signInPage.username,registrant.getLogin());
        waitAndSendText(signInPage.password,registrant.getPassword());
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(searchPatientOnStaffPage.searchPatientDropdown);
        Driver.wait(1);
        Thread.sleep(1000);

        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
        System.out.println(getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
        Thread.sleep(1000);
//        Driver.getDriver().switchTo().window(registerPage);
//        Driver.wait(1);
//        Driver.getDriver().navigate().refresh();
//        Driver.wait(1);

    }

    @And("The staff assigns the appointment to a doctor")
    public void theStaffAssignsTheAppointmentToADoctor() throws InterruptedException {
//        Driver.getDriver().switchTo().window(staffPage);
//        Driver.wait(1);
//        Driver.getDriver().navigate().refresh();
//        Driver.wait(1);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Select select=new Select(waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
        select.selectByVisibleText("PENDING");
        doctorAppointment.setStatus("PENDING");
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(appointmentEditPageForDoctor.appointmentPhysicianBox);
        waitAndClick(myAppointmentPageAsDoctor.selectDoctorArif);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(1);
        Thread.sleep(2000);

    }

    @And("The doctor edits the appointment by asking test results")
    public void theDoctorEditsTheAppointmentByAskingTestResults() throws InterruptedException {
        getDriver().switchTo().newWindow(WindowType.TAB);
        doctorPage=getDriver().getWindowHandle();
//        Driver.wait(1);
        getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(signInPage.username,ConfigurationReader.getProperty("doctor_username"));
        waitAndSendText(signInPage.password,ConfigurationReader.getProperty("doctor_password"));
        waitAndClick(signInPage.singInButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        Driver.wait(2);
        Thread.sleep(2000);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(appointmentEditPageForDoctor.requestATestButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(requestATestPage.glucoseCheck);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(requestATestPage.saveButton);
        Driver.wait(1);
        Thread.sleep(1000);
        int id=Integer.parseInt(appointmentEditPageForDoctor.appointmentIdBox.getAttribute("value"));
        System.out.println(id);
        doctorAppointment.setId(id);
        java.lang.String startDate=appointmentEditPageForDoctor.appointmentStartDateBox.getAttribute("value")+":00Z";
        doctorAppointment.setStartDate(startDate);
        java.lang.String endDate=appointmentEditPageForDoctor.appointmentEndDateBox.getAttribute("value")+":00Z";
        doctorAppointment.setEndDate(endDate);
        waitAndSendText(appointmentEditPageForDoctor.appointmentAnamnesisBox,"allergic reaction");
        waitAndSendText(appointmentEditPageForDoctor.appointmentTreatmentBox,"nasal sprays");
        waitAndSendText(appointmentEditPageForDoctor.appointmentDiagnosisBox,"Skin Prick Test");
//        waitAndSendText(appointmentEditPageForDoctor.appointmentPrescriptionBox,"Otrivin");
//        waitAndSendText(appointmentEditPageForDoctor.appointmentDescriptionBox,"Breathing problems");
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(appointmentEditPageForDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);

    }

    @And("The staff approves the test request and updates it")
    public void theStaffApprovesTheTestRequestAndUpdatesIt() throws InterruptedException {
        getDriver().switchTo().window(staffPage);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
        // System.out.println(getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.showTestsButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.viewTestResults);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(myAppointmentPageAsDoctor.editResultTextBox,"66");
        waitAndSendText(myAppointmentPageAsDoctor.editDescriptionTextBox,"the results are under than min default value");
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);

    }

    @And("The doctor views test results, gives prescription, changes status as completed and request inpatient")
    public void theDoctorViewsTestResultsGivesPrescriptionChangesStatusAsCompletedAndRequestInpatient() throws InterruptedException {

        getDriver().switchTo().window(doctorPage);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        Driver.wait(2);
        Thread.sleep(2000);
        waitAndClick(myAppointmentPageAsDoctor.editFirstAppointment);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(appointmentEditPageForDoctor.showTestResultButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.viewTestResults);
        Driver.wait(2);
        Thread.sleep(2000);
        getDriver().navigate().back();
        Driver.wait(1);
        Thread.sleep(1000);
        getDriver().navigate().back();
        Driver.wait(1);
        Thread.sleep(1000);
        waitForVisibility(appointmentEditPageForDoctor.requestInpatientButton,1);
        clickWithJS(appointmentEditPageForDoctor.requestInpatientButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(appointmentEditPageForDoctor.appointmentPrescriptionBox,"Otrivin");
        waitAndSendText(appointmentEditPageForDoctor.appointmentDescriptionBox,"Breathing problems");
        Select select=new Select(waitForVisibility(appointmentEditPageForDoctor.appointmentStatusBox,1));
        select.selectByVisibleText("COMPLETED");
        doctorAppointment.setStatus("COMPLETED");
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(appointmentEditPageForDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);


    }

    @And("Admin create a room for inpatients")
    public void adminCreateARoomForInpatients() {
        Driver.wait(1);

        getDriver().switchTo().window(adminPage);
        waitAndClick(createOrEditARoomByAdminPage.itemsTitlesDropdown);
        clickWithJS(createOrEditARoomByAdminPage.roomDropdown);
        waitAndClick(createOrEditARoomByAdminPage.createANewRoomButton);
        roomNumber= java.lang.String.valueOf(faker.number().numberBetween(1000,3000));
        waitAndSendText(createOrEditARoomByAdminPage.roomNumberTextBox,roomNumber );
        price=faker.number().numberBetween(100,500);
        Driver.waitAndSendText(createOrEditARoomByAdminPage.priceTextBox, java.lang.String.valueOf(price));
        Driver.waitAndSendText(createOrEditARoomByAdminPage.createdDateTextBox,createdDate);
        saveRoomData(roomNumber,price,createdDate);


        Driver.clickWithJS(requestATestPage.saveButton);
    }

    @And("The staff approves inpatient request and assigns a room for patient")
    public void theStaffApprovesInpatientRequestAndAssignsARoomForPatient() throws InterruptedException {
        Driver.wait(1);
        Thread.sleep(1000);
        getDriver().switchTo().window(staffPage);
//        getDriver().navigate().refresh();
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.inPatientDropdown);
        Driver.wait(1);
        Thread.sleep(1000);

        waitAndClick(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
        Driver.wait(1);
        Thread.sleep(1000);
        //  waitAndClick(myAppointmentPageAsDoctor.endDateRoom);
        int id=Integer.parseInt(myAppointmentPageAsDoctor.idBoxInPatient.getAttribute("value"));
        inpatient.setId(id);
        Select options=new Select( waitForVisibility(searchPatientOnStaffPage.statusDropdownCreateEditAppointment,1));
        options.selectByVisibleText("STAYING");
        Driver.wait(1);
        Thread.sleep(1000);
        Select rooms=new Select(myAppointmentPageAsDoctor.roomSelection);
//       rooms.selectByValue("5926");
        rooms.selectByIndex(4);
        Driver.wait(1);
        Thread.sleep(1000);
        clickWithJS(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);
    }

    @And("The doctor updates status inpatient as discharged")
    public void theDoctorUpdatesStatusInpatientAsDischarged() throws InterruptedException {
        Driver.wait(1);
        Thread.sleep(1000);
        getDriver().switchTo().window(doctorPage);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myInpatientsDropdown);
        Driver.wait(1);
        Thread.sleep(1000);
        clickWithJS(createOrEditARoomByAdminPage.editElements.get(createOrEditARoomByAdminPage.editElements.size()-1));
        Driver.wait(1);
        Thread.sleep(1000);

        Select options=new Select( waitForVisibility(searchPatientOnStaffPage.statusDropdownCreateEditAppointment,1));
        options.selectByVisibleText("DISCHARGED");
        inpatient.setStatus("DISCHARGED");

        Driver.wait(1);
        Thread.sleep(1000);
        clickWithJS(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);
    }

    @And("The staff views updated status and creates an invoice")
    public void theStaffViewsUpdatedStatusAndCreatesAnInvoice() throws InterruptedException {
        getDriver().switchTo().window(staffPage);
        Driver.wait(1);
        Thread.sleep(1000);
        getDriver().navigate().refresh();
        Driver.wait(1);
        Thread.sleep(1000);
//        waitAndClick(myAppointmentPageAsDoctor.myPagesDropdown);
//        waitAndClick(myAppointmentPageAsDoctor.myInpatientsDropdown);
        try{
            hover(myAppointmentPageAsDoctor.h3);
        }catch (Exception e){

        }
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.myPagesDropdown);
        waitAndClick(searchPatientOnStaffPage.searchPatientDropdown);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(searchPatientOnStaffPage.patientSSNSearchBox,getSSNIDs().get(getSSNIDs().size()-2));
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(searchPatientOnStaffPage.showAppointmentsButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.invoice);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.createInvoiceButton);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.saveButton);
        Driver.wait(2);
        Thread.sleep(2000);



    }

    @When("The patient views the invoice")
    public void thePatientViewsTheInvoice() throws InterruptedException {
        getDriver().switchTo().window(patientPage);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndClick(myAppointmentPageAsDoctor.patientMyPagesDropdown);
        waitAndClick(myAppointmentPageAsDoctor.myAppointment);
        waitAndSendText(myAppointmentPageAsDoctor.fromDateAppointment,createdDate);
        Driver.wait(1);
        Thread.sleep(1000);
        waitAndSendText(myAppointmentPageAsDoctor.toDateAppointment,createdDate);
        waitAndClick(myAppointmentPageAsDoctor.showInvoiceButton);
        Driver.wait(2);
        Thread.sleep(2000);
//        invoice=new Invoice(myAppointmentPageAsDoctor.invoiceDate.getText(),
//                myAppointmentPageAsDoctor.invoiceName.getText(),
//                myAppointmentPageAsDoctor.invoiceSsn.getText(),
//                myAppointmentPageAsDoctor.invoicePaymentMethod.getText(),
//                myAppointmentPageAsDoctor.invoiceTotalCost.getText().substring(0,3));
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
//        Driver.wait(2);
//        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(3);
        Thread.sleep(3000);

    }

    @Then("The patient has an heart attack")
    public void thePatientHasAnHeartAttack() {
    }

    @Then("validate the appointment with api and database")
    public void validateTheAppointmentWithApiAndDatabase() throws JsonProcessingException {

        response=getRequest(generateToken(ConfigurationReader.getProperty("doctor_username"),
                        ConfigurationReader.getProperty("doctor_password")),
                "https://medunna.com/api/appointments/bydateandId?fromDate=2022-05-"+createdDate.substring(0,2)+"&toDate=2022-05-"+createdDate.substring(0,2)+"&userId=10097");

//        response.then().statusCode(200).contentType(ContentType.JSON).body("id",equalTo(doctorAppointment.getId()),
//        "startDate",equalTo(doctorAppointment.getStartDate()),"endDate",equalTo(doctorAppointment.getEndDate()),
//        "status",equalTo(doctorAppointment.getStatus()));
        response.then().statusCode(200).contentType(ContentType.JSON);
        ObjectMapper obj=new ObjectMapper();
        DoctorAppointment[] actualData=obj.readValue(response.asString(), DoctorAppointment[].class);
//        assertEquals(doctorAppointment.getId(),json.getInt("id"));
//        assertEquals(doctorAppointment.getStartDate(),json.getString("startDate"));
//        assertEquals(doctorAppointment.getStatus(),json.getString("status"));
//        assertEquals(doctorAppointment.getEndDate(),json.getString("endDate"));
//response.prettyPrint();


        createConnection();
        String query="Select id, start_date, end_date, status from appointment where physician_id = 10501 and id = "+ doctorAppointment.getId();
        executeQuery(query);
        System.out.println("Actual appointment data from API: "+ Arrays.toString(actualData));
        System.out.println("Actual appointment data from DataBase: "+getRowMap(query));
        System.out.println("Expected appointment data: "+ doctorAppointment);


    }


    @Then("validate the room with api and database")
    public void validateTheRoomWithApiAndDatabase() throws JsonProcessingException {
        response=getRequest(generateToken(ConfigurationReader.getProperty("doctor_username"),
                        ConfigurationReader.getProperty("doctor_password")),
                "https://medunna.com/api/in-patients/"+inpatient.getId());
        System.out.println("https://medunna.com/api/in-patients/"+inpatient.getId());
        response.then().statusCode(200).contentType(ContentType.JSON);
//        body("id",equalTo(inpatient.getId()),
//                "appointment.id",equalTo(doctorAppointment.getId()),"appointment.endDate",equalTo(doctorAppointment.getEndDate()),
//                "appointment.startDate",equalTo(doctorAppointment.getStartDate()),
//                "appointment.status",equalTo(doctorAppointment.getStatus()),"status",equalTo(inpatient.getStatus()),"appointment.patient.user.ssn",equalTo(getSSNIDs().get(getSSNIDs().size()-2)));
//     JsonPath json=response.jsonPath();
//        assertEquals(inpatient.getId(),json.getInt("id"));
//        assertEquals(doctorAppointment.getId(),json.getInt("appointment.id"));
//        assertEquals(doctorAppointment.getStartDate(),json.getString("appointment.startDate"));
//        assertEquals(doctorAppointment.getStatus(),json.getString("appointment.status"));
//        assertEquals(doctorAppointment.getEndDate(),json.getString("appointment.endDate"));

        List<DoctorAppointment> doctorAppointmentList =new ArrayList<>();
        doctorAppointmentList.add(0, doctorAppointment);
        inpatient.setAppointment(doctorAppointmentList);

        JsonPath json=response.jsonPath();
        DoctorAppointment actualAppointment =new DoctorAppointment(json.getInt("appointment.id"), json.getString("appointment.startDate"), json.getString("appointment.endDate"), json.getString("appointment.status"));
        List<DoctorAppointment> actualAppointmentList =new ArrayList<>();
        actualAppointmentList.add(0, actualAppointment);
        Inpatient actualData=new Inpatient(json.getInt("id"), json.getString("status"),actualAppointmentList );


//        createConnection();
        java.lang.String query="Select id,appointment_id,status from in_patient where id = "+inpatient.getId();
     //   executeQuery(query);
        System.out.println("Actual inpatient data from API: "+ actualData );
        System.out.println("Actual inpatient data from DataBase: "+getRowMap(query));
        System.out.println("Expected inpatient data: "+inpatient);


    }

    @Then("validate the invoice with api and database")
    public void validateTheInvoiceWithApiAndDatabase() throws JsonProcessingException {
        response=getRequest(generateToken(ConfigurationReader.getProperty("staff_username"),
                        ConfigurationReader.getProperty("staff_password")),
                "https://medunna.com/api/bills/appointment/"+ doctorAppointment.getId());
//        response.then().statusCode(200).contentType(ContentType.JSON).body("billDate",equalTo(invoice.getBillDate()),
//                "appointment.id",equalTo(doctorAppointment.getId()),"appointment.endDate",equalTo(doctorAppointment.getEndDate()),
//                "appointment.startDate",equalTo(doctorAppointment.getStartDate()),
//                "appointment.status",equalTo(doctorAppointment.getStatus()),"ssn",equalTo(invoice.getSsn()),
//                "appointment.patient.user.ssn",equalTo(getSSNIDs().get(getSSNIDs().size()-2)),
//                "billName",equalTo(invoice.getBillName()),"paymentMethod",equalTo(invoice.getPaymentMethod()),
//                "totalCost",equalTo(Double.parseDouble(invoice.getTotalCost())));
//        ObjectMapper obj=new ObjectMapper();
//        Invoice[] actualData=obj.readValue(response.asString(),Invoice[].class);
        JsonPath json=response.jsonPath();
        Invoice actualData=new Invoice(json.getString("billDate"), json.getString("billName"), json.getString("ssn"), json.getString("paymentMethod"), json.getString("totalCost") );

//
//        response.prettyPrint();

//        createConnection();

        java.lang.String query="Select bill_date,ssn,bill_name,payment_method,total_cost from bill where appointment_id ="+ doctorAppointment.getId();
        executeQuery(query);
        System.out.println("Actual appointment data from API: "+actualData);
        System.out.println("Actual inpatient data from DataBase: "+getRowMap(query));
        System.out.println("Expected inpatient data: "+actualData);



        response=deleteRequest(generateToken(ConfigurationReader.getProperty("doctor_username"),
                        ConfigurationReader.getProperty("doctor_password")),
                "https://medunna.com/api/appointments/bydateandId?fromDate=2022-05-"+createdDate.substring(0,2)+"&toDate=2022-05-"+createdDate.substring(0,2)+"&userId=10097");

    }
}
