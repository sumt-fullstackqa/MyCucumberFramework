/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ViewBandwidthOnDemandPage;

/**
 * @author ankur.bhardwaj
 *
 */
public class ViewBandwidthonDemandSteps {
	
	ViewBandwidthOnDemandPage viewbandwidthpage = new ViewBandwidthOnDemandPage(TestBase.driver);

	@Given("^click on the service Management$")
	public void click_on_the_service_Management() throws Throwable {
		viewbandwidthpage.clickOnserviceManagement();
	}

	@When("^I click on services name Bandwidth on Demand$")
	public void i_click_on_services_name_Bandwidth_on_Demand() throws Throwable {
		viewbandwidthpage.clickOnBandwidthondemandlink();
	}

	@Then("^I validate it navigates to bandwidth on demand screen$")
	public void i_validate_it_navigates_to_bandwidth_on_demand_screen() throws Throwable {
	
	}

	@When("^I click on Networks$")
	public void i_click_on_Networks() throws Throwable {
		viewbandwidthpage.clickOnNetwork();
	}

	@When("^click on view networks$")
	public void click_on_view_networks() throws Throwable {
		viewbandwidthpage.viewserviceDetails();
	}

	@Then("^service details should open$")
	public void service_details_should_open() throws Throwable {
	    
	}

	@Then("^details should displayed on screen$")
	public void details_should_displayed_on_screen() throws Throwable {
	   
	}

}
