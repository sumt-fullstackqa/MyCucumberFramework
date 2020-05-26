package stepDefinition;

import org.openqa.selenium.WebDriver;

import configreader.ObjectRepo;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.seabornlogin;
import utility.ConfigProperties;

public class loginapplication {

	public static WebDriver driver;

	seabornlogin pages = new seabornlogin(TestBase.driver);

	@Given("^I navigate to the seaborn login page$")
	public void i_navigate_to_the_mpc_login_page() throws Throwable {
		TestBase.driver.navigate().to(ObjectRepo.reader.getUrl());

	}

	@When("^user enter Username and Password$")
	public void user_enter_Username_and_Password() throws Throwable {

		pages.Login(ConfigProperties.ADMINUSEREMAIL, ConfigProperties.ADMINPASSWORD);

	}

	@And("^I click on SignIn button$")
	public void i_click_on_SignIn_button() throws Throwable {

		pages.clicksignin();

	}

	@Then("^Login should be successful and click on signout button to logout of the application$")
	public void login_should_be_successful_and_click_on_signout_button_to_logout_of_the_application() throws Throwable {

		pages.logoutApp();
	}

}