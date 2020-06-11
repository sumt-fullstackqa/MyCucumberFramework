package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addnewticketwithcustomer;
import utility.ConfigProperties;

public class Raisenewticketwithcustomer {
	
	Addnewticketwithcustomer addcustomerticket=new Addnewticketwithcustomer(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to seaborn application with customer admin$")
		public void login_to_seaborn_application_with_customer_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the tickets menu icon$")
		public void click_on_the_tickets_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.clickOnAddNewticketwithcustomer();
		}
		@And("^click on the raise ticket button$")
		public void click_on_the_raise_ticket_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.clickonRaiseticketbutton();
		}
		
		@When("^enter valid ticketname and description$")
		public void enter_valid_ticketname_and_description() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.customerticketSelectvalues(ConfigProperties.DESCRIPTION );
		}
		@And("^select Ticketfor$")
		public void select_Ticketfor() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.customerticketselectticketfor();
		}
		@And("^click yes for Is your service down radio button$")
		public void click_yes_for_Is_your_service_down_radio_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.isyourservicedown();
		}
		@And("^click on select files and add attachment$")
		public void click_on_select_files_and_add_attachments() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.addattachment();
		}
		@And("^click on save button for this form$")
		public void click_on_save_button_for_this_form() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomerticket.createnewcustomerticket();	
		}
		
		@Then("^success message should be shown\\.$")
		public void success_message_should_be_shown() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


