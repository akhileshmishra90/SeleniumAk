package com.Actouch.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceDashbord {
	@FindBy(xpath="//input[@data-bind='selectcontrolnewShpMainSite:newSHPMain.sitedesc']")
	WebElement SiteEdt;
	 @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr[1]/td[5]")
	   WebElement ResultEdt;
	   public InvoiceDashbord(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   public void SiteEdt(String Site)
	   {
		   SiteEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Site);
	   }
     public void Searchext(String InvEdt)
     {
    	 Searchext.sendKeys(InvEdt);
     }
     public String ResultEdt()
     {
    	String RS= ResultEdt.getText();
    	return RS;
     }
}
