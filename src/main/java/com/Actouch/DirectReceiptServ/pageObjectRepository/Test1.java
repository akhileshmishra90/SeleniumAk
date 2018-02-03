package com.Actouch.DirectReceiptServ.pageObjectRepository;


import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Test1 {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://178.162.192.40:8080/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void test() throws Exception {
	    driver.get(baseUrl + "/AcTouchWeb/login.jsp?logout");
	    driver.findElement(By.name("j_password")).clear();
	    driver.findElement(By.name("j_password")).sendKeys("akhilesh");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("amdummy46@gmail.com");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.xpath("//div[@id='formString']/div/div/a/div/div/div/div/div[2]")).click();
	    driver.findElement(By.cssSelector("div.panel-heading > div.row")).click();
	    driver.findElement(By.id("createSoCustId-btn")).click();
	    driver.findElement(By.id("ui-id-75")).click();
	    driver.findElement(By.id("c9fd3730-7642-4a2b-88ab-7db982af3a8d-btn")).click();
	    driver.findElement(By.id("ui-id-100")).click();
	    driver.findElement(By.cssSelector("span.label.label-warning")).click();
	    driver.findElement(By.cssSelector("td.col-xs-1 > input[type=\"checkbox\"]")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[176]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[176]")).sendKeys("1.000");
	    driver.findElement(By.cssSelector("div.messageBox > div.modal-footer > button.btn.btn-primary")).click();
	    driver.findElement(By.id("unitprice_1")).clear();
	    driver.findElement(By.id("unitprice_1")).sendKeys("100.00");
	    driver.findElement(By.cssSelector("span.label.label-warning")).click();
	    driver.findElement(By.id("chkTaxId")).click();
	    driver.findElement(By.cssSelector("div.messageBox > div.modal-footer > button.btn.btn-primary")).click();
	    driver.findElement(By.id("btnSave")).click();
	    driver.findElement(By.xpath("//div[9]/div/div[3]/button")).click();
	    driver.findElement(By.linkText("Sales Order")).click();
	    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).clear();
	    driver.findElement(By.cssSelector("label > input[type=\"text\"]")).sendKeys("SO113");
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	}

