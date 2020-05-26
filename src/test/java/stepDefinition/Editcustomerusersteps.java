package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Editcustomeruserpage;
import utility.ConfigProperties;

public class Editcustomerusersteps {
	
	Editcustomeruserpage updatecustomeruser=new Editcustomeruserpage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with customer admin to the portal$")
		public void login_with_customer_admin_to_the_portal() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on customer user management menu icon$")
		public void click_on_customer_user_management_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updatecustomeruser.clickOnCustomerUserManagementmenu();
		}
		@And("^click on the 3 dotted icon for first customer from the list and click on edit link$")
		public void click_on_the_3_dotted_icon_for_first_customer_from_the_list_and_click_on_edit_link() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updatecustomeruser.clickonthreedottediconandeditlinkforcustomer();
		}
		
		@When("^clear and enter new valid customeruseremailaddress and clear and enter new customeruserfirstname and clear and enter new customerusermiddlename and clear and enter new customeruserlastname and clear and enter new customeruserphonenumber$")
		public void clear_and_enter_new_valid_customeruseremailaddress_and_clear_and_enter_new_customeruserfirstname_and_clear_and_enter_new_customerusermiddlename_and_clear_and_enter_new_customeruserlastname_and_clear_and_enter_new_customeruserphonenumber() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updatecustomeruser.customeruserUpdatevalues(ConfigProperties.UPDATECUSTOMEREMAILADDRESS, ConfigProperties.UPDATECUSTOMERUSERFIRSTNAME, ConfigProperties.UPDATECUSTOMERUSERMIDDLENAME, ConfigProperties.UPDATECUSTOMERUSERLASTNAME, ConfigProperties.UPDATECUSTOMERUSERPHONENUMBER);
		}
		@And("^select new county and select new role$")
		public void select_new_country_and_select_new_role() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updatecustomeruser.customeruserselectnewcountyandnewRole();
		}
		@And("^click on the update button$")
		public void click_on_the_update_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			updatecustomeruser.updatecustomeruser();
		}
		@Then("^success message should appear for customer user updated in application\\.$")
		public void success_message_should_appear_for_customer_user_updated_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


