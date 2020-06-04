package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages.UserResetPasswordPage;
import utility.ConfigProperties;


public class UserResetPasswordSteps {
	
	UserResetPasswordPage resetpassworduser=new UserResetPasswordPage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to SDX with service provider admin$")
		public void login_to_SDX_with_service_provider_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the user management menu icon for service provider admin login$")
		public void click_on_the_user_management_menu_icon_for_service_provider_admin_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			
			resetpassworduser.clickOnUserManagementmenu();
		}
		@And("^click on the 3 dotted icon for first user from the list and click on Reset Password link$")
		public void click_on_the_3_dotted_icon_for_first_user_from_the_list_and_click_on_Reset_Password_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpassworduser.clickonthreedottediconandresetpasswordlinkforuser();
		}
		@When("^enter New password and Confirm Password for user$")
		public void enter_New_Password_and_Confirm_Password_for_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpassworduser.userresetpasswordSelectvalues(ConfigProperties.NEWPASSWORD, ConfigProperties.CONFIRMPASSWORD);
		}
		@And("^click on ok button for Reset Password pop up for user$")
		public void click_on_ok_button_for_Reset_Password_pop_up_for_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpassworduser.clickonokbuttonforresetpasswordforuser();
		}
		@Then("^success message should appear for Password Reset for that user$")
		public void success_message_should_appear_for_Password_Reset_for_that_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpassworduser.Successmessageforresetpassworduser();
	}
	}



