package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DLVValidateCustomer {
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
   
    public void CustomerValidate() throws InterruptedException
    {
  	WebDriverCommonlib.waitForPageToLoad();
  	Actions act = new Actions(Browser.driver);
      	String exp=searchtxt.getAttribute("value"); 
    	String Cust= CustId.getText();
    	String Custname =CustName.getText();
    	 	 Browser.driver.get(Constant.shpMain);
    	CustIdShpedt.sendKeys(Cust);
    	act.sendKeys(Keys.ARROW_DOWN).perform();
    	act.sendKeys(Keys.ENTER).perform();
    	String veryCust = VeryfyCust.getAttribute("value");
    	Assert.assertEquals(veryCust, Custname,"Customer Name veryfied==fail");
    	System.out.println("Customer Name veryfied == pass");
    	Thread.sleep(2000);
    SearchforSo.sendKeys(exp);
   		chooseSoId.click();
    		String veryCust1 = VeryfyCust.getAttribute("value");
    	Assert.assertEquals(veryCust1, Custname,"Customer Name veryfied==fail");
    	System.out.println("Customer Name veryfied == pass");
    	}
}
