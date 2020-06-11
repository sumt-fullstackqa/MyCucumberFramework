package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.DeactivateandActivateUserPage;


public class DeactivateandActivateusersteps {
	
	DeactivateandActivateUserPage deactivateandactivateuser=new DeactivateandActivateUserPage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with service provider admin credentials to the seaborn portal$")
		public void login_with_service_provider_admin_credentials_to_the_seaborn_portal() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on user management menu icon with SP login$")
		public void click_on_user_management_menu_icon_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickOnUserManagementmenu();
		}
		@And("^click on the 3 dotted icon for first customer from the list and click on deactivate link with SP login$")
		public void click_on_the_3_dotted_icon_for_first_customer_from_the_list_and_click_on_deactivate_link_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickonthreedottediconanddeactivatebuttonforuser();
		}
		@And("^click on ok button for confirmation pop up with SP login$")
		public void click_on_ok_button_for_confirmation_pop_up_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickonokbuttonfordeactivateuser();
		}
		@And("^Success message should appear for the user deactivated by SP login$")
		public void success_message_should_appear_for_the_user_deactivated() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.Successmessagefordeactivateuser();
		}
		@And("^click on status filter and click on inactive radio button and click on filter button with SP login$")
		public void click_on_status_filter_and_click_on_inactive_radio_button_and_click_on_filter_button_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickonstatusfilterandinactiveandfilterbuttonforuser();
		}
		@And("^click on the 3 dotted icon for deactivated user in the list and click on Activate link with SP login$")
		public void click_on_the_3_dotted_icon_for_deactivated_user_in_the_list_and_click_on_Activate_link_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickonthreedottediconandactivatebuttonforuser();
		}
		@And("^click on ok button for confimation pop up of activate user with SP login$")
		public void click_on_ok_button_for_confirmation_pop_up_of_activate_user_with_SP_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.clickonokbuttonforactivateuser();
		}
		@Then("^success message should appear for user activated in application$")
		public void success_message_should_appear_for_user_activated_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			deactivateandactivateuser.Successmessageforactivateuser();
	}
	}


