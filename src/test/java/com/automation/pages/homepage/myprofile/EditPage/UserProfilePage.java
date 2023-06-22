package com.automation.pages.homepage.myprofile.EditPage;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
//import org.sikuli.api.Screen;

import com.automation.pages.base.BasePage;

import io.reactivex.rxjava3.functions.Action;

public class UserProfilePage extends BasePage {
	Actions action=new Actions(driver);
	public UserProfilePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//a[contains(@class, 'contactInfoLaunch editLink')]")WebElement editButton;
	@FindBy(css="#publisherAttachTextPost > span:nth-child(2)")WebElement postLink;
	
	//@FindBy(className="chatterPublisherRTE cke_editable cke_editable_themed cke_contents_ltr cke_show_borders")WebElement postText;
	@FindBy(css="#cke_publisherRichTextEditor_arialbl")WebElement postText;	
	@FindBy(xpath="//input[@id='publishersharebutton']")WebElement shareButton;
	@FindBy(xpath="//*[@id='cke_43_contents']/iframe")WebElement frame1;

	//File
	@FindBy(xpath="//*[@id='publisherAttachContentPost']/span[1]")WebElement File;
	@FindBy(xpath="//*[@id='chatterUploadFileAction']")WebElement uploadAFileFromComputer;
	@FindBy(id="chatterFile")WebElement choose;

	//AddPhoto
	@FindBy(xpath="//span[@class='profileImage chatter-avatarFull chatter-avatar']")WebElement  profileImage;
	@FindBy(xpath="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/a[1]")WebElement addPhoto;
	@FindBy(xpath="//body[1]/span[1]/form[1]/input[2]")WebElement choose1;
	@FindBy(xpath="//input[@id='j_id0:uploadFileForm:uploadBtn' and @value='Save']")WebElement saveButton;
	@FindBy(id="uploadPhotoContentId")WebElement frame2;
	@FindBy(xpath="//*[@id='j_id0:outer']/div[1]/div/div/div/div[6]")WebElement cropPhoto;
	@FindBy(xpath="//*[@id='j_id0:j_id7:save']") WebElement saveButton1;
	
	public void  clickOnEditButton(String text) {
	    // performMouseHoverWithWait(driver, editButton);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", editButton);
	    log.info("user is clicked on Edit Button");
	}  
    public void clickOnPostLink(String text) {
    	moveToElementAction(driver,  postLink, text);
    }
    public void enterPostText(WebDriver driver,String text1) {    	
    	// Switch to the iframe if necessary
    	switchToPostTextAreaFrame();

    	// Locate the textarea element inside the iframe
    	postText.click();
    	postText.sendKeys(text1);
    }
    public void clickOnShareButton(String text) {
    	moveToElementAction(driver,  shareButton, text);
    }
   public void switchToPostTextAreaFrame() {
	   switchToframeByWebElement(frame1);
	   log.info("SwitchToTextArea");
   }
   public void switchToMainWindow() {
	   switchToDefaultWindow();
	   log.info("SwitchToParentWindow");
   }
   public void clickOnFile() {
	   File.click();	   
   }
   public void clickOnUploadLink() {
	   uploadAFileFromComputer.click();
   }
   public void uploadAFile(String text) {
   // waitForElementToBeVisible(driver, choose , 40, text);
    // Provide the file path for upload
   	String filePath = "C:\\Users\\knand\\Desktop\\360_F_266724172_Iy8gdKgMa7XmrhYYxLCxyhx6J7070Pr8.jpg";
   	choose.sendKeys(filePath);
   	clickOnShareButton(text);
   }
   public void addPhotoToProfile(String text) {
	  action.moveToElement(profileImage).click().build().perform();
	  action.moveToElement(addPhoto).click().build().perform();	  
//	  driver.switchTo().frame(frame2);
	  String filePath = "C:\\Users\\knand\\Desktop\\360_F_266724172_Iy8gdKgMa7XmrhYYxLCxyhx6J7070Pr8.jpg";
	  choose1.sendKeys(filePath);
	  waitForElementToBeVisible(driver,saveButton, 40, text);
	  action.moveToElement(saveButton).click().build().perform();	
	  //saveButton1
	  action.moveToElement(saveButton1).click().build().perform();	
   }
   
}
