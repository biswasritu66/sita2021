package com.sita.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.sita.pageObjects.CreateUser;

@Test
public class Deactivate_user {
	
	 WebDriver driver=null;
	 
	@BeforeTest
	public void setupTest() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://d1hyptr76mcsyh.cloudfront.net/login");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("admin@testsita.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	}
	
	public void deactivate_user() throws InterruptedException {
		CreateUser Cu= new CreateUser(driver);
	
		List<WebElement> all_delete_icon = driver.findElements(By.xpath("//*[name()='path' and contains(@d,'M864 256H7')]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);	
		
		for (int i=1; i<=all_delete_icon.size(); i++)
		{
			 /*Getting the list of items again so that when the page is
		     navigated back to, then the list of items will be refreshed
		     again */ 
			all_delete_icon = driver.findElements(By.xpath("//*[name()='path' and contains(@d,'M864 256H7')]"));
			 //Waiting for the element to be visible
		    //Used (i-1) because the list's item start with 0th index, like in an array
			wait.until(ExpectedConditions.visibilityOf(all_delete_icon.get(i-1)));
			//Clicking on the first element 
			 all_delete_icon.get(i).click();
			 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			 System.out.print(i + " element clicked");
			Cu.click_Deactive_now();
			Thread.sleep(5000);
			Cu.Deactivate();
			 driver.navigate().back();
		}
			
		}
	}
	





















