	package com.Actouch.Pages;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
		public class ShipmentCreation {
		@FindBy(id="invoiceId")
		WebElement InvoiceId;
		@FindBy(xpath="//label[@data-bind='html: soShipment.grossAmt']")
		 WebElement grossAmtEdt;
		@FindBy(xpath="//label[@data-bind='html: soShipment.totalTax']")
		 WebElement TotalTaxEdt;
		@FindBy(id="btnSave")
		 WebElement shipsaving;
		@FindBy(xpath="html/body/div[9]/div/div[3]/button")
		 WebElement aftSavingShp;
		@FindBy(xpath="//label[@data-bind='html: soShipment.totalAmt']")
		 WebElement TotalEdt;
		public ShipmentCreation(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public String InvoiceId ()
		{
			String inv ="";
			try{
			inv  = InvoiceId.getAttribute("value");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return inv;
		}
	 public String grossAmtEdt()
	 {
		 String grossAmt = grossAmtEdt.getText();
		 return grossAmt;
	 }
	 public String TotalTaxEdt()
	 {
		String TotalTax = TotalTaxEdt.getText();
		return TotalTax;
	 }
	 public String TotalEdt() {
		 String Total = TotalEdt.getText();
			return Total;
	}
	
		public void shipsaving()
		{
			
			shipsaving.click();
		}
		public void aftSavingShp()
		{
			aftSavingShp.click();
		}
	 
		}
	


