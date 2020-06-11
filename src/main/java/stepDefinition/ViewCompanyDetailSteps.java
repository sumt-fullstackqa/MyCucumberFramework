
package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ViewCompanydetailspage;

/**
 * @author ankur.bhardwaj
 *
 */
public class ViewCompanyDetailSteps {

	ViewCompanydetailspage companydetailpage = new ViewCompanydetailspage(TestBase.driver);
	
	
	@Given("^navigates to company List screen$")
	public void navigates_to_company_List_screen() throws Throwable {
		companydetailpage.navigateToCompanyList();
	}

	@When("^I click on any company view details$")
	public void i_click_on_any_company_view_details() throws Throwable {
		companydetailpage.clickOnViewDetails();
	}

	@Then("^company details screen is opened$")
	public void company_details_screen_is_opened() throws Throwable {
		companydetailpage.companyDetails();
	}

	@Then("^company details should displayed$")
	public void company_details_should_displayed() throws Throwable {
	   
	}

	
}
