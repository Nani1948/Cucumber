package com.automation.tests;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
//import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.accountpage.AccountPage;
import com.automation.pages.accountpage.accountreport.AccountReport;
import com.automation.pages.accountpage.mergeaccount.MergeAccount;
import com.automation.pages.contactpage.ContactEditNewContactPage;
import com.automation.pages.contactpage.ContactPage;
import com.automation.pages.contactpage.concreatenewview.ContactCreateNewViewpage;
import com.automation.pages.homepage.AllTabsPage;
import com.automation.pages.homepage.HomePage;
import com.automation.pages.homepage.developerconsole.DeveloperConsolePage;
import com.automation.pages.homepage.myprofile.EditPage.EditPage;
import com.automation.pages.homepage.myprofile.EditPage.UserProfilePage;
import com.automation.pages.homepage.mysettings.displayandlayout.ConfigurationOfMyTabsPage;
import com.automation.pages.leadpage.LeadPage;
import com.automation.pages.leadpage.NewLeadCreationPage.CreateNewLeadPage;
import com.automation.pages.login.ForgotYourPasswordPage;
import com.automation.pages.login.LoginPage;
import com.automation.pages.opportunitiespage.OpportunitiesPage;
import com.automation.pages.opportunitiespage.OpportunityPipelinePage;
import com.automation.pages.opportunitiespage.OpportunityReportPage;
import com.automation.pages.opportunitiespage.StuckOpportunitiesReportPage;
import com.automation.pages.opportunitiespage.editpage.OpportunityEditNewOpportunityPage;
import com.automation.pages.randomscenario.RandomSceanrioPage;
import com.automation.test.base.BaseTest;
import com.automation.utility.PropertiesUtility;
import com.automation.pages.homepage.mysetting.email.EmailSetting;
public class AutomationScript extends BaseTest{
	
    @Test
	public void login_to_Salesforce_Application() {
		//Create an object of properties utility class
		//get LoadFilemethod from properties utlity class to load the file of applicationData.properties. 
		//which store sensitive information like username and password
		PropertiesUtility prop=new PropertiesUtility();
		//get entire properties applicationData.and load the file.
		Properties applicationPro=prop.loadFile("applicationDataProperties");
		//read the key from the applicationData.properties 
		String username1=applicationPro.getProperty("valid_username");
		String password1=applicationPro.getProperty("valid_password");
		//enter username and password then click on login button
		LoginPage loginPage=new LoginPage(driver);
		
		loginPage.enterUsername(username1);
		loginPage.enterPassword(password1);
		loginPage.clickOnLoginButton();		
		HomePage homepage=new HomePage(driver);
	    String exceptedTitle=applicationPro.getProperty("title_of_Home_Page");
		String actualTitle=homepage.getTitleOfHomePage();
		Assert.assertEquals( actualTitle,exceptedTitle);				
   }
    
