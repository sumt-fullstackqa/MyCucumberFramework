package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Portandelineorderpage;
import utility.ConfigProperties;

public class PlaceorderPortandEline {

	Portandelineorderpage placeordereline = new Portandelineorderpage(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to SDX Portal with customer admin$")
	public void login_to_SDX_Portal_with_customer_admin() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the manage orders icon and place an order$")
	public void click_on_the_manage_orders_icon_and_place_an_order() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickOnManageordersandPlaceanordersubmenu();
	}

	@And("^click on the 3dotted icon for  Ethernet U.N.I. Port and sub menu Add button$")
	public void click_on_the_3dotted_icon_for_Ethernet_UNI_Port_and_sub_menu_Add_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickOnThreedottedandAddbuttonforuniport();
	}

	@And("^select Location and select porttype and select capacity$")
	public void select_Location_and_select_porttype_and_select_capacity() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.uniportselectvaluesforlocationportandcapacity();
	}

	@When("^enter valid portdisplayname and valid duration value$")
	public void enter_valid_portdisplayname_and_valid_duration_value() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.uniportEntervalues(ConfigProperties.DURATIONPORTFORELINE);
	}

	@And("^click on Add to cart button for adding UNI Port$")
	public void click_on_Add_to_cart_button_for_adding_UNI_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickonadduniporttocart();

	}
	@And("^click on Eline section$")
	public void click_on_Eline_section() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickonelinesection();

	}
	@When("^enter valid elinename and duration$")
	public void enter_valid_elanname_and_duration() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.elineSelectvalues(ConfigProperties.DURATIONELINE);
	}

	@And("^select Latency protection Class Bandwidth and Source port and select Destination location and select Destination Port$")
	public void select_Latency_Protection_Class_Bandwidth_and_Source_port_and_select_Destination_location_and_select_Destination_Port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.elineselectlatencyprotectionclassbandwidthandport();
	}

	@And("^click on Add to cart button for eline$")
	public void click_on_Add_to_cart_button_for_eline() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.addelinetocart();

	}

	@And("^click on cart menu icon and place order button$")
	public void click_on_cart_menu_icon_and_place_order_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickOnCartmainmenubuttonandPlaceorderbutton();
	}

	@When("^enter valid Poreference and CommentsSpecialInstruction value$")
	public void enter_valid_Poreference_and_CommentsSpecialInstruction_value() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.referenceandcommentsEntertvalues(ConfigProperties.POREFERENCEIDELINE,
				ConfigProperties.COMMENTSSPECIALINSTRUCTIONELINE);
	}

	@And("select primary contact 247 contact and select technical contact$")
	public void select_primary_contact_247_contact_and_select_technical_contact() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.orderselectprimarycontact247contactandtechnicalcontactElineorder();
	}

	@And("^click on next button and click on confirm order button$")
	public void click_on_next_button_and_click_on_confirm_order_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeordereline.clickOnNextbuttonandConfirmorderbuttonforeline();
	}

	@Then("^success message should appear on the page that order has been confirmed$")
	public void success_message_should_appear_on_the_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		
		placeordereline.Successmessageforelineorder();
	}
}
