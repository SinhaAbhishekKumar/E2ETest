package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	By email = By.cssSelector("[id='user_email']");
	By password = By.cssSelector("[type='password']");
	By loginBtn = By.cssSelector("[name='commit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getUsername() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}

}
