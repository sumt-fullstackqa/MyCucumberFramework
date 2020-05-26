package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addnewcustomeruserpage;
import utility.ConfigProperties;

public class Addnewcustomerusersteps {
	
	Addnewcustomeruserpage addcustomeruser=new Addnewcustomeruserpage(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with customer admin$")
		public void login_with_customer_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the customer user management menu icon$")
		public void click_on_the_customer_user_management_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomeruser.clickOnAddNewcustomeruser();
		}
		@And("^click on the add new customer user button$")
		public void click_on_the_add_new_customer_user_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomeruser.clickonAddnewcustomeruserbutton();
		}
		
		@When("^enter valid customeruseremailaddress customeruserfirstname customerusermiddlename customeruserlastname and customeruserphonenumber$")
		public void enter_valid_customeruseremailaddress_customeruserfirstname_customerusermiddlename_customeruserlastname_and_customerphonenumber() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomeruser.customeruserSelectvalues(ConfigProperties.CUSTOMEREMAILADDRESS, ConfigProperties.CUSTOMERUSERFIRSTNAME, ConfigProperties.CUSTOMERUSERMIDDLENAME, ConfigProperties.CUSTOMERUSERLASTNAME, ConfigProperties.CUSTOMERUSERPHONENUMBER);
		}
		@And("^select county and roles for add new customer user form$")
		public void select_country_and_roles_for_add_new_customer_user_form() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomeruser.customeruserselectcountyandRoles();
		}
		@And("^click on the save button for add new customer user$")
		public void click_on_the_save_button_for_add_new_customer_user() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomeruser.createcustomeruser();
		}
		@Then("^success message should appear for new customer user added in application\\.$")
		public void success_message_should_appear_for_new_customer_user_added_in_application() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


