package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {

    @Before
    public void setUp(){
//Driver.wait(1);

    }


    public static RequestSpecification spec;


    @Before(value = "@ApiRegistrant")
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshots");
        }
//         Driver.closeDriver();
        Driver.wait(1);
       // Driver.closeDriver();
    }

    @Before(order = 1, value = "@user_register")
    public void navigateToRegistrationPage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_registration_url"));

    }
@Before(order=1,value="@SignIn_Page")
    public void navigateToLoginPage(){
    Driver.getDriver().get(ConfigurationReader.getProperty("medunna_signin_url"));

}
    @Before(order = 1, value = "@user_login_positive")
    public void navigateToHomePage(){

        Driver.getDriver().get(ConfigurationReader.getProperty("medunna_url"));

    }

}

