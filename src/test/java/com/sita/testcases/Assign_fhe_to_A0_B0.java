package com.sita.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.sita.pageObjects.HomePage;
import com.sita.pages.BaseClass_dev;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;

/**
 * Assigning FHE and deligating files to The AO/BO.
 * 
 * @author Ritu
 *
 */
public class Assign_fhe_to_A0_B0 extends BaseClass_dev {
	
	//public HomePage Hp=new HomePage(driver);

	@Test(priority = 1)
	public void loginApp() {

		logger = report.createTest("Login to Sita");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginToAPP(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		logger.pass("Login Success");
	}

	@Test(priority = 2)

	public void assign_the_fhe()

	{
		logger = report.createTest("click_on_ArrowButton");
		HomePage Hp = new HomePage(driver);
		WebdriverUtility wb = new WebdriverUtility();
		Hp.Click_ArrowButton_of_supervisor();
		logger.pass("ArrowButton_clicked");
		//CLICKING CONFIRM BUTTON
		Hp.Click_ConfirmButton();
		//assigning file handler
		Hp.AssignFile_Handler();
		Hp.RituFHE();
		Hp.AssignButton();
		Hp.sendButton();
		//Click_on_BackButton
		Hp.BackButton();
		// moving mouse cursor to "logout" dropdown and clicking it.
		WebElement ele = driver.findElement(By.xpath("/html/body/div[1]/section/header/div/div[3]/ul/li[6]/img"));
		wb.mouseOver(driver, ele);
		Hp.Click_on_LogoutButton();
	}

	@Test(priority = 3)

	public void loginFHE_deligate_all_ao_bo() 
	{
		HomePage Hp = new HomePage(driver);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.loginToAPP(excel.getStringData("LoginFHE", 0, 0), excel.getStringData("LoginFHE", 0, 1));
		Hp.Click_ArrowButtonFHE();
		Hp.Click_on_BookingCentre();
		Hp.go_to_AO_BO();
		//clicking all select button.
		List<WebElement> allbuttons = driver.findElements(By.xpath("//button[@class='ant-btn btn-select']"));
		for (WebElement currentbutton : allbuttons)
		{
			currentbutton.click();
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll Down
		js.executeScript("window.scrollBy(0,1500)");
		// Scroll Up
		js.executeScript("window.scrollBy(0,-1500)");
		Hp.Click_on_Deligate_Button();
	}


}
