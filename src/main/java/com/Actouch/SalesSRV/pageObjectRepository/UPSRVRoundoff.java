package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPSRVRoundoff {

	@FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement TextEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement SerchTextEdt;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ClickForUpdate;
	@FindBy(linkText ="Update Invoice")
	WebElement openForUpdatePage;
	@FindBy(id="roundOffPO")
	WebElement RoundoffEdt;
	@FindBy(id="btnSaveSO")
	WebElement UpdateEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(linkText="View Invoice")
	WebElement clickforView;
	@FindBy(xpath="//input[@data-bind='value: soShipment.roundOff']")
	WebElement Result;
	public void upadateCust(String CustID) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	    Actions Act = new Actions(Browser.driver);
		String SoId=TextEdt.getAttribute("value");
	    Browser.driver.get(Constant.newShpMain);
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    openForUpdatePage.click();
	    RoundoffEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),CustID);
	    Act.sendKeys(Keys.ENTER).perform();
	    String Expected = RoundoffEdt.getAttribute("value");
	    UpdateEdt.click();
	    AfterSave.click();
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    clickforView.click();
	    Thread.sleep(3000);
	   String Actual= Result.getAttribute("value");
	   Assert.assertEquals(Actual, Expected,"given customer name is invalid");
	System.out.println("given Customer name is valid");
	}
		

}
