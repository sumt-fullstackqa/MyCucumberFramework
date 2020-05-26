package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.createnewuser;
import utility.ConfigProperties;

public class Adduser {
	
	createnewuser adduser=new createnewuser(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to seaborn portal$")
		public void login_to_seaborn_portal() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the user management menu icon$")
		public void click_on_the_user_management_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			adduser.clickOnAddNewuser();
		}
		@And("^click on the add new user button$")
		public void click_on_the_add_new_user_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			adduser.clickonAddnewuserbutton();
		}
		
		@When("^enter valid emailaddress userfirstname usermiddlename userlastname and phonenumber$")
		public void enter_valid_emailaddress_userfirstname_usermiddlename_userlastname_and_phonenumber() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			adduser.userSelectvalues(ConfigProperties.EMAILADDRESS, ConfigProperties.USERFIRSTNAME, ConfigProperties.USERMIDDLENAME, ConfigProperties.USERLASTNAME, ConfigProperties.USERPHONENUMBER);
		}
		@And("^select county and roles$")
		public void select_country_and_roles() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			adduser.userselectcountyandRoles();
		}
		@And("^click on the save button$")
		public void click_on_the_save_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			adduser.createuser();
		}
		@Then("^success message should appear\\.$")
		public void success_message_should_appear() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


