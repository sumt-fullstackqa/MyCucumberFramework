package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.DeactivateandActivateCustomeruserpage;


public class DeactivateandActivateCustomerusersteps {
	
	DeactivateandActivateCustomeruserpage deactivateandactivatecustomeruser=new DeactivateandActivateCustomeruserpage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with customer credentials to the seaborn portal$")
		public void login_with_customer_credentials_to_the_seaborn_portal() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on user management menu icon$")
		public void click_on_user_management_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickOnCustomerUserManagementmenu();
		}
		@And("^click on the 3 dotted icon for first customer from the list and click on deactivate link$")
		public void click_on_the_3_dotted_icon_for_first_customer_from_the_list_and_click_on_deactivate_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickonthreedottediconanddeactivatebutton();
		}
		@And("^click on ok button for confirmation pop up$")
		public void click_on_ok_button_for_confirmation_pop_up() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickonokbuttonfordeactivate();
		}
		@And("^Success message should appear for the user deactivated$")
		public void success_message_should_appear_for_the_user_deactivated() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.Successmessagefordeactivatecustomeruser();
		}
		@And("^click on status filter and click on inactive radio button and click on filter button$")
		public void click_on_status_filter_and_click_on_inactive_radio_button_and_click_on_filter_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickonstatusfilterandinactiveandfilterbutton();
		}
		@And("^click on the 3 dotted icon for deactivated customer in the list and click on Activate link$")
		public void click_on_the_3_dotted_icon_for_deactivated_customer_in_the_list_and_click_on_Activate_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickonthreedottediconandactivatebutton();
		}
		@And("^click on ok button for confimation pop up of activate user$")
		public void click_on_ok_button_for_confirmation_pop_up_of_activate_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.clickonokbuttonforactivate();
		}
		@Then("^success message should appear for customer user activated in application$")
		public void success_message_should_appear_for_customer_user_activated_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivatecustomeruser.Successmessageforactivatecustomeruser();
	}
	}


