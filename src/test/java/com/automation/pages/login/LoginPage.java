package com.automation.pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage{
// In LOginPage-we shouldn't use any selenium commands exceptReusable method

	
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="Login")WebElement loginButton;
	@FindBy(xpath="//label[contains(text(),'Remember me')] ")WebElement  rememberMe;
	@FindBy(xpath="//span[@id='idcard-identity']")WebElement  textOfUsername;
	@FindBy(xpath="//div[@id='error']")WebElement     textOfErrorMessage;
	@FindBy(xpath="//a[contains(text(),'Forgot Your Password?')]")WebElement forgotPasswordlink;
	public LoginPage(WebDriver driver){
		super(driver);// it will call the super class constructor;when to call super constuructor it will intialize the webelement and this refer to the current object of LoginPage.
	}
	
	public void enterUsername(String usernameData) {
		clearElement(username, "Username field");
		enterText(username, usernameData, "Username field");
	}
	
	public void enterPassword(String passwordData) {
		clearElement(password, "Password  field");
		enterText(password, passwordData, "Password field");
	}
	public void clearPassword(String passwordData) {
		clearElement(password, "Password  field");
		
	}
	public void clickOnLoginButton() {
		clickElement(driver, loginButton,"Login Button");
	}
	
	public void checkRememberMe() {
		isChecked( rememberMe, true);
	}
	

	public String getTextOfUsername() {
		return getText(textOfUsername);
	}
	
	public String getTitleOfThePage() {
		return getPageTitle();
	}
	
	public String getErrorMessageOnLoginPage() {
		   return getText(textOfErrorMessage);
	   }
	public void  clickOnForgotPassword() {
		moveToElementAction(driver,forgotPasswordlink,"Forgot Password Link");
	}
}
