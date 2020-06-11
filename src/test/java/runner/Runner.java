package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/feature" }, tags = {"@Addcompany,"+ "@Interconnect,"+ "@Inventory,"+ "@Library,"+ "@Location,"+ "@AddNewBillingAccount,"+ "@AddNewCustomeruser,"+ "@NetworkTemplate,"+ "@AddNewuser,"+ "@AddRack,"+ "@ApproveandRejectCustomer,"+ "@AssignPort,"+ "@AssignRoletoCustomeruser,"+ "@CustomerRequestPort,"+ "@CustomerUserResetPassword,"+ "@DeactivateandActivateCustomerUser,"+ "@DeactivateandActivateUser,"+ "@EditCompany,"+ "@EditCustomerUser,"+ "@Edituser,"+ "@Exportfile,"+ "@LoginandLogout,"+ "@PortandElan,"+ "@PortandEline,"+ "@PortandETree,"+ "@RaiseNewTicket,"+ "@editticket,"+ "@Reopenclosedticket,"+ "@UserResetPassword,"+ "@viewnetworks,"+ "@Viewcompanydetails,"+ "@vieworderwithcustomer,"+ "@ViewTicketdetails,"+ "@ViewTicketReports"},
                               glue = {"stepDefinition"},
                               plugin = { "html:target/reports/cucumber-preety","json:target/cucumber.json",
                            		       "com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html",  }, 

                               monochrome = true, dryRun = false)

public class Runner {
	
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("src//test//resources/extent-config.xml"));
    }  

}
