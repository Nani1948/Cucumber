package com.automation.pages.contactpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ContactEditNewContactPage extends BasePage{
   
	
	
	@FindBy(xpath="//input[@id='name_lastcon2']")WebElement lastName;
	@FindBy(xpath="//input[@id='con4']")WebElement accountName;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save & New']")WebElement saveandNewButton;
	public ContactEditNewContactPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void setLastName(String lastNameData,String text) {
		clearElement(lastName, text);
		enterText(lastName, lastNameData,  text);
	}
	public void setAccountName(String accountNameData,String text) {
		clearElement(accountName, text);
		enterText(accountName, accountNameData,  text);
	}
	public void clickOnSaveAndNew(String text) {
		 moveToElementAction(driver,saveandNewButton,  text);
	}
}
