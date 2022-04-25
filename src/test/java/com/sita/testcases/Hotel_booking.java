package com.sita.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sita.pageObjects.GmailPage_Objects;
import com.sita.pageObjects.HomePage;
import com.sita.pages.BaseClass_dev;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;

public class Hotel_booking extends BaseClass_dev {
	
	//public HomePage Hp = new HomePage(driver);
	public WebdriverUtility wb = new WebdriverUtility();
	//public JavascriptExecutor js = (JavascriptExecutor) driver;
	
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
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		Hp.Click_ArrowButtonFHE();
		Hp.Click_on_BookingCentre();
		Hp.Room_category_no();
		logger=report.createTest("Room Configuration,Pax , Meal Plan is showing");
		Hp.Hotel_Select_button();
		Hp.Book_button();
		logger=report.createTest("Bookings can be processed individually");
		Thread.sleep(2000);
		Hp.Show_more_poc();
		Thread.sleep(3000);
		WebElement Ritu_Poc = driver.findElement(By.xpath("//h3[@class='book-item-sub-header']"));
		js.executeScript("arguments[0].scrollIntoView();", Ritu_Poc);
		Hp.Ritu_poc();
		
		Thread.sleep(2000);
		Hp.File_Upload();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\sita_file_upload\\fileupload.exe");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		{
			String FileName = driver.findElement(By.xpath("//span[@title='Screenshot1.png']")).getText();
			
			System.out.println("The Uploaded file name is--"+FileName);
		}
		logger=report.createTest("File Upload successfully for FHE");
		Hp.Notes();
		WebElement Confirm_button = driver.findElement(By.xpath("//span[normalize-space()='Confirm']"));
		//js.executeScript("arguments[0].scrollIntoView();", Confirm_button);
		Confirm_button.click();
		Thread.sleep(2000);
		logger=report.createTest("Mail sent successfully to POC");
		Thread.sleep(2000);
		Hp.BackButton();
		
		//loging out supervisor
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout Successfully By Supervisor");
		
	}
	@Test(priority = 3)
	public void supplier_login() throws InterruptedException 
	{
		logger=report.createTest("Login To gmail");
		driver.get("https://mail.google.com/");
		GmailPage_Objects gp=PageFactory.initElements(driver, GmailPage_Objects.class);
		gp.enterEmail("rituparna@needleinnovision.com");
		Thread.sleep(2000);
		gp.enterPassword("7501649127#Ritu");
		Thread.sleep(2000);
		gp.clickEmail("New Booking Request for");
		Thread.sleep(5000);
		gp.View_entire_message();
		Thread.sleep(3000);
		
		//Taking the handle of newly opened window
		
		Set <String> ids = driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		String currentWindow = it.next();
		String newlyOpenedWindow = it.next();
		driver.switchTo().window(newlyOpenedWindow);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Manage_bookings = driver.findElement(By.xpath("//span[contains(text(),'Manage')]"));
		js.executeScript("arguments[0].scrollIntoView();", Manage_bookings);
		Manage_bookings.click();
		Thread.sleep(3000);
		//Taking the handle of newly opened window
		String winHandleBefore=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("Login", 2, 0),excel.getStringData("Login", 2, 1));
		
		Thread.sleep(10000);
		HomePage Hp = new HomePage(driver);
		Hp.Lock_Button();
		logger=report.createTest("File locked successfully");
		Hp.supplier_view_files_notes();
		Thread.sleep(3000);
		Hp.Files_and_notes_Cross_button();
		Thread.sleep(2000);
		Hp.Expand_button();
		Thread.sleep(2000);
		Hp.Status1();
		logger=report.createTest("Showing requested Status");
		js.executeScript("window.scrollBy(0,1500)");
		Hp.status_button1();
		logger=report.createTest("Showing Waitlisted/Partially Confirmed Status");
		//Thread.sleep(3000);
		Hp.status_button2();
		//Hp.status_button3();
		//Hp.status_button4();
		Hp.Status3();
		logger=report.createTest("Showing Confirmed Status");
		Hp.View_History();
		logger=report.createTest("Showing file history");
		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("window.scrollBy(0,-5000)");
		Hp.Save_Changes_button();
		Hp.error_popup();
		logger=report.createTest("Error popup showing ");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,2000)");
		//js.executeScript("window.scrollBy(0,-5000)");
		Hp.Ref_box1();
		//Hp.Ref_box2();
		logger=report.createTest("Booking reference number entered successfully");
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-5000)");
		Hp.Save_Changes_button();
		Thread.sleep(3000);
		
		}
		
		}

