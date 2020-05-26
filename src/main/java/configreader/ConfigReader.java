package configreader;

import configurationBrowser.BrowserType;

public interface ConfigReader {

	public String getPassword();
	public String getUrl();
	public int ImplicitWait();
	public int ExplicitWait();
	public int getPageLoadTimeOut();
	public BrowserType getBrowser();
	public String getUseremail();
		
}
