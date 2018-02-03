package com.Actouch.SalesSRV.TestScript;

	import java.util.regex.Pattern;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import static org.testng.Assert.*;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class Login {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.co.in/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testLogin() throws Exception {
	    driver.get(baseUrl + "/search?num=100&hl=en&dcr=0&source=hp&q=actouch+login&oq=actou&gs_l=psy-ab.3.2.0l4.1444.3746.0.6803.5.5.0.0.0.0.240.852.0j2j2.4.0....0...1.1.64.psy-ab..1.4.850...46j0i46k1j0i131k1.0.fnb6NAaRYEg");
	    driver.findElement(By.linkText("Login")).click();
	    driver.findElement(By.name("j_password")).clear();
	    driver.findElement(By.name("j_password")).sendKeys("akhilesh");
	    driver.findElement(By.id("email")).clear();
	    driver.findElement(By.id("email")).sendKeys("amdummy46@gmail.com");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    driver.findElement(By.id("profileName")).click();
	    driver.findElement(By.linkText("Logout")).click();
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


