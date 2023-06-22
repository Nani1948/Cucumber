package com.automation.pages.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.automation.pages.base.BasePage;

public class StuckOpportunitiesReportPage extends BasePage{
    
	
	
	
	public StuckOpportunitiesReportPage(WebDriver driver) {
		super(driver);
		
	}
	public String  getTitleOfTheOfStuckOpportunity() {
		return getPageTitle();
	}

}
