package com.sita.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sita.pages.WebdriverUtility;

public class activities_page_objects extends WebdriverUtility{
	WebDriver driver;
	public activities_page_objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath="//div[contains(text(),'Activities')]") WebElement Activities_tab;
	@FindBy(xpath="//tbody/tr[1]/td[6]/div[1]/div[2]/span[1]/a[1]//*[name()='svg']") WebElement ArrowButtonFHE;
	public void Activities_tab()
	{
		Activities_tab.click();
		
	}
	public void Click_ArrowButtonFHE()
	{
		
		ArrowButtonFHE.click();
	}

}
