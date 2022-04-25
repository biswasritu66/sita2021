package com.sita.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * here clicking every blank boxes for each in select amenities page
 * @author Ritu
 *
 */
public class Select_amenities {
	WebDriver driver;
	public  Select_amenities(WebDriver driver)
	{
		this.driver=driver;//for initializing webdriver we are creating this constructor.
	}
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/div[1]/div[2]/input[1]")WebElement Z_mumbai_box1;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[2]/div[1]/div[2]/input[1]")WebElement Z_mumbai_box2;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[2]/div[1]/div[2]/input[1]")WebElement Z_mumbai_box3;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[2]/input[1]")WebElement Z_mumbai_box4;
	
	public void Z_mumbai_units(String units1,String units2,String units3)
	{
		Z_mumbai_box1.sendKeys(String.valueOf(units1));
		Z_mumbai_box2.sendKeys(String.valueOf(units2));
		Z_mumbai_box3.sendKeys(String.valueOf(units3));
		
	}
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[3]/div[1]/div[2]/input[1]")WebElement Z_Puri_box1;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[3]/div[1]/div[2]/input[1]")WebElement Z_Puri_box2;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[3]/div[1]/div[2]/input[1]")WebElement Z_Puri_box3;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[3]/div[1]/div[2]/input[1]")WebElement Z_Puri_box4;

	public void Z_Puri_units(String units1,String units2,String units3)
	{
		 Z_Puri_box1.sendKeys(String.valueOf(units1));
		 Z_Puri_box2.sendKeys(String.valueOf(units2));
		 Z_Puri_box3.sendKeys(String.valueOf(units3));
	}
	
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[4]/div[1]/div[2]/input[1]")WebElement Z_Bhub_box1;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[4]/div[1]/div[2]/input[1]")WebElement Z_Bhub_box2;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[4]/div[1]/div[2]/input[1]")WebElement Z_Bhub_box3;
	@FindBy(xpath="/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[4]/div[1]/div[2]/input[1]")WebElement Z_Bhub_box4;

	public void Z_Bhubneswar_units(String units1,String units2,String units3,String units4)
	{
		 Z_Bhub_box1.sendKeys(String.valueOf(units1));
		 Z_Bhub_box2.sendKeys(String.valueOf(units2));
		 Z_Bhub_box3.sendKeys(String.valueOf(units3));
		 Z_Bhub_box4.sendKeys(String.valueOf(units4));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
