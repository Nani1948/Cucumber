package com.automation.pages.leadpage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.automation.pages.base.BasePage;

public class LeadPage extends BasePage{
    @FindBy(linkText="Leads")WebElement leadTab;
    @FindBy(linkText="Close")WebElement close;
    @FindBy(xpath = "//select[@id='fcf']")private WebElement dropdownElement;
	@FindBy(xpath="//input[@value=' Go! ']")WebElement go;
    @FindBy(xpath="//input[@name='new']")WebElement newButton;
	
	public LeadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
   public void clickOnLead(String text) {
	   moveToElementAction(driver, leadTab,  text);
   }
   public void clickOnClose(String text) {
	   moveToElementAction(driver, close,  text);
   }
   
  

   public void getListOfAllDropdownOptions() {
       Select dropdown = new Select(dropdownElement);
       for (WebElement option : dropdown.getOptions()) {
           String optionText = option.getText();
           System.out.println("Dropdown Option: " + optionText);
       }
   }
   public void selectTodayLeads(String text) {
	   selectByVisibleTextOfElement(dropdownElement,text);
   }
   public void clickOnGo(String text) {
	   moveToElementAction(driver,go,  text);
   }
   public void clickOnNew(String text) {
	   moveToElementAction(driver,newButton,  text);
   }
}
