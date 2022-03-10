package Hooks;

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
        Driver.wait(5);
        Driver.closeDriver();
    }
    public static RequestSpecification spec;

    @Before( value = "@ApiRegistrant")
    public void setup(){

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("base_url")).build();


    }
    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshots");
        }
     //  Driver.getDriver().close();
    }

}
