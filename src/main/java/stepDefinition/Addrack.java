package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addinventoryrack;
import utility.ConfigProperties;

public class Addrack {

	Addinventoryrack addrack = new Addinventoryrack(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn application with service provider admin user$")
	public void login_to_seaborn_application_with_service_provider_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the inventory management menu and Rack link$")
	public void click_on_the_inventory_management_menu_and_Rack_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addrack.clickOnInventorymanagementandRack();
	}

	@And("^click on the Add Rack button$")
	public void click_on_the_Add_Rack_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addrack.clickonaddrack();
	}

	@And("^select Rack type and select Manufacturer name and select location$")
	public void select_Rack_type_and_select_Manufacturer_name_and_select_location() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addrack.AddRackselectracktypeandManufacturernameandLocation();
	}

	@When("^enter model name and size and notes$")
	public void enter_model_name_and_size_and_notes() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addrack.addrackSelectvalues(ConfigProperties.SIZE, ConfigProperties.RACKNOTES);
	}

	@And("^click on save button for Add Rack form$")
	public void click_on_save_button_for_Add_Rack_form() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addrack.addnewrack();

	}

	@Then("^success message should be shown on the pages\\.$")
	public void success_message_should_be_displayed_on_the_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
