package com.automation.pages.homepage.myprofile.EditPage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class EditPage extends BasePage{

	//@FindBy(xpath="//div[@class='editPen']//a[@class='contactInfoLaunch editLink']/img[@title='Edit Profile']")WebElement editButton;
	

	//protected String frame1="contactInfoContentId";
	//@FindBy(id="contactInfoContentId")WebElement frame1;
	@FindBy(xpath="//a[normalize-space()='About']")WebElement about;
	@FindBy(xpath="//*[@id='lastName']")WebElement lastName;
	@FindBy(xpath="//input[@value='Save All']")WebElement saveAll;
	
	//@FindBy(xpath="//body[1]/div[4]/div[2]/div[1]/div[1]/iframe[1]")WebElement frame1;
	//@FindBy(css="iframe#contactInfoContentId")WebElement frame1;
	@FindBy(xpath="//a[contains(text(),'Close')][1]")WebElement close;
	public EditPage(WebDriver driver) {
		super(driver);
		
	}
	public void  clickOnAbout(String text) {
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", about);
	    log.info("user is clicked about Button");
	}
	

    public void switchToFrame1() {
        
    	
    	//switchToFrameByText(frame1);
    	driver.switchTo().frame("contactInfoContentId");
    	  log.info("SwitchToFrame");
       
    }
    
    
    public void enterLastname(String text1,String text2) {
    	clearElement(lastName, text2);
    	enterText(lastName, text1, text2);
    }
    public void clickOnSaveAllButton(String text) {
    	moveToElementAction(driver, saveAll, text);
    }
    public void clickOnCloseButton(String text) {
    	JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", close);
	    log.info("user is clicked Close Button");
    }
  
    public void switchToDefaultWindow() {
    	switchToDefaultWindow();
    }
}
