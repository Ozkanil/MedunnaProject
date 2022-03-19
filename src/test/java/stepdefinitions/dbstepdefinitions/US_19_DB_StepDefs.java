package stepdefinitions.dbstepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.createConnection;
import static utilities.DBUtils.getColumnData;

public class US_19_DB_StepDefs {

    List<Object> staffDB= new ArrayList<>();
    @Given("user connects to the Staff database")
    public void user_connects_to_the_staff_database() {

        createConnection();
    }
    @Given("user selects all Staff {string} column data")
    public void user_selects_all_staff_column_data(String id) {
        staffDB = getColumnData("select * from staff", id);
        System.out.println(staffDB);
    }
    @Given("user verify Staff {string} with the database")
    public void user_verify_staff_with_the_database(String id) {
        assertTrue(staffDB.toString().contains(id));
    }
    @Then("close the connection")
    public void close_the_connection() {

    }
}
