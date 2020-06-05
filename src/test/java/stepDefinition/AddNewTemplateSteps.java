/**
 * 
 */
package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AddNewTemplatepage;
import utility.ConfigProperties;

/**
 * @author ankur.bhardwaj
 *
 */
public class AddNewTemplateSteps {

	AddNewTemplatepage templatepage = new AddNewTemplatepage(TestBase.driver);
	
	@When("^I click on Network and click on template$")
	public void i_click_on_Network_and_click_on_template() throws Throwable {
		templatepage.clickOnTemplatelink();
	}

	@When("^I click on Add New Template$")
	public void i_click_on_Add_New_Template() throws Throwable {
		templatepage.clickOnAddTemplateButton();
	}

	@When("^add Template details$")
	public void add_Template_details() throws Throwable {
		templatepage.addTemplateDetails(ConfigProperties.TEMPLATENAME, ConfigProperties.TEMPLATEDURATION, ConfigProperties.TEMPLATEDESC);
	}

	@When("^I click on save button$")
	public void i_click_on_save_button() throws Throwable {
	   
	}

	@Then("^template should created successfully$")
	public void template_should_created_successfully() throws Throwable {
		templatepage.cleanup();
	}
}
