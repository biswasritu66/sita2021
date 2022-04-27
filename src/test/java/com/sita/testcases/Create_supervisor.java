package com.sita.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sita.pageObjects.CreateUser;
import com.sita.utility.ExcelUtils;

public class Create_supervisor {
	WebDriver driver=null;
	@BeforeTest
	public void setupTest() throws InterruptedException {
		//CreateUser Cu= new CreateUser(driver);
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://d1hyptr76mcsyh.cloudfront.net/login");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys("admin@testsita.com");
		driver.findElement(By.id("password")).sendKeys("Test@123");
		driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary']")).click();
		Thread.sleep(1000);
	}
	
	@Test(dataProvider="Inventory_data",priority=1)
	
	public void customer_details( String Name, String EmployeeCode, String EmailId, String PhoneNumber) throws InterruptedException {
		//System.out.println(Name+" "+EmployeeCode+" "+EmailId+" "+PhoneNumber+"");
		
		//driver.findElement(By.id("fullName")).clear();
		driver.findElement(By.id("fullName")).sendKeys(Name);
		driver.findElement(By.id("employeeId")).sendKeys(EmployeeCode);
		driver.findElement(By.id("email")).sendKeys(EmailId);
		driver.findElement(By.id("phoneNumber")).sendKeys(PhoneNumber);
		
		CreateUser Cu= new CreateUser(driver);
		Cu.org_Unit();
		Cu.Location();
		Cu.scroll_to_rollprofile_addnewbutton_click();
		Cu.click_and_select_department();
		Cu.click_select_roles();
		Cu.select_supervisor();
		Cu.adding_customer_segments();
		Cu.select_customer();
		//Thread.sleep(5000);
		Cu.scroll_and_select_FIT_GIT_SERIES();
		//Thread.sleep(3000);
		Cu.click_Create_user();
		Thread.sleep(2000);
		Cu.click_on_AddUsers();

	}
		@Test(priority = 2)
		public void Login_Supervisor() throws InterruptedException 
		{
			CreateUser Cu= new CreateUser(driver);
			Cu.Click_logout();
			driver.close();
			Thread.sleep(5000);
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("https://d28eejm9iuuhtp.cloudfront.net/login");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.findElement(By.id("username")).sendKeys("avika@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Test@123");
			driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
			Thread.sleep(7000);
			
		}
	
	@DataProvider(name="Inventory_data")
	public Object[][]  getData() {
		String excelPath = "C:\\Users\\Ritu\\git\\needle\\com.Sita.Framework0\\TestData\\Data.xlsx";
		Object data[][] = testData(excelPath, "Create_user_supervisor");
		return data;
	}
	
	
	public  Object[][] testData(String excelPath, String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		int rowCount = excel.getRowCount();
		int colCount =  excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		//i is for rowcount
		//j is for column count
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				
				String cellData = excel.getCellDataString(i, j);
			//	System.out.print(cellData+"");
				data[i-1][j]=cellData;
			}
			System.out.println();
		}
		return data;
	}
	@AfterClass
	void Closing_browser()
	{
		driver.close();
	}
}

