package com.Actouch.PurchaseSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POSRVPayNowMultiCheque {
	public static String amt;
	@FindBy(id ="poId")
	WebElement PoIdEdt;
	@FindBy(id="poServSuppList")
	WebElement SuppEdt;
	@FindBy(xpath="//textarea[@placeholder='Enter Service Description (Max 190 characters)']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind ='selectcontrolExpenseAcPOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="POSunitprice")
	WebElement UnitPriceEdt;
	@FindBy(id="payTypePOS")
	WebElement PaytypeEdt;
	@FindBy(id="payMode2-select")
	WebElement paymodeEdt;
	@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	WebElement chequeNo;
	@FindBy(xpath="//label[@data-bind='html: POInventory.netAmt']")
    WebElement getTotalAmount;
	@FindBy(xpath="//input[@data-bind='value: Amount']")
    WebElement setTotalAmount;
	@FindBy(xpath="//button[@id='btnAddDetail']")
	WebElement addNewChq;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[1]/input")
	WebElement chequeNo2;
	@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[5]/input")
    WebElement setTotalAmount2;
    @FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement savingCheq;
		@FindBy(xpath="//label[@data-bind='html: POService.netAmt']")
	WebElement TotalEdt;
	@FindBy(id="btnSave")
	WebElement SaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmEdt;
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement SearchEdt;
	@FindBy(xpath="//table[@id='POTable']/tbody/tr[1]/td[2]")
	WebElement actval;
	public void payNowSChq(String Supp,String Desc,String Category,String Unitprice,String Paytype,String BankName,String ChequeNo, String ChequeNo1,String RecvdbankName) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
		Actions act = new Actions(Browser.driver);
		String exp = PoIdEdt.getAttribute("value");
		Thread.sleep(3000);
		SuppEdt.sendKeys(Supp);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).perform();
		DescEdt.sendKeys(Desc);
		CategoryEdt.sendKeys(Category);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		UnitPriceEdt.sendKeys(Unitprice);
		act.sendKeys(Keys.ENTER).perform();
		amt=TotalEdt.getText();
		 PaytypeEdt.clear();
		   PaytypeEdt.sendKeys(Paytype);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   PaytypeEdt.clear();
			 PaytypeEdt.sendKeys(Paytype);
			act.sendKeys(Keys.ARROW_DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			 amt=TotalEdt.getText();  			
			paymodeEdt.clear();
			  			paymodeEdt.sendKeys(BankName);
			  			act.sendKeys(Keys.ARROW_DOWN).perform();
			  			act.sendKeys(Keys.ENTER).perform();
		    double a1 = 0; 
		  	 if(!amt.equals("")){
		  		 a1 = Double.valueOf(amt); 
		  	 }
		  			double amt1 = a1/2;
			String amount1 =Double.toString(amt1);	  				
				chequeNo.sendKeys(ChequeNo);  				
				setTotalAmount.clear();
				setTotalAmount.sendKeys(amount1);	  				
				addNewChq.click();	  				
				chequeNo2.sendKeys(ChequeNo1);	  				
				setTotalAmount2.sendKeys(amount1);	  				
				savingCheq.click();
		SaveEdt.click();
		ConfirmEdt.click();
		 Browser.driver.get(Constant.PurchaseMain);
		  Thread.sleep(7000);
		  SearchEdt.sendKeys(exp);
		   String act2 = actval.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	 		System.out.println("payment later after saving case == pass");
	}
}
