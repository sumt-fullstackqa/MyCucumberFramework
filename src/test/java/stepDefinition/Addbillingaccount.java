package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Createnewbillingaccount;
import utility.ConfigProperties;

public class Addbillingaccount {
	
	Createnewbillingaccount addbillingaccount=new Createnewbillingaccount(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login to seaborn portal with customer admin$")
		public void login_to_seaborn_portal_with_customer_admin() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the billing accounts managemengt menu icon$")
		public void click_on_the_billing_accounts_management_menu_icon() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addbillingaccount.clickOnAddNewbillingaccount();
		}
		@And("^click on the add new account button$")
		public void click_on_the_add_new_account_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addbillingaccount.clickonAddnewaccountbutton();
		}
		
		@When("^enter valid BillingCompany BillingAddress BillingPhoneNumber Billingcity BillingPostalCode and BillingFaxNumber$")
		public void enter_valid_BillingCompany_BillingAddress_BillingPhoneNumber_Billingcity_BillingPostalCode_and_BillingFaxNumber() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addbillingaccount.billingSelectvalues(ConfigProperties.BILLINGCOMPANY, ConfigProperties.BILLINGADDRESS, ConfigProperties.BILLINGPHONENUMBER, ConfigProperties.BILLINGCITY, ConfigProperties.BILLINGPOSTALCODE, ConfigProperties.BILLINGFAXNUMBER );
		}
		@And("^select currency country and state$")
		public void select_country_and_roles() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addbillingaccount.billingselectcurrencycountryandstate();
		}
		@And("^click on the billing account save button$")
		public void click_on_the_billing_account_save_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addbillingaccount.createbillingaccount();
		}
		@Then("^success message should display on page\\.$")
		public void success_message_should_display_on_page() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


