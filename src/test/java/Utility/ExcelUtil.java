package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public  static String xlfile="C:\\Users\\CHANDAN KUMAR\\OneDrive\\Desktop\\Automation\\AssessmentTask\\Testdata\\Book1.xlsx";
	public static String xlsheet="Sheet1";
	
	public static String getcelldata(int Row,int Col) throws Exception {
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(Row);
		cell=row.getCell(Col);
	
		String data="";
		try {
			data=cell.toString();
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fi.close();
		return data;
	}
	public static void writeDropdownDataToExcel(int Row,int Col,List<String> stations) throws Exception {
		fi=new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(Row);
	//	cell=row.createCell(Col);
		 for (String station : stations) {
			 
			 cell= row.createCell(Col++);
	            cell.setCellValue(station);
	            
	        }
		 fo= new FileOutputStream(xlfile);
		 wb.write(fo);
		 fi.close();
		 fo.close();
		
	}
	
}
