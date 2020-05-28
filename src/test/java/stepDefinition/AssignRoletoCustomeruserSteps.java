package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.AssignRoletoCustomeruserpage;


public class AssignRoletoCustomeruserSteps {
	
	AssignRoletoCustomeruserpage assignroletocustomeruser=new AssignRoletoCustomeruserpage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to SDX portal with customer admin$")
		public void login_to_SDX_portal_with_customer_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the user management menu icon for customer admin$")
		public void click_on_the_user_management_menu_icon_for_customer_admin() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.clickOnCustomerUserManagementmenuforcustomeradmin();
		}
		@And("^click on the 3 dotted icon for first customer from the list and click on Assign Roles link$")
		public void click_on_the_3_dotted_icon_for_first_customer_from_the_list_and_click_on_Assign_Roles_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.clickonthreedottediconandassignroleslink();
		}
		@And("^click on Assign Roles tab$")
		public void click_on_Assign_Roles_tab() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.clickonassignrolestab();
		}
		@And("^click on checkbox for customer admin role$")
		public void click_on_checkbox_for_customer_admin_role() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.clickoncustomeradminrolecheckbox();
		}
		@And("^click on Assign button$")
		public void click_on_Assign_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.clickonassignbutton();
		}
		@Then("^success message should appear that role has been successfully updated for the user$")
		public void success_message_should_appear_that_role_has_been_successfully_updated_for_the_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			assignroletocustomeruser.Successmessageforrolesupdated();
	}
}

