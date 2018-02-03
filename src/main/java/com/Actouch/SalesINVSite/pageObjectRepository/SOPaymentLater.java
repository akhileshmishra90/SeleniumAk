package com.Actouch.SalesINVSite.pageObjectRepository;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.Assert;
	import org.testng.Reporter;
	import com.Actouch.Pages.SODashBoard;
	import com.Actouch.Pages.SalesOrderCreation;
	import com.Actouch.Sales.generic_Lib.Browser;
	import com.Actouch.Sales.generic_Lib.Constant;
	import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

	public class SOPaymentLater {
		public static String amt;
		public void payltr(String Site,String Customer_Id,String Product_Id,String Quantity,String unit_price,String taxCode) throws InterruptedException
		{
			WebDriverCommonlib.waitForPageToLoad();
			Actions act = new Actions(Browser.driver);
			SalesOrderCreation SOC = new SalesOrderCreation(Browser.driver); 
			JavascriptExecutor kl = (JavascriptExecutor)Browser.driver;
			SODashBoard SOB = new SODashBoard(Browser.driver);
			Thread.sleep(2000);
			SOC.SiteEdt(Site);
			Thread.sleep(2000);
			act.sendKeys(Keys.TAB).perform();
			String Exp = SOC.SOidEdt();
			SOC.SoCustIdEdt(Customer_Id);
			act.sendKeys(Keys.TAB).perform();
			kl.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(3000);
			SOC.prdSo_1Edt(Product_Id);
			Thread.sleep(3000);
			act.sendKeys(Keys.TAB).perform();
			SOC.qntnormEdt(Quantity);
			SOC.unitprice_1edt(unit_price);
			SOC.taxEdt();
			 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
			amt = SOC.gettingTotalAmount();
			Thread.sleep(3000);
			SOC.btnSaveEdt();
			SOC.ConfirmSaveedt();
			 Browser.driver.get(Constant.SalesMain);
			 SOB.SiteEdt(Site);
			 act.sendKeys(Keys.TAB).perform();
			 SOB.Setsearchtxt(Exp);
			 String Actual =  SOB.actval();
			 Assert.assertEquals(Actual, Exp,"payment later after saving case == fail");
		  		Reporter.log("payment later after saving case == pass",true);
			
			
		}

	}


