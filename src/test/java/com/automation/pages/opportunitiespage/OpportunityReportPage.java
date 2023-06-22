package com.automation.pages.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.automation.pages.base.BasePage;

public class OpportunityReportPage extends BasePage{

	public OpportunityReportPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String  getTitleOfTheOpportunityReport() {
		return getPageTitle();
	}
}
