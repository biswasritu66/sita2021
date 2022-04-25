package com.sita.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.sita.pageObjects.CreateUser;
import com.sita.pageObjects.HomePage;
import com.sita.utility.BrowserFactory;
import com.sita.utility.ConfigDataProvider;
import com.sita.utility.ExcelDataProvider;
import com.sita.utility.Helper;

public class BaseClass_dev {

	public  WebDriver driver;
	public ConfigDataProvider config;
	public ExcelDataProvider excel;
	public ExtentReports report;
	public ExtentTest logger;
	public HomePage Hp;
	public CreateUser Cu;
	public WebdriverUtility wu=new WebdriverUtility();
	
	@BeforeSuite
	public void ExtentReportsetUp()
	{
		Reporter.log("Setting up reports and Test is getting Ready", true);
		config=new ConfigDataProvider();
		excel=new ExcelDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Sita"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test Will start now", true);
	}
	
	@BeforeClass
	public void openingbrowser() {
		Reporter.log("Trying to start Browser and Getting application ready", true);
		driver=BrowserFactory.startApplication(driver,config.getBrowser(),config.dev_url());
		Reporter.log("Browser and Application is up and running", true);
	}
	@AfterClass
	public void closeBrowser() {
	BrowserFactory.quitBrowser(driver);
}
	@AfterMethod
	public void Screenshot(ITestResult result) throws IOException
	{
		Reporter.log("Test is about to end", true);
		
		if (result.getStatus()==ITestResult.FAILURE)
		{
		
		logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
	/*	else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test passed" ,MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}*/
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.pass("Test skipped" ,MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		report.flush();
		Reporter.log("Test Completed >>> Reports Generated", true);
	}
}
