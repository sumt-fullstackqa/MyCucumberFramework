package configreader;

import java.util.Properties;

import configurationBrowser.BrowserType;
import utility.ResourceHelper;

public class PropertyFileReader implements ConfigReader {

	private static Properties prop = null;
	//public static PropertyFileReader reader;
	public PropertyFileReader() {
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("/src/main/resources/configfile/config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
			
	@Override
	public String getUseremail() {
		return prop.getProperty("Useremail");

	}

	@Override
	public String getPassword() {
		return prop.getProperty("Password");

	}

	@Override
	public String getUrl() {
		return prop.getProperty("Url");

	}

	@Override
	public int ImplicitWait() {
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}

	@Override
	public int ExplicitWait() {
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}

	@Override
	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}

	@Override
	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));

	}

	/*public static void main(String[] args) {
		PropertyFileReader obj = new PropertyFileReader();
		System.out.println(prop.getProperty("Browser"));
	}*/

}
