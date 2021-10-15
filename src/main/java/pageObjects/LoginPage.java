package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;
	By email = By.name("email");
	By password = By.name("password");
	By login = By.cssSelector("button[class*='btn-success']");
	By header = By.linkText("Recipe Book");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}



}
