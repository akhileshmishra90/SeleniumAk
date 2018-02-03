package com.Actouch.Sales.generic_Lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {
	public static WebDriver driver;
	public static WebDriver getbrowser()
	{
		if (Constant.browser.equals("ie"))
		{
			System.setProperty("webdriver", "");
			driver = new InternetExplorerDriver();
		}
		else if(Constant.browser.equals("chromedriver"))
		{
			System.setProperty("webdriver", "D:\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Constant.browser.equals("firefoxdriver"))
		{
			
			driver = new FirefoxDriver();

		}
		return driver;
		
	}

}


