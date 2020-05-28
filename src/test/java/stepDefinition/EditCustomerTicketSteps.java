package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Editcustomerticketpage;
import utility.ConfigProperties;

public class EditCustomerTicketSteps {
	
	Editcustomerticketpage editpage = new Editcustomerticketpage(TestBase.driver);
	
	@When("^user click on edit ticket$")
	public void user_click_on_edit_ticket() throws Throwable {
		editpage.search(ConfigProperties.TICKETNAME);
		editpage.editLink();
	}

	@When("^add details$")
	public void add_details() throws Throwable {
		editpage.updateDetails(ConfigProperties.UPDATEDTICKETNAME, ConfigProperties.UPDATEDTICKETDESCRIPTION);
	}

	@Then("^ticket updated successfully$")
	public void ticket_updated_successfully() throws Throwable {
		editpage.search(ConfigProperties.UPDATEDTICKETNAME);
		editpage.cleanup(ConfigProperties.TICKETNAME, ConfigProperties.DESCRIPTION);
	}

	

}
