package com.Actouch.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class ShipmentDashbord {
	@FindBy(id="custIdForShp")
	private WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='SOTable_filter']/label/input")
	private WebElement SearchforSo;
	@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]/a")
	private WebElement chooseSoId;
	@FindBy(xpath="//div[@id='crsobtn']/a")
	private WebElement viewInvoice;
	@FindBy(xpath="//input[@data-bind='selectcontrolSHPMainSite:shpMstr.sitedesc']")
	private WebElement siteEdt;
   public ShipmentDashbord(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   public void siteEdt(String site)
   {
	   siteEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),site);
   }
   public void viewInvoice()
   {
	   WebDriverCommonlib.waitForElementPresent(viewInvoice);
	   viewInvoice.click();
   }
	public void CustIdShpedt(String CustIdShp)
	{
		CustIdShpedt.sendKeys(CustIdShp);
	}
	public void SearchforSo(String ForSO)
	{
		SearchforSo.sendKeys(ForSO);
	}
	public void chooseSoId()
	{
		chooseSoId.click();
	}

}
