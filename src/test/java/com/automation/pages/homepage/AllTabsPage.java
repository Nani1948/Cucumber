package com.automation.pages.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AllTabsPage extends BasePage{
    @FindBy(xpath="//input[@title='Customize My Tabs']")WebElement customizedMyTabs;
	public AllTabsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void clickOnCustomizeMyTabs(String text) {
    	moveToElementAction(driver, customizedMyTabs,text);
    	
  }
	
	
  
}
