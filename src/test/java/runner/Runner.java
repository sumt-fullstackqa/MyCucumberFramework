package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/feature" }, 
        glue = {"stepDefinition"},
        monochrome = true,
        plugin = { "html:target/reports/cucumber-preety","json:target/cucumber.json",
                   "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html",  }, 
        tags = {"@Addcompany,"+ "@Interconnect"}
 )

public class Runner {
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src//test//resources/extent-config.xml"));
    }  

}
