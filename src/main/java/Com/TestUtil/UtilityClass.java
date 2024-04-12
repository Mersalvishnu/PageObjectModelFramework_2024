package Com.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class UtilityClass {
	
	public static long PageloadTimeout =20;
    public static long implicit_wait =25;
    static Xls_Reader reader;
    
    /*
    public static String TestData_SHEET_PATH ="C:/Users/vishn/eclipse-workspace/TSRTCBookingTest/src/main/java/Com/TestData/EnquiryPage.xlsx";
    
    static Workbook book;
    static Sheet sheet;
     
     
    public static Object[][] getTestData(String SheetName) throws InvalidFormatException{
    FileInputStream file =null;
    try{
    file =new FileInputStream(TestData_SHEET_PATH);
    }catch(FileNotFoundException e){
    e.printStackTrace();
    }
    try{
    book =WorkbookFactory.create(file);
    }catch(IOException e){
    e.printStackTrace();
    }
    sheet=book.getSheet(SheetName);
     
    Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
     
    for(int i=0;i<sheet.getLastRowNum();i++){
    for(int k=0;k<sheet.getRow(0).getLastCellNum();k++){
    data[i][k]=sheet.getRow(i +1).getCell(k).toString();
    }
     
    }
     
     
   return data;
     
     
     
     
     
     
     
    }
    */
    
    
      public static  ArrayList<Object[]>  getDataFromExcel() {
		
		ArrayList<Object[]> list =new ArrayList<Object[]>();
		
		try {
			 reader =new Xls_Reader("C:/Users/vishn/eclipse-workspace/TSRTCBookingTest/src/main/java/Com/TestData/EnquiryPage.xlsx");			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
            for(int Rownum=2;Rownum<=reader.getRowCount("EnquiryData");Rownum++) {
			
			String TKTNumber=reader.getCellData("EnquiryData","TKTNumber", Rownum);	
			String MNO =reader.getCellData("EnquiryData","MNO", Rownum);			
						
				
			
			
			Object ob[]= {TKTNumber,MNO};
			list.add(ob);
			
		}
		
		
		return list;
	}

    
    
    
    
    
    
    
    
    
    
}
