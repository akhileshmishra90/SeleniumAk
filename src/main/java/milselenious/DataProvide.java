package milselenious;

import java.util.ArrayList;

import org.testng.annotations.DataProvider;

public class DataProvide {

	@DataProvider  //(name = "loginToAppWithAllRoles")
	public Object[][] getLoginDataForAllRoles() throws Exception{
		DataExcel userData = new DataExcel("D:\\ServerCode\\Purchase Order.xlsx", "PO");
		 
	 
	 ArrayList<Object[]> dataList = new ArrayList<Object[]>();
	 
	 int i = 3;// excluding header row
	int totalRows = 8;

	// int slno = 2;
	 while (i < totalRows) {
	
		 Object[] dataLine = new Object[2];
	  dataLine[0] = userData.getCell(i, 3);
	  dataLine[1] = userData.getCell(i, 4);
	  
	//  slno = 4;
	 /* dataLine[2] = userData.getCell(i, 2);
	  dataLine[3] = userData.getCell(i, 3);*/
	 
	  dataList.add(dataLine);
	
	 
	  i++;
	 }
	 
	 Object[][] data = new Object[dataList.size()][];
	 for (i = 0; i < dataList.size(); i++)
	  data[i] = (Object[]) dataList.get(i);
	 
	 return data;
	}
	
	}


