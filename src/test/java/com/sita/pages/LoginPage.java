package com.sita.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * all  the page elements for loging page tci sita and add user
 * @author Ritu
 *
 */
public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;//for initializing webdriver we are creating this constructor.
	}
	@FindBy(id="username") WebElement username;
	
	@FindBy(id="password") WebElement password;
	
	@FindBy(xpath="//span[normalize-space()='Login']") WebElement loginButton;
	
	public void loginToAPP(String usernameApplication,String passwordApplication)
	{
		username.sendKeys(usernameApplication);
		password.sendKeys(passwordApplication);
		loginButton.click();
	}
}
