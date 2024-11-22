package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.AccountPage;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	
	public WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplicationURL(p.getProperty("browserName"));
		homePage = new HomePage(driver);
		homePage.clickOnMyAccountDropMenu();
		loginPage = homePage.selectLoginOption();
		//homePage.navigateToLoginPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name="validCredentialsSupplier")
	public Object[][] supplyTestData()
	{
		Object[][] data = Utilities.getTestDataFromExcel("Login");			
		return data;	
	}
	
	
	@Test(priority=1,dataProvider="validCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password)
	{
		//loginPage.enterEmailAdress(email);
		//loginPage.enterPassword(password);
		//AccountPage accountPage = loginPage.clickOnLoginButton();
		AccountPage accountPage = loginPage.login(email, password);

		Assert.assertTrue(accountPage.verifyGetDisplayStatusOfYourAccountInfoOption(), "Edit Your Account Information option is not displayed");	
	}
	
	
	@Test(priority=2)
	public void verifyLoginWithInvalidCredentials()
	{
		
		//loginPage.enterEmailAdress(Utilities.generateTimeStamp());
		//loginPage.enterPassword(pData.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();
		
		loginPage.login(Utilities.generateTimeStamp(), pData.getProperty("invalidPassword"));
		
		//String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessageText();
		//String expectedWarningMessage = pData.getProperty("emailPasswordNoMatchingWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(pData.getProperty("emailPasswordNoMatchingWarning")), "Expected Warning message is not displayed");
	}
	
	@Test(priority=3)
	public void verifyLoginWithInvalidEmailAndValidPassword()
	{
		//loginPage.enterEmailAdress(Utilities.generateTimeStamp());
		//loginPage.enterPassword(p.getProperty("password"));
		//loginPage.clickOnLoginButton();
		
		loginPage.login(Utilities.generateTimeStamp(), p.getProperty("password"));
		
		//String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessageText();
		//String expectedWarningMessage = pData.getProperty("emailPasswordNoMatchingWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(pData.getProperty("emailPasswordNoMatchingWarning")), "Expected Warning message is not displayed");
	}
	
	@Test(priority=4)
	public void verifyLoginWithValidEmailAndInvalidPassword()
	{

		//loginPage.enterEmailAdress(p.getProperty("validEmail"));
		//loginPage.enterPassword(pData.getProperty("invalidPassword"));
		//loginPage.clickOnLoginButton();
		loginPage.login(p.getProperty("validEmail"), pData.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(pData.getProperty("emailPasswordNoMatchingWarning")), "Expected Warning message is not displayed");
		
		
		//String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessageText();
		//String expectedWarningMessage = pData.getProperty("emailPasswordNoMatchingWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");

	}
	
	@Test(priority=5)
	public void verifyLoginWithoutCredentials()
	{
		loginPage.clickOnLoginButton();
		
		//String actualWarningMessage = loginPage.retriveEmailPasswordNotMatchingWarningMessageText();
		//String expectedWarningMessage = pData.getProperty("emailPasswordNoMatchingWarning");
		//Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
		Assert.assertTrue(loginPage.retriveEmailPasswordNotMatchingWarningMessageText().contains(pData.getProperty("emailPasswordNoMatchingWarning")), "Expected Warning message is not displayed");
	}
	
	
	
	
	

	
	
	
	
	
	
}
