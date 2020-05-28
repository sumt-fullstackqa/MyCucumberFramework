package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import pages.CustomerUserResetPasswordpage;
import utility.ConfigProperties;


public class CustomerUserResetPasswordSteps {
	
	CustomerUserResetPasswordpage resetpasswordcustomeruser=new CustomerUserResetPasswordpage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to SDX with customer admin$")
		public void login_to_SDX_with_customer_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the user management menu icon for customer admin login$")
		public void click_on_the_user_management_menu_icon_for_customer_admin_login() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			
			resetpasswordcustomeruser.clickOnCustomerUserManagementmenu();
		}
		@And("^click on the 3 dotted icon for first customer from the list and click on Reset Password link$")
		public void click_on_the_3_dotted_icon_for_first_customer_from_the_list_and_click_on_Reset_Password_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpasswordcustomeruser.clickonthreedottediconandresetpasswordlink();
		}
		@When("^enter New password and Confirm Password$")
		public void enter_New_Password_and_Confirm_Password() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpasswordcustomeruser.customeruserresetpasswordSelectvalues(ConfigProperties.NEWPASSWORD, ConfigProperties.CONFIRMPASSWORD);
		}
		@And("^click on ok button for Reset Password pop up$")
		public void click_on_ok_button_for_Reset_Password_pop_up() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpasswordcustomeruser.clickonokbuttonforresetpassword();
		}
		@Then("^success message should appear for Password Reset for that customer user$")
		public void success_message_should_appear_for_customer_user_activated_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			resetpasswordcustomeruser.Successmessageforresetpasswordcustomeruser();
	}
	}


