package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class Login 
{
	@FindBy(id ="email")
	WebElement useredt;
	@FindBy(name="j_password")
WebElement pswedt;
	@FindBy(xpath ="//button[text()='Sign in']")
	WebElement loginbtn;
	public void login(String Username, String password )
	{
    WebDriverCommonlib.waitForPageToLoad();
	Browser.driver.manage().window().maximize();
		useredt.sendKeys(Username);
		pswedt.sendKeys(password);
		loginbtn.click();
		
	}
	

}
