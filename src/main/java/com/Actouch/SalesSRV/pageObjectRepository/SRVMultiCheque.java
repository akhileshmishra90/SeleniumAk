package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class SRVMultiCheque {
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
	@FindBy(xpath="//button[@id='btnAddDetail']")
	WebElement addNewChq;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[1]/input")
	WebElement chequeNo2;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[2]/input")
	WebElement recvdbankName1;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[5]/input")
	WebElement puttingTotalAmount1;
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
	   public void PayNowMultiCheque(String Cust,String Desc,String Category,String Unitprice,String Paytype,String paymode,String ChequeNo,String RecvdbankName,String ChequeNo2,String Recvbank2  ) throws InterruptedException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		   String exp = SOSIdEdt.getAttribute("value");
		   WebDriverCommonlib.waitForElementPresent(CustEdt);
		   Thread.sleep(3000);
		   CustEdt.sendKeys(Cust);
		   Thread.sleep(1000);
		   act.sendKeys(Keys.TAB).perform();
		   DescEdt.sendKeys(Desc);
		   CategoryEdt.sendKeys(Category);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   UnitPrice.sendKeys(Unitprice);
		    PaytypeEdt.clear();
		   PaytypeEdt.sendKeys(Paytype);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   amt=TotalEdt.getText();
		   double a1 = 0; 
		  	 if(!amt.equals("")){
		  		 a1 = Double.valueOf(amt); 
		  	 }
		  			double amt1 = a1/2;
		  			String amount1 =Double.toString(amt1);
		   paymodeEdt.clear();
		   paymodeEdt.sendKeys(paymode);
		 act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		  
		  
		   chequeNo.sendKeys(ChequeNo);
 			recvdbankName.sendKeys(RecvdbankName);
 			
 			puttingTotalAmount.clear();
 				puttingTotalAmount.sendKeys(amount1);
 				
addNewChq.click();
 				
 				chequeNo2.sendKeys(ChequeNo2);
 				recvdbankName1.sendKeys(Recvbank2);
 				
 				puttingTotalAmount1.clear();
 				
 				puttingTotalAmount1.sendKeys(amount1);
 				
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
