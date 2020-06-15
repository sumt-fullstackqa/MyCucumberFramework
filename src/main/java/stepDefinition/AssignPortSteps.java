package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AssignPortPage;
import utility.ConfigProperties;

public class AssignPortSteps{

	AssignPortPage assignport = new AssignPortPage(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to SDX  app with service provider admin$")
	public void login_to_SDX_app_with_service_provider_admin() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}
	@And("^click on the inventory management menu and manage port link$")
	public void click_on_the_inventory_management_menu_and_manage_port_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assignport.clickOnInventorymanagementandManagePort();
	}
	@And("^click on the 3 dotted icon for first company from the list and click on Assign Port link$")
	public void click_on_the_3_dotted_icon_for_first_company_from_the_list_and_click_on_Assign_Port_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assignport.clickonthreedottediconandassignportlink();
	}
	@And("^select location and select Inventory and select port and select Billing account$")
	public void select_Country_and_select_State_and_select_City() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	assignport.AssignPortselectlocationandinventoryandportandbillingaccount();
	
	}
	@When("^enter Port display name for assign port$")
	public void enter_Port_display_name_for_assign_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assignport.AssignportSelectvalues();
	}
	@And("^click on add button$")
	public void click_on_add_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	  assignport.clickonaddbutton();
	}
	@And("^click on checkbox for the added value$")
	public void click_on_checkbox_for_the_added_value() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	  assignport.clickonaddedvaluecheckboxinassignedportlist();
	}
	@And("^clcik on Assign button$")
	public void click_on_Assign_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	  assignport.clickonassignbuttonforport();
	  
	}
	@Then("^success message should appear for assigned port to the company$")
	public void success_message_should_appear_for_assigned_port_to_the_company() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		assignport.Successmessageforassignedport();
	}
}

