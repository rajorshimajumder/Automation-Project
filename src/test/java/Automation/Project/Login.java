package Automation.Project;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;
import pageObjects.RecipesPage;
import resources.base;

public class Login extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
	}
	
	@Test(dataProvider="getData")
	public void baseNavigation(String userName, String Password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Login page");
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys(userName);
		login.getPassword().sendKeys(Password);
		login.getLogin().click();
		log.info("Successfully logged in with username " + userName +" and password " + Password);
		RecipesPage rp = new RecipesPage(driver);
		String text = rp.getTitle().getText();
		Assert.assertEquals(text, "Please Select a Recipe!");
		log.info("Successfully validated login");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="mailto.rajorshimajumder@gmail.com";
		data[0][1]="qwerty";
		data[1][0]="habibakhtar201@gmail.com";
		data[1][1]="qwerty";
		return data;
				
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	

}
