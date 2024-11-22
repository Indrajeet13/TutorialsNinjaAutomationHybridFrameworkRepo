package com.tutorialsninja.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
 	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privaycPolicyWarning;
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailAddressWarningMessage;
	
	@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
	private WebElement telephonesWarningMessage;
	
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarningMessage;
	
	
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterFirstName(String firstNameText)
	{
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText)
	{
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText)
	{
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText)
	{
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText)
	{
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String passwordText)
	{
		passwordConfirmField.sendKeys(passwordText);
	}
	
	public void selectPrivayPolicy()
	{
		privacyPolicyField.click();
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public void clickOnYesNewsletterOption()
	{
		yesNewsletterOption.click();
	}
	
	
	
	public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText)
	{
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(passwordText);
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText)
	{
		firstNameField.sendKeys(firstNameText);
		lastNameField.sendKeys(lastNameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
		passwordConfirmField.sendKeys(passwordText);
		yesNewsletterOption.click();
		privacyPolicyField.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	
	public String retrievePrivaycPolicyWarning()
	{
		String privaycPolicyWarningText = privaycPolicyWarning.getText();
		return privaycPolicyWarningText;
	}
	
	public String retrieveFirstNameWarning()
	{
		String firstNameWarningMessageText = firstNameWarningMessage.getText();
		return firstNameWarningMessageText;
	}
	public String retrieveLasttNameWarning()
	{
		String lastNameWarningMessageText = lastNameWarningMessage.getText();
		return lastNameWarningMessageText;
	}
	public String retrieveTelephoneWarning()
	{
		String telephonesWarningMessageText= telephonesWarningMessage.getText();
		return telephonesWarningMessageText;
	}
	public String retrieveEmailAddressWarning()
	{
		String emailAddressWarningMessageText= emailAddressWarningMessage.getText();
		return emailAddressWarningMessageText;
	}
	public String retrieveDuplicatesEmailAddressWarning()
	{
		String duplicateEmailAddressWarningText= duplicateEmailAddressWarning.getText();
		return duplicateEmailAddressWarningText;
	}
	
	public String retrievePasswordWarning()
	{
		String passwordWarningMessageText= passwordWarningMessage.getText();
		return passwordWarningMessageText;
	}
	
	public boolean displayStatusOfWarningMessages(String expectedPrivaycPolicyWarning,String expectedFirstNameWarning, String expectedLastNameWarning, String expectedEmailWarning, String expectedTelephoneWarning, String expectedPasswordWarning)
	{
	//	String actualPrivaycPolicyWarningText = privaycPolicyWarning.getText();
		boolean privaycPolicyWarningStatus = privaycPolicyWarning.getText().contains(expectedPrivaycPolicyWarning);
		//String actualFirstNameWarningMessageText = firstNameWarningMessage.getText();		
		boolean firstNameWarningStatus = firstNameWarningMessage.getText().equals(expectedFirstNameWarning);
		//String actualLastNameWarningMessageText = lastNameWarningMessage.getText();
		boolean lastNameWarningStatus = lastNameWarningMessage.getText().equals(expectedLastNameWarning);
		//String actualTelephonesWarningMessageText= telephonesWarningMessage.getText();
		boolean telephoneWarningStatus = telephonesWarningMessage.getText().equals(expectedTelephoneWarning);
		//String actualEmailAddressWarningMessageText= emailAddressWarningMessage.getText();
		boolean emailWarningStatus = emailAddressWarningMessage.getText().equals(expectedEmailWarning);
		//String actualPasswordWarningMessageText= passwordWarningMessage.getText();
		boolean passwordWarningStatus = passwordWarningMessage.getText().equals(expectedPasswordWarning);
		
		return privaycPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && telephoneWarningStatus && emailWarningStatus && passwordWarningStatus;
		
	}
	
	
}
