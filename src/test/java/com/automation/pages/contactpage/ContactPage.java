package com.automation.pages.contactpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class ContactPage extends BasePage {
	@FindBy(linkText="Close")WebElement close;
	@FindBy(xpath="//input[@title='New']")WebElement newButton;
	@FindBy(xpath="//input[@id='name_lastcon2']")WebElement lastName;
	@FindBy(xpath="//input[@id='con4']")WebElement accountName;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']")WebElement saveButton;
	@FindBy(xpath="//a[normalize-space()='Create New View']")WebElement  createNewView;
	@FindBy(xpath="//*[@id='hotlist_mode']")WebElement listOfDropdown;
	@FindBy(xpath="//option[text()='Recently Created']")WebElement recentlyCreated;
	@FindBy(xpath="//select[@id='fcf']")WebElement dropdownListOfView;
	@FindBy(xpath="//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")WebElement    contactName;

	public ContactPage(WebDriver driver) {
		super(driver);
	}
	public void clickOnClose(String text) {
		   moveToElementAction(driver, close,  text);
	}
	public void clickOnNewButton(String text) {
		   moveToElementAction(driver, newButton,  text);
	}
	public String  getTitleOfTheContactEditNewContact() {
		return getPageTitle();
	}
	public void setLastName(String lastNameData,String text) {
		clearElement(lastName, text);
		enterText(lastName, lastNameData,  text);
	}
	public void setAccountName(String accountNameData,String text) {
		clearElement(accountName, text);
		enterText(accountName, accountNameData,  text);
	}
	public void clickOnSave(String text) {
		 moveToElementAction(driver, saveButton,  text);
	}
	public String  getTitleOfTheContactName() {
		return getPageTitle();
	}
	public void clickOnCreateNewView(String text) {
		 moveToElementAction(driver,createNewView,  text);
	}
	public void  selectOptionFromDropdown(String text) {
		waitForElementToBeVisible(driver, listOfDropdown, 20,text);
		moveToElementAction(driver,listOfDropdown,  text);
		selectByVisibleTextOfElement(listOfDropdown, text);
	}
	public void  selectOptionFromViewDropdown(String text,String text1) {
		moveToElementAction(driver,dropdownListOfView,  text);
		selectByVisibleTextOfElement(dropdownListOfView, text1);
	}
	public void clickOnContactName(String text) {
		 moveToElementAction(driver,contactName,  text);
	}
}
