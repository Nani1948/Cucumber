package com.automation.pages.accountpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountPage extends BasePage{
	@FindBy(linkText="Close")WebElement close;
	@FindBy(xpath="//input[@name='new' and @value=' New ']")WebElement newButton;
	@FindBy(xpath="//input[@id='acc2']")WebElement accountName;
	@FindBy(xpath="//select[@id='acc6']")WebElement  dropdownListOFType;
	@FindBy(xpath="//select[@tabindex='26']") WebElement dropdownListOFCustomerPrority;
	@FindBy(xpath="//input[@name='save' and @value=' Save ']") WebElement saveButton;
	@FindBy(linkText="Create New View")WebElement createNewView;
	@FindBy(xpath="//select[@id='fcf']")WebElement  dropdownListOfView;
	@FindBy(xpath="//input[@value=' Go! ']")WebElement go;
	@FindBy(xpath="//a[contains(text(),'Edit')]") WebElement editButton;
	@FindBy(xpath="//input[@id='fname']")WebElement  viewName;
	@FindBy(xpath="//input[@id='devname']")WebElement uniqueName;
	@FindBy(xpath="//input[@id='fscope1']")WebElement  allAccount;
	@FindBy(xpath="//select[@id='fcol1']")WebElement   selectAccountName;
	@FindBy(xpath="//select[@id='fop1']")WebElement   operator;
	@FindBy(xpath="//input[@id='fval1']")WebElement value;
	@FindBy(xpath="//input[@value=' Save ' and @name='save'][1]")WebElement saveButton1;
	@FindBy(linkText="Merge Accounts")WebElement mergeAccount;
	@FindBy(linkText="Accounts with last activity > 30 days")WebElement accountsIsGreaterThan30Days;
	public AccountPage(WebDriver driver) {
		super(driver);
		
	}
	public void clickOnClose(String text) {
		   moveToElementAction(driver, close,  text);
	}
	public void clickOnNew(String text) {
	 moveToElementAction(driver, newButton,  text);
    }
	
	public void setAccountName(String accountNameData,String text) {
		clearElement(accountName, text);
		enterText(accountName, accountNameData,  text);
	}
	
	public void  selectTechnologyPartnerFromPartner(String text) {
		selectByVisibleTextOfElement(dropdownListOFType, text);
	}
	
	public void  selectHighFromCustomerPriority(String text) {
		selectByVisibleTextOfElement(dropdownListOFCustomerPrority, text);
	}
	public void clickOnGo(String text) {
		 moveToElementAction(driver, go,  text);
	}
	public void clickOnSave(String text) {
		 moveToElementAction(driver, saveButton,  text);
	}
	public void clickOnCreateNewView(String text) {
		 moveToElementAction(driver,createNewView,  text);
	}	
	public void selectFromViewDropdown(String text) {
		selectByVisibleTextOfElement(dropdownListOfView, text);
	}
	public void clickOnEdit(String text) {
		 moveToElementAction(driver,editButton,  text);
	}
	public void setViewName(String viewNameData,String text) {
		//clearElement(viewName, text);
		enterText( viewName,viewNameData,  text);
	}
	public void setUniqueName(String uniqueNameData,String text) {
		clearElement(uniqueName, text);
		enterText( uniqueName,uniqueNameData,  text);
	}
	public void clickOnAllAccount(String text) {
		 moveToElementAction(driver, allAccount,  text);
	}
	public void  selectEqualFromOperator(String text) {
		selectByVisibleTextOfElement( operator, text);
	}
	public void  selectAccountNameFromField(String text) {
		//selectAccountName.click();
		selectByVisibleTextOfElement(selectAccountName, text);
	}
	public void setValue(String valueData,String text) {
		enterText(value,valueData,  text);
	}
	public void clickOnSave1(String text) {
		 moveToElementAction(driver, saveButton,  text);
	}
	public void clickOnMergeAccount(String text) {
		 
		moveToElementAction(driver, mergeAccount,  text);
	}
	public void clickOnAccountsIsGreaterThan30Days(String text) {
		 
		moveToElementAction(driver, accountsIsGreaterThan30Days,  text);
	}
}
