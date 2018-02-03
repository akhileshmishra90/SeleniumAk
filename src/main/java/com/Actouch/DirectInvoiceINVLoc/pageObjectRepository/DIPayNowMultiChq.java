package com.Actouch.DirectInvoiceINVLoc.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DIPayNowMultiChq {
	public static String amt;
	   @FindBy(id="SoIsoId")	
	   WebElement SOidEdt;
	   @FindBy(id="createDinvCustId")
	   WebElement DSOCustEdt;
	   @FindBy(id="prdSo_1")
	   WebElement PrDSO;
	   @FindBy(xpath="//div[@data-bind='if:chkLoc']/span[@class='label label-warning']")
	   WebElement peDetailsEdt;
	   @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[1]/input")
	   WebElement roleSelProdEdt;
	  @FindBy(xpath=".//*[@id='taxCalc']/tbody/tr[1]/td[13]/input")
	   WebElement Qnty;
	   @FindBy(xpath="//button[@data-bind='click: ok']")
	   WebElement SaveProdModel;
	   @FindBy(id="unitprice_1")
	   WebElement UnitPrice;
	   @FindBy(id="payType")
	   WebElement PayEdt;
	   @FindBy(id="SoIpayMode-select")
	   WebElement payByEdt;
	   @FindBy(xpath="//button[@id='btnAddDetail']")
		WebElement addNewChq;
		@FindBy(xpath="//input[@data-bind='value: ChequeNo,hasfocus:true']")
		   WebElement chequeNo1;
		@FindBy(xpath="//input[@data-bind='value: recvdbankName,enable: hasColumn']")
		WebElement recvdbankName;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[1]/input")
		WebElement chequeNo2;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[2]/input")
		WebElement recvdbankName1;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[1]/td[5]/input")
	    WebElement puttingTotalAmount;
		@FindBy(xpath="//table[@id='taxCalc']/tbody/tr[2]/td[5]/input")
		WebElement puttingTotalAmount1;
		 @FindBy(xpath="//button[@data-bind='click: ok']")
			WebElement savingcheq;
	   @FindBy(xpath="//label[@data-bind='html: DIInventory.totalAmt']")
	   WebElement TotalEdt;
	   @FindBy(id="btnSave")
	   WebElement SaveEdt;
	   @FindBy(xpath="html/body/div[9]/div/div[3]/button")
	   WebElement AfterSaveEdt;
	   @FindBy(xpath="//input[@aria-controls='SHP_Table']")
	  WebElement Searchext;
	   @FindBy(xpath=".//*[@id='SHP_Table']/tbody/tr[1]/td[5]")
	   WebElement ResultEdt;
	   public void paySgChq(String Customer_Id,String Product_Id,String Quantity,String unit_price,String PayType,String PayMode ,String ChequeNo,String RecvdbankName,String ChequeNo2,String Recvbank2) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   Actions act = new Actions(Browser.driver);
		    String exp = SOidEdt.getAttribute("value");
		    Thread.sleep(3000);
		    DSOCustEdt.sendKeys(Customer_Id);
		 Thread.sleep(1000);
		  act.sendKeys(Keys.TAB).perform();
		   JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
		   kl.executeScript("window.scrollBy(0,300)", "");
		   PrDSO.sendKeys(Product_Id);
		  Thread.sleep(2000);
	     	act.sendKeys(Keys.TAB).perform();
	     	peDetailsEdt.click();
		    roleSelProdEdt.click();
		    Qnty.sendKeys(Quantity);
		    SaveProdModel.click();
		   Thread.sleep(2000);
		   UnitPrice.sendKeys(unit_price);
		   act.sendKeys(Keys.ENTER).perform();
		   amt = TotalEdt.getText();
		   PayEdt.clear();
		   PayEdt.sendKeys(PayType);
		    act.sendKeys(Keys.ARROW_DOWN).perform();
		   act.sendKeys(Keys.ENTER).perform();
		   payByEdt.clear();
		   payByEdt.sendKeys(PayMode);
		   act.sendKeys(Keys.ARROW_DOWN).perform();
		  act.sendKeys(Keys.ENTER).perform();
		  double a1 = 0; 
		  	 if(!amt.equals("")){
		  		 a1 = Double.valueOf(amt); 
		  	 }
		  			double amt1 = a1/2;
		  			String amount1 =Double.toString(amt1);
		  			chequeNo1.sendKeys(ChequeNo);
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
		   AfterSaveEdt.click();
		  Browser.driver.get(Constant.newShpMain);
		  Thread.sleep(7000);
		  Searchext.sendKeys(exp);
		   String act2 = ResultEdt.getText();
		    Assert.assertEquals(act2, exp,"payment later after saving case == fail");
	  		System.out.println("payment later after saving case == pass");
		    }
}
