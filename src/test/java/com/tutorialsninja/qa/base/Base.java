package com.tutorialsninja.qa.base;


import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class Base {
	
	public static WebDriver driver;
	public Properties p;
	public Properties pData;
	
	public Base() 
	{
		try
		{
		//Loading config.properties file
			FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			p = new Properties();
			p.load(file);
		
		
		//Loading testdata.properties file
			pData = new Properties();
			FileReader fileData = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
			pData.load(fileData);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName)
	{
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		
		driver.get(p.getProperty("url"));
		
		return driver;
	}
	
	
}
