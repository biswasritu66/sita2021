package com.sita.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sita.pages.WebdriverUtility;


/**
 * this page we are storing all the page elements of tci sita homepage, booking centre, ao/bo,amenities
 * @author Ritu
 *
 */
public class HomePage extends WebdriverUtility{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[2]/span[1]/a[1]//*[name()='svg']") WebElement ArrowButton_supervisor;
	@FindBy(xpath="//tbody/tr[1]/td[6]/div[1]/div[2]/span[1]/a[1]//*[name()='svg']") WebElement ArrowButtonFHE;
	public void Click_ArrowButton_of_supervisor()
	{
		ArrowButton_supervisor.click();
		
	}
	public void Click_ArrowButtonFHE()
	{
		
		ArrowButtonFHE.click();
	}
	
	@FindBy(xpath="//span[normalize-space()='Confirm']") WebElement ConfirmButton;
	
	public void Click_ConfirmButton()
	{
		ConfirmButton.click();
	}
	@FindBy(xpath="//span[normalize-space()='Assign to File Handler']")WebElement AssignFile_Handler;
	public void AssignFile_Handler()
	{
		AssignFile_Handler.click();
	}
	@FindBy(xpath="//span[normalize-space()='Select']")WebElement RituFHE;
	public void RituFHE()
	{
		RituFHE.click();
	}
	@FindBy(xpath="//button[contains(@class,'assign-btn-selected')]")WebElement AssignButton;
	public void AssignButton()
	{
		AssignButton.click();
	}
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button/span")WebElement sendButton;
	public void sendButton()
	{
		
		sendButton.click();
	}
	@FindBy(xpath="//h5[@class='ant-typography _title back-option']") WebElement BackButton;
	public void BackButton()
	{
		BackButton.click();
	}
	@FindBy(xpath="//li[normalize-space()='Logout']")WebElement LogoutButton;
	public void Click_on_LogoutButton()
	{
	LogoutButton.click();
	}
	
	@FindBy(xpath="//span[normalize-space()='Booking Centre']")WebElement BookingCentre;
	public void Click_on_BookingCentre()
	{
		BookingCentre.click();
	}
	@FindBy(xpath="//div[contains(text(),'AO/BO Delegations')]")WebElement AO_BO_Delegations;
	public void go_to_AO_BO()
	{
		
		AO_BO_Delegations.click();
	}
	@FindBy(xpath="//button[@class='ant-btn booking-center-card-action book-btn']")WebElement Deligate_Button_for_AO_BO;
	public void Click_on_Deligate_Button()
	{
		Deligate_Button_for_AO_BO.click();
	}
	@FindBy(xpath="//button[@class='ant-btn monument-send-request-btn ']")WebElement Deligate_Button_for_Amenities;
	public void Click_on_Deligate_Button1()
	{
		Deligate_Button_for_Amenities.click();
	}
	@FindBy(xpath="//div[contains(@class,'booking-center-header-box amenities')]")WebElement Amenities;
	public void Click_on_Amenitiestab()
	{
		Amenities.click();
		
	}
	@FindBy(xpath="//button[@class='ant-btn btn-select']")WebElement select_Button;
	;
	public void Click_on_select_Button()
	{
		select_Button.click();
		
	}
	//moving cursor to No of units.
	
	@FindBy(xpath="//tbody/tr[2]/td[1]/div[1]/div[2]/div[1]/div[2]")WebElement Units;
	public void CopyingUnits()
	{
		Units.isSelected();
		
	}
	@FindBy(xpath="//span[normalize-space()='Delegate']")WebElement deligate_popup_button;
	public void deligate_popup_button()
	{
		deligate_popup_button.click();
		
	}
	//xpath for all the blank boxes and filling the box from excel
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/div/div[2]/table/tbody/tr[2]/td[3]/div[1]/div[2]/input")WebElement blank_box;
	public void blank_box()
	{
		blank_box.sendKeys("10");
		
	}
	@FindBy(xpath="//span[normalize-space()='Save']")WebElement save_amenities;
	public void save_amenities()
	{
		save_amenities.click();
		
	}
	@FindBy(xpath="//span[normalize-space()='Confirm']")WebElement confirm_amenities;
	public void confirm_amenities()
	{
		confirm_amenities.click();
		
	}
	@FindBy(xpath="//tbody/tr[1]/td[5]/div[1]/div[2]/span[1]/a[1]//*[name()='svg']")WebElement Arrow_Button_BO ;
	public void Arrow_Button_BO()
	{
		Arrow_Button_BO.click();
		
	}
	@FindBy(xpath="//button[@class='ant-btn ant-btn-icon-only btn-icon lock-btn']//*[name()='svg']")WebElement Lock_Button ;
	public void Lock_Button()
	{
		Lock_Button.click();
		
	}
	@FindBy(xpath="//span[normalize-space()='Accept all']")WebElement Accept_all_amenities ;
	public void Accept_all_amenities()
	{
		Accept_all_amenities.click();
		
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Accept']")WebElement Accept_popup ;

	public void Accept_popup()
	{
		
		Accept_popup.click();
		
	}
	@FindBy(xpath="//p[@class='ant-upload-text']")WebElement File_Upload ;

	public void File_Upload()
	{
		
		File_Upload.click();
		
	}
	@FindBy(xpath="//div[@class='booking-center-content']//div[1]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]//*[name()='svg']")WebElement view_files_note_dots ;
	@FindBy(xpath="//span[normalize-space()='View Files and Notes']")WebElement view_files_notes ;
	@FindBy(xpath="//span[contains(text(),'Files & Notes')]")WebElement files_notes ;
	public void view_files_notes()
	{
		
		view_files_note_dots.click();
		view_files_notes.click();
		files_notes.click();
		
	}
	
	@FindBy(xpath="//span[normalize-space()='View Files and Notes']")WebElement view_files_notes1 ;
	@FindBy(xpath="//span[contains(text(),'Files & Notes')]")WebElement files_notes1 ;
	@FindBy(xpath="//div[@class='download-file']")WebElement files_notes_name ;
	@FindBy(xpath="//div[normalize-space()='hello']")WebElement note_text ;
	public void view_files_notes_for_poc()
	{
		
		view_files_notes1.click();
		files_notes1.click();
		
	}
	public void supplier_view_files_notes()
	{
		
		files_notes1.click();
		System.out.println("The file name is--"+files_notes_name.getText());
		System.out.println("The file name is--"+note_text.getText());
		
	}
	
	@FindBy(xpath="//span[@aria-label='close']//*[name()='svg']")WebElement Files_and_notes_Cross_button ;

	public void Files_and_notes_Cross_button()
	{
		
		Files_and_notes_Cross_button.click();
		
	}
	@FindBy(xpath="(//span[@class='ant-tag ant-tag-has-color requirement rounded unbordered confirmed'])[1]")WebElement Remaining_units ;

	public void Remaining_units()
	{
		
		Remaining_units.click();
		
	}
	@FindBy(xpath="//button[@class='ant-btn monument-send-request-btn ']")WebElement Deligate_Button_for_Amenities2;
	public void Click_on_Deligate_Button2()
	{
		Deligate_Button_for_Amenities2.click();
	}
	@FindBy(xpath="//tbody/tr[2]/td[2]/div[1]/div[1]/span[2]")WebElement Bo_amenitie_box;

	public void Bo_amenitie_box()
	{
		Bo_amenitie_box.click();
		
	}
	@FindBy(xpath="//div[2]//div[2]//div[2]//div[1]//div[1]//div[2]//div[1]//div[1]//button[1]//span[1]")WebElement Select_button;

	public void Hotel_Select_button()
	{
		Select_button.click();
		
	}
	@FindBy(xpath="(//button[@class='ant-btn booking-center-card-action book-btn'])[1]")WebElement Book_button;

	public void Book_button()
	{
		Book_button.click();
		
	}
	@FindBy(xpath="//div[@class='show-more']")WebElement Show_more_poc;

	public void Show_more_poc()
	{
		Show_more_poc.click();
		
	}
	@FindBy(xpath="(//div[@class='select-item'])[2]")WebElement Ritu_poc;

	public void Ritu_poc()
	{
		Ritu_poc.click();
		
	}
	@FindBy(xpath="//div[@class='ant-col']//span[@class='ant-typography']//*[name()='svg']")WebElement downarrow_expand_button;

	public void Expand_button()
	{
		downarrow_expand_button.click();
		
	}
	
	@FindBy(xpath="//textarea[@placeholder='Notes ... ']")WebElement Notes;
	public void Notes()
	{
		Notes.sendKeys("hello");
	}
	
	@FindBy(xpath="//span[@class='ant-tag ant-tag-geekblue geekblue   ']")WebElement Requested_Status;
	public void Status1()
	{
		//Requested_Status.getText();
		System.out.println(Requested_Status.getText());
	}
	@FindBy(xpath="//span[@class='ant-tag ant-tag-warning warning   ']")WebElement Partially_Confirmed_Status;
	public void Status2()
	{
		//Requested_Status.getText();
		System.out.println(Partially_Confirmed_Status.getText());
	}
	@FindBy(xpath="(//span[@class='ant-tag ant-tag-success success   '])[1]")WebElement Confirmed_Status;
	public void Status3()
	{
		//Requested_Status.getText();
		System.out.println(Confirmed_Status.getText());
	}
	@FindBy(xpath="(//div[@class='ant-dropdown-trigger'])[1]")WebElement downarrow_status_button1;
	@FindBy(xpath="(//div[@class='ant-dropdown-trigger'])[2]")WebElement downarrow_status_button2;
	@FindBy(xpath="(//div[@class='ant-dropdown-trigger'])[3]")WebElement downarrow_status_button3;
	@FindBy(xpath="(//div[@class='ant-dropdown-trigger'])[4]")WebElement downarrow_status_button4;
	@FindBy(xpath="(//span[@class='ant-dropdown-menu-title-content'][normalize-space()='Confirmed'])[1]")WebElement confirm_button1;
	@FindBy(xpath="(//span[@class='ant-dropdown-menu-title-content'][normalize-space()='Confirmed'])[2]")WebElement confirm_button2;
	@FindBy(xpath="(//span[@class='ant-dropdown-menu-title-content'][normalize-space()='Confirmed'])[3]")WebElement confirm_button3;
	@FindBy(xpath="(//span[@class='ant-dropdown-menu-title-content'][normalize-space()='Confirmed'])[4]")WebElement confirm_button4;
	
	
	public void status_button1() throws InterruptedException
	{
		Thread.sleep(3000);
		downarrow_status_button1.click();
		Thread.sleep(3000);
		confirm_button1.click();
		Thread.sleep(3000);
	}
	public void status_button2() throws InterruptedException 
	{   
		Thread.sleep(3000);
		downarrow_status_button2.click();
		Thread.sleep(3000);
		confirm_button2.click();
		Thread.sleep(3000);
	}
	public void status_button3() throws InterruptedException
	{
		Thread.sleep(3000);
		downarrow_status_button3.click();
		Thread.sleep(3000);
		confirm_button3.click();
		Thread.sleep(3000);
	}
	public void status_button4()throws InterruptedException
	{
		Thread.sleep(3000);
		downarrow_status_button4.click();
		Thread.sleep(3000);
		confirm_button4.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath="//span[normalize-space()='View History']")WebElement View_History;
	@FindBy(xpath="//div[@class='ant-list-item-meta-description']")WebElement Booking_History;
	@FindBy(xpath="//span[normalize-space()='Done']")WebElement Done_Button;
	public void View_History() throws InterruptedException
	{
		View_History.click();
		System.out.println(Booking_History.getText());
		//Thread.sleep(3000);
		Done_Button.click();
	}
	@FindBy(xpath="(//input[@class='ant-input'])[1]")WebElement ref_box1;
	@FindBy(xpath="(//input[@class='ant-input'])[2]")WebElement ref_box2;
	@FindBy(xpath="//span[normalize-space()='Save Changes']")WebElement Save_Changes;
	public void Ref_box1()
	{
		ref_box1.sendKeys("123");
		
	}
	public void Ref_box2()
	{
		ref_box2.sendKeys("123");
		
	}
	public void Save_Changes_button()
	{
		Save_Changes.click();
		
	}
	
	@FindBy(xpath="(//td[@class='ant-table-cell'])[2]")WebElement Room_category_no;
	@FindBy(xpath="(//td[@class='ant-table-cell'])[3]")WebElement Meal_Plan;
	public void Room_category_no()
	{
		System.out.println(Room_category_no.getText());
		System.out.println(Meal_Plan.getText());
	}
	
	@FindBy(xpath="(//div[@class='ant-notification-notice-description'])[1]")WebElement error_popup;
	public void error_popup()
	{
		System.out.println(error_popup.getText());
		
	}
}

















