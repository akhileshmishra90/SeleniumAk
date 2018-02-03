package com.Actouch.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SODashBoard {
	@FindBy(xpath="//input[@data-bind='selectcontrolSOMainSite:SOMain.sitedesc']")
	private WebElement SiteEdt;
	@FindBy(xpath="//input[@aria-controls='SOTable']")
	private WebElement searchtxt;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
    private WebElement actval;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
   private WebElement CustId;
    public SODashBoard(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    public void SiteEdt(String Site)
    {
    	SiteEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Site);
    }
    public void Setsearchtxt(String setexp)
    {
    	searchtxt.sendKeys(setexp);
    }

    public String actval()
    {
    String ac=actval.getText();
    	return ac;
    }
    public  String CustId()
    {
    	String Cus = CustId.getText();
    	return Cus;
    }
    public String GetSetsearchtxt()
    {
    String SrcTxt = searchtxt.getAttribute("value");	
    	return SrcTxt;
    }
    public String GetSiteEdt()
    {
    	String SiteTxt = SiteEdt.getAttribute("value");	
    	return SiteTxt;
    }
    }
    

