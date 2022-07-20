package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDatafromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./Testdata/Exceldata.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("Sheet1");
		Row r = sh.getRow(1);
		Cell c = r.getCell(0);
		String value = c.getStringCellValue();
		System.out.println(value);
		
	Row r1 = sh.getRow(3);
	Cell c1 = r1.getCell(1);
	String value1 = c1.getStringCellValue();
	
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	driver.get(value1);

	Row r2 = sh.getRow(4);
	Cell c2 = r2.getCell(1);
	String value2 = c2.getStringCellValue();
	driver.findElement(By.name("user_name")).sendKeys(value2);
	
	//
	Row r3 = sh.getRow(5);
	Cell c3 = r3.getCell(1);
	String value3 = c3.getStringCellValue();
	driver.findElement(By.name("user_password")).sendKeys(value3);
		
	
	
	 driver.findElement(By.id("submitButton")).click();
	
	
	 Thread.sleep(5000);
	 driver.close();

	}

}
