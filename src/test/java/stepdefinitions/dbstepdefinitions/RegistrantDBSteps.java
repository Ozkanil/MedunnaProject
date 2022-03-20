package stepdefinitions.dbstepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static utilities.DBUtils.*;

public class   RegistrantDBSteps {

    @Given("user gets the {string} of registrant {string} from {string} table")
    public void user_gets_the_of_registrant_from_table(String column, String name, String table) {
        createConnection();
        String myDynamicQuery = "Select * from " + table + " where " + column + " = '" + name + "'";
        DBUtils.executeQuery(myDynamicQuery);
    }

    @Then("user validates {string} from {string} column")
    public void user_validates_o_from_column(String data, String column) throws SQLException {
        DBUtils.getResultset().next();
        Object columnData = DBUtils.getResultset().getObject(column);
        String actualData = (String) columnData;
        assertEquals(data, actualData);
        System.out.println(columnData);
        DBUtils.closeConnection();
    }


//    public static void main(String[] args) throws SQLException {
//        createConnection();
//        String myDynamicQuery = "Select * from jhi_user where first_name = 'Makeda'";
//        DBUtils.executeQuery(myDynamicQuery);
//                DBUtils.getResultset().next();
//        Object columnData = DBUtils.getResultset().getObject("ssn");
//
//        System.out.println(columnData);
//        DBUtils.closeConnection();
//
//    }

}
