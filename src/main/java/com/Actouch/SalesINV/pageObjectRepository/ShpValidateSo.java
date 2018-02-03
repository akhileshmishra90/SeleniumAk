package com.Actouch.SalesINV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class ShpValidateSo   {
	//---------------------------validate SO----------
	
	@FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement searchtxt;
	@FindBy(id="custIdForShp")
	WebElement CustIdShpedt;
	@FindBy(xpath="//div[@id='SOTable_filter']/label/input")
	WebElement SearchforSo;
	@FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]/a")
	WebElement chooseSoId;
  @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[5]")
    WebElement CustId;
    @FindBy(xpath="//table[@id='SOTable']/tbody/tr[1]/td[6]")
    WebElement CustName;
    @FindBy(id="custName")
    WebElement VeryfyCust;
    @FindBy(id="soId")
    WebElement veryfySo;
   public void SoValidate() throws InterruptedException
    {
    	
    	WebDriverCommonlib.waitForPageToLoad();
    String exp=searchtxt.getAttribute("value"); 
    	String Cust= CustId.getText();
     Browser.driver.get(Constant.shpMain);
    	CustIdShpedt.sendKeys(Cust);
    		Actions act = new Actions(Browser.driver);
act.sendKeys(Keys.ARROW_DOWN).perform();
act.sendKeys(Keys.ENTER).perform();
Thread.sleep(2000);    
SearchforSo.sendKeys(exp);
  	chooseSoId.click();
      	String verySo1 = veryfySo.getAttribute("value");
    	Assert.assertEquals(verySo1, exp,"So veryfied==fail");
    	System.out.println("So veryfied == pass");
    	  }

}
