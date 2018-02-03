package milselenious;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class check {
	@Test
	public void heck()
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("https://apps.actouch.com/AcTouchWeb");
	}

}
