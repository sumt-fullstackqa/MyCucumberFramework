package stepDefinition;
import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Addcompany;
import utility.ConfigProperties;

public class Addcustomer {
	
	Addcompany addcustomer=new Addcompany(TestBase.driver);
	// TODO Auto-generated constructor stub
		@Given("^login with valid credentials$")
		public void login_with_valid_credentials() {
		    // Write code here that turns the phrase above into concrete actions
			TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());	
		}
		
		@And("^click on the add new company button$")
		public void click_on_the_add_new_company_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomer.clickOnAddNewCompany();
		}
		@When("^enter valid Company name email first name last name contact number  Corporate Contact Number tax id postal code Address and city$")
		public void enter_valid_Company_name_email_first_name_last_name_contact_number_corporate_contact_number_tax_id_postal_code_Address_and_city() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomer.companySelectvalues(ConfigProperties.COMPANYNAME, ConfigProperties.COMPANYEMAIL, ConfigProperties.FIRSTNAME, ConfigProperties.LASTNAME, ConfigProperties.CONTACTNUMBER, ConfigProperties.CORPORATECONTACTNUMBER, ConfigProperties.TAXID, ConfigProperties.POSTALCODE, ConfigProperties.ADDRESS, ConfigProperties.CITY);
		}
		@And("^select county and state$")
		public void select_country_and_state() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomer.companyselectcountyandstate();
		}
		@And("^click on save button$")
		public void click_on_save_button() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
			addcustomer.createcompany();
		}
		@Then("^success message should be displayed\\.$")
		public void success_message_should_be_displayed() throws Exception {
		    // Write code here that turns the phrase above into concrete actions
	}
	}


