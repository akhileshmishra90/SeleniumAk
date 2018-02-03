package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISTDSDifferTax {
	@FindBy(xpath="//label[@data-bind='html: NewSHPMain.OrderTypeSelected'] ")
	WebElement changeType;
	@FindBy(linkText="Service")
	WebElement Service;
	  @FindBy(id ="SoSsoId")
	  WebElement SOSIdEdt;
	  @FindBy(id="custid_createSOS")
	  WebElement CustEdt;
	  @FindBy(xpath="//textarea[@data-bind='value: prdDesc']")
	  WebElement DescEdt;
	   @FindBy(xpath="//input[@data-bind='selectcontrolExpenseAcSOSInput:prdId']")
	  WebElement CategoryEdt;
	  @FindBy(id="unitprice")
	  WebElement UnitpriceEdt;
	  @FindBy(xpath="//span[@data-bind='click: showSOTaxModel']")
	  WebElement TaxModel;
	  @FindBy(xpath="html/body/div[11]/div/div[2]/p[contains(text(),'Select Multiple Tax Type with TDS')]")
	  WebElement actval;
	public void TDSDeduction(String Cust,String Desc,String Category,String Unitprice,String taxCode1,String taxCode2) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act = new Actions(Browser.driver);
	   changeType.click();
				Thread.sleep(4000);
				Service.click();
     String exp = "You Can't Select Multiple Tax Type with TDS";
	Thread.sleep(3000);
	CustEdt.sendKeys(Cust);
	Thread.sleep(1000);
	act.sendKeys(Keys.TAB).perform();
	
	DescEdt.sendKeys(Desc);

	CategoryEdt.sendKeys(Category);
	act.sendKeys(Keys.ARROW_DOWN).perform();
	act.sendKeys(Keys.ENTER).perform();
	UnitpriceEdt.sendKeys(Unitprice);
	TaxModel.click();
	  		 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode1)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	 TaxModel.click();
	  		 for(int i=1;i<10;i++)
		  {
		String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
			  if(count1.equals(taxCode2)){
				Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
				Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
			  
			  	break;
			  	
			  }
		  }
	
String Atual= actval.getText();
	    Assert.assertEquals(Atual, exp,"payment later after saving case == fail");
 		System.out.println("payment later after saving case == pass");
	   
	
	}

}
