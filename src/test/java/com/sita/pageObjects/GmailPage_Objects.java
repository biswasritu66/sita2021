package com.sita.pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage_Objects {

	private WebDriver driver;
	@FindBy(xpath="//input[@id='identifierId']") WebElement emailField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//span[normalize-space()='Next']") WebElement Next_button;
	@FindBy(xpath="//img[@class='gb_Aa gbii']") WebElement profileLogo;
	@FindBy(xpath="//span[@class='bog']") List<WebElement> emailThreads;
	
	
	public GmailPage_Objects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterEmail(String emailID)
	{
		waitForVisible(driver,emailField);
		Actions actions=new Actions(driver);
		actions.moveToElement(emailField);
		actions.click();
		actions.sendKeys(emailID + Keys.ENTER);
		actions.build().perform();
		System.out.println("Email entered");
	}
	public void enterPassword(String password)
	{
		waitForVisible(driver,passwordField);
		Actions actions=new Actions(driver);
		actions.moveToElement(passwordField);
		actions.click();
		actions.sendKeys(password + Keys.ENTER);
		actions.build().perform();
		System.out.println("Password entered");
	}
	public void clickEmail(String emailSubject)
	{
		waitForVisible(driver, profileLogo);
		
		for(int i = 0; i<emailThreads.size();i++) {
			
			if (emailThreads.get(i).getText().contains(emailSubject)) {
				emailThreads.get(i).click();
				System.out.println("email clicked");
				break;
			}
		}
	}
	
	public void waitForVisible(WebDriver driver, WebElement element) {
		try {
			Thread.sleep(1000);
			System.out.println("Waiting for element visibility");
			WebDriverWait wait = new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath="//a[normalize-space()='View entire message']") WebElement View_entire_message;
	public void View_entire_message()
	{
		View_entire_message.click();
		
	}
	
	
	
	
	
	
	
	
}



