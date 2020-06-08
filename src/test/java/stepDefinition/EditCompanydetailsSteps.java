/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EditCompanydetailspage;
import utility.ConfigProperties;

/**
 * @author ankur.bhardwaj
 *
 */
public class EditCompanydetailsSteps {

	EditCompanydetailspage editcompanypage = new EditCompanydetailspage(TestBase.driver);
	
	@When("^I click on edit link$")
	public void i_click_on_edit_link() throws Throwable {
		editcompanypage.clickOnEditlink();
	}

	@When("^update the mandatory company details$")
	public void update_the_mandatory_company_details() throws Throwable {
		editcompanypage.EditCompanyDetails(ConfigProperties.COMPANYNAME, ConfigProperties.ACCOUNTNUMBER, ConfigProperties.COUNTRYNAME, ConfigProperties.ADDRESS, ConfigProperties.CITY, ConfigProperties.STATENAME, ConfigProperties.TAXID);
	}

	@When("^click on the update company button$")
	public void click_on_the_update_company_button() throws Throwable {
		editcompanypage.EditContactDetails(ConfigProperties.EMAILADDRESS, ConfigProperties.FIRSTNAME, ConfigProperties.LASTNAME, ConfigProperties.COUNTRYNAME);
	}

	@Then("^company details should be updated successfully$")
	public void company_details_should_be_updated_successfully() throws Throwable {
	    
	}


	
}
