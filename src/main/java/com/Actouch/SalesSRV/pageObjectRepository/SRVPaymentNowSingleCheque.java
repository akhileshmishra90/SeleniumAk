package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRVPaymentNowSingleCheque {
	public static String amt;
	@FindBy(id="SoSsoId")
	WebElement SOSIdEdt;
	@FindBy(id="custid_createSOS")
	WebElement CustEdt;
	@FindBy(xpath="//textarea[@placeholder='Enter Service Description (Max 1990 characters)']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind='selectcontrolExpenseAcSOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="unitprice")
	WebElement UnitPrice;
	@FindBy(id="payType")
	WebElement PaytypeEdt;
	@FindBy(id="SoIpayMode-select")
	WebElement paymodeEdt;
	
	
	
	@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	   WebElement chequeNo;
	@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
	WebElement recvdbankName;
	
	@FindBy(xpath="//input[@data-bind='value: Amount']")
    WebElement puttingTotalAmount;
    @FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingcheq;
	@FindBy(xpath="//label[@data-bind='html: SOService.totalAmt']")
	WebElement TotalEdt;
	
	@FindBy(id="btnSaveSO")
	WebElement SaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmEdt;
	 @FindBy(xpath="//input[@aria-controls='SOTable']")
	    WebElement searchtxt;
	   @FindBy(xpath="//table[@id='SOTable']/tbody/tr/td[2]")
	   WebElement actval;
	   public void PayNowPettySingleCheque(String Cust,String Desc,String Category,String Unitprice,String Paytype,String paymode,String ChequeNo,String RecvdbankName ) throws InterruptedException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		   String exp = SOSIdEdt.getAttribute("value");
		   Thread.sleep(3000);
		   CustEdt.sendKeys(Cust);
		   Thread.sleep(1000);
		   act.sendKeys(Keys.TAB).perform();
		   DescEdt.sendKeys(Desc);
		   CategoryEdt.sendKeys(Category);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   UnitPrice.sendKeys(Unitprice);
		   amt=TotalEdt.getText();
		   PaytypeEdt.clear();
		   PaytypeEdt.sendKeys(Paytype);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   amt=TotalEdt.getText();
		   paymodeEdt.clear();
		   paymodeEdt.sendKeys(paymode);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   chequeNo.sendKeys(ChequeNo);
 			recvdbankName.sendKeys(RecvdbankName);
 		puttingTotalAmount.clear();
 				puttingTotalAmount.sendKeys(amt);
 			savingcheq.click();
		  SaveEdt.click();
			ConfirmEdt.click();
			 Browser.driver.get(Constant.SalesMain);
			  Thread.sleep(7000);
			   // saleConfirmMsgedt.getText();
			  searchtxt.sendKeys(exp);
			   String act2 = actval.getText();
			    Assert.assertEquals(act2, exp,"payment now after saving case == fail");
		 		System.out.println("payment now after saving case == pass");
		   
		   
	   }
	

}
