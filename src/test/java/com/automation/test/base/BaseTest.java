package com.automation.test.base;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import java.time.Duration;
import com.automation.utility.ExtentReportUtility2;
import com.automation.utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;

	// Create an objectOf logger
	protected Logger log;
	protected ExtentReportUtility2 report1=ExtentReportUtility2.getInstance();
		
		@BeforeTest
		public void setUpBeforeTest() {
			// LogManager
			log=LogManager.getLogger(BaseTest.class);
			// return log
         // this is method can be used for the parent class and all other child class also.
			
			
		}
		/*@AfterTest()
		public void setUpAfterTest() {
			
		}*/
		@BeforeMethod
		@Parameters("browserName")
		public void setUpBeforeTestMethod(@Optional("chrome")String browName) {
			PropertiesUtility prop=new PropertiesUtility();
			Properties applicationPro=prop.loadFile("applicationDataProperties");
			String url1=applicationPro.getProperty("url2");
			launchBrowser(browName);
			log.info(browName+" is launched");
			report1.logTestInfo(browName+" is launched");
			goToURL(url1);
			log.info(url1+"is enterd in the searchBar");
			report1.logTestInfo(url1+"is enterd in the searchBar");
		}
	/*	@AfterMethod
		public void tearDownAfterTestMethod() {
		driver.close();
		report1.logTestInfo("Browser is closed");
		}*/
		public void launchBrowser(String browserName) {
			 switch (browserName) {
		        case "chrome":
		            WebDriverManager.chromedriver().setup();
		            driver = new ChromeDriver();
		            driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;

		        case "firefox":
		            WebDriverManager.firefoxdriver().setup();
		            driver = new FirefoxDriver();
		            driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;

		        case "Edge":
		            WebDriverManager.edgedriver().setup();
		            driver = new EdgeDriver();
		            driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		            driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		            driver.manage().window().maximize();
		            driver.manage().deleteAllCookies();
		            break;
		    }
		
		//Please note that this code assumes you have the appropriate WebDriverManager dependencies and imports included in y
			log.info(browserName+"is opened");
		}
			/*
			if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		          driver.manage().window().maximize();
		          driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
			}
			else if(browserName.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		        driver.manage().window().maximize();
		        driver.manage().deleteAllCookies();  
				driver.manage().window().maximize();
			}
			else if(browserName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
		          driver=new EdgeDriver();
		          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		          driver.manage().window().maximize();
		          driver.manage().deleteAllCookies();
			}
		}	*/
	
		public void goToURL(String url) {
		    driver.get(url);
		    log.info(url + " is entered");
		}

		
	
		//----------------close application----------------------------------
		    public void closeApplication() {
		    	driver.close();
		    	log.info("Browser is closed");
		    }
		    public  void quitApplication() {
		    	driver.quit();
		    	log.info("All browser window is closed");
		    }
		    
		
		}

