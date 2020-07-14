package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepDefinition.TestBase;

public class login extends TestBase {

	public static WebDriver driver;

	@SuppressWarnings("static-access")
	public login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locator user name
	@FindBy(how = How.CSS, using = "a[href*='my-account']")
	private WebElement Login;
	
	@FindBy(how = How.ID, using = "email")
	private WebElement email;

	@FindBy(how = How.ID, using = "passwd")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "//p[@class='submit']//span[1]")
	private WebElement signin;


	@FindBy(how = How.XPATH, using = "//a[@class='logout']")
	public WebElement logoutlink;

	// Method for Login user name and password with parameters
	
	public void clickonlogin() {
		
		ClickOn(driver, Login, 5);
		writeLogs("clicked on login link successfully");
	}
	
	
	public void Login(String useremail1, String password1) throws Exception {
		sendKeys(driver, email, 5, useremail1);
		sendKeys(driver, password, 5, password1);
		writeLogs("Entered username and password successfully");
	}

	// Method for signIn click
	public void clicksignin() throws Exception {
		ClickOn(driver, signin, 5);
		writeLogs("clicked on sign in button");
	}

	public void logoutApp() throws Exception {
		ClickOn(driver, logoutlink, 15);
		
		writeLogs("clicked on logout link and user gets logged out of application successfully");
	}

}
