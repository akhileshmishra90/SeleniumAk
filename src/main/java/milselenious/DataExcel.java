package milselenious;



	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	 
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	 
	public class DataExcel {
	 
	 private Workbook wb;
	 private Sheet sh;
	 public DataExcel(String fileName, String sheetName) {
	  try {
	   if (fileName.indexOf("xlsx") < 0) { 
	    wb = new HSSFWorkbook(new FileInputStream(new File(fileName)));
	    sh = wb.getSheet(sheetName);
	   } else {
	    wb = new XSSFWorkbook(fileName);
	    sh = (XSSFSheet) wb.getSheet(sheetName);
	   }
	  } catch (IOException io) {
	   System.err.println("Invalid file '" + fileName
	     + "' or incorrect sheet '" + sheetName
	     + "', enter a valid one");
	  }
	 }
	 
	
	 public String getCell(int rowIndex, int columnIndex) {
	  Cell cell = null;
	  try {
	    cell = sh.getRow(rowIndex).getCell(columnIndex);
	  } catch (Exception e) {
	   System.err.println("The cell with row '" + rowIndex + "' and column '"
	     + columnIndex + "' doesn't exist in the sheet");
	  }
	  return new DataFormatter().formatCellValue(cell);
	 }
	}


