package com.sita.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sita.pages.WebdriverUtility;

public class Inventory_page_objects {
	WebDriver driver;
	public WebdriverUtility wb;
	public Inventory_page_objects(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tbody/tr[2]/td[6]/div[1]/div[2]//*[name()='svg']") WebElement ArrowButton_hotel;
	public void Click_Hotel_ArrowButton()
	{
		ArrowButton_hotel.click();
		
	}
	
	@FindBy(xpath="(//span[contains(text(),'Topup')])[1]") WebElement Topup_Button;
	public void Topup_Button()
	{
		Topup_Button.click();
		
	}
	@FindBy(xpath="//div[@id='3']") WebElement Date;
	public void Select_Date()
	{
		Date.click();
		
	}
	@FindBy(xpath="//span[normalize-space()='Topup']") WebElement Topup_Button1;
	public void Topup_Button1()
	{
		Topup_Button1.click();
		
	}
	@FindBy(xpath="//span[normalize-space()='Confirm']") WebElement confirm_Button;
	public void confirm_Button()
	{
		confirm_Button.click();
		
	}
	@FindBy(xpath="//div[normalize-space()='Hotel']") WebElement Hotel_filter;
	public void Hotel_name_filter()
	{
		Hotel_filter.click();
	}
	@FindBy(xpath="//div[@class='ant-select-selection-overflow']") WebElement Hotel_name;
	@FindBy(xpath="//div[@class='ant-select-item-option-content'][normalize-space()='Z_Radisson Blu Plaza']") WebElement Z_Radisson_Blu_Plaza;
	public void Hotel_name() throws Throwable
	{
		Hotel_name.click();
		//Hotel_name.sendKeys("Z_Needle- Royal Group");
		Z_Radisson_Blu_Plaza.click();
		
	}
	@FindBy(xpath="//h5[@class='ant-typography _title back-option']") WebElement Back_button;
	public void Back_button()
	{
		Back_button.click();
	}
	@FindBy(xpath="//div[contains(text(),'History')]") WebElement History_tab;
	public void History_tab()
	{
		History_tab.click();
	}
}

















