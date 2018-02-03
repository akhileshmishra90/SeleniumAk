package milselenious;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SeleniumDataBaseTesting {

		   private Connection connection;
		   private static Statement statement;
		   private static ResultSet rs;
           public static String CUST_ID;
           public static String CUST_Name; 
           public static Double TOTAL_AMT;
           public static Double Total_Tax;
           
		 public void getEmployeesFromDataBase(String query,String Column1, String Column2,String Total,String TotalTax, String databaseURL,String user,String password ) throws SQLException, ClassNotFoundException {
            connection = null;
		    // List<String> colList = new ArrayList<String>();
		                Class.forName("com.mysql.jdbc.Driver");
		                System.out.println("Connecting to Database...");
		                connection = DriverManager.getConnection(databaseURL, user, password);
		                if (connection != null) {
		                    System.out.println("Connected to the Database...");
		                }
		            statement = connection.createStatement();
		            rs = statement.executeQuery(query);

		            while(rs.next()){
		                 //EmpDept=rs.getArray(Column);
		            	//String col=  colList.add(rs.getString(Column));
		            	CUST_ID =rs.getString(Column1) ;
		            	CUST_Name = rs.getString(Column2);
		            	TOTAL_AMT = rs.getDouble(Total);
		            	Total_Tax = rs.getDouble(TotalTax);
		            //for(String col : colList){
		            	//System.out.println(col);
		     System.out.println(CUST_ID );
		     System.out.println(CUST_Name );
		     System.out.println(TOTAL_AMT );
		     System.out.println(Total_Tax );
		            	// }
		            	}
		            connection.close();
		    }
		   
}

