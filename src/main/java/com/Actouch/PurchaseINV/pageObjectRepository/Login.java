package com.Actouch.PurchaseINV.pageObjectRepository;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;



public class Login 
{
	@FindBy(id ="email")
	WebElement userEdt;
	@FindBy(name="j_password")
	WebElement pswEdt;
	@FindBy(xpath ="//button[text()='Sign in']")
	WebElement loginbtn;
		public void login(String Username, String password )
	{
		WebDriverCommonlib.waitForPageToLoad();
		com.Actouch.Purchase.generic_Lib.Browser.driver.manage().window().maximize();
		userEdt.sendKeys(Username);
		pswEdt.sendKeys(password);
		loginbtn.click();
		
	}
	

}
