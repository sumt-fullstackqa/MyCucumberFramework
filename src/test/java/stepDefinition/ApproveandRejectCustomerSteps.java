package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ApproveandRejectCustomerPage;
import utility.ConfigProperties;

public class ApproveandRejectCustomerSteps {

	ApproveandRejectCustomerPage approveandrejectcustomer = new ApproveandRejectCustomerPage(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login with service provider admin credentials to the SDX portal$")
	public void login_with_service_provider_admin_credentials_to_the_SDX_portal() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the 3 dotted icon for pending customer from the list and click on Reject link$")
	public void click_on_the_3_dotted_icon_for_pending_customer_from_the_list_and_click_on_Reject_link()
			throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.clickonthreedottediconandrejectlink();
	}

	@When("^enter reason for reject$")
	public void enter_reason_for_reject() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.rejectcustomerreason(ConfigProperties.REJECTREASON);
	}

	@And("^click on Save button for reject customer$")
	public void click_on_save_button_for_reject_customer() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.clickonsavebuttonforrejectcustomer();
	}

	@And("^Success message should appear for the customer rejected by SP login$")
	public void success_message_should_appear_for_the_customer_rejected_by_SP_login() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.Successmessageforrejectcustomer();
	}

	@And("^click on status filter and enter Rejected in filter field and click on filter button$")
	public void click_on_status_filter_and_enter_Rejected_in_filter_field_and_click_on_filter_button()
			throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.clickonstatusfilterandfilterrejectedcustomers(ConfigProperties.FILTERFIELD);
	}

	@And("^click on the 3 dotted icon for rejected user in the list and click on Approve link$")
	public void click_on_the_3_dotted_icon_for_rejected_user_in_the_list_and_click_on_Approve_link() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.clickonthreedottediconandapprovelink();
	}

	@And("^click on create new and approve button$")
	public void click_on_create_new_and_approve_button() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.clickoncreatenewandapprovebutton();
	}

	@Then("^success message should appear for user approved in application$")
	public void success_message_should_appear_for_user_approved_in_application() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		approveandrejectcustomer.Successmessageforapproveuser();
	}
}
