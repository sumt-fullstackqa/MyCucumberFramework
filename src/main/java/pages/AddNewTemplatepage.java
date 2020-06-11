/**
 * 
 */
package pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import helperLogger.LoggerHelper;
import stepDefinition.TestBase;

/**
 * @author ankur.bhardwaj
 *
 */
public class AddNewTemplatepage extends TestBase {

	public static WebDriver driver;
	
	String url;
	
	Logger log = LoggerHelper.getLogger(AddNewTemplatepage.class);
	
	@SuppressWarnings("static-access")
	public AddNewTemplatepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.CSS, using = "a.Networks")
	private WebElement networklink;
	
	//span[@class='nav-label menu-name'][contains(.,'Templates')]

	@FindBy(how = How.XPATH, using = "//a[@role='menuitem']")
	public List<WebElement> submenu;
	
	@FindBy(how = How.XPATH, using = "//a[@href='http://seaborn.cloudsmartz.com/group/services/networks/templates'][contains(.,'Templates')]")
	private WebElement templatelink;
	
	@FindBy(how = How.XPATH, using = "//a[@data-toggle='modal'][contains(.,'Add New Template')]")
	private WebElement addTemplateButton;
	
	@FindBy(how = How.XPATH, using = "//input[@id='templateName']")
	private WebElement templatenameInputField;
	
	@FindBy(how = How.XPATH, using = "//input[@id='duration']")
	private WebElement templatenamedurationField;
	
	@FindBy(how = How.XPATH, using = "//select[@id='durationUnit']")
	private WebElement durationtypedropdown;
	
	@FindBy(how = How.XPATH, using = "//option[@value='5'][contains(.,'Month(s)')]")
	private WebElement durationtypedropdownvalue;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='description']")
	private WebElement templatedescriptionTextarea;
	
	@FindBy(how = How.XPATH, using = "//input[@id='saveTemplateButton']")
	private WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//tr[1]//td[5]//a[3]")
	private WebElement DeleteButton;
	
	@FindBy(how = How.XPATH, using = "//button[@data-bb-handler='success'][contains(.,'Ok')]")
	private WebElement okButton;
	
	@FindBy(how = How.CSS, using = "div#templateMsg")
	private WebElement notifymsg;
	
	
	
	
	public void clickOnTemplatelink() {
		log.info("clicking on network link");
		submenu.get(0).click();
		executionDelay(5);
		log.info("clicking on sub menu network link");
		templatelink.click();
		executionDelay(5);
		url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("networks"));
	}
	
	
	public void clickOnAddTemplateButton() {
		log.info("clicking on Add New template");
		clickElement(driver, addTemplateButton);
		executionDelay(2);
		
	}
	
	public void addTemplateDetails(String tname, String tduration, String tdescription) {
		log.info("Adding Template Name");
		inputText(templatenameInputField, tname);
		log.info("Adding Template Duration");
		inputText(templatenamedurationField, tduration);
		log.info("Adding Durationdropdown");
		clickElement(driver, durationtypedropdown);
		log.info("Adding Durationdropdownvalue");
		clickElement(driver, durationtypedropdownvalue);
		log.info("Adding Template Description");
		inputText(templatedescriptionTextarea, tdescription);
		log.info("Clicking on Save button");
		clickElement(driver, saveButton);
		executionDelay(5);
		notifymessage(notifymsg, "Template has been created successfully");
		

	}
	
	public void cleanup() {
		log.info("Clicking on Delete button");
		clickElement(driver, DeleteButton);
		executionDelay(2);
		log.info("Clicking on confirmation Ok button");
		clickElement(driver, okButton);
		executionDelay(5);
		notifymessage(notifymsg, "Template has been deleted successfully");	
		
	}
	
}
