package milselenious;

import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.Test;
	public class DataDrivenTest extends DataProvide {
			WebDriver dr;
			@Test(priority=1)
			public void Urlconfig()
			{
				
				System.setProperty("webdriver.gecko.driver","C:\\Users\\Akhilesh\\Downloads\\geckodriver.exe" );
				dr = new FirefoxDriver();
				
			}
		@Test(dataProvider = "getLoginDataForAllRoles",priority=2)
		
			public void Login(String username, String password) throws InterruptedException
			{
				
				dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			dr.get("http://178.162.192.70:8080/AcTouchWeb");
				
				System.out.println("AcTouch application successfully opened.");
					dr.manage().window().maximize();
				dr.findElement(By.id("email")).sendKeys(username);//
			dr.findElement(By.name("j_password")).sendKeys(password);
	dr.findElement(By.xpath("//button[text()='Sign in']")).click();
			System.out.println("TC-1:Login event Run successfully.");
			Thread.sleep(7000);
			dr.findElement(By.id("profileName")).click();
		Thread.sleep(7000);
		dr.findElement(By.xpath("//a[@onclick='return logout();']")).click();

		System.out.println("TC-2:Logout event Run successfully.");
		System.out.println("Test Case is execute successfully");
				System.out.println("you have provided username as::"+username);
				System.out.println("you have provided password as::"+password);
				
			}

		@Test(priority=2)
		public void pala()
		{
			
		}
}
	

