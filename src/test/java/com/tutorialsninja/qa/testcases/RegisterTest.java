package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.AccountSuccessPage;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base {
		
	public WebDriver driver;
	RegisterPage registerPage;
	AccountSuccessPage accSuccessPage;
	HomePage homePage;
	
	public RegisterTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplicationURL(p.getProperty("browserName"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		registerPage = homePage.selectRegisterOption();
		//homePage.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields()
	{
//		registerPage.enterFirstName(pData.getProperty("firstName"));
//		registerPage.enterLastName(pData.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilities.generateTimeStamp());
//		registerPage.enterTelephone(pData.getProperty("telephoneNum"));
//		
//		registerPage.enterPassword(p.getProperty("password"));
//		registerPage.enterConfirmPassword(p.getProperty("password"));
//		
//		registerPage.selectPrivayPolicy();
//		accSuccessPage = registerPage.clickOnContinueButton();

		accSuccessPage = registerPage.registerWithMandatoryFields(pData.getProperty("firstName"), pData.getProperty("lastName"), Utilities.generateTimeStamp(), pData.getProperty("telephoneNum"), p.getProperty("password"));
		Assert.assertEquals(accSuccessPage.retrieveAccountSuccessPageHeading(), pData.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
		
		//String actualSuccessHeading = accSuccessPage.retrieveAccountSuccessPageHeading();
		//Assert.assertEquals(actualSuccessHeading, pData.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
		
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountByProvidingAllFields()
	{
//		registerPage.enterFirstName(pData.getProperty("firstName"));
//		registerPage.enterLastName(pData.getProperty("lastName"));
//		registerPage.enterEmailAddress(Utilities.generateTimeStamp());
//		registerPage.enterTelephone(pData.getProperty("telephoneNum"));
//		
//		registerPage.enterPassword(p.getProperty("password"));
//		registerPage.enterConfirmPassword(p.getProperty("password"));
//		
//		registerPage.clickOnYesNewsletterOption();
//		registerPage.selectPrivayPolicy();
//		accSuccessPage = registerPage.clickOnContinueButton();
		
		accSuccessPage = registerPage.registerWithAllFields(pData.getProperty("firstName"), pData.getProperty("lastName"), Utilities.generateTimeStamp(), pData.getProperty("telephoneNum"), p.getProperty("password"));
		
		String actualSuccessHeading = accSuccessPage.retrieveAccountSuccessPageHeading();
		Assert.assertEquals(actualSuccessHeading, pData.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
		
	}
	
	@Test(priority=3)
	public void verifyRegisteringAccountWithExistingEmailAddress()
	{
		registerPage.registerWithAllFields(pData.getProperty("firstName"), pData.getProperty("lastName"), p.getProperty("validEmail"), pData.getProperty("telephoneNum"), p.getProperty("password"));
		
		
//		registerPage.enterFirstName(pData.getProperty("firstName"));
//		registerPage.enterLastName(pData.getProperty("lastName"));
//		registerPage.enterEmailAddress(p.getProperty("validEmail"));
//		registerPage.enterTelephone(pData.getProperty("telephoneNum"));
//
//		registerPage.enterPassword(p.getProperty("password"));
//		registerPage.enterConfirmPassword(p.getProperty("password"));
//		
//		registerPage.selectPrivayPolicy();
//		registerPage.clickOnContinueButton();
		
		String actualSuccessHeading = registerPage.retrieveDuplicatesEmailAddressWarning();
		Assert.assertTrue(actualSuccessHeading.contains(pData.getProperty("duplicateEmailWarning")), "Warning Message regarding duplicate email address is not displayed");
		
	}
	
	@Test(priority=4)
	public void verifyRegisteringAccountWithoutFillingAnyDetails()
	{
		
		registerPage.clickOnContinueButton();
		
		Assert.assertTrue(registerPage.displayStatusOfWarningMessages(pData.getProperty("privacyPolicyWarning"), pData.getProperty("firstNameWarning"), pData.getProperty("lastNameWarning"), pData.getProperty("emailWarning"), pData.getProperty("telephoneWarning"), pData.getProperty("passwordWarnimg")));
		
		
		
//		Assert.assertTrue(registerPage.retrievePrivaycPolicyWarning().contains(pData.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");
//		Assert.assertTrue(registerPage.retrieveFirstNameWarning().contains(pData.getProperty("firstNameWarning")), "First Name Warning message is not displayed");
//		Assert.assertTrue(registerPage.retrieveLasttNameWarning().contains(pData.getProperty("lastNameWarning")), "Last Name Warning message is not displayed");
//		Assert.assertTrue(registerPage.retrieveEmailAddressWarning().contains(pData.getProperty("emailWarning")), "Email Warning message is not displayed");
//		Assert.assertTrue(registerPage.retrieveTelephoneWarning().contains(pData.getProperty("telephoneWarning")), "Telephone Warning message is not displayed");
//		Assert.assertTrue(registerPage.retrievePasswordWarning().contains(pData.getProperty("passwordWarnimg")), "Password Warning message is not displayed");
		
		
		
//		String actualPrivacyPolicyWarning= registerPage.retrievePrivaycPolicyWarning();
//		Assert.assertTrue(actualPrivacyPolicyWarning.contains(pData.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");
//		
//		String actualFirstNameWarning = registerPage.retrieveFirstNameWarning();
//		Assert.assertTrue(actualFirstNameWarning.contains(pData.getProperty("firstNameWarning")), "First Name Warning message is not displayed");
//		
//		String actualLastNameWarning = registerPage.retrieveLasttNameWarning();
//		Assert.assertTrue(actualLastNameWarning.contains(pData.getProperty("lastNameWarning")), "Last Name Warning message is not displayed");
//		
//		String actualEmailWarning = registerPage.retrieveEmailAddressWarning();
//		Assert.assertTrue(actualEmailWarning.contains(pData.getProperty("emailWarning")), "Email Warning message is not displayed");
//		
//		String actualTelephoneWarning = registerPage.retrieveTelephoneWarning();
//		Assert.assertTrue(actualTelephoneWarning.contains(pData.getProperty("telephoneWarning")), "Telephone Warning message is not displayed");
//		
//		String actualPasswordWarning = registerPage.retrievePasswordWarning();
//		Assert.assertTrue(actualPasswordWarning.contains(pData.getProperty("passwordWarnimg")), "Password Warning message is not displayed");
	
	}
	
	
	
	
	
}
