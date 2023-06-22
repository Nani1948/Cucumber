package com.automation.pages.accountpage.accountreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.pages.base.BasePage;

public class AccountReport extends BasePage {
    @FindBy(id="ext-gen149")WebElement dropdownListOfDate;
    @FindBy(xpath="//div[contains(text(),'Created Date')]")WebElement createDate;
    @FindBy(xpath="//img[@id='ext-gen153']")WebElement clickOnFromDateCalendarIcon;
    @FindBy(xpath="//*[@id='ext-gen286']")WebElement todayDate;
    @FindBy(xpath="//button[@id='ext-gen50']")WebElement saveButton;
	@FindBy(xpath="//input[@id='saveReportDlg_reportNameField']")WebElement  reportName;
	@FindBy(xpath="//input[@id='saveReportDlg_DeveloperName']")WebElement    reportUniqueName;
	@FindBy(xpath="//table[@id='dlgSaveAndRun']")WebElement  saveAndRunReport;
    public AccountReport(WebDriver driver) {
		super(driver);
	}
	public void clickOnDropdownDate(String text) {
		 
		moveToElementAction(driver, dropdownListOfDate,  text);
	}
	public void clickOnCreateDate(String text) {
		 
		moveToElementAction(driver, createDate,  text);
	}
	public void clickOnFromCalendarIcon(String text) {
		waitForElementToBeVisible(driver, clickOnFromDateCalendarIcon, 40, text);
		moveToElementAction(driver, clickOnFromDateCalendarIcon,  text);
	}
	public void clickOnTodayDate(String text) {
		
		moveToElementAction(driver,todayDate,  text);
	}
	public void clickOnSaveButton(String text) {
		moveToElementAction(driver,saveButton,  text);
	}
	public void setReportName(String reportNameData,String text) {
		clearElement(reportName, text);
		enterText( reportName,reportNameData,  text);
	}
	public void setReportUniqueName(String reportUniqueNameData,String text) {
		clearElement(reportUniqueName, text);
		enterText(reportUniqueName,reportUniqueNameData,  text);
	}//saveAndRunReport
	public void clickOnSaveAndRunReport(String text) {
		waitForElementToBeVisible(driver, saveAndRunReport, 40, text);
	moveToElementAction(driver,saveAndRunReport,  text);
}
}