package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
 
public class Logout {
	@FindBy(xpath="//ul[@id='profileId']/li/a/span")
	WebElement LogoutLink;
	@FindBy(linkText="Logout")
	WebElement Logout;
	public void logout() throws InterruptedException
	{
	Thread.sleep(6000);
	LogoutLink.click();
	Thread.sleep(7000);
	Logout.click();
	

	}
}
