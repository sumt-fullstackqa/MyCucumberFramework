package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addinventorypage;
import utility.ConfigProperties;

public class Addinventory{

	Addinventorypage addinventory = new Addinventorypage(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn with service provider admin user$")
	public void login_to_seaborn_with_service_provider_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the inventory management menu and Inventory link$")
	public void click_on_the_inventory_management_menu_and_Inventory_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.clickOnInventorymanagementandInventory();
	}

	@And("^click on the Add Inventory button$")
	public void click_on_the_Add_Inventory_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.clickonaddinventory();
	}

	@And("^select Device Model and select Location and select Vlan Start Range and select Vlan End Range and select Rack and select rack start unit$")
	public void select_Device_Model_and_select_Location_and_select_Vlan_Start_Range_and_select_Vlan_End_Range_and_select_Rack_and_select_rack_start_unit() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.AddInventoryselectDeviceModelandselectLocationandselectVlanStartRangeandselectVlanEndRangeandselectRackandselectrackstartunit();
	}

	@When("^enter Device name and inventory ID and serial number and IPAddress and Inventorynotes and inventory status$")
	public void enter_Device_name_and_inventory_ID_and_serial_number_and_IPAddress_and_Inventorynotes_and_inventory_status() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.addinventorySelectvalues(ConfigProperties.IPADDRESS, ConfigProperties.INVENTORYNOTES, ConfigProperties.INVENTORYSTATUS);
	}

	@And("^click on Device for LOA$")
	public void click_on_Device_for_LOA() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.clickonDeviceforLOA();

	}

	@And("^click on Save button$")
	public void click_on_Save_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		addinventory.addnewinventory();
	}
	
	@Then("^success message should be shown for inventory added in application\\.$")
	public void success_message_should_be_displayed_on_the_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
