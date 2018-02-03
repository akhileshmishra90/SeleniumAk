package milselenious;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class RunDB {
public WebDriver driver;
@Test
public void Run() throws ClassNotFoundException, SQLException
{
	SeleniumDataBaseTesting DT =PageFactory.initElements(driver, SeleniumDataBaseTesting.class);
	DT.getEmployeesFromDataBase("select * from actouch.so_mstr where  ENTITY_ID = 399807654 and SO_ID ='SO_99'","CUST_ID","CUST_NAME","TOTAL_AMT","TOTAL_TAX","jdbc:mysql://178.162.192.70:3306/", "actouchuser", "actouchuser");
 

}

}
