package com.automation.pages.homepage.developerconsole;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class DeveloperConsolePage extends BasePage {
   @FindBy(xpath="//a[@class='debugLogLink menuButtonMenuLink']")WebElement developerConsole;
	public DeveloperConsolePage(WebDriver driver) {
		super(driver);
		
	}
	public void clickOnDeveloperConsole() {
		moveToElementAction(driver, developerConsole,"Developer Console");
		log.info("Developer console is opened");
	}
	
}
