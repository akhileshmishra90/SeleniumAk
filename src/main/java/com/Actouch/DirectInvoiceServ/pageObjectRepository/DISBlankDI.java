package com.Actouch.DirectInvoiceServ.pageObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;

public class DISBlankDI {
	@FindBy(xpath="//label[@data-bind='html: NewSHPMain.OrderTypeSelected'] ")
	WebElement changeType;
	@FindBy(linkText="Service")
	WebElement Service;
	@FindBy(xpath="//p[contains(text(),'Customer Id cannot be blank')]")
	WebElement Errormessge;
	@FindBy(id="btnSaveSO")
	   WebElement 	SaveEdt;
	   public void payltr() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException
	   {
		   WebDriverCommonlib.waitForPageToLoad();
		   changeType.click();
			Thread.sleep(4000);
			Service.click();
		  String exp = "Customer Id cannot be blank";
		  Thread.sleep(2000);
		  SaveEdt.click();
		   String act2 = Errormessge.getText();
		    Assert.assertEquals(act2, exp,"BlankSO Error message   case == fail");
	  		System.out.println("BlankSO Error message case == pass");
	
	   }

}
