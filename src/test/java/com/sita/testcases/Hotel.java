package com.sita.testcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sita.pageObjects.GmailPage_Objects;
import com.sita.pageObjects.HomePage;
import com.sita.pages.BaseClass_dev;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;
import org.openqa.selenium.Point;

public class Hotel extends BaseClass_dev {
	
	//public HomePage Hp = new HomePage(driver);
	public WebdriverUtility wb = new WebdriverUtility();
	//public JavascriptExecutor js = (JavascriptExecutor) driver;
	
	/*@Test(priority=1)
	public void supervisor_login_and_assigning_fhe() throws InterruptedException
	{
		
		logger=report.createTest("Login as supervisor");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToAPP(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		HomePage Hp = new HomePage(driver);
		//WebdriverUtility wb = new WebdriverUtility();
		Hp.Click_ArrowButton_of_supervisor();
		Hp.Click_ConfirmButton();
		Thread.sleep(2000);
		Hp.AssignFile_Handler();
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
	}*/
	@Test(priority = 2)
	public void fhe_distribution() throws IOException, InterruptedException  
	{
		logger=report.createTest("Login as FHE");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("LoginFHE", 0, 0), excel.getStringData("LoginFHE", 0, 1));
		HomePage Hp = new HomePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Hp.Click_ArrowButtonFHE();
		Hp.Click_on_BookingCentre();
		Hp.Hotel_Select_button();
		Hp.Book_button();
		Thread.sleep(2000);
		Hp.Show_more_poc();
		Thread.sleep(3000);
		WebElement Ritu_Poc = driver.findElement(By.xpath("//h3[@class='book-item-sub-header']"));
		js.executeScript("arguments[0].scrollIntoView();", Ritu_Poc);
		Hp.Ritu_poc();
		Hp.File_Upload();
		Thread.sleep(4000);
		
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\needle_file_upload\\fileupload.exe");
	
		{
			String FileName = driver.findElement(By.xpath("//span[@title='Screenshot.png']")).getText();
			System.out.println("The Uploaded file name is--"+FileName);
		}
		logger=report.createTest("File Upload successfully for FHE");
		WebElement Confirm_button = driver.findElement(By.xpath("//span[normalize-space()='Confirm']"));
		js.executeScript("arguments[0].scrollIntoView();", Confirm_button);
		Confirm_button.click();
		Hp.BackButton();
		//Thread.sleep(5000);
		//loging out supervisor
		// moving mouse cursor to "logout" dropdown and clicking it.
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout Successfully By Supervisor");
		
	}
	@Test(priority = 3)
	public void Loging_to_mail() throws InterruptedException  
	{
		logger=report.createTest("Login To gmail");
		driver.get("https://mail.google.com/");
		GmailPage_Objects gp=PageFactory.initElements(driver, GmailPage_Objects.class);
		gp.enterEmail("rituparna@needleinnovision.com");
		Thread.sleep(2000);
		gp.enterPassword("7501649127#Ritu");
		Thread.sleep(2000);
		gp.clickEmail("New Booking Request for");
		gp.View_entire_message();
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
		Thread.sleep(4000);
		HomePage Hp = new HomePage(driver);
		Hp.Lock_Button();
		Thread.sleep(3000);
		//Hp.view_files_notes_for_poc();
		//{
			//String File_and_Notes = driver.findElement(By.xpath("//div[@class='download-file']")).getText();
		//	System.out.println("The Uploaded file name is--"+File_and_Notes);
		//}
		//logger=report.createTest("Check POC can view the file and notes sent by FHE");
		//Thread.sleep(3000);
		Hp.Expand_button();
		js.executeScript("window.scrollBy(0,1500)");
		Hp.Status1();
		logger=report.createTest("Showing requested Status");
		Hp.status_button1();
		Hp.Status2();
		logger=report.createTest("Showing Waitlisted/Partially Confirmed Status");
		Hp.status_button3();
		Hp.status_button4();
		Hp.status_button2();
		Thread.sleep(4000);
		Hp.Status3();
		//logger=report.createTest("Showing Confirmed Status");
		Hp.View_History();
		logger=report.createTest("Showing file history");
		Hp.Ref_box1();
		Hp.Ref_box2();
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-5000)");
		//Hp.Save_Changes_button();
		Thread.sleep(3000);
		
		}
		
		}


















