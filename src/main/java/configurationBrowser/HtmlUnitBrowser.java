package configurationBrowser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HtmlUnitBrowser {

	public Capabilities getHTMLUnitDriverCapabilities(){
		DesiredCapabilities unit=DesiredCapabilities.htmlUnit();
		return unit;
	}
	
	public HtmlUnitBrowser getHtmlUnitDriver(Capabilities cap) {
		return new HtmlUnitBrowser();
	}

	public Capabilities getHtmlUnitDriverCapabilities() {
		// TODO Auto-generated method stub
		return null;
	}
}
