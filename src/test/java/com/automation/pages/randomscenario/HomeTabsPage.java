package com.automation.pages.randomscenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class HomeTabsPage extends BasePage{

	@FindBy(xpath="//a[normalize-space()='Monday June 19, 2023']")WebElement  dateandTimeLink;
	public HomeTabsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    public void clickOnDateAndTime(String text) {
    	
        moveToElementAction(driver,dateandTimeLink,  text);
    }
    
}
