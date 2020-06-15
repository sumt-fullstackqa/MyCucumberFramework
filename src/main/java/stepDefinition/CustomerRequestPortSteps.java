package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CustomerRequestPortPage;
import utility.ConfigProperties;

public class CustomerRequestPortSteps {
	
	CustomerRequestPortPage requestport=new CustomerRequestPortPage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with customer admin to the SDX portal$")
		public void login_with_customer_admin_to_the_SDX_portal() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the Assigned port menu icon$")
		public void click_on_the_Assigned_port_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			requestport.clickOnAssignedPortmenu();
		}
		@And("^click on the Request port button$")
		public void click_on_the_Request_port_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			requestport.clickonrequestportbutton();
		}
		@And("^select Location and Port type and Billing account$")
		public void select_Location_and_Port_type_and_Billing_account() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			requestport.requestportselectlocationandPorttypeandBillingaccount();
		}
		
		@When("^enter port display name$")
		public void enter_port_display_name() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			requestport.requestportSelectvalues();
		}
		
		@And("^click on the save button for requesting port$")
		public void click_on_the_save_button_for_requesting_port() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			requestport.requestport();
		}
		@Then("^success message should appear for new port request$")
		public void success_message_should_appear_on_the_page_that_order_has_been_confirmed_for_ETree() throws Exception {
			// Write code here that turns the phrase above into concrete actions
			requestport.Successmessageforrequestport();
	}
	}


