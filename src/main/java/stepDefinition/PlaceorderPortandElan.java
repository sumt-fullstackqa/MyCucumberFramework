package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Portandelanorder;
import utility.ConfigProperties;

public class PlaceorderPortandElan {

	Portandelanorder placeorder = new Portandelanorder(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn app with customer admin$")
	public void login_to_seaborn_app_with_customer_admin() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the manage orders icon and place an order link$")
	public void click_on_the_manage_orders_icon_and_place_an_order_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.clickOnManageordersandPlaceanorder();
	}

	@And("^click on the 3dotted icon for  Ethernet U.N.I. Port and Add button$")
	public void click_on_the_3dotted_icon_for_Ethernet_UNI_Port_and_Add_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.clickOnThreedottedandAddbutton();
	}

	@And("^select Location porttype and capacity$")
	public void select_Location_porttype_and_capacity() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.uniportselectlocationportandcapacity();
	}

	@When("^enter valid portdisplayname and duration$")
	public void enter_valid_portdisplayname_and_duration() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.uniportSelectvalues(ConfigProperties.DURATIONPORT);
	}

	@And("^click on Add to cart button$")
	public void click_on_Add_to_cart_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.adduniporttocart();

	}

	@When("^enter valid elanname and duration$")
	public void enter_valid_elanname_and_duration() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.elanSelectvalues(ConfigProperties.DURATIONELAN);
	}

	@And("^select Latency protection Class Bandwidth and port$")
	public void select_Latency_Protection_Class_Bandwidth_and_port() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.elanselectlatencyprotectionclassbandwidthandport();
	}

	@And("^click on Add to cart button for elan$")
	public void click_on_Add_to_cart_button_for_elan() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.addelantocart();

	}

	@And("^click on cart menu and place order button$")
	public void click_on_cart_menu_and_place_order_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.clickOnCartmainbuttonandPlaceorderbutton();
	}

	@When("^enter valid Poreference and CommentsSpecialInstruction$")
	public void enter_valid_Poreference_and_CommentsSpecialInstruction() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.referenceandcommentsSelectvalues(ConfigProperties.POREFERENCEID,
				ConfigProperties.COMMENTSSPECIALINSTRUCTION);
	}

	@And("^select primary contact 247 contact and technical contact$")
	public void select_primary_contact_247_contact_and_technical_contact() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.orderselectprimarycontact247contactandtechnicalcontact();
	}

	@And("^click on next button and confirm order button$")
	public void click_on_next_button_and_confirm_order_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		placeorder.clickOnNextbuttonandConfirmorderbutton();
	}

	@Then("^success message should appear on the page\\.$")
	public void success_message_should_appear_on_the_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
