package Automation.Project;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import resources.base;

public class validateHomeButton extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());	
	public WebDriver driver;
	
		@BeforeTest
		public void initialize() throws IOException {
			driver = initializeDriver();
			driver.get(prop.getProperty("url"));
		}
	
		@Test
		public void Navigation() throws IOException {
			LoginPage login = new LoginPage(driver);
			Assert.assertTrue(login.getHeader().isDisplayed());
			log.info("Header is displayed");
		}
		
		@AfterTest
		public void closeBrowser() {
			driver.close();
		}
		
	}
	

	


