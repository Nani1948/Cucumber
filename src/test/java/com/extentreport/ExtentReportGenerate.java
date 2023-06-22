package com.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportGenerate {
	
	public  static  void main(String[]args) {
	ExtentReports report=new ExtentReports();
	//target./Spark.html= it is a path where the report is generated.
	ExtentSparkReporter spark=new ExtentSparkReporter("Spark.html");
	//spark type of report is attached to ExtentReport with .html.so the report is ready has been generated.S
	
	report.attachReporter(spark);
	//givethe ssytem.info
	report.setSystemInfo("HostName", "Value");
	report.setSystemInfo("Rani", "SalesforceQA");
	report.setSystemInfo("Ran", "Salesforce developer");
	
	
	spark.config().setDocumentTitle("Test Executuioon");
	
	spark.config().setReportName("firebase regression");
	spark.config().setTheme(Theme.DARK);
	
	
	// create a test for a particular testmethod with  name.
	ExtentTest reportLogger=report.createTest("testScript1");
	// Now add report method
	reportLogger.log(Status.INFO, "Started Execution");
	reportLogger.log(Status.PASS, "Test Method is passed");
	reportLogger.log(Status.SKIP, "Test Method is skipped");
	reportLogger.log(Status.FAIL, "Test Method is Failed");

	reportLogger.log(Status.WARNING, "Test Method is not executed");
	
	ExtentTest reportLogger1=report.createTest("testScript2");
	// Now add report method
	reportLogger1.log(Status.INFO, "Started Execution");
	reportLogger1.log(Status.PASS, "Test Method is passed----------------");
	reportLogger1.log(Status.SKIP, "Test Method is skipped--------------");
	reportLogger1.log(Status.FAIL, "Test Method is Failed-------------");

	reportLogger1.log(Status.WARNING, "Test Method is not executed-------------");
	
	}
}
