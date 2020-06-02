package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PortandETreeorderpage;
import utility.ConfigProperties;

public class PlaceorderPortandETree {

	PortandETreeorderpage placeorderetree = new PortandETreeorderpage(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to SDX Portal app with customer admin$")
	public void login_to_SDX_Portal_app_with_customer_admin() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the manage orders icon and place an order sub menu$")
	public void click_on_the_manage_orders_icon_and_place_an_order_sub_menu() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickOnManageordersandPlaceanordersubmenuforetree();
	}

	@And("^click on the 3dotted icon for  Ethernet U.N.I. Port and Add button link$")
	public void click_on_the_3dotted_icon_for_Ethernet_UNI_Port_and_Add_button_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickOnThreedottedandAddbuttonforetree();
	}

	@And("^select Location and select porttype and select capacity for UNI port$")
	public void select_Location_and_select_porttype_and_select_capacity_for_UNI_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.uniportselectvaluesforlocationportandcapacityetree();
	}

	@When("^enter valid portdisplayname and valid duration value for UNI port$")
	public void enter_valid_portdisplayname_and_valid_duration_value_for_UNI_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.uniportEntervaluesetree(ConfigProperties.PORTDISPLAYNAMEFORETREE,
				ConfigProperties.DURATIONPORTFORETREE);
	}

	@And("^click on Add to cart button for adding UNI Port to the cart$")
	public void click_on_Add_to_cart_button_for_adding_UNI_port_to_the_cart() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickonadduniporttocartetree();

	}

	@And("^click on ETree section$")
	public void click_on_Eline_section() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickonetreesection();

	}

	@When("^enter valid ETreename and duration$")
	public void enter_valid_eTreename_and_duration() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.etreeSelectvalues(ConfigProperties.TREENAME, ConfigProperties.DURATIONETREE);
	}

	@And("^select Latency protection Class Bandwidth and select Source port and select Destination location and select Destination Port$")
	public void select_Latency_Protection_Class_Bandwidth_and_select_Source_port_and_select_Destination_location_and_select_Destination_Port()
			throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.etreeselectlatencyprotectionclassbandwidthandport();
	}

	@And("^click on Add to cart button for Etree$")
	public void click_on_Add_to_cart_button_for_Etree() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.addetreetocart();

	}

	@And("^click on cart and place order button$")
	public void click_on_cart_and_place_order_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickOnCartmainmenubuttonandPlaceorderbuttonetree();
	}

	@When("^enter valid Poreference and CommentsSpecialInstruction value for ETree$")
	public void enter_valid_Poreference_and_CommentsSpecialInstruction_value_for_ETree() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.referenceandcommentsEntertvaluesetree(ConfigProperties.POREFERENCEIDETREE,
				ConfigProperties.COMMENTSSPECIALINSTRUCTIONETREE);
	}

	@And("^select primary contact 247 contact and select technical contact for ETree$")
	public void select_primary_contact_247_contact_and_select_technical_contact_for_ETree() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.orderselectprimarycontact247contactandtechnicalcontactEtreeorder();
	}

	@And("^click on next button and click on confirm order button for ETree$")
	public void click_on_next_button_and_click_on_confirm_order_button_for_ETree() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.clickOnNextbuttonandConfirmorderbuttonforetree();
	}

	@Then("^success message should appear on the page that order has been confirmed for ETree$")
	public void success_message_should_appear_on_the_page_that_order_has_been_confirmed_for_ETree() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorderetree.Successmessageforetreeorder();
	}
}
