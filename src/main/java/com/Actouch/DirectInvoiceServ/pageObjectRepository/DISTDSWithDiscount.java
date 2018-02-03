package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISTDSWithDiscount {
   public static String amt;
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
	  @FindBy(id="lineDisc")
	  WebElement DiscountEdt;
	  @FindBy(xpath="//span[@data-bind='click: showSOTaxModel']")
	  WebElement TaxModel;
		@FindBy(xpath="//label[@data-bind ='html: DIService.totalAmt']")
		WebElement TotalEdt;
		@FindBy(id="btnSaveSO")
	   WebElement 	SaveEdt;
		 @FindBy(xpath="html/body/div[9]/div/div[3]/button")
		   WebElement ConfirmEdt;
		   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
		  WebElement Searchext;
		   @FindBy(xpath="//table[@id='SHP_Table']/tbody/tr[1]/td[3]")
		   WebElement ResultEdt;
		
		public void payLtr(String Cust,String Desc,String Category,String Unitprice,String Discount,String taxCode1 ) throws InterruptedException
		{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		changeType.click();
		Thread.sleep(4000);
		Service.click();
		String exp = SOSIdEdt.getAttribute("value");
		Thread.sleep(3000);
		CustEdt.sendKeys(Cust);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
	   DescEdt.sendKeys(Desc);
	   CategoryEdt.sendKeys(Category);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		UnitpriceEdt.sendKeys(Unitprice);
		DiscountEdt.sendKeys(Discount);
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
		act.sendKeys(Keys.ENTER).perform();
		amt=TotalEdt.getText();
		SaveEdt.click();
		ConfirmEdt.click();
		 Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  Searchext.sendKeys(exp);
		   String act2 = ResultEdt.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	 		System.out.println("payment later after saving case == pass");
		   
		
		}

}
