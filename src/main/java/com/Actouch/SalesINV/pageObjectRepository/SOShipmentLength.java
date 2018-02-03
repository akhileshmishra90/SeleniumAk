package com.Actouch.SalesINV.pageObjectRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.Actouch.Sales.generic_Lib.Browser;
import com.Actouch.Sales.generic_Lib.WebDriverCommonlib;
public class SOShipmentLength {
	@FindBy(id ="SoIsoId")
	WebElement SOidEdt;
	@FindBy(id ="createSoCustId")
	WebElement SoCustIdEdt;
	@FindBy(xpath="//textarea[@placeholder='Shipping Address']")
	WebElement shippingAddress;
	public void ShipLength(String Cust_id,String shipping_Address) throws InterruptedException
	{
	WebDriverCommonlib.waitForPageToLoad();
	Actions act = new Actions(Browser.driver);
	int kh = 200;
	Thread.sleep(5000);
	SoCustIdEdt.sendKeys(Cust_id);
Thread.sleep(1000);
act.sendKeys(Keys.TAB).perform();
	shippingAddress.clear();
	shippingAddress.sendKeys(shipping_Address);
	String fh = shippingAddress.getAttribute("value");
	int n = fh.length();
	System.out.println(n);
	 Assert.assertTrue(kh>=n, "shipment lenth is less than equal to 200 == fail");
	System.out.println("shipment lenth is less than or equal to 200 == pass");
}
}