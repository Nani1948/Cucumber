package com.automation.pages.homepage.mysetting.email;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class EmailSetting  extends BasePage{
    //Email
	@FindBy(xpath="//div[@id='EmailSetup']")WebElement emailLink;
	@FindBy(linkText="My Email Settings")WebElement  myEmailSetting;
	@FindBy(xpath="//input[@id='sender_name']") WebElement sendName;
	@FindBy(xpath="//input[@id='sender_email']") WebElement email;
	@FindBy(xpath="//input[@id='auto_bcc1']") WebElement ischeckedBCC;
	@FindBy(xpath="//input[@class='btn primary' and @name='save']") WebElement saveButtonOnCalendarRemainder;
	@FindBy(xpath="//div[@id='CalendarAndReminders']") WebElement CalendarAndRemainder;
	@FindBy(xpath=" clickOnActivityRemainder") WebElement ActivityRemainder;
	@FindBy(xpath="//input[@id='testbtn']") WebElement OpenATestRemainder;
	public EmailSetting(WebDriver driver) {
		super(driver);
	}
	 public void clickOnEmailLink() {
	    	clickElement(driver,  emailLink, "Email");
	    }
	    public void clickOnMyEmailSetting() {
	    	clickElement(driver,  myEmailSetting, "Email Setting");
	    }
	    public void enterSendName(String text1) {
	    	clearElement(sendName, "Send Name");
	    	enterText( sendName, text1,"Send Name");
	    }
	    public void enterEmail(String text1) {
	    	clearElement(email, "Email");
	    	enterText(email, text1,"Email");
	    }
	    public void isBCCChecked() {
	    	deselectRadioButton(ischeckedBCC, "Radio button");
	    	selectRadioButton(ischeckedBCC,"Radio button");
	    }
	    public void clickOnSaveOfEmailSettingPage() {
	    	clickElement(driver,  saveButtonOnCalendarRemainder, "Save Button");
	    }
	   
}
