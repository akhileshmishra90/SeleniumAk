package com.Actouch.DirectReceiptINV.pageObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Actouch.Purchase.generic_Lib.Browser;

public class DRBlankDR {
  @FindBy(id="btnSave")
		WebElement Save;
		@FindBy(xpath="//p[contains(text(),'Supplier ID Cannot be Blank')]")
		WebElement Result;
		public void BatchMuom() throws InterruptedException
		{
			WebDriverWait wait =new WebDriverWait(Browser.driver, 20);
			String	Expected = "Supplier ID Cannot be Blank";
			 wait.until(ExpectedConditions.visibilityOf(Save));
			  Save.click();
			 String Actual = Result.getText();
			 Assert.assertEquals(Actual, Expected,"POR ID not created");
			  
		}
	

}
