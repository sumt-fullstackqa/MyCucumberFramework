package utility;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {

	private static Properties configProperties;

	static {
		configProperties = new Properties();

		try {
			configProperties
					.load(ConfigProperties.class.getClassLoader().getResourceAsStream("configfile\\config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static final String WEBSITE = configProperties.getProperty("Url");
	public static final String USEREMAIL = configProperties.getProperty("Useremail");
	public static final String PASSWORD = configProperties.getProperty("Password");
	
}
