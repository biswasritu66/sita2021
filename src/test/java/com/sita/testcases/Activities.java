package com.sita.testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sita.pageObjects.HomePage;
import com.sita.pageObjects.activities_page_objects;
import com.sita.pages.BaseClass_dev;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;

public class Activities extends BaseClass_dev{
	public WebdriverUtility wb = new WebdriverUtility();
	
	@Test(priority = 1)
	public void supervisor_login_and_assigning_fhe() throws InterruptedException
	{
		
		logger=report.createTest("Login as supervisor");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToAPP(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		HomePage Hp = new HomePage(driver);
		
		Hp.Click_ArrowButton_of_supervisor();
		
		Hp.Click_ConfirmButton();
		Thread.sleep(2000);
		Hp.AssignFile_Handler();
		Thread.sleep(2000);
		Hp.RituFHE();
		Thread.sleep(2000);
		Hp.AssignButton();
		Thread.sleep(2000);
		Hp.sendButton();
		logger=report.createTest("Assign FHE");
		Hp.BackButton();
		//loging out supervisor
		// moving mouse cursor to "logout" dropdown and clicking it.
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout Successfully By Supervisor");
	}
	@Test(priority = 2)
	public void fhe_distribution() throws IOException, InterruptedException  
	{
		
		logger=report.createTest("Login as FHE");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("LoginFHE", 0, 0), excel.getStringData("LoginFHE", 0, 1));
		HomePage Hp = new HomePage(driver);
		activities_page_objects Ap = new activities_page_objects(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		Hp.Click_ArrowButtonFHE();
		Hp.Click_on_BookingCentre();
		Ap.Activities_tab();
		List<WebElement> allbuttons = driver.findElements(By.xpath("//button[@class='ant-btn btn-select']"));
		for (WebElement selectbutton : allbuttons) 
		{
			selectbutton.click();
		}
		js.executeScript("window.scrollBy(0,1500)");
		js.executeScript("window.scrollBy(0,-5000)");
		Thread.sleep(7000);
}
}