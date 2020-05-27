package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Editcustomerticketpage;

public class EditCustomerTicketSteps {
	
	Editcustomerticketpage editpage = new Editcustomerticketpage(TestBase.driver);
	
	@When("^user click on edit ticket$")
	public void user_click_on_edit_ticket() throws Throwable {
		editpage.editLink();
	}

	@When("^add details$")
	public void add_details() throws Throwable {
	    
	}

	@Then("^ticket updated successfully$")
	public void ticket_updated_successfully() throws Throwable {
	   
	}

	

}
