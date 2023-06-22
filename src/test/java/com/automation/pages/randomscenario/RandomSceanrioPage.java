package com.automation.pages.randomscenario;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class RandomSceanrioPage extends BasePage{
    @FindBy(xpath="//*[@id='ptBody']/div/div[2]/span[1]/h1/a")WebElement userNameOnHomePage;
    @FindBy(xpath="//a[contains(@class, 'contactInfoLaunch editLink')]")WebElement editButton;
    @FindBy(xpath="//*[@id='contactInfoX']")WebElement close;
	@FindBy(xpath="//input[@id='lastName']")WebElement lastName;
	
	public RandomSceanrioPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String getTextOfUserName() {
	
		log.info("First and Last Name:"+userNameOnHomePage.getText());
		return userNameOnHomePage.getText();
	}
	 public void clickOnUserName() {
	    	moveToElementAction(driver,  userNameOnHomePage," UserName");
	    }
	 public String getTitleOfUserProfileOnHomePage(String text) {
		 clickElement(driver, userNameOnHomePage, text);
	    
	    	return getPageTitle().toString();
	    }
	 
	 public String getTitleOfUserProfilePage() {
			return getPageTitle().toString();
	 }
	 public void  clickOnEditButton(String text) {
		    // performMouseHoverWithWait(driver, editButton);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			jsExecutor.executeScript("arguments[0].click();", editButton);
		    log.info("user is clicked on Edit Button");
		}  
	 public void switchToFrame1() {
	        
	    	
	    	//switchToFrameByText(frame1);
	    	driver.switchTo().frame("contactInfoContentId");
	    	  log.info("SwitchToFrame");
	       
	    }
	 public void clickOnClose() {
	    	moveToElementAction(driver,   close," Close");
	    }
	 public void enterLastname(String text1,String text2) {
	    	clearElement(lastName, text2);
	    	enterText(lastName, text1, text2);
	    }
}
