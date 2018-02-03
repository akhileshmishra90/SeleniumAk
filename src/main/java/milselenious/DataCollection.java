package milselenious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

public class DataCollection {
	public  static void main(String args[]){

//	 @DataProvider(name = "loginToAppWithAllRoles")
//	 public Object[][] getLoginDataForAllRoles() throws Exception {
//	 
	 DataExcel userData = new DataExcel("D:\\sele\\src\\generic\\Book2.xlsx", "Sheet1");
	  
	 // ArrayList<Object> dataList = new ArrayList<Object>();
	 
	  int i = 3;
	  int totalRows = 39;
	  Set<String> testIdList = new HashSet<String>();
	  List<String[]> fullTestList = new ArrayList<String[]>();
       HashMap<String, List<String[]>> map = new HashMap<String, List<String[]>>();
	  
       while (i < totalRows) {
// Object[] dataLine = new Object[1];
	  int colNum = 10;

	   String arr[] = new String[colNum];
	   
	   for(int ij=0; ij<colNum; ij++){
		   //arr.add(userData.getCell(i, ij));
		   if(userData.getCell(i, 0)==null){
			   break;
		   }
		   arr[ij] = userData.getCell(i, ij);
}
	   
	   fullTestList.add(arr);
	   
	   testIdList.add(userData.getCell(i, 1));
	 for(String testId : testIdList){
	 List<String[]> valTestList = new ArrayList<String[]>();
		   for(String[] strArr : fullTestList){
			   if(strArr[1].equals(testId)){
				   valTestList.add(strArr);
			   }
		   }
		   map.put(testId, valTestList);
	   }
	   
	  
	   
	//   dataList.add(dataLine);
	 
	   i++;
	  }
	  
	  for(Map.Entry<String, List<String[]>> entry : map.entrySet()){
		   System.out.println("Key : "+entry.getKey() + "Value : "+entry.getValue());
	   }
	  
	  for(String testId : testIdList){
		  System.out.println("Test Id : "+testId);
	  }
	
	  
	  //4thdPart
//	//  Object[][] data = new Object[dataList.size()][];
//	  for (i = 0; i < dataList.size(); i++)
//	   data[i] = (Object[]) dataList.get(i);
	 
	 // return data;
	 }
	
//	 @Test(dataProvider = "loginToAppWithAllRoles", description = "Login with different roles")
//	 public void testLogin(String userID) {
//	 
//	 
//	  System.out.println("userID:" + userID);
	  
	 
	 
}

//}
