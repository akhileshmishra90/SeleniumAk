package com.Actouch.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login {
	@FindBy(id ="email")
	WebElement useredt;
	@FindBy(name="j_password")
WebElement pswedt;
	@FindBy(xpath ="//button[text()='Sign in']")
	WebElement loginbtn;
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void  useredt(String usrid)
	{
		useredt.sendKeys(usrid);
	}
	public void pswedt(String pass)
	{
		pswedt.sendKeys(pass);
	}
	public void loginbtn()
	{
		loginbtn.click();
	}

}
