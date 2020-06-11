package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addinventoryinterconnect;
import utility.ConfigProperties;

public class Addinterconnect{

	Addinventoryinterconnect addinterconnect = new Addinventoryinterconnect(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn app with service provider admin user$")
	public void login_to_seaborn_app_with_service_provider_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the inventory management menu and Interconnect link$")
	public void click_on_the_inventory_management_menu_and_Interconnect_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinterconnect.clickOnInventorymanagementandInterconnect();
	}

	@And("^click on the Add Interconnect button$")
	public void click_on_the_Add_Interconnect_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinterconnect.clickonaddinterconnect();
	}

	@And("^select Source Device and select Destination Device and select Source port and select Destination port$")
	public void select_Source_Device_and_select_Destination_Device_and_select_Source_port_and_select_Destination_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	addinterconnect.AddInterconnectselectSourcedeviceandselectDestinationdeviceandselectSourceportandselectDestinationport();
	}

	@When("^enter Interconnect ID and Circuit ID and Description$")
	public void enter_Interconnect_ID_and_Circuit_ID_and_Description() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinterconnect.addinterconnectSelectvalues(ConfigProperties.INTERCONNECTDESCRIPTION);
	}

	@And("^click on Save button for interconnect form$")
	public void click_on_Save_button_for_interconnect_form() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinterconnect.addnewinterconnect();
	}
	
	@Then("^success message should be shown for interconnect added in application\\.$")
	public void success_message_should_be_shown_for_interconnect_added_in_application() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
