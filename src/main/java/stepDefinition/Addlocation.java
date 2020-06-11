package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addinventorylocation;
import utility.ConfigProperties;

public class Addlocation{

	Addinventorylocation addlocation = new Addinventorylocation(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to portal with service provider admin user$")
	public void login_to_portal_with_service_provider_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the inventory management menu and Location link$")
	public void click_on_the_inventory_management_menu_and_Location_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlocation.clickOnInventorymanagementandLocation();
	}

	@And("^click on the Add New Location button$")
	public void click_on_the_Add_New_Location_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlocation.clickonaddnewlocation();
	}

	@And("^select Country and select State and select City$")
	public void select_Country_and_select_State_and_select_City() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	addlocation.AddNewLocationselectcountryandselectStateandselectCity();
	}

	@When("^enter Location Name and Location code and Address and othercity name and Zip code$")
	public void enter_Location_Name_and_Location_code_and_Address_and_othercity_name_and_Zip_code() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlocation.addnewlocationSelectvalues(ConfigProperties.LOCATIONNAME, ConfigProperties.LOCATIONCODE, ConfigProperties.LOCATIONADDRESS, ConfigProperties.OTHERCITY, ConfigProperties.LOCATIONZIPCODE);
	}

	@And("^click on Save button for New Location form$")
	public void click_on_Save_button_for_New_Location_form() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	  addlocation.addnewlocation();
	}
	
	@Then("^success message should be shown for new Location added in application\\.$")
	public void success_message_should_be_shown_for_new_Location_added_in_application() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
