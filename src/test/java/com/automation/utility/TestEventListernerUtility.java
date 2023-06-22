package com.automation.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import com.automation.utility.ExtentReportUtility2;

public class TestEventListernerUtility implements ITestListener {
    protected  ExtentReportUtility2 extentReport;

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReportUtility2.getInstance();
        System.out.println("inside onStart listeners" + extentReport);
        extentReport.startExtentReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentReport.startSingleTestReport(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentReport.logTestPass(result.getMethod().getMethodName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentReport.logTestFail(result.getMethod().getMethodName() + " is failed");
        extentReport.logTestFailedWithException(result.getThrowable());
        /*BaseTest ob=new BaseTest();
        WebDriver driver =ob.returnDriverInstance();
        extentReport.logTestFailedWithScreenshot(ob.getScreenshotOfThePage(driver).getAbsolutePath());
        */
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentReport.logTestSkip(result.getMethod().getMethodName() + " is skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.endReport();
    }
}