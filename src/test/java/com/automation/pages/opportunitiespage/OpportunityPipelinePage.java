package com.automation.pages.opportunitiespage;

import org.openqa.selenium.WebDriver;

import com.automation.pages.base.BasePage;

public class OpportunityPipelinePage extends BasePage{

	public OpportunityPipelinePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String  getTitleOfTheOfOpportunityPipeline() {
		return getPageTitle();
	}

}
