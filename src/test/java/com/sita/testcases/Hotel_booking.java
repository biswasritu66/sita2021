package com.sita.testcases;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
		logger=report.createTest("Assignig FHE");
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
		Hp.Rate_Details();
		logger=report.createTest("Check if FHE is able to view the Room category, Meal plan, Number of Pax, Rate Details and Number of Rooms required");
		//Hp.Hotel_Select_button();
		List<WebElement> allbuttons = driver.findElements(By.xpath("//button[@class='ant-btn btn-select']"));
		for (WebElement selectbutton : allbuttons) 
		{
			selectbutton.click();
		}
		// Scroll Down
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-5000)");
		Hp.Book_button();
		logger=report.createTest("Check if Booking can be processed individually");
		Thread.sleep(2000);
		Hp.Show_more_poc1();
		//WebElement Ritu_Poc = driver.findElement(By.xpath("//h3[@class='book-item-sub-header']"));
		//js.executeScript("arguments[0].scrollIntoView();", Ritu_Poc);
		Hp.Ritu_poc1();
		//Hp.Mandeep_poc();
		Hp.Show_Less1();
		logger=report.createTest("Check if FHE is able to send booking to multiple/respective POCs");
		WebElement File_Notes = driver.findElement(By.xpath("//h3[normalize-space()='File & Notes']"));
		js.executeScript("arguments[0].scrollIntoView();",File_Notes);
		Hp.Show_more_poc2();
		Hp.Ritu_poc2();
		//Hp.Show_Less2();
		Hp.Show_more_poc3();
		Hp.Ritu_poc3();
		//Hp.Show_Less3();
		WebElement Confirm_button = driver.findElement(By.xpath("//span[normalize-space()='Confirm']"));
		js.executeScript("arguments[0].scrollIntoView();",Confirm_button);
		Hp.File_Upload();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\sita_file_upload\\fileupload.exe");
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		
		{
			String FileName = driver.findElement(By.xpath("//span[@title='Screenshot1.png']")).getText();
			
			System.out.println("The Uploaded file name is--"+FileName);
		}
	
		logger=report.createTest("Check if FHE is able to upload files and send notes to the selected POCs");
		
		Hp.Notes();
		//WebElement Confirm_button = driver.findElement(By.xpath("//span[normalize-space()='Confirm']"));
		//js.executeScript("arguments[0].scrollIntoView();", Confirm_button);
		Confirm_button.click();
		Thread.sleep(5000);
		logger=report.createTest("Check if Supplier is able to receive the new booking request over the registered mail id sent by an FHE");
		Hp.view_files_notes_for_fhe_followup();
		logger=report.createTest("Check if FHE is able to send file and notes to supplier under 3dot menu");
		logger=report.createTest("Check if FHE can do the followup of the booking");
		Thread.sleep(2000);
		Hp.BackButton();
		
		//loging out supervisor
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout Successfully By FHE");
		
	}
	
	@Test(priority = 3)
	public void supplier_login() throws InterruptedException, IOException 
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
		Thread.sleep(7000);
		//Taking the handle of newly opened window
		String winHandleBefore=driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("Login", 2, 0),excel.getStringData("Login", 2, 1));
		
		Thread.sleep(10000);
		logger=report.createTest("Check if supplier is able to login with registered username and password set on the product side");
		HomePage Hp = new HomePage(driver);
		Hp.Lock_Button();
		logger=report.createTest("Check if Hotel Supplier is able to lock the File");
		Hp.supplier_view_files_notes();
		logger=report.createTest("Check if supplier can see file and notes and can sent as well");
		//Thread.sleep(3000);
		
		Hp.Expand_button1();
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		Hp.Status1();
		logger=report.createTest("Check for supplier, if the status is displaying as Requested by default");
		Hp.Day1();
		Hp.Status3();
		logger=report.createTest("Check for supplier, if the status is displaying as Confirmed");
		Hp.View_History();
		logger=report.createTest("Showing file history");
		js.executeScript("window.scrollBy(0,-500)");
		Hp.Save_Changes_button();
		Hp.error_popup();
		logger=report.createTest("Check error message is displayed, if supplier do not enter Booking reference number on confirming the room");
		Hp.Ref_box();
		logger=report.createTest("Check if Supplier can enter Booking reference number");
		js.executeScript("window.scrollBy(0,-500)");
		Hp.Save_Changes_button();
		logger=report.createTest("Check if supplier can confirm WL or requested status later as well");
		Hp.uparrow_button();
		//js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		Hp.Expand_button2();
		Hp.Day2();
		Hp.Status2();
		Hp.Ref_box();
		js.executeScript("window.scrollBy(0,-700)");
		Hp.Save_Changes_button();
		logger=report.createTest("Check for supplier, if the status is displaying as Waitlisted/Partially Confirmed");
		driver.close();
	
	} 
	
		
		}

