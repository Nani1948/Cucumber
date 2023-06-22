package com.automation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtility1 {
	public static ExtentReports report;
	public static 	ExtentSparkReporter spark;
	public static ExtentTest testLogger;
	private static ExtentReportUtility1 extentObject;
	public void startExtentReport() {
		// create a spark report and then attach the report to it spark.html , set the system configuration in this methods
		
		report=new ExtentReports();
	    spark=new ExtentSparkReporter(Constants.SPARK_HTML_REPORT_PATH);
		report.attachReporter(spark);
		
		//setSystemInformation
		report.setSystemInfo("HostName", "Value");
		report.setSystemInfo("Rani", "SalesforceQA");
		report.setSystemInfo("Ran", "Salesforce developer");
		
		//setDocumentTitle
		spark.config().setDocumentTitle("Test Executuioon");
		//setReportName
		spark.config().setReportName("firebase regression");
		//setTheme
		spark.config().setTheme(Theme.DARK);
	}
	private ExtentReportUtility1() {
		
	}
	public  static ExtentReportUtility1 getInstance() {
		if(extentObject==null) {
			extentObject=new ExtentReportUtility1();
		}
		
			return extentObject;
		}
		
	
    public  void  startSingleTestReport(String methodName) {
    	testLogger=report.createTest(methodName);
    }
    // close the report
    public  void  endReport() {
    	report.flush();
    }
    public  void  logTestInfo(String text) {
    	testLogger.log(Status.INFO, text);
    	//testLogger.info(text);
    }
    public  void  logTestPass(String text) {
    	testLogger.log(Status.PASS,MarkupHelper.createLabel(text,ExtentColor.GREEN));
    }
    public  void  logTestFail(String text ) {
    	testLogger.log(Status.FAIL,MarkupHelper.createLabel(text,ExtentColor.RED));
    }
    public  void  logTestSkip(String text) {
    	testLogger.log(Status.SKIP,MarkupHelper.createLabel(text,ExtentColor.ORANGE));
    }
    public  void  logTestWarning( String text) {
    	testLogger.log(Status.WARNING, text);
    	testLogger.info(text);
    }
    public void logTestFailedWithException(Throwable e) {
    	testLogger.log(Status.FAIL,e);
    }
    public void logTestFailedWithScreenshot(String path) {
    	testLogger.addScreenCaptureFromPath(path);
    }
    }

