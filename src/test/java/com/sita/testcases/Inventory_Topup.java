package com.sita.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sita.pageObjects.HomePage;
import com.sita.pageObjects.Inventory_page_objects;
import com.sita.pages.BaseClass_inventory;
import com.sita.pages.LoginPage;
import com.sita.pages.WebdriverUtility;
import com.sita.utility.ExcelDataProvider;

public class Inventory_Topup extends BaseClass_inventory{
	
	public Inventory_page_objects IO;
	public WebdriverUtility WU;
	
	@Test(priority = 1)
	public void loginApp() throws InterruptedException {

		logger = report.createTest("Login to Inventory");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting Application");

		loginPage.loginToAPP(excel.getStringData("Login", 1, 0), excel.getStringData("Login", 1, 1));

		logger.pass("Login Success");	
		Thread.sleep(9000);
    }

	@Test(priority=2)
	
	public void navigate_to_homepage_click_on_Hotel_ArrowButton () throws Throwable 
	
	{
		
		IO = new Inventory_page_objects(driver);
		IO.Hotel_name_filter();
		
		IO.Hotel_name();
		
		IO.Click_Hotel_ArrowButton();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
		
		IO.Topup_Button();
	
		IO.Select_Date();
		
		js.executeScript("window.scrollBy(0,5000)");
		List<WebElement> allbuttons = driver.findElements(By.xpath("//div[@class='ant-input-number-input-wrap']//input[@role='spinbutton']"));
		for (WebElement currentbutton : allbuttons)
		{
			currentbutton.sendKeys("4");
		}
		
		IO.Topup_Button1();
		//Thread.sleep(1000);
		IO.confirm_Button();
		//Thread.sleep(2000);
		IO.Back_button();
		IO.Back_button();
		IO.History_tab();
		//Thread.sleep(5000);
		List<WebElement> History = driver.findElements(By.xpath("//tr[contains(@class,'ant-table-row ant-table-row-level-0')]"));

        System.out.println(History.size());

        for (WebElement webElement : History) {
            String name = webElement.getText();
            System.out.println(name);
        }
	}

	
	
	
	
	
	
	
}


