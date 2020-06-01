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
	public static final String ADMINUSEREMAIL = configProperties.getProperty("AdminUseremail");
	public static final String ADMINPASSWORD = configProperties.getProperty("AdminPassword");
	public static final String CUSTOMERUSEREMAIL = configProperties.getProperty("CustomerUseremail");
	public static final String CUSTOMERPASSWORD = configProperties.getProperty("CustomerPassword");
	public static final String BROWSER = configProperties.getProperty("Browser");
	public static final int PAGELOADTIME = Integer.parseInt(configProperties.getProperty("PageLoadTimeOut"));
	public static final int IMPLICITWAIT = Integer.parseInt(configProperties.getProperty("ImplicitWait"));
	public static final int EXPLICITWAIT = Integer.parseInt(configProperties.getProperty("ExplicitWait"));
	public static final String COMPANYNAME = configProperties.getProperty("Companyname");
	public static final String COMPANYEMAIL = configProperties.getProperty("Companyemail");
	public static final String ADDRESS = configProperties.getProperty("Address");
	public static final String CITY = configProperties.getProperty("City");
	public static final String TAXID = configProperties.getProperty("TaxID");
	public static final String FIRSTNAME = configProperties.getProperty("Firstname");
	public static final String LASTNAME = configProperties.getProperty("Lastname");
	public static final String POSTALCODE = configProperties.getProperty("postalcode");
	public static final String CORPORATECONTACTNUMBER = configProperties.getProperty("Corporatecontactnumber");
	public static final String CONTACTNUMBER = configProperties.getProperty("Contactnumber");
	public static final String EMAILADDRESS = configProperties.getProperty("emailaddress");
	public static final String USERFIRSTNAME = configProperties.getProperty("userfirstname");
	public static final String USERMIDDLENAME = configProperties.getProperty("usermiddlename");
	public static final String USERLASTNAME = configProperties.getProperty("userlastname");
	public static final String USERPHONENUMBER = configProperties.getProperty("userphonenumber");
	public static final String BILLINGCOMPANY = configProperties.getProperty("BillingCompany");
	public static final String BILLINGADDRESS = configProperties.getProperty("BillingAddress");
	public static final String BILLINGPHONENUMBER = configProperties.getProperty("BillingPhoneNumber");
	public static final String BILLINGCITY = configProperties.getProperty("Billingcity");
	public static final String BILLINGPOSTALCODE = configProperties.getProperty("BillingPostalCode");
	public static final String BILLINGFAXNUMBER = configProperties.getProperty("BillingFaxNumber");
	public static final String TICKETNAME = configProperties.getProperty("Ticketname");
	public static final String DESCRIPTION = configProperties.getProperty("Description");
	public static final String PORTDISPLAYNAME = configProperties.getProperty("PortDisplayName");
	public static final String DURATIONPORT = configProperties.getProperty("Durationport");
	public static final String LANNAME = configProperties.getProperty("LanName");
	public static final String DURATIONELAN = configProperties.getProperty("DurationElan");
	public static final String POREFERENCEID = configProperties.getProperty("PoreferenceID");
	public static final String COMMENTSSPECIALINSTRUCTION = configProperties.getProperty("CommentsspecialInstruction");
	public static final String DEVICEMODEL = configProperties.getProperty("Devicemodel");
	public static final String NOTES = configProperties.getProperty("Notes");
	public static final String RACKINSTALLATIONUNITSIZE = configProperties.getProperty("Rackinstallationunitsize");
	public static final String MODELNAME = configProperties.getProperty("Modelname");
	public static final String SIZE = configProperties.getProperty("Size");
	public static final String RACKNOTES = configProperties.getProperty("RackNotes");
	public static final String DEVICENAME = configProperties.getProperty("Devicename");
	public static final String INVENTORYID = configProperties.getProperty("InventoryID");
	public static final String SERIALNUMBER = configProperties.getProperty("Serialnumber");
	public static final String IPADDRESS = configProperties.getProperty("IPAddress");
	public static final String INVENTORYNOTES = configProperties.getProperty("InventoryNotes");
	public static final String INVENTORYSTATUS = configProperties.getProperty("InventoryStatus");
	public static final String INTERCONNECTID = configProperties.getProperty("InterconnectID");
	public static final String CIRCUITID = configProperties.getProperty("CircuitID");
	public static final String INTERCONNECTDESCRIPTION = configProperties.getProperty("InterconnectDescription");
	public static final String LOCATIONNAME = configProperties.getProperty("LocationName");
	public static final String LOCATIONCODE = configProperties.getProperty("Locationcode");
	public static final String LOCATIONADDRESS = configProperties.getProperty("LocationAddress");
	public static final String OTHERCITY = configProperties.getProperty("Othercity");
	public static final String LOCATIONZIPCODE = configProperties.getProperty("LocationZipcode");
	public static final String CUSTOMEREMAILADDRESS = configProperties.getProperty("customeremailaddress");
	public static final String CUSTOMERUSERFIRSTNAME = configProperties.getProperty("customeruserfirstname");
	public static final String CUSTOMERUSERMIDDLENAME = configProperties.getProperty("customerusermiddlename");
	public static final String CUSTOMERUSERLASTNAME = configProperties.getProperty("customeruserlastname");
	public static final String CUSTOMERUSERPHONENUMBER = configProperties.getProperty("customeruserphonenumber");
	public static final String UPDATECUSTOMEREMAILADDRESS = configProperties.getProperty("updatecustomeremailaddress");
	public static final String UPDATECUSTOMERUSERFIRSTNAME = configProperties.getProperty("updatecustomeruserfirstname");
	public static final String UPDATECUSTOMERUSERMIDDLENAME = configProperties.getProperty("updatecustomerusermiddlename");
	public static final String UPDATECUSTOMERUSERLASTNAME = configProperties.getProperty("updatecustomeruserlastname");
	public static final String UPDATECUSTOMERUSERPHONENUMBER = configProperties.getProperty("updatecustomeruserphonenumber");
	public static final String UPDATEDTICKETDESCRIPTION = configProperties.getProperty("TicketupdatedDescription");
	public static final String UPDATEDTICKETNAME = configProperties.getProperty("Ticketupdatedname");
	public static final String NEWPASSWORD = configProperties.getProperty("NewPassword");
	public static final String CONFIRMPASSWORD = configProperties.getProperty("ConfirmPassword");
	public static final String TICKETCOMMENTS = configProperties.getProperty("Comments");
	public static final String PORTDISPLAYNAMEFORELINE = configProperties.getProperty("PortDisplayNameforeline");
	public static final String DURATIONPORTFORELINE = configProperties.getProperty("Durationportforeline");
	public static final String LINENAME = configProperties.getProperty("LineName");
	public static final String DURATIONELINE = configProperties.getProperty("DurationEline");
	public static final String POREFERENCEIDELINE = configProperties.getProperty("PoreferenceIDEline");
	public static final String COMMENTSSPECIALINSTRUCTIONELINE = configProperties.getProperty("CommentsspecialInstructionEline");
	
}
