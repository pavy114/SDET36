package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadAllrowFromExcelTest {

	
	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis = new FileInputStream("./Testdata/Exceldata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Fruits");
		int count = sh.getLastRowNum();
		
		for(int i=0;i<count;i++)
		{
			Row row= sh.getRow(i);
			String firstvalue=row.getCell(0).getStringCellValue();
			//String secondvalue= 
			
		}
		
	}
	
	
}
