/**
 * 
 */
package pages;

import java.io.File;

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
public class DownloadTicketsDatapage extends TestBase {
	public static WebDriver driver;
	File folder;

	// private static String downloadPath = "C:\\Users\\ankur.bhardwaj\\Downloads";

	Logger log = LoggerHelper.getLogger(DownloadTicketsDatapage.class);

	@SuppressWarnings("static-access")
	public DownloadTicketsDatapage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement locators
	@FindBy(how = How.CSS, using = "a.k-grid-excel")
	private WebElement exportexcelbutton;

	@FindBy(how = How.CSS, using = "a.k-grid-pdf")
	private WebElement exportpdfbutton;

	/*
	 * public boolean isFileDownloaded(String downloadPath, String fileName) {
	 * boolean flag = false; File dir = new File(downloadPath); File[] dir_contents
	 * = dir.listFiles();
	 * 
	 * for (int i = 0; i < dir_contents.length; i++) { if
	 * (dir_contents[i].getName().equals(fileName)) return flag = true; }
	 * 
	 * return flag; }
	 */
	public void isFileDownloaded(String fileName) {
		/*
		 * folder = new File(UUID.randomUUID().toString()); folder.mkdir();
		 */
		File folder = new File(System.getProperty("user.dir"));
		// List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		for (File listOfFile : listOfFiles) {
			if (listOfFile.isFile()) {
				String fname = listOfFile.getName();
				System.out.println("File " + listOfFile.getName());
				if (fname.equals(fileName)) {
					f = new File(fileName);
					found = true;
				}
			}
		}
		Assert.assertTrue(found);
		f.deleteOnExit();
	}

	public void VerifyDownloadExcelWithFileName() {
		log.info("clicking on export to excel");
		clickElement(driver, exportexcelbutton);
		executionDelay(5);
		log.info("File downloaded");

	}

	public void VerifyDownloadPdfWithFileName() {
		log.info("clicking on export pdf button");
		clickElement(driver, exportpdfbutton);
		executionDelay(10);
		log.info("export pdf File downloaded");

	}

}
