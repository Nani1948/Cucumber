package com.automation.pages.accountpage.mergeaccount;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class MergeAccount extends BasePage {
	//MergeAccount
	
		@FindBy(xpath="//input[@id='srch']")WebElement searchBox;
		@FindBy(xpath="//input[@value='Find Accounts']")WebElement findAccount;
		@FindBy(xpath="//input[@id='cid0']")WebElement  isCheckedBox1;
		@FindBy(xpath="//input[@id='cid1']")WebElement  isCheckedBox2;
		@FindBy(xpath="//input[@value=' Next ']")WebElement  nextButton;
		@FindBy(xpath="//input[@value=' Merge ']")WebElement mergeButton;
		@FindBy(xpath="//select[@id='fcf']")WebElement selectOptionsFromView;
	public MergeAccount(WebDriver driver) {
		super(driver);
		
	}
	
	public void setAccountNameInSearchBox(String searchBoxData,String text) {
			clearElement(searchBox, text);
			enterText(searchBox, searchBoxData,  text);
	}
	public void clickOnFindAccount(String text) {
		 
		moveToElementAction(driver, findAccount,  text);
	}
	public void clickOnFirstCheckBox() {
		 
		isChecked(isCheckedBox1, true);
		log.info("Box1 is  checked");
	}
	public void clickOnSecondCheckBox() {
		 
		isChecked(isCheckedBox2, true);
		log.info("Box2 is  checked");
	}
	public void clickOnNext(String text) {
		 
		moveToElementAction(driver, nextButton,  text);
	}
	public void clickOnMerge(String text) {
		 
		moveToElementAction(driver, mergeButton,  text);
	}
	public void clickOnPopup(String text) {
		try {
            // Attempt to switch to the alert
            Alert alert = driver.switchTo().alert();
            alert.accept();
          

        } catch (NoAlertPresentException e) {
            System.out.println("No alert is present.");
        }
	 
		selectByVisibleTextOfElement(selectOptionsFromView, text);
    }
	
	
}
