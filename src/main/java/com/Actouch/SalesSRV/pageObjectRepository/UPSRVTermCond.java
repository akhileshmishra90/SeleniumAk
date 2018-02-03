package com.Actouch.SalesSRV.pageObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.Constant;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class UPSRVTermCond {
    @FindBy(xpath="//input[@aria-controls='SOTable']")
	WebElement TextEdt;
	@FindBy(xpath="//input[@aria-controls='SHP_Table']")
	WebElement SerchTextEdt;
	@FindBy(xpath="//button[text()='Actions']")
	WebElement ClickForUpdate;
	@FindBy(linkText ="Update Invoice")
	WebElement openForUpdatePage;
	@FindBy(xpath="//div[@data-bind='click: updateDIService.showTermsConditionModal']")
	WebElement TermCondModel;
	@FindBy(xpath="//textarea[@data-bind='value: termsCondnSQ']")
	WebElement termCondEdt;
	@FindBy(xpath="//button[@data-bind='click: ok']")
	WebElement AftTermCond;
	@FindBy(id="btnSaveSO")
	WebElement UpdateEdt;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement AfterSave;
	@FindBy(linkText="View Invoice")
	WebElement clickforView;
	@FindBy(xpath="//div[@data-bind='click: soShipment.showTermsConditionModal']")
	WebElement viewDetail;
	@FindBy(xpath="//textarea[@placeholder='Terms and Conditions']")
	WebElement Result;
	public void upadateCust(String termCond) throws InterruptedException
	{
		WebDriverCommonlib.waitForPageToLoad();
	    Actions Act = new Actions(Browser.driver);
		String SoId=TextEdt.getAttribute("value");
	    Browser.driver.get(Constant.newShpMain);
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    openForUpdatePage.click();
	    Thread.sleep(3000);
	    TermCondModel.click();
	    termCondEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),termCond);
	    Act.sendKeys(Keys.ENTER).perform();
	    String Expected = termCondEdt.getAttribute("value");
	    AftTermCond.click();
	    UpdateEdt.click();
	    AfterSave.click();
	    SerchTextEdt.sendKeys(SoId);
	    ClickForUpdate.click();
	    clickforView.click();
Thread.sleep(3000);
           viewDetail.click();
        String Actual= Result.getAttribute("value");
	   Assert.assertEquals(Actual, Expected,"given customer name is invalid");
	System.out.println("given Customer name is valid");
	}
		

}
