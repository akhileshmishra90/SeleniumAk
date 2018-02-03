package com.Actouch.DirectReceiptServ.pageObjectRepository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.Actouch.Purchase.generic_Lib.Browser;
import com.Actouch.Purchase.generic_Lib.Constant;

public class DRSPayLtr {
	public static String Exp;
	public static String Amt;
	private Connection connection;
	private static Statement statement;
	   private static ResultSet rs;
 public static String Supp_ID;
 public static BigDecimal TOTAL_AMT;
 
	@FindBy(xpath="//label[text()='Order Type']/following-sibling::div/button")
	WebElement drsERv;
	@FindBy(linkText="Service")
	WebElement seLServ;
	@FindBy(id="poId")
	WebElement POREdt;
	@FindBy(id="poServSuppList")
	WebElement SuppEdt;
	@FindBy(xpath="//textarea[@data-bind='value: prdDesc']")
	WebElement DescEdt;
	@FindBy(xpath="//input[@data-bind='selectcontrolExpenseAcPOSInput:prdId']")
	WebElement CategoryEdt;
	@FindBy(id="POSunitprice")
	WebElement  SerPriceEdt;
	@FindBy(xpath="//label[@data-bind='html: DIService.netAmt']")
	WebElement TotalEdt;
	@FindBy(id="btnSave")
	WebElement Save;
	@FindBy(xpath="html/body/div[9]/div/div[3]/button")
	WebElement aftrSave;
	@FindBy(xpath="//input[@aria-controls='POR_Table']")
	WebElement SercPOR;
	@FindBy(xpath=".//*[@id='POR_Table']/tbody/tr/td[3]")
	WebElement Result;
	public void payltr(String SuppID,String Desc,String Category,String SerPrice) throws InterruptedException, ClassNotFoundException, SQLException
	{
		WebDriverWait wait = new WebDriverWait(Browser.driver, 20);
		Actions act = new Actions(Browser.driver);
		wait.until(ExpectedConditions.visibilityOf(drsERv));
		Thread.sleep(3000);
		act.moveToElement(drsERv).click().perform();
		wait.until(ExpectedConditions.visibilityOf(seLServ));
		act.moveToElement(seLServ).click().perform();
		Exp = POREdt.getAttribute("value");
		wait.until(ExpectedConditions.visibilityOf(SuppEdt));
		SuppEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),SuppID);
		Thread.sleep(2000);
		act.sendKeys(Keys.TAB).perform();
		wait.until(ExpectedConditions.visibilityOf(DescEdt));
		DescEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Desc);
		CategoryEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),Category);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		SerPriceEdt.sendKeys(Keys.chord(Keys.CONTROL,"a"),SerPrice);
		act.sendKeys(Keys.ENTER).perform();
		Amt=TotalEdt.getText();
		Save.click();
		aftrSave.click();
		 Browser.driver.get(Constant.PorMain);
		 wait.until(ExpectedConditions.visibilityOf(SercPOR));
		 SercPOR.sendKeys(Exp);
		 String Actual = Result.getText();
		 Assert.assertEquals(Actual, Exp,"POR ID not created");
	}
		public void payltrDB(String databaseURL,String user,String password,String query,String Supp_IiD, String Total) throws ClassNotFoundException, SQLException
		{
		 Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Connecting to Database...");
         connection = DriverManager.getConnection(databaseURL, user, password);
         if (connection != null) {
             System.out.println("Connected to the Database...");
         }
     statement = connection.createStatement();
     rs = statement.executeQuery(query);

     while(rs.next()){
         
     	Supp_ID =rs.getString(Supp_IiD) ;
        TOTAL_AMT = rs.getBigDecimal(Total);
     	}
     connection.close();
	
	
	
	
}
}
