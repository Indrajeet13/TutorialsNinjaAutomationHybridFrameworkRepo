package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageObjects.HomePage;
import com.tutorialsninja.qa.pageObjects.SearchPage;

public class SearchTest extends Base {

	SearchPage searchPage; 
	HomePage homePage;
	public WebDriver driver;
	
	public SearchTest()
	{
		super();	
	}
	
	@BeforeMethod
	public void setup()
	{
		driver = initializeBrowserAndOpenApplicationURL(p.getProperty("browserName"));
		homePage = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void verifySearchWithValidProducts()
	{
		//homePage.searchBoxField(pData.getProperty("validProduct"));
		//searchPage = homePage.clickOnSearchButton();
		
		searchPage = homePage.searchForAProduct(pData.getProperty("validProduct"));
		Assert.assertTrue(searchPage.displayStatusOfHPvalidProduct());
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProducts()
	{
		
		//homePage.searchBoxField(pData.getProperty("invalidProduct"));
		//homePage.clickOnSearchButton();
		homePage.searchForAProduct(pData.getProperty("invalidProduct"));
		
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		//Assert.assertEquals(actualSearchMessage, pData.getProperty("noProductTextInSearchResults"),"There is not product that matches the search criteria");
		Assert.assertEquals(actualSearchMessage,"abcd","There is not product that matches the search criteria");
	}
	
	@Test(priority=3,dependsOnMethods={"verifySearchWithInvalidProducts","verifySearchWithValidProducts"})
	public void verifySearchWithoutAnyProducts()
	{
		searchPage = homePage.clickOnSearchButton();

		String actualSearchMessage = searchPage.retrieveNoProductMessageText();
		Assert.assertEquals(actualSearchMessage, pData.getProperty("noProductTextInSearchResults"), "There is not product that matches the search criteria");
	}
	
	
}
