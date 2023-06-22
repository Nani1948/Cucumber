package com.automation.utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


	public class ExtentReportUtility2 {
	
	    private static ExtentReports report;
	    private static ExtentSparkReporter spark;
	    private static ExtentTest testLogger;
	    private static ExtentReportUtility2 extentObject1;
	    protected ExtentReportUtility2() {
	        // Private constructor to prevent direct instantiation
	    }

	    public static synchronized ExtentReportUtility2 getInstance() {
	        if (extentObject1 == null) {
	            extentObject1= new ExtentReportUtility2();       
	        }
	        return extentObject1;
	    }

	    public void startExtentReport() {
	        // Create a spark report and attach it to the extent report
	        spark = new ExtentSparkReporter(Constants.SPARK_HTML_REPORT_PATH);
	        report = new ExtentReports();
	        report.attachReporter(spark);

	        // Set system information
	        report.setSystemInfo("HostName", "Value");
	        report.setSystemInfo("Rani", "SalesforceQA");
	        report.setSystemInfo("Ran", "Salesforce developer");

	        // Set document title
	        spark.config().setDocumentTitle("Test Execution");
	        // Set report name
	        spark.config().setReportName(" Regression");
	        // Set theme
	        spark.config().setTheme(Theme.DARK);
	    }

	    public void startSingleTestReport(String methodName) {
	        testLogger = report.createTest(methodName);
	        extentObject1 = this;
	    }

	    public void endReport() {
	        report.flush();
	    }

	    public void logTestInfo(String text) {
	        if (testLogger != null) {
	            testLogger.log(Status.INFO, text);
	            testLogger.info(text);
	        } else {
	            System.out.println("Test logger not initialized. Please call startSingleTestReport() first.");
	        }
	    }

	    public void logTestPass(String text) {
	        testLogger.log(Status.PASS, MarkupHelper.createLabel(text, ExtentColor.GREEN));
	    }

	    public void logTestFail(String text) {
	        testLogger.log(Status.FAIL, MarkupHelper.createLabel(text, ExtentColor.RED));
	    }

	    public void logTestSkip(String text) {
	        testLogger.log(Status.SKIP, MarkupHelper.createLabel(text, ExtentColor.ORANGE));
	    }

	    public void logTestWarning(String text) {
	        testLogger.log(Status.WARNING, text);
	        testLogger.info(text);
	    }

	    public void logTestFailedWithException(Throwable e) {
	        testLogger.log(Status.FAIL, e);
	    }

	    public void logTestFailedWithScreenshot(String path) {
	        testLogger.addScreenCaptureFromPath(path);
	    }
	}
