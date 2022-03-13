package stepdefinitions.dbstepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.*;

public class DoctorAppointmentStepdefs {
    @Given("user connects to the Database")
    public void user_connects_to_the_database() {
        createConnection();
    }


    @When("user gets {string} from the {string} table for {string}")
    public void userGetsFromTheTableFor(String arg0, String arg1, String arg2) {
        String query="Select "+arg0+" from "+arg1+" where "+ arg2;
        executeQuery(query);
    }



    @And("user verify that the data includes {int}, {string}, {string} and {string}")
    public void userVerifyThatTheDataIncludesIdAnd(int i2,String arg0, String arg1, String arg2) throws Exception {
        for (int i=0; i<getRowCount();i++) {

            getResultset().getRow();
            if (getResultset().getObject(1).equals(i2)) {
                assertEquals(arg0, getResultset().getObject(2).toString());
                assertEquals(arg1, getResultset().getObject(3).toString());
                assertEquals(arg2, getResultset().getObject(4));
            } else {
                getResultset().next();
            }
        }
    }

    @Then("user close the database connection")
    public void userCloseTheDatabaseConnection() {
    }



}
