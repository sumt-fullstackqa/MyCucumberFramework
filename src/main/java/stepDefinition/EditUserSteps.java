package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EditUserPage;
import utility.ConfigProperties;

public class EditUserSteps {
	
	EditUserPage updateuser=new EditUserPage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to SDX portal with service proivder admin$")
		public void login_to_SDX_portal_with_service_provider_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the user management menu icon for SP$")
		public void click_on_the_user_management_menu_icon_for_SP() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.clickOnUserManagementmenu();
		}
		@And("^click on the 3 dotted menu icon for first user and click on edit link$")
		public void click_on_the_3_dotted_menu_icon_for_first_user_and_click_on_edit_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.clickonthreedottediconandeditlink();
		}
		
		@When("^clear and enter new valid emailaddress and clear and enter new firstname and clear and enter new middlename and clear and enter new lastname and clear and enter new phonenumber$")
		public void clear_and_enter_new_valid_emailaddress_and_clear_and_enter_new_firstname_and_clear_and_enter_new_middlename_and_clear_and_enter_new_lastname_and_clear_and_enter_new_phonenumber() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.userUpdatevalues(ConfigProperties.UPDATEEMAILADDRESS, ConfigProperties.UPDATEFIRSTNAME, ConfigProperties.UPDATEMIDDLENAME, ConfigProperties.UPDATELASTNAME, ConfigProperties.UPDATEPHONENUMBER);
		}
		@And("^select new county and select the new role$")
		public void select_new_country_and_select_the_new_role() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.userselectnewcountyandnewRole();
		}
		@And("^click on update button$")
		public void click_on_update_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.updateuser();
		}
		@Then("^success message should appear for user updated in application$")
		public void success_message_should_appear_for_user_updated_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updateuser.Successmessageforupdateuser();
	}
	}


