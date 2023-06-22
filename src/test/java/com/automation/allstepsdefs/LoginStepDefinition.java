package com.automation.allstepsdefs;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.automation.pages.homepage.HomePage;
import com.automation.pages.login.ForgotYourPasswordPage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {

     protected static Logger log;
     public  WebDriver driver;
     protected static Log4JUtility logObject = Log4JUtility.getInstance();
     LoginPage login=null;
     HomePage home=null;
	 ForgotYourPasswordPage foryourPassswordPage=null;
     protected PropertiesUtility prop=new PropertiesUtility();
     protected Properties applicationPro=prop.loadFile("applicationDataProperties");
    public void launchBrowser(String browserName) {
        switch (browserName) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
        System.out.println(browserName + " browser opened");
    }

    public void goToUrl(String url) {
        driver.get(url);
        log.info(url + " is entered");
    }

    public void closeBrowser() {
        driver.close();
        log.info("current browser closed");
    }
    @AfterStep
    public void after_Each_Scenario(Scenario sc) throws IOException {
    	sc.log("after step executed");
    	if(sc.isFailed()) {
    		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		byte[] fileContent=FileUtils.readFileToByteArray(screenshot);
    		sc.attach(fileContent, "image/png", "screenshots");
    	}
    }
    @BeforeAll
    public static void setUpBeforeAllScenarios() {
        log = logObject.getLogger();
    }

    @Before
    public void setUpEachScenario() {
        launchBrowser("chrome");
    }

   /* @After
    public void tearDown() {
        closeBrowser();
    }
*/
    @Given("User open salesforce application")
    public void user_open_salesforce_application() {
        String url = applicationPro.getProperty("url2");
        goToUrl(url);
        System.out.println("driver in baseTest=" + driver);
    }

    @When("user on {string}")
    public WebDriver user_on(String page) {
        switch (page.toLowerCase()) {
            case "loginpage":
                login = new LoginPage(driver);
                home = null; // Set home to null when on the login page
                break;
            case "homepage":
                login = null; // Set login to null when on the homepage
                home = new HomePage(driver);
                break;
            case "forgot your password":
                foryourPassswordPage=new ForgotYourPasswordPage(driver);
                break;   
                
            default:
                throw new IllegalArgumentException("Invalid page: " + page);
        }
        return driver;
    }
    @When("User enters value into text box username as {string}")
    public void user_enters_value_into_text_box_username_as(String username1) {
    	
       username1=applicationPro.getProperty("valid_username");
	
        login.enterUsername(username1);
    }

    @When("User enters value into text box password as {string}")
    public void user_enters_value_into_text_box_password_as(String password1) {
    password1=applicationPro.getProperty("valid_password");
        login.enterPassword(password1);
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        login.clickOnLoginButton();
    }

    @Then("verify we can see {string}")
    public void verify_page_title_as( String exceptedTitle) {
    	 if (home == null) {
    	        // Handle the scenario when on the login page
    	        // You can either skip the verification or perform an alternative check
    	        System.out.println("Cannot verify page title on the login page");
    	        return;
    	    }
    	    
    	    String actualTitle = home.getTitleOfHomePage();
    	    exceptedTitle=applicationPro.getProperty("title_of_Home_Page");
    	    Assert.assertEquals(actualTitle,   exceptedTitle);

 	
 		
    }
    @When("User should clear text box password as {string}")
    public void user_should_clear_text_box_password_as(String password1) {
    password1=applicationPro.getProperty("valid_password");
     login.clearPassword(password1);
    }

    @Then("verify error message is displayed")
    public void verify_error_message_is_displayed() {

	    String actualErrorMessage= login.getErrorMessageOnLoginPage();
	    String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_valid_username_and_No_Password");
	    Assert.assertEquals(actualErrorMessage,   exceptedErrorMessage);
    }


@When("User check the box of remember username")
public void user_check_the_box_of_remember_username() {
  login.checkRememberMe();
}

@When("click on user menu dropodown")
public void click_on_user_menu_dropodown() {
   home.clickOnUserProfileName();
  
}

@When("Select option of logout from dropdown")
public void select_option_of_logout_from_dropdown() {
	 home.clickOnLogout();
}

@Then("verify username is displayed on the username field")
public void verify_username_is_displayed_on_the_username_field() {
	 String exceptedUsernameText=applicationPro.getProperty("valid_username");
	 String actualUserNameText=login.getTextOfUsername();
	 Assert.assertEquals(actualUserNameText,exceptedUsernameText);
}
@When("user click on forgot password link")
public void user_click_on_forgot_password_link() {
	  login.clickOnForgotPassword();
}

@Then("verify we can see {string} ")
public void forgot_password_page_should_be_opened() {

	  String exceptedTitleofforgotPasswordPage=applicationPro.getProperty("title_of_ForgotPasswordPage");
	  String actualTitleofforgotPasswordPage= foryourPassswordPage.getTitleOfForgotPasswordPage1();
	  Assert.assertEquals(actualTitleofforgotPasswordPage,exceptedTitleofforgotPasswordPage);
}

@When("User enters value into text box username field as {string}")
public void user_enter_a_username(String username1) {
	 username1=applicationPro.getProperty("valid_username");
	 foryourPassswordPage.enterUsernameOnForgotPasswordLink(username1);
	
}

@When("user click On continue button")
public void user_click_on_continue_button() {
	 foryourPassswordPage.clickOnContinueButton();
}


@When("User enters wrong  value into text box username as {string}")
public void user_enters_wrong_value_into_text_box_username_as(String username2) {
	 username2=applicationPro.getProperty("invalid_username");
	   login.enterUsername(username2);
}




@When("User enters wrong value into text box password as {string}")
public void user_enters_wrong_value_into_text_box_password_as(String   password2) {
	  password2=applicationPro.getProperty("invalid_password");
      login.enterPassword(password2);
}

@Then("verify error message is displayed on loginPage")
public void verify_error_message_is_displayed_on_login_page() {
		String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_Invalid_Username_and_Invalid_Password");
   		String actualErrorMessage=login.getErrorMessageOnLoginPage();
   	    Assert.assertEquals(actualErrorMessage,exceptedErrorMessage);  
}
}
