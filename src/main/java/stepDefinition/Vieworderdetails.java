package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.Vieworder;

public class Vieworderdetails {

	Vieworder vieworder = new Vieworder(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn with customer admin user$")
	public void login_to_seaborn_with_customer_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the manage orders icon and order list link$")
	public void click_on_the_manage_orders_icon_and_order_list_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		vieworder.clickOnManageordersandorderlist();
	}

	@And("^click on the 3dotted icon for first order from the list and click on view details$")
	public void click_on_the_3dotted_icon_for_first_order_from_the_list_and_click_on_view_details() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		vieworder.clickOnThreedottedandViewdetails();
	}
	
	@And("^click on previous button$")
	public void click_on_previous_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		vieworder.clickonpreviousbutton();
	}
	
	@Then("^user should be navigated back to order list page.\\.$")
	public void user_should_be_navigated_back_to_order_list_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
