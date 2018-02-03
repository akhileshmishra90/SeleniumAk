package com.Actouch.SalesQuotation.TestScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import com.Actouch.SalesQuotation.generic_Lib.Browser;
import com.Actouch.SalesQuotation.generic_Lib.Constant;
import com.Actouch.SalesQuotation.generic_Lib.SalesQuotationExcellib;
import com.Actouch.SalesQuotation.pageObjectRepository.Login;


public class LoginPage {
	WebDriver driver;
	
	public void sqIN_Login_TC_1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException
	{
		//login
		
		driver = Browser.getbrowser();
		Browser.driver.get(Constant.Url);
		
		 String usrid = SalesQuotationExcellib.getExcelDat("Sheet1", 03, 03);
		 String pss = SalesQuotationExcellib.getExcelDat("Sheet1", 03, 04);
			
		Login loginpage = PageFactory.initElements(driver, Login.class);
		loginpage.login(usrid, pss);
	
		Thread.sleep(3000);
		
		}

}
