package com.Actouch.PurchaseSRV.pageObjectRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;
import com.Actouch.Purchase.generic_Lib.WebDriverCommonlib;

public class POSRVTDSDis {
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
	@FindBy(xpath="//label[@data-bind='html: POService.netAmt']")
	WebElement TotalEdt;
	@FindBy(xpath="//table[@id='PODetailsTable']/tbody/tr/td[8]/div/div/span[text()='Tax Details']")
	WebElement Taxmodel;
	@FindBy(id="lineDisc")
	WebElement DisEdt;	
	@FindBy(id="btnSave")
	WebElement SaveEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement ConfirmEdt;
	@FindBy(xpath="//input[@aria-controls='POTable']")
	WebElement SearchEdt;
	@FindBy(xpath="//table[@id='POTable']/tbody/tr[1]/td[2]")
	WebElement actval;
	public void TDSDis(String Supp,String Desc,String Category,String Unitprice,String taxCode1,String Dis) throws InterruptedException
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
		DisEdt.sendKeys(Dis);
		 Taxmodel.click();
		 for(int i=1;i<10;i++)
			  {
			String count1=Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td[2]/input[@id ='taxId'] ")).getAttribute("value");
				  if(count1.equals(taxCode1)){
					Browser.driver.findElement(By.xpath("//table[@id='taxCalc']/tbody/tr["+i+"]/td/input[@id ='chkTaxId']")).click();
					Browser.driver.findElement(By.xpath("//button[@data-bind='click: ok']")).click();
				  
				  	break;
				  	
				  }
			  }
		
		
		amt=TotalEdt.getText();
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
