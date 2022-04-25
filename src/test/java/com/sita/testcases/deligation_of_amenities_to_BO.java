package com.sita.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.List;

import com.sita.pageObjects.HomePage;
import com.sita.pageObjects.Select_amenities;
import com.sita.pages.BaseClass_dev;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;
public class deligation_of_amenities_to_BO extends BaseClass_dev {
	
	public HomePage Hp = new HomePage(driver);

	@Test(priority=1)
	public void supervisor_login_and_assigning_fhe() throws InterruptedException
	{
		
		logger=report.createTest("Login as supervisor");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		loginPage.loginToAPP(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		logger.pass("Login Success");
		HomePage Hp = new HomePage(driver);
		WebdriverUtility wb = new WebdriverUtility();
		Hp.Click_ArrowButton_of_supervisor();
		Hp.Click_ConfirmButton();
		Hp.AssignFile_Handler();
		Thread.sleep(3000);
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
		WebdriverUtility wb = new WebdriverUtility();
		Hp.Click_ArrowButtonFHE();
		Hp.Click_on_BookingCentre();
		Hp.Click_on_Amenitiestab();
		//selecting all the amenities list
		List<WebElement> allbuttons = driver.findElements(By.xpath("//button[@class='ant-btn btn-select ']"));
		for (WebElement selectbutton : allbuttons) 
		{
			selectbutton.click();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll Down
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-5000)");
		Hp.Click_on_Deligate_Button1();
		//here clicking every blank boxes in selecting amenitie quantities from excel sheet.
		//z_mumbai_units
		Select_amenities Sa = PageFactory.initElements(driver, Select_amenities.class);
		//filling invalid nos of units
		{
			
			Sa.Z_mumbai_units(excel.getStringData("Amenities",1,2), excel.getStringData("Amenities",2,2),
				excel.getStringData("Amenities",3,2));
			Thread.sleep(3000);
		
			String expectedHeading = "more than allowed limit";
    	//Storing the text of the heading in a string
    	String heading = driver.findElement(By.xpath("//div[@class='error-msg']")).getText();
    	if(expectedHeading.equalsIgnoreCase(heading))
          	System.out.println("The expected heading is same as actual heading --- "+heading);
    	else
          	System.out.println("The expected heading doesn't match the actual heading --- "+heading);
		}
		logger=report.createTest("Check if units can not be distributed more than total units");
		//valid no of units
		Sa.Z_mumbai_units(excel.getStringData("Amenities",1,1), excel.getStringData("Amenities",2,1),
				excel.getStringData("Amenities",3,1));
		//z_puri_units
		//Sa.Z_Puri_units(excel.getStringData("Amenities",6,1), excel.getStringData("Amenities",7,1),
			//	excel.getStringData("Amenities",8,1));
		
		Hp.confirm_amenities();
		Hp.File_Upload();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\sita_file_upload\\fileupload.exe");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,2000)");
		Hp.Notes();
		Thread.sleep(2000);
		WebElement deligate_popup_button=driver.findElement(By.xpath("//span[normalize-space()='Delegate']"));
		//js.executeScript("arguments[0].scrollIntoView();", deligate_popup_button);
		{
			String FileName = driver.findElement(By.xpath("//span[@class='ant-upload-list-item-name']")).getText();
			System.out.println("The Uploaded file name is--"+FileName);
		}
		logger=report.createTest("File and notes Uploaded successfully for FHE");
		
		Thread.sleep(2000);
		deligate_popup_button.click();
		// Scroll Down
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-5000)");
		Thread.sleep(2000);
		{
			String Remaining_units = driver.findElement(By.xpath("(//span[@class='ant-tag ant-tag-has-color requirement rounded unbordered pconfirmed'])[1]")).getText();
			System.out.println("The Remaining_units"+Remaining_units);
		}
		logger=report.createTest("Remaining units are displaying with correct calculation");
		Thread.sleep(2000);
		
		Hp.BackButton();
		// moving mouse cursor to "logout" dropdown and clicking it.
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout from FHE");
	}
	@Test(priority = 3)
	public void Bo_amenities_list() throws InterruptedException 
	{
		logger=report.createTest("Login as BO Mumbai");
		//login as BO Mumbai
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("LoginBo", 0, 0), excel.getStringData("LoginBo", 0, 1));
		HomePage Hp = new HomePage(driver);
		WebdriverUtility wb = new WebdriverUtility();
		Hp.Arrow_Button_BO();
		Hp.Click_on_Amenitiestab();
		Hp.Lock_Button();
		Thread.sleep(3000);
		/*Hp.view_files_notes();
		 
		try {
			String Files = driver.findElement(By.xpath("//div[@class='download-file']")).getText();
			String Notes = driver.findElement(By.xpath("//div[normalize-space()='hello']")).getText();
			System.out.println("The Uploaded file name is--"+Files);
			System.out.println("The Uploaded file name is--"+Notes);
		}
		catch (Exception e) {
			System.out.println("The uploaded files and notes is not showing");
			logger=report.createTest("The uploaded files and notes is not showing");
		}
		
		logger=report.createTest("Check if BO Mumbai can view the file and notes sent by FHE");
		
		Hp.Files_and_notes_Cross_button();
		Hp.BackButton();
		*/
		Hp.Accept_all_amenities();
		Thread.sleep(3000);
		Hp.Accept_popup();
		Thread.sleep(2000);
		logger=report.createTest("Check if BO Mumbai can accept all the amenities");
		Thread.sleep(3000);
		Hp.view_files_notes();
		Thread.sleep(2000);
		{
			String Files = driver.findElement(By.xpath("//div[@class='download-file']")).getText();
			String Notes = driver.findElement(By.xpath("//div[normalize-space()='hello']")).getText();
			System.out.println("The Uploaded file name is--"+Files);
			System.out.println("The Uploaded file name is--"+Notes);
		}
		logger=report.createTest("Check if BO Mumbai can view the file and notes sent by FHE");
		Hp.BackButton();
		WebElement ele = driver.findElement(By.xpath("//img[@class='ant-dropdown-trigger menu-avatar']"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
		logger=report.createTest("Logout from BO");
	///
	}
}

	
	
	

