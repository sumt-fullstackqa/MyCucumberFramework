package stepDefinition;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Viewreportingtabs;
import utility.ConfigProperties;

public class Viewticketreports {

	Viewreportingtabs viewreports = new Viewreportingtabs(TestBase.driver);

	// TODO Auto-generated constructor stub
	@Given("^login to seaborn portal with service provider admin user$")
	public void login_to_seaborn_portal_with_service_provider_admin_user() {
		// Write code here that turns the phrase above into concrete actions
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());
	}

	@And("^click on the Ticket management menu and click on Reports$")
	public void click_on_the_Ticket_management_menu_and_click_on_Reports() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		viewreports.clickOnTicketmanagementandReports();
	}

	@And("^click on the overdue tickets tab and click on Ticket response rate tab and click on First time response and click on ticket count and click on outage tickets tab and click on unattended tickets tab and click on Reopened tickets tab$")
	public void click_on_the_overdue_tickets_tab_and_click_on_ticket_response_rate_tab_and_click_on_first_time_response_and_click_on_ticket_count_and_clkick_on_outage_tickets_tab_and_click_on_unattended_tickets_tab_and_click_on_reopened_tickets_tab() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		viewreports.clickonallreportingtabsonebyone();
	}
	
	@Then("^data should be visible in grid\\.$")
	public void data_should_be_visible_in_grid() throws Exception {
		// Write code here that turns the phrase above into concrete actions
	}
}