     @Test  
     public void  Login_Error_Message() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
    	String username1=applicationPro.getProperty("valid_username");
    	String password1=applicationPro.getProperty("valid_password");
 		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername(username1);
		loginPage.clearPassword(password1);
		loginPage.clickOnLoginButton();
		 String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_valid_username_and_No_Password");
    	 String actualErrorMessage=loginPage.getErrorMessageOnLoginPage();
    	 Assert.assertEquals(actualErrorMessage,exceptedErrorMessage);
	}	
     @Test
      public void Check_Remember_Me() {
    	 PropertiesUtility prop=new PropertiesUtility(); 
    	 Properties applicationPro=prop.loadFile("applicationDataProperties");
    	 String username1=applicationPro.getProperty("valid_username");
    	 String password1=applicationPro.getProperty("valid_password");
    	 LoginPage loginPage=new LoginPage(driver);
    	 loginPage.enterUsername(username1);
    	 loginPage.enterPassword(password1);
    	 loginPage.checkRememberMe();
    	 loginPage.clickOnLoginButton();
    	 HomePage homepage=new HomePage(driver);
    	 homepage.clickOnUserProfileName();
    	 homepage.clickOnLogout();
    	 String exceptedUsernameText=applicationPro.getProperty("valid_username");
    	 String actualUserNameText=loginPage.getTextOfUsername();
    	 Assert.assertEquals(actualUserNameText,exceptedUsernameText);
	
     }
       @Test
       public void forgot_Password_4A() {
	      PropertiesUtility prop=new PropertiesUtility(); 
		  Properties applicationPro=prop.loadFile("applicationDataProperties");
		  String username1=applicationPro.getProperty("valid_username");
		  LoginPage loginPage=new LoginPage(driver);
		  loginPage.clickOnForgotPassword();
		  ForgotYourPasswordPage forgotYourPasswordPage=new ForgotYourPasswordPage(driver);
		 
		  String exceptedTitleofforgotPasswordPage=applicationPro.getProperty("title_of_ForgotPasswordPage");
		  String actualTitleofforgotPasswordPage=forgotYourPasswordPage.getTitleOfForgotPasswordPage1();
		  Assert.assertEquals(actualTitleofforgotPasswordPage,exceptedTitleofforgotPasswordPage);
		  forgotYourPasswordPage.enterUsernameOnForgotPasswordLink(username1);
		  forgotYourPasswordPage.clickOnContinueButton();
		  
      }      

       @Test
       public void forgot_Password_4B() {
    	PropertiesUtility prop=new PropertiesUtility(); 
       	Properties applicationPro=prop.loadFile("applicationDataProperties");
       	String username2=applicationPro.getProperty("invalid_username");
       	String password2=applicationPro.getProperty("invalid_password");
     	
        LoginPage loginPage=new LoginPage(driver);
   		loginPage.enterUsername(username2);
   		loginPage.enterPassword(password2);
   		loginPage.clickOnLoginButton();
   		String exceptedErrorMessage=applicationPro.getProperty("error_Message_for_Invalid_Username_and_Invalid_Password");
   		String actualErrorMessage=loginPage.getErrorMessageOnLoginPage();
   	    Assert.assertEquals(actualErrorMessage,exceptedErrorMessage);
    	   
     }
     @Test
     public void UserMenuDropDisplay() {
    	PropertiesUtility prop=new PropertiesUtility(); 
     	Properties applicationPro=prop.loadFile("applicationDataProperties");
     	String username1=applicationPro.getProperty("valid_username");
     	String password1=applicationPro.getProperty("valid_password");
  		LoginPage loginPage=new LoginPage(driver);
 		loginPage.enterUsername(username1);
 		loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	 
 		HomePage homepage=new HomePage(driver);
   	    homepage.clickOnUserProfileName();
   	    homepage.getListofUserMenuDropdown(); 
     }
     @Test
     public void selectDeveloperConsole() {
    	PropertiesUtility prop=new PropertiesUtility(); 
       	Properties applicationPro=prop.loadFile("applicationDataProperties");
       	String username1=applicationPro.getProperty("valid_username");
       	String password1=applicationPro.getProperty("valid_password");
    	LoginPage loginPage=new LoginPage(driver);
   		loginPage.enterUsername(username1);
   		loginPage.enterPassword(password1);
   		loginPage.clickOnLoginButton();	 
   		HomePage homepage=new HomePage(driver);
     	homepage.clickOnUserProfileName();  
     	homepage.getListofUserMenuDropdown(); 
     	DeveloperConsolePage developerConsolePage=new DeveloperConsolePage(driver);
     	developerConsolePage.clickOnDeveloperConsole();
     }
     @Test(groups="groups1")
     public void   getAllOperationOFMySetting(){
    	 PropertiesUtility prop=new PropertiesUtility(); 
         Properties applicationPro=prop.loadFile("applicationDataProperties");
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
     	// String selectOptionsOfMarketing=applicationPro.getProperty(clickOnClose)
       //  String clickOnNoThanks=applicationPro.getProperty("Click_On_No_Thanks");
     	 LoginPage loginPage=new LoginPage(driver);
    	 loginPage.enterUsername(username1);
    	 loginPage.enterPassword(password1);
    	 loginPage.clickOnLoginButton();   	     	 
    	 HomePage homepage=new HomePage(driver);
      	 homepage.clickOnUserProfileName();  
      	 homepage.getListofUserMenuDropdown();
      	 homepage.clickOnMySettings();
      	 homepage.clickOnPersonalInformation();
      	 homepage.clickOnLoginHistory();
      	 homepage.clickOnDownloadLoginHistory();      
     }
    
     @Test(groups="groups1")
     public void configureOFMyTabs() {
    	 PropertiesUtility prop=new PropertiesUtility(); 
         Properties applicationPro=prop.loadFile("applicationDataProperties");
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         String selectOptionsOfSalesforceChatter=applicationPro.getProperty("select_Salesforce_Chatter");
         String selectOptionsOfReports=applicationPro.getProperty("select_Reports");
         String ReportisDisplayed=applicationPro.getProperty("Report_tab");
         String selectOptionsOfSales=applicationPro.getProperty("Select_Sales");
         String selectOptionsOfMarketing=applicationPro.getProperty("Select_Marketing");
     	 String clickOnClose=applicationPro.getProperty("Click_On_Popup");
     	// String selectOptionsOfMarketing=applicationPro.getProperty(clickOnClose)
       //  String clickOnNoThanks=applicationPro.getProperty("Click_On_No_Thanks");
     	 LoginPage loginPage=new LoginPage(driver);
    	 loginPage.enterUsername(username1);
    	 loginPage.enterPassword(password1);
    	 loginPage.clickOnLoginButton(); 
    	 HomePage homepage=new HomePage(driver);
      	 homepage.clickOnUserProfileName();
      	 homepage.getListofUserMenuDropdown();
      	 homepage.clickOnMySettings();       	
      	 ConfigurationOfMyTabsPage   customizedTabs=new ConfigurationOfMyTabsPage(driver);         
         customizedTabs.clickOnDisplayAndLayOut();
         customizedTabs.clickOnCustomizeMyTabs();
         customizedTabs.clickOnDropdownListOfCustomApp();
         customizedTabs.getListofOfCustomApp();
         customizedTabs.selectSalesforceChatter(selectOptionsOfSalesforceChatter);
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         customizedTabs.clickOnRemove();
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         customizedTabs.clickOnSave();
         //Sales
         customizedTabs.clickOnDisplayAndLayOut();
         customizedTabs.clickOnCustomizeMyTabs();
         customizedTabs.clickOnDropdownListOfCustomApp();
         customizedTabs.getListofOfCustomApp();
         customizedTabs.selectSales(selectOptionsOfSales);
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         customizedTabs.clickOnRemove();
       //  customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         customizedTabs.clickOnSave();
         //Marketing
         customizedTabs.clickOnDisplayAndLayOut();
         customizedTabs.clickOnCustomizeMyTabs();
         customizedTabs.clickOnDropdownListOfCustomApp();
         customizedTabs.getListofOfCustomApp();
         customizedTabs.selectMarketing(selectOptionsOfMarketing);
         customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
         customizedTabs.clickOnRemove();
        // customizedTabs.selectReportsFromAvailableTabs(selectOptionsOfReports);
         customizedTabs.clickOnAdd();
         customizedTabs.clickOnSave();
         //Assertion for Salesforce Chatter
         customizedTabs.clickOnPageMenuDropdown();
         customizedTabs.clickOnSalesforceChatterFromPagesDropDown(selectOptionsOfSalesforceChatter);
         customizedTabs.clickOnClose(clickOnClose);
         String ExpectedTabIsAvailable=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable,actualTabIsAvialble);
         //Assertion for Sales
         customizedTabs.clickOnPageMenuDropdown();
         customizedTabs.clickOnSalesFromPagesDropDown(selectOptionsOfSales);
         //customizedTabs.clickOnClose(clickOnClose);
         String ExpectedTabIsAvailable1=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble1=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable1,actualTabIsAvialble1);
         //Assertion for Marketing
       //Assertion
         customizedTabs.clickOnPageMenuDropdown();
         customizedTabs.clickOnMarketingFromPagesDropDown(selectOptionsOfMarketing);
       //  customizedTabs.clickOnClose(clickOnClose);
         String ExpectedTabIsAvailable2=applicationPro.getProperty(ReportisDisplayed);
         String actualTabIsAvialble2=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
         
         Assert.assertEquals(ExpectedTabIsAvailable2,actualTabIsAvialble2);
     }
     @Test(groups="groups1")
     public void EmailSetting() {
    	 PropertiesUtility prop=new PropertiesUtility(); 
         Properties applicationPro=prop.loadFile("applicationDataProperties");
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         
         LoginPage loginPage=new LoginPage(driver);
    	 loginPage.enterUsername(username1);
    	 loginPage.enterPassword(password1);
    	 loginPage.clickOnLoginButton();
    	 
    	 HomePage homepage=new HomePage(driver);
      	 homepage.clickOnUserProfileName();
      	 homepage.getListofUserMenuDropdown();
      	 homepage.clickOnMySettings(); 
      	 
      	 EmailSetting  emailPage=new EmailSetting(driver);
      	 emailPage.clickOnEmailLink(); 
      	 emailPage.clickOnEmailLink(); 
      	 String nameOFSender=applicationPro.getProperty("Name");
      	 emailPage.enterSendName(nameOFSender);
      	 String emailAddress=applicationPro.getProperty("Email_Address");
      	 emailPage.enterEmail(emailAddress);
      	 emailPage.isBCCChecked();
      	 emailPage.clickOnSaveOfEmailSettingPage();
     }
     @Test 
     public void    selectMyProfileOption() throws InterruptedException {
    	 PropertiesUtility prop=new PropertiesUtility(); 
         Properties applicationPro=prop.loadFile("applicationDataProperties");
         String username1=applicationPro.getProperty("valid_username");
         String password1=applicationPro.getProperty("valid_password");
         String selectOptionFromUserMenu=applicationPro.getProperty("SelectOptionfromUserMenu1");
         String clickOnButton=applicationPro.getProperty("click_On_Button");
         String clickOnTab=applicationPro.getProperty("Click_On_Tab");
         String textOfName=applicationPro.getProperty("Last_Name");
         String labelOfLastName=applicationPro.getProperty("Label_Of_LastName");
         String clickOnButton1=applicationPro.getProperty("Click_On_Button1");
         String clickOnLink1=applicationPro.getProperty("Click_On_Link1");
         String enterPostTextInTextArea=applicationPro.getProperty("Post_Text");
         String textOfPostArea=applicationPro.getProperty("Post_Text1");
         String clickOnButton2=applicationPro.getProperty("Click_On_Button2");
         String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
         String pathOfImage=applicationPro.getProperty("ImagePath");
         String clickOnButton4=applicationPro.getProperty("clickOnButton4");
        // String textOfFrame=applicationPro.getProperty("Frame1");
         LoginPage loginPage=new LoginPage(driver);
    	 loginPage.enterUsername(username1);
    	 loginPage.enterPassword(password1);
    	 loginPage.clickOnLoginButton(); 
    	 HomePage homepage=new HomePage(driver);
      	 homepage.clickOnUserProfileName();
      	 homepage.getListofUserMenuDropdown();
    	 homepage.clickOnMyProfile(selectOptionFromUserMenu); 
         homepage.switchToMainWindow();
         UserProfilePage userProfilePage=new UserProfilePage(driver);
          userProfilePage.clickOnEditButton(clickOnButton);
            EditPage editPage=new EditPage(driver);
            editPage.switchToFrame1();
            editPage.clickOnAbout(clickOnTab);
           editPage.enterLastname(textOfName, labelOfLastName);
           editPage.clickOnSaveAllButton(clickOnButton1);
           editPage.clickOnCloseButton(clickOnButton3);
           userProfilePage.switchToMainWindow();    
           userProfilePage.clickOnPostLink(clickOnLink1);
           userProfilePage.switchToPostTextAreaFrame();
           userProfilePage.enterPostText(driver,enterPostTextInTextArea);
           userProfilePage.clickOnShareButton(clickOnButton2);
           userProfilePage.clickOnFile();
           userProfilePage.clickOnUploadLink();
           userProfilePage.uploadAFile(clickOnButton2);
           userProfilePage.addPhotoToProfile(clickOnButton4);
         
     }
	@Test
     public void LogoutOfTheProfile() {
    	PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
   		LoginPage loginPage=new LoginPage(driver);
  		loginPage.enterUsername(username1);
  		loginPage.enterPassword(password1);
  		loginPage.clickOnLoginButton();	 
  		HomePage homepage=new HomePage(driver);
    	homepage.clickOnUserProfileName(); 
    	homepage.getListofUserMenuDropdown(); 
    	homepage.clickOnLogout();
    	String exceptedTitle=applicationPro.getProperty("title_of_page");
    	String actualTitle=loginPage.getTitleOfThePage();
    	Assert.assertEquals( actualTitle,exceptedTitle);	
     }
	@Test
	
	public void  getAllOperationOfLeadTab() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnTab1=applicationPro.getProperty("Click_on_Tab1");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String selectOptionsFromDropdown=applicationPro.getProperty("Select_Option1");
      	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
      	String clickOnButton5=applicationPro.getProperty("Click_On_Button5");
    	String clickOnButton6=applicationPro.getProperty("Click_On_Button6");
        String textOfName=applicationPro.getProperty("Last_Name");
        String labelOfLastName=applicationPro.getProperty("Label_Of_LastName");
      	String textOfCompanyName=applicationPro.getProperty("Company_Name");
      	String labelOfCompanyName=applicationPro.getProperty("Text_OF_Company_Name");
        LoginPage loginPage=new LoginPage(driver);
  		loginPage.enterUsername(username1);
  		loginPage.enterPassword(password1);
  		loginPage.clickOnLoginButton();	
  		
  		LeadPage leadPage=new LeadPage(driver);
  	    //1.check leads tab link 
  		leadPage.clickOnLead(clickOnTab1);
  		leadPage.clickOnClose(clickOnButton3);
  		//2.Validate 'View' drop down list contents
  		leadPage.getListOfAllDropdownOptions();
  		//3.Functionality of the Go Button  		
  		//4.List item "Todays Leads" work
  		//Two test cases are verified
  		leadPage.selectTodayLeads(selectOptionsFromDropdown);
  		HomePage homepage=new HomePage(driver);
    	homepage.clickOnUserProfileName(); 
    	homepage.getListofUserMenuDropdown(); 
    	homepage.clickOnLogout();
  		loginPage.enterUsername(username1);
  		loginPage.enterPassword(password1);
  		loginPage.clickOnLoginButton();	 
  		leadPage.clickOnLead(clickOnTab1);
  		//leadPage.clickOnClose(clickOnButton3);
  		leadPage.clickOnGo(clickOnButton5);
  		leadPage.clickOnLead(clickOnTab1);
  		leadPage.clickOnNew(clickOnButton6);
  		CreateNewLeadPage newLeadPage=new CreateNewLeadPage(driver);
  		newLeadPage.setLastName(textOfName, labelOfLastName);
  		newLeadPage.setCompanyName(textOfCompanyName, labelOfCompanyName);
  		newLeadPage.clickOnSave(clickOnButton4);
	}
	@Test
	public void getAllOperationOfAccountTabs() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
        String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
        String clickOnButton6=applicationPro.getProperty("Click_On_Button6");
        String selectOptionFromType=applicationPro.getProperty("Select_Option1");
        String clickOnButton4=applicationPro.getProperty("clickOnButton4");
        String selectOptionFromCustomerType=applicationPro.getProperty("Select_OptionFromCustomerPriority");
        String clickOnLink2=applicationPro.getProperty("Click_On_Link2=");
        String textOFAccountName=applicationPro.getProperty("Account_Name");
        String labelOfAccountName=applicationPro.getProperty("Label_Account_Name");
        String selectOptionFromDropdown=applicationPro.getProperty("Select_Option-From_View");
        String clickOnButton=applicationPro.getProperty("click_On_Button");
        String textOFViewName=applicationPro.getProperty("Change_Name_of_View_Name");
        String textOFUniqueName=applicationPro.getProperty("Change_Name_of_Unique_Name");
        String labelOFViewName=applicationPro.getProperty("Label_oF_View_Name");
        String labelOFUniqueName=applicationPro.getProperty("Label_oF_Unique_Name");
        String labelOFAllAccounts=applicationPro.getProperty("Label_OF_All_Account");
        String textOfOperator=applicationPro.getProperty("Label_of_Operator");
        String textOfvalue=applicationPro.getProperty("Text_OF_Value");
        String labelOFValue=applicationPro.getProperty("Label_OF_Value");
        LoginPage loginPage=new LoginPage(driver);
        loginPage.enterUsername(username1);
 		loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnAccount(); 		
		
 		AccountPage accountPage=new AccountPage(driver);
 		accountPage.clickOnClose(clickOnButton3);
		accountPage.clickOnNew(clickOnButton6);
		
		accountPage.setAccountName(textOFAccountName,labelOfAccountName);
		accountPage.selectTechnologyPartnerFromPartner(selectOptionFromType);
		accountPage.selectHighFromCustomerPriority(selectOptionFromCustomerType);
	    accountPage.clickOnSave(clickOnButton4);
	    
	    //2.New View Page should be displayed
		homepage.clickOnAccount(); 
	    accountPage.clickOnCreateNewView(clickOnLink2);
	 	homepage.clickOnUserProfileName(); 
    	homepage.getListofUserMenuDropdown(); 
    	homepage.clickOnLogout();
	    //3.
        loginPage.enterUsername(username1);
 		loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		homepage.clickOnAccount(); 	
 		accountPage.selectFromViewDropdown(selectOptionFromDropdown);
 		accountPage.clickOnEdit(clickOnButton);
 		accountPage.setViewName(textOFViewName,labelOFViewName);
 		accountPage.setUniqueName(textOFUniqueName, labelOFUniqueName);
 		accountPage.clickOnAllAccount(labelOFAllAccounts);
 		accountPage.selectAccountNameFromField(labelOfAccountName);
 		accountPage.selectEqualFromOperator( textOfOperator);
 		accountPage.setValue(textOfvalue, labelOFValue);
 		accountPage.clickOnSave1(clickOnButton4);
 	 	homepage.clickOnUserProfileName(); 
    	homepage.getListofUserMenuDropdown(); 
    	homepage.clickOnLogout();
	}
	@Test
	public void getAllOperationOfMergeAccount() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
	    String clickOnLink3=applicationPro.getProperty("Click_on_Link3");
		String textOfAccountNameForSearching=applicationPro.getProperty("Text_Of_AccountName");
		String labelOfAccountName=applicationPro.getProperty("Label_Account_Name");
		String labelOfFindAccount=applicationPro.getProperty("Label_Find_Account");
		String selectOptionFromView=applicationPro.getProperty("Select_Options_From_View");
		String clickOnButton7=applicationPro.getProperty("Click_On_Button7");
		String clickOnButton8=applicationPro.getProperty("Click_on_Button8");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();		
		    
  		HomePage homepage=new HomePage(driver);
  		homepage.clickOnAccount(); 
  		AccountPage accountPage=new AccountPage(driver);
  		accountPage.clickOnClose(clickOnButton3);
  		accountPage.clickOnMergeAccount(clickOnLink3);
  		MergeAccount mergeAccountPage=new MergeAccount(driver);
  		
  		mergeAccountPage.setAccountNameInSearchBox(textOfAccountNameForSearching, labelOfAccountName);
  		mergeAccountPage.clickOnFindAccount(labelOfFindAccount);
  		mergeAccountPage.clickOnFirstCheckBox();
  		mergeAccountPage.clickOnSecondCheckBox();
  		mergeAccountPage.clickOnNext(clickOnButton7);
  		mergeAccountPage.clickOnMerge(clickOnButton8);
  		mergeAccountPage.clickOnPopup(selectOptionFromView);
  		
	}
	@Test 
	public void  createAccountReport() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String clickOnLink4=applicationPro.getProperty("Click_on_Link5");
      	String labelOfDateDropdown=applicationPro.getProperty("Click_on_Date");
      	String labelOfCreateDate=applicationPro.getProperty("Select_Options_From_Date");
    	String labelOfFromCalendarIcon=applicationPro.getProperty("Click_on_Form_CalendarIcon");
      	String clickOnButton8=applicationPro.getProperty("Click_On_Button8");
      	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
      	String textOfReportName=applicationPro.getProperty("Report_Name");
      	String labelOfReportName=applicationPro.getProperty("Label_Report_Name");

      	String textOfReportUniqueName=applicationPro.getProperty("Report_Unique_Name");
      	String labelOfReportUniqueName=applicationPro.getProperty("Label_Report_Unique_Name");
      	String labelOfSaveandRunReport=applicationPro.getProperty("Click_On_Button9");
      	
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
	  	homepage.clickOnAccount(); 
	  	AccountPage accountPage=new AccountPage(driver);
	  	accountPage.clickOnClose(clickOnButton3);
		accountPage.clickOnAccountsIsGreaterThan30Days(clickOnLink4);
		AccountReport accountReport=new AccountReport(driver);
		accountReport.clickOnDropdownDate(labelOfDateDropdown);
		accountReport.clickOnCreateDate( labelOfCreateDate);
		accountReport.clickOnFromCalendarIcon(labelOfFromCalendarIcon);
		accountReport.clickOnTodayDate(clickOnButton8);
		accountReport.clickOnSaveButton(clickOnButton4);
		accountReport.setReportName(textOfReportName, labelOfReportName);
		//accountReport.setReportUniqueName(textOfReportUniqueName,  labelOfReportUniqueName);
		accountReport.clickOnSaveAndRunReport(labelOfSaveandRunReport);
	}
	
	@Test
	public void getAllOperationOfOpportunities() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String labelOfDropdownListOfView=applicationPro.getProperty("Label_Of_Dropdown_List_Of_View");
        String clickOnButton6=applicationPro.getProperty("Click_On_Button6");
      	List<String> expectedDropdownListOFView = List.of(applicationPro.getProperty("listOfDropdownOfOpportunities"));
      	String textOfOpportunityNameData=applicationPro.getProperty("Opportunity_Name");
      	String labelOfOpportunityName=applicationPro.getProperty("Label_Of_Opportunity_Name");
    	String textOfAccountNameData=applicationPro.getProperty("Account_Name");
      	String labelOfAccountName=applicationPro.getProperty("Label_Of_Account_Name");
        String labelOfCloseDate=applicationPro.getProperty("Label_Of_Close_Date");
      	String labelOfToday=applicationPro.getProperty("Label_Of_Today");
      	String selectOptionFromType=applicationPro.getProperty("Select_Type_Options");
      	String selectOptionFromStage=applicationPro.getProperty("Select_Stage_Options");
      	String selectOptionFromLeadSource=applicationPro.getProperty("Select_Lead_Source_Options");
      	String textOfProbabilityData=applicationPro.getProperty("Text_Of_Probability");
      	String labelOfProbability=applicationPro.getProperty("Label_Of_Probability");
      	String textOfPrimaryCampaignSourceData=applicationPro.getProperty("Text_Of_Primary_Campaign_Source");
      	String labelOfPrimaryCampaignSource=applicationPro.getProperty("Label_Of_Primary_Campaign_Source");
      	String labelOfOpportunitiesPipeline=applicationPro.getProperty("Label_Of_Opportunity_Pipeline");
     	String labelOfStuckOpportunities=applicationPro.getProperty("Label_Of_Stuck_Opportunities");
      	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
    	String clickOnButton9=applicationPro.getProperty("ClickOnButton9");
    	String selectOptionFromInclude=applicationPro.getProperty("Select_Options_From_Include");
    	String selectOptionFromInterval=applicationPro.getProperty("Select_Options_From_Interval");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnOpportunities();
 		//1.Verify the list of dropdown values
 		AccountPage accountPage=new AccountPage(driver);
	    accountPage.clickOnClose(clickOnButton3);
	    
	    OpportunitiesPage opportunitiesPage=new OpportunitiesPage(driver);
	    opportunitiesPage.clickOnDropdownListOfView(labelOfDropdownListOfView);
	    opportunitiesPage.getTextOfDropdownListOFView1();
	    opportunitiesPage.testDropdownListOFView();
	    
	    //2.Create a new Opportunity
	    opportunitiesPage.clickOnNew(labelOfDropdownListOfView);
	    OpportunityEditNewOpportunityPage  oppEditNewPage=new OpportunityEditNewOpportunityPage (driver);
	    oppEditNewPage.setOpportunityName(textOfOpportunityNameData,labelOfOpportunityName);
	    oppEditNewPage.setAccountName(textOfAccountNameData,  labelOfAccountName);
	    oppEditNewPage.clickOnCloseDate(labelOfCloseDate);
	    oppEditNewPage.clickOnTodayLink( labelOfToday);
	    oppEditNewPage.selectOptionFromType( selectOptionFromType);
	    oppEditNewPage.selectOptionFromStage(selectOptionFromStage);
	    oppEditNewPage.selectOptionFromLeadSource(selectOptionFromLeadSource);
	    oppEditNewPage.setProbability(textOfProbabilityData, labelOfProbability);
	    oppEditNewPage.setPrimaryCampaignSource(textOfPrimaryCampaignSourceData,  labelOfPrimaryCampaignSource);	    
	    oppEditNewPage.clickOnSaveButton(clickOnButton4);
	    
	    //3.Test Opportunity Pipeline Report
	    homepage.clickOnOpportunities();
	    opportunitiesPage.clickOnOpportunityPipeline(labelOfOpportunitiesPipeline);
	    String exceptedTitleOfPageOfOPPPipe=applicationPro.getProperty("Title_Of_Page_Opportunity_Pipeline");
	    OpportunityPipelinePage oppPipelinePage=new OpportunityPipelinePage(driver);
	    String actualTitleOfThePage=oppPipelinePage.getTitleOfTheOfOpportunityPipeline();
	    Assert.assertEquals(actualTitleOfThePage, exceptedTitleOfPageOfOPPPipe);
	    
	    
	    //4.Test Stuck Opportunities Report
	    homepage.clickOnOpportunities();
	    opportunitiesPage.clickOnStuckOpportunities(labelOfStuckOpportunities);
	    String exceptedTitleOfPageOfStuckOpp=applicationPro.getProperty("Title_Of_Page_Stuck_Opportunities");
	    StuckOpportunitiesReportPage stuckOppPage=new StuckOpportunitiesReportPage(driver);
	    String actuatTitleOfPageOfStuckOpp=stuckOppPage.getTitleOfTheOfStuckOpportunity();
	    Assert.assertEquals(actuatTitleOfPageOfStuckOpp, exceptedTitleOfPageOfStuckOpp);
	    //5.Test Quarterly Summary Report
	    homepage.clickOnOpportunities();
	    opportunitiesPage.selectOptionFromInterval(selectOptionFromInterval);
	    opportunitiesPage.selectOptionFromInclude(selectOptionFromInclude);
	    opportunitiesPage.clickOnRunReport(clickOnButton9);
	    OpportunityReportPage oppReportPage=new OpportunityReportPage(driver);
	    String exceptedTitleOfPageOfOPPReport=applicationPro.getProperty("Title_Of_Page_Opportunity_Report");
	    String actualTitleOFOppReport=oppReportPage.getTitleOfTheOpportunityReport();
	    Assert.assertEquals(actualTitleOFOppReport, exceptedTitleOfPageOfOPPReport);
	
	}
	
	@Test
	public void getAllOperationOfContact() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton6=applicationPro.getProperty("Click_On_Button6");
      	String exceptedTitleOFConEditNewPage=applicationPro.getProperty("Title_Of_Page_Contact_Edit_New_Contact");
      	String textOfLastNameData=applicationPro.getProperty("Text_Of_Last_Name");
      	String labelOfLastName=applicationPro.getProperty("Label_Of_Last_Name");
      	String textOfAccountNameData=applicationPro.getProperty("Text_Of_Account_Name");
        String labelOfAccountName=applicationPro.getProperty("Label_Of_Account_Name");
        String clickOnButton4=applicationPro.getProperty("clickOnButton4");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnContact(clickOnTab5);
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnClose(clickOnButton3);
      	//1.Create new contact
      	contactPage.clickOnNewButton(clickOnButton6);
      	String actualTitleOFConEditNewPage=contactPage.getTitleOfTheContactEditNewContact();
      	Assert.assertEquals(actualTitleOFConEditNewPage, exceptedTitleOFConEditNewPage);
      	contactPage.setLastName(textOfLastNameData, labelOfLastName);
      	contactPage.setAccountName(textOfAccountNameData,labelOfAccountName);
      	contactPage.clickOnSave(clickOnButton4);
    	String exceptedTitleOFContactNamePage=applicationPro.getProperty("Title_Of_Contact_Name_Page");
      	String actualTitleOFContactNamePage=contactPage.getTitleOfTheContactName();
	    Assert.assertEquals(actualTitleOFContactNamePage, exceptedTitleOFContactNamePage);	  
	    
	}
	@Test
	public void   CreateNewviewInTheContact() {
		PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String labelOfCreateNewViewLink=applicationPro.getProperty("Label_Of_Create_New_View");	
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnContact(clickOnTab5);
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnClose(clickOnButton3);
      	contactPage.clickOnCreateNewView(labelOfCreateNewViewLink);
      	String labelOfViewName=applicationPro.getProperty("Label_oF_View_Name");	
      	String labelOfViewUniqueName=applicationPro.getProperty("Label_oF_View_Unique_Name");	
    	String textOfViewName=applicationPro.getProperty("Text_Of_View_Name2");	
      	String textOfViewUniqueName=applicationPro.getProperty("Text_of_View_Unique_Name2");
      	ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
      	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
      	createNewViewPage.setViewName(textOfViewName, labelOfViewName);
      	createNewViewPage.setViewUniqueName(textOfViewUniqueName,labelOfViewUniqueName);
      	createNewViewPage.clickOnSaveButton(clickOnButton4);
      	
	}
    @Test
    public void  displayListOfRecentlyCreated() {
    	PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnContact(clickOnTab5);
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnClose(clickOnButton3);
      	String textOfDropdown=applicationPro.getProperty("Text_Of_Dropdown");
      	contactPage.selectOptionFromDropdown(textOfDropdown);
      	
    }
    @Test
    public void displayListOfMyContact() {
    	PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String textOfViewDropdown=applicationPro.getProperty("Select_Option_From_View_Dropdown");
    	String labelOfViewDropdown=applicationPro.getProperty("Label_Of_View_Dropdown");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnContact(clickOnTab5);
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnClose(clickOnButton3);
      	contactPage.selectOptionFromViewDropdown(labelOfViewDropdown, textOfViewDropdown);
    }
    
    @Test
    public void  viewAContactInContactPage() {
    	PropertiesUtility prop=new PropertiesUtility(); 
      	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");
      	String textOfViewDropdown=applicationPro.getProperty("Select_Option_From_View_Dropdown");
    	String labelOfViewDropdown=applicationPro.getProperty("Label_Of_View_Dropdown");
    	String labelOfName=applicationPro.getProperty("Label_OF_Name");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnContact(clickOnTab5);
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnClose(clickOnButton3);
    	contactPage.clickOnContactName(labelOfName);
      	
    }
    @Test
    public void isCancelButtonWorkingFineInCreateNewView() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String labelOfCreateNewViewLink=applicationPro.getProperty("Label_Of_Create_New_View");	
    	String labelOfViewName1=applicationPro.getProperty("Label_oF_View_Name3");
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
    	
      	String labelOfViewUniqueName1=applicationPro.getProperty("Label_oF_View_Unique_Name3");	
    	String textOfViewName1=applicationPro.getProperty("Text_Of_View_Name3");	
      	String textOfViewUniqueName1=applicationPro.getProperty("Text_of_View_Unique_Name3");
    	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
    	String clickOnButton10=applicationPro.getProperty("Label_Of_CancelButton");
    	String exceptedTitleOfContactHomePage=applicationPro.getProperty("Title_Of_Page_Contact_Home1");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
      	homepage.clickOnHome(labelOfTab6);
      	homepage.clickOnClose(clickOnButton3);
      	homepage.clickOnContact(clickOnTab5);
    	ContactPage contactPage=new ContactPage(driver);
    	contactPage.clickOnCreateNewView(labelOfCreateNewViewLink);
    	ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
      	createNewViewPage.setViewName(textOfViewName1,labelOfViewName1);
      	createNewViewPage.setViewUniqueName(textOfViewUniqueName1,  labelOfViewUniqueName1);
     	createNewViewPage.clickOnCancelButton(clickOnButton10);
     	String actualTitleOfContactHomePage=createNewViewPage.getTitleOfTheContactHomePage();
     	Assert.assertEquals(actualTitleOfContactHomePage, exceptedTitleOfContactHomePage);
     	
    }
    @Test
    
    public void testErrorMessageOnCreateNewView() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String labelOfCreateNewViewLink=applicationPro.getProperty("Label_Of_Create_New_View");	
    	String labelOfViewName1=applicationPro.getProperty("Label_oF_View_Name3");
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
    	
      	String labelOfViewUniqueName1=applicationPro.getProperty("Label_oF_View_Unique_Name3");	
    	String textOfViewName1=applicationPro.getProperty("Text_Of_View_Name3");	
      	String textOfViewUniqueName1=applicationPro.getProperty("Text_of_View_Unique_Name3");
    	String clickOnButton4=applicationPro.getProperty("clickOnButton4");
    	String clickOnButton10=applicationPro.getProperty("Label_Of_CancelButton");
    	String exceptedErrorMessage1=applicationPro.getProperty("exceptedErrorMessage1");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		HomePage homepage=new HomePage(driver);
      	homepage.clickOnHome(labelOfTab6);
      	homepage.clickOnClose(clickOnButton3);
      	homepage.clickOnContact(clickOnTab5);
    	ContactPage contactPage=new ContactPage(driver);
    	contactPage.clickOnCreateNewView(labelOfCreateNewViewLink);
    	ContactCreateNewViewpage  createNewViewPage=new ContactCreateNewViewpage(driver);
    	createNewViewPage.setViewUniqueName(textOfViewUniqueName1,  labelOfViewUniqueName1);
     	createNewViewPage.clickOnSaveButton(clickOnButton10);
     	String actualErrorMessage1=createNewViewPage.getTextOfErroMessageOnViewName();
     	Assert.assertEquals( actualErrorMessage1, exceptedErrorMessage1);
    }
    @Test
    
    public void isSaveAndNewButtonWorkingFine() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
    	String exceptedTitleOFConEditNewPage=applicationPro.getProperty("Title_Of_Page_Contact_Edit_New_Contact1");
      	String textOfLastNameData1=applicationPro.getProperty("Text_Of_Last_Name1");
      	String labelOfLastName=applicationPro.getProperty("Label_Of_Last_Name");
      	String textOfAccountNameData1=applicationPro.getProperty("Text_Of_Account_Name1");
        String labelOfAccountName=applicationPro.getProperty("Label_Of_Account_Name");
        String clickOnButton4=applicationPro.getProperty("clickOnButton4");
    	String clickOnButton6=applicationPro.getProperty("Click_On_Button6");
    	String clickOnButton10=applicationPro.getProperty("Click_On_Button10");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		
 		HomePage homepage=new HomePage(driver);
      	homepage.clickOnHome(labelOfTab6);
      	homepage.clickOnClose(clickOnButton3);
      	homepage.clickOnContact(clickOnTab5);
      //1.Create new contact
      	ContactPage contactPage=new ContactPage(driver);
      	contactPage.clickOnNewButton(clickOnButton6); 
      	ContactEditNewContactPage  editNewConPage=new ContactEditNewContactPage(driver);
      	editNewConPage.setLastName(textOfLastNameData1, labelOfLastName);
      	editNewConPage.setAccountName(textOfAccountNameData1,labelOfAccountName);
      	editNewConPage.clickOnSaveAndNew(clickOnButton10);
    	String actualTitleOFConEditNewPage=contactPage.getTitleOfTheContactEditNewContact();
      	Assert.assertEquals(actualTitleOFConEditNewPage, exceptedTitleOFConEditNewPage);
    }
    
    @Test
    public void  testValidationOfFirstNameAndLastName() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
     String selectOptionFromUserMenu=applicationPro.getProperty("SelectOptionfromUserMenu1");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		
 		HomePage homepage=new HomePage(driver);
      	homepage.clickOnHome(labelOfTab6);
      	
      	
      	homepage.clickOnClose(clickOnButton3);
        String exceptedTitle=applicationPro.getProperty("Title_Of_Home_Page1");
      	String actualTitle=homepage.getTitleOfHomePage();
      	Assert.assertEquals( actualTitle,exceptedTitle);
      	RandomSceanrioPage randScenarioPage=new RandomSceanrioPage(driver);
    	String exceptedUserName=applicationPro.getProperty("Link_Of_UserName");
      	String actualUserName=randScenarioPage.getTextOfUserName();
      	Assert.assertEquals(actualUserName , exceptedUserName);
     	String actualUserName1=randScenarioPage.getTitleOfUserProfileOnHomePage(selectOptionFromUserMenu); 
     	homepage.clickOnUserProfileName();
     	String exceptedUserName1=homepage.getTitleOfMyProfilePage(selectOptionFromUserMenu);
     	
     	Assert.assertEquals(actualUserName1, exceptedUserName1);
    }
    @Test
    public void testValidationOfLastName() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String clickOnTab5=applicationPro.getProperty("Click_On_Tab5");
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
        String selectOptionFromUserMenu=applicationPro.getProperty("SelectOptionfromUserMenu1");
       String clickOnUserNameLink=applicationPro.getProperty("Link_Of_UserName");
       String clickOnTab=applicationPro.getProperty("Click_On_Tab");
       String textOfName1=applicationPro.getProperty("Last_Name1");
       String labelOfLastName=applicationPro.getProperty("Label_Of_LastName");
       String clickOnButton1=applicationPro.getProperty("Click_On_Button1");
       String clickOnLink1=applicationPro.getProperty("Click_On_Link1");
       String clickOnButton=applicationPro.getProperty("Click_On_Button");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();	
 		
 		HomePage homepage=new HomePage(driver);
      	homepage.clickOnHome(labelOfTab6);
      	
      	
      	homepage.clickOnClose(clickOnButton3);
        String exceptedTitle=applicationPro.getProperty("Title_Of_Home_Page1");
      	String actualTitle=homepage.getTitleOfHomePage();
      	Assert.assertEquals( actualTitle,exceptedTitle);
      	RandomSceanrioPage randScenarioPage=new RandomSceanrioPage(driver);
  
     	
     	String exceptedUserName2=applicationPro.getProperty("Title_Of_UserProfile");
     	randScenarioPage.clickOnUserName();
     	String actualUserName2=randScenarioPage.getTitleOfUserProfilePage(); 
     	
     	Assert.assertEquals(actualUserName2, exceptedUserName2);     	
     	randScenarioPage.clickOnEditButton(clickOnButton);
        EditPage editPage=new EditPage(driver);
        editPage.switchToFrame1();
        editPage.clickOnAbout(clickOnTab);
        randScenarioPage.enterLastname(textOfName1, labelOfLastName);
        editPage.clickOnSaveAllButton(clickOnButton1);
        randScenarioPage.clickOnClose();
     	
     	
    }
    @Test
    public void testValidationOFTabCustomization() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
      	String clickOnIcon1=applicationPro.getProperty("Click_On_Icon1");
      	String  labelOfCustomizeMyTabs=applicationPro.getProperty("Label_Of_Customize_My_Tabs");
      	String selectOptionsOfSalesforceChatter=applicationPro.getProperty("select_Salesforce_Chatter");
        String selectOptionsOfReports=applicationPro.getProperty("select_Reports");
        String ReportisDisplayed=applicationPro.getProperty("Report_tab");
        String selectOptionsOfSales=applicationPro.getProperty("Select_Sales");
       
    	 String clickOnClose=applicationPro.getProperty("Click_On_Popup");
      	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();
 		HomePage homepage=new HomePage(driver);
 		homepage.clickOnPlusIcon( clickOnIcon1);
 		AllTabsPage allTabsPage=new AllTabsPage(driver);
 	    allTabsPage.clickOnCustomizeMyTabs(labelOfCustomizeMyTabs);
 	   ConfigurationOfMyTabsPage   customizedTabs=new ConfigurationOfMyTabsPage(driver);   
 	   customizedTabs.clickOnDropdownListOfCustomApp();
       customizedTabs.getListofOfCustomApp();
       customizedTabs.selectSales(selectOptionsOfSales);
       customizedTabs.selectReportFromSelectedTabs(selectOptionsOfReports);
       customizedTabs.clickOnRemove();
       customizedTabs.clickOnSave();
       homepage.clickOnUserProfileName(); 
 	   homepage.getListofUserMenuDropdown(); 
 	   homepage.clickOnLogout();
 		loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();
       customizedTabs.clickOnPageMenuDropdown();
       customizedTabs.clickOnSalesFromPagesDropDown(selectOptionsOfSales);
       customizedTabs.clickOnClose(clickOnClose);
       String ExpectedTabIsAvailable=applicationPro.getProperty(ReportisDisplayed);
       String actualTabIsAvialble=customizedTabs.getTextOfReport(applicationPro.getProperty(ReportisDisplayed));
       Assert.assertEquals(actualTabIsAvialble, ExpectedTabIsAvailable);
    }
    
    @Test
    public void  blockingAnEventInCal() {
    	PropertiesUtility prop=new PropertiesUtility(); 
    	Properties applicationPro=prop.loadFile("applicationDataProperties");
      	String username1=applicationPro.getProperty("valid_username");
      	String password1=applicationPro.getProperty("valid_password");
      	String clickOnButton3=applicationPro.getProperty("Click_On_Button3");	
    	String labelOfTab6=applicationPro.getProperty("Label_Of_Tab6");
    	LoginPage loginPage=new LoginPage(driver);
      	loginPage.enterUsername(username1);
      	loginPage.enterPassword(password1);
 		loginPage.clickOnLoginButton();
 		HomePage homepage=new HomePage(driver);
 	 	homepage.clickOnHome(labelOfTab6);	  	
      	homepage.clickOnClose(clickOnButton3);
      	
      	
      	
    }
}
