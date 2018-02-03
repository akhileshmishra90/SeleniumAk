package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISRcvbyChq {

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
	  @FindBy(id="chkAdv1")
	  WebElement EnableAdvEdt;
	  @FindBy(id="SoSSadvAmt")
	  WebElement AdvAmtEdt;
	  @FindBy(id="SoIpayMode-select")
	  WebElement PayModeEdt;
	  @FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
	   WebElement chequeNo;
	@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
	WebElement recvdbankName;
	 @FindBy(xpath="//button[@data-bind='click: ok']")
		WebElement savingcheq;
	 @FindBy(xpath="//input[@data-bind='value: Amount']")
	 WebElement puttingTotalAmount;
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
		
		public void payLtr(String Cust,String Desc,String Category,String Unitprice,String Advanced,String paymode,String ChequeNo,String RecvdbankName  ) throws InterruptedException
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
		EnableAdvEdt.click();
		AdvAmtEdt.sendKeys(Advanced);
		PayModeEdt.clear();
		PayModeEdt.sendKeys(paymode);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		 chequeNo.sendKeys(ChequeNo);
	 			recvdbankName.sendKeys(RecvdbankName);
	 			
	 			puttingTotalAmount.clear();
	 				puttingTotalAmount.sendKeys(Advanced);
	 				
	 			savingcheq.click();
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
