package com.automation.allrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features/salesforcelogin.feature",
    glue = "com.automation.allstepsdefs",
    monochrome = true,
    dryRun = false,
    plugin = {
        "pretty",
        "html:target/cucumber1.html",
        "json:target/cucumber1.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}