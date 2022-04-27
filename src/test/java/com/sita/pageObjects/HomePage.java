package com.sita.pageObjects;

import java.io.IOException;

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
	public void view_files_notes_for_Bo()
	{
		
		view_files_note_dots.click();
		view_files_notes.click();
		files_notes.click();
		
	}
	@FindBy(xpath="(//button[@class='ant-btn ant-btn-icon-only ant-btn-background-ghost btn-icon ant-dropdown-trigger'])[3]")WebElement view_files_note_3dots;
	@FindBy(xpath="//span[normalize-space()='View Status']")WebElement View_status;
	@FindBy(xpath="//span[contains(text(),'Files & Notes')]")WebElement Files_notes;
	@FindBy(xpath="//span[contains(@title,'Add Notes and Files')]//*[name()='svg']")WebElement Add_files_notes_button;
	@FindBy(xpath="//textarea[@placeholder='Notes ... ']")WebElement Notes2;
	@FindBy(xpath="//span[normalize-space()='Save Note']")WebElement Save_notes;
	@FindBy(xpath="(//div[normalize-space()='hello'])[1]")WebElement note_text1;
	@FindBy(xpath="(//div[normalize-space()='Fhe uploaded notes'])")WebElement note_text2;
	@FindBy(xpath="(//div[@class='download-file'])[1]")WebElement filesname1;
	@FindBy(xpath="(//div[@class='download-file'])[2]")WebElement filesname2;
	@FindBy(xpath="(//span[@class='anticon anticon-close'])[1]")WebElement cross_button;
	@FindBy(xpath="(//span[@class='ant-typography'])[3]") WebElement down_arrow;
	@FindBy(xpath="//span[normalize-space()='Follow Up']") WebElement FollowUp;
	@FindBy(xpath="//span[normalize-space()='OK']") WebElement Ok;
	@FindBy(xpath="//h5[@class='ant-typography _title back-option']") WebElement BackButton2;
	public void view_files_notes_for_fhe_followup() throws IOException, InterruptedException
	{
		
		view_files_note_3dots.click();
		View_status.click();
		Files_notes.click();
		Add_files_notes_button.click();
		File_Upload.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\sita_file_upload\\fileupload.exe");
		Notes2.sendKeys("Fhe uploaded notes");
		Save_notes.click();
		Thread.sleep(2000);
		System.out.println("The 1st note is--"+note_text1.getText());
		System.out.println("The 2nd note is--"+note_text2.getText());
		System.out.println("The 1st uploaded file is--"+filesname1.getText());
		System.out.println("The 2nd uploaded file is--"+filesname2.getText());
		cross_button.click();
		Thread.sleep(2000);
		down_arrow.click();
		FollowUp.click();
		Thread.sleep(3000);
		Ok.click();
		Thread.sleep(2000);
		BackButton2.click();
		
	}
	
	@FindBy(xpath="//span[normalize-space()='Files & Notes']")WebElement view_files_notes_poc ;
	@FindBy(xpath="//span[contains(text(),'Files & Notes')]")WebElement files_notes1 ;
	@FindBy(xpath="//div[@class='download-file']")WebElement files_notes_name ;
	@FindBy(xpath="//div[normalize-space()='hello']")WebElement note_text ;
	@FindBy(xpath="(//div[normalize-space()='POC uploaded notes'])")WebElement note_text3;
	@FindBy(xpath="(//div[@class='download-file'])[3]")WebElement filesname3;
	public void supplier_view_files_notes() throws InterruptedException, IOException
	{
		
		view_files_notes_poc.click();
		Thread.sleep(3000);
		Add_files_notes_button.click();
		Thread.sleep(3000);
		File_Upload.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\Ritu\\Documents\\sita_file_upload\\fileupload.exe");
		Notes2.sendKeys("POC uploaded notes");
		Thread.sleep(3000);
		Save_notes.click();
		Thread.sleep(2000);
		System.out.println("The 1st note is--"+note_text1.getText());
		System.out.println("The 2nd note is--"+note_text2.getText());
		System.out.println("The 2nd note is--"+note_text3.getText());
		System.out.println("The 1st uploaded file is--"+filesname1.getText());
		System.out.println("The 2nd uploaded file is--"+filesname2.getText());
		System.out.println("The 2nd uploaded file is--"+filesname3.getText());
		cross_button.click();
		
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
	@FindBy(xpath="(//div[@class='show-more'])[1]")WebElement Show_more_poc1;
	@FindBy(xpath="(//div[@class='show-more'])[2]")WebElement Show_more_poc2;
	@FindBy(xpath="(//div[@class='show-more'])[3]")WebElement Show_more_poc3;
	@FindBy(xpath="(//div[normalize-space()='Less'])[1]")WebElement Show_Less1;
	@FindBy(xpath="(//div[normalize-space()='Less'])[2]")WebElement Show_Less2;
	@FindBy(xpath="(//div[normalize-space()='Less'])[3]")WebElement Show_Less3;
	public void Show_more_poc1()
	{
		Show_more_poc1.click();
		
	}
	public void Show_more_poc2()
	{
		Show_more_poc2.click();
		
	}
	public void Show_more_poc3()
	{
		Show_more_poc3.click();
		
	}
	
	public void Show_Less1()
	{
		Show_Less1.click();
		
	}
	public void Show_Less2()
	{
		Show_Less2.click();
		
	}
	public void Show_Less3()
	{
		Show_Less3.click();
		
	}
	@FindBy(xpath="//div[@class='select-item']")WebElement Mandeep_poc;

	public void Mandeep_poc()
	{
		Mandeep_poc.click();
		
	}
	@FindBy(xpath="(//div[@class='select-item'])[2]")WebElement Ritu_poc1;

	public void Ritu_poc1()
	{
		Ritu_poc1.click();
		
	}
	@FindBy(xpath="(//div[@class='select-item'])[3]")WebElement Ritu_poc2;

	public void Ritu_poc2()
	{
		Ritu_poc2.click();
		
	}
	@FindBy(xpath="(//div[@class='select-item'])[5]")WebElement Ritu_poc3;

	public void Ritu_poc3()
	{
		Ritu_poc3.click();
		
	}
	@FindBy(xpath="(//div[@class='ant-col']//span[@class='ant-typography']//*[name()='svg'])[1]")WebElement downarrow_expand_button1;
	@FindBy(xpath="(//div[@class='ant-col']//span[@class='ant-typography']//*[name()='svg'])[2]")WebElement downarrow_expand_button2;
	@FindBy(xpath="(//div[@class='ant-col']//span[@class='ant-typography']//*[name()='svg'])[3]")WebElement downarrow_expand_button3;
	public void Expand_button1()
	{
		downarrow_expand_button1.click();
		
	}
	public void Expand_button2()
	{
		downarrow_expand_button2.click();
		
	}
	public void Expand_button3()
	{
		downarrow_expand_button3.click();
		
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
	@FindBy(xpath="//span[normalize-space()='Waitlisted']")WebElement waitlisted_button1;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/ul[1]/li[2]/span[1]")WebElement waitlisted_button2;
	
	@FindBy(xpath="(//span[@class='ant-typography'])[3]")WebElement uparrow_button1;
	
	public void Day1() throws InterruptedException
	{
		Thread.sleep(3000);
		downarrow_status_button1.click();
		Thread.sleep(3000);
		confirm_button1.click();
		Thread.sleep(2000);
		downarrow_status_button2.click();
		Thread.sleep(3000);
		confirm_button2.click();
		//Thread.sleep(3000);
	}
	public void Day2() throws InterruptedException
	{
		Thread.sleep(3000);
		downarrow_status_button1.click();
		Thread.sleep(3000);
		waitlisted_button1.click();
		Thread.sleep(3000);
		//downarrow_status_button2.click();
		//Thread.sleep(3000);
		//waitlisted_button2.click();
		//Thread.sleep(3000);
	}
	public void uparrow_button() throws InterruptedException
	{
		uparrow_button1.click(); 
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
	@FindBy(xpath="(//input[@class='ant-input'])[1]")WebElement ref_box;
	//@FindBy(xpath="(//input[@class='ant-input'])[2]")WebElement ref_box2;
	@FindBy(xpath="//span[normalize-space()='Save Changes']")WebElement Save_Changes;
	public void Ref_box()
	{
		ref_box.sendKeys("123");
		
	}
	
	public void Save_Changes_button()
	{
		Save_Changes.click();
		
	}
	
	@FindBy(xpath="(//td[@class='ant-table-cell'])[2]")WebElement Room_category_no;
	@FindBy(xpath="(//td[@class='ant-table-cell'])[3]")WebElement Meal_Plan;
	@FindBy(xpath="(//td[@class='ant-table-cell'])[1]")WebElement Pax;
	@FindBy(xpath="(//td[@class='ant-table-cell'])[5]")WebElement Contract_Type;
	@FindBy(xpath="(//div[@class='ant-popover-inner-content'])[1]")WebElement Rate_Details;
	public void Room_category_no() throws InterruptedException
	{
		System.out.println(Room_category_no.getText());
		System.out.println(Meal_Plan.getText());
		System.out.println(Pax.getText());
		
		
	}
	public void Rate_Details() throws InterruptedException
	{
		
		Contract_Type.click();
		Thread.sleep(2000);
		System.out.println(Rate_Details.getText());
	}
	
	@FindBy(xpath="(//div[@class='ant-notification-notice-description'])[1]")WebElement error_popup;
	public void error_popup()
	{
		System.out.println(error_popup.getText());
		
	}
}

















