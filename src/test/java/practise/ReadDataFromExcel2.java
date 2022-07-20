package practise;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {
	public static void main(String[] args) throws Throwable {
		
		
		FileInputStream fis= new FileInputStream("./Testdata/Exceldata.xlsx");
		
		
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Fruits");
		
		int count = sh.getLastRowNum();
		
		for(int i=0; i<=count;i++)
		{
			
			
			
			Row row=sh.getRow(i);
			
			String firstvalue = row.getCell(0).getStringCellValue();
			String secondvalue = row.getCell(1).getStringCellValue();
			
			System.out.println(firstvalue+"\t" +secondvalue);
			
			
			
			//Row r=sh.getRow(i);
			//Cell c = r.getCell(0);
			//String value1 = c.getStringCellValue();
			//System.out.println(value1);
			
			
			
			//Cell c1 = r.getCell(1);
				//	String value2 = c1.getStringCellValue();
				//System.out.println(value2);
			

		}
	}

}
//Sheet sh = book.getSheet("Sheet1");
//Row r = sh.getRow(1);
//Cell c = r.getCell(0);
//String value = c.getStringCellValue();
//System.out.println(value);
