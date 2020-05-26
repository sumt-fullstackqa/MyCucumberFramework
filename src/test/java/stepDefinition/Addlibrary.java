package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addinventorylibrary;
import utility.ConfigProperties;

public class Addlibrary {

	Addinventorylibrary addlibrary = new Addinventorylibrary(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn application with service provider admin$")
	public void login_to_seaborn_application_with_service_provider_admin() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the inventory management menu and Library link$")
	public void click_on_the_inventory_management_menu_and_Library_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlibrary.clickOnInventorymanagementandLibrary();
	}

	@And("^click on the Add library button$")
	public void click_on_the_Add_library_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlibrary.clickonaddlibrary();
	}

	@And("^select device type and select Manufacturer name$")
	public void select_device_type_and_select_Manufacturer_name() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlibrary.Addlibraryselectdevicetypeandmanufacturername();
	}

	@When("^enter device model and notes and rack size$")
	public void enter_device_model_and_notes_and_rack_size() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlibrary.addlibrarySelectvalues(ConfigProperties.DEVICEMODEL, ConfigProperties.NOTES, ConfigProperties.RACKINSTALLATIONUNITSIZE);
	}

	@And("^click on save button for Add library form$")
	public void click_on_save_button_for_Add_library_form() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addlibrary.addnewlibrary();

	}

	@Then("^success message should be displayed on the page\\.$")
	public void success_message_should_be_displayed_on_the_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
