package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecipesPage {

	WebDriver driver;
	By title = By.tagName("h3");
	public RecipesPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
