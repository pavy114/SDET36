package practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CreatePurchaseOrderWithVendorNameTest {
	public static void main(String[] args) throws Throwable {
		
		
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		FileInputStream fis=new FileInputStream("./Testdata/commondata.properties");
		Properties pro=new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		
		
		FileInputStream fisi=new FileInputStream("./Testdata/Exceldata.xlsx");
		Workbook wb=WorkbookFactory.create(fisi);
		Sheet sh = wb.getSheet("Vtiger");
		Row prow = sh.getRow(6);
		Cell cell = prow.getCell(1);
		String Product = cell.getStringCellValue();
		
		
	
		
		

		Random ran= new Random();
		int num=ran.nextInt(1000);
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
	
	
	
	WebElement ad = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	
	Actions a= new Actions(driver);
	a.moveToElement(ad).perform();
	//driver.findElement(By.xpath("(//a[text()='Vendors'])[1]")).click();
	
	driver.findElement(By.name("Vendors")).click();
	driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
	
	Row vendornamerow = sh.getRow(10);
	Cell  vendornamecell = vendornamerow.getCell(1);
	String vendorname = vendornamecell.getStringCellValue();
	driver.findElement(By.name("vendorname")).sendKeys(vendorname+num);
	
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
	
	WebElement dd = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	
		Actions a1= new Actions(driver);
		a1.moveToElement(dd).perform();
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		
		Row subjectrow = sh.getRow(10);
		Cell  subjectcell = subjectrow.getCell(1);
		String subject = subjectcell.getStringCellValue();
		driver.findElement(By.name("subject")).sendKeys(subject+num);	
		driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		
		Row vendorchildtitlerow = sh.getRow(15);
		Cell  vendorchildtitlecell = vendorchildtitlerow.getCell(1);
		String vendorchildtitle = vendorchildtitlecell.getStringCellValue();
		
		
//		while(it.hasNext())
//		{
//			String currenttitle = it.next();
//			if(currenttitle.contains(vendorchildtitle))
//			{
//				break;
//			}
//			
//			
//		}
//		System.out.println("Before Execution");
//		
		wlib.swithToWindow(driver, vendorchildtitle);
		//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(vendorname+num);
		driver.findElement(By.className("txtBox")).sendKeys(vendorname+num);
		System.out.println("After Execution");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.id("1")).click();
		
		//Going back to Parentwindow
		
		Row purchaseoparenttitlerow = sh.getRow(14);
		Cell  purchaseoparenttitlecell = purchaseoparenttitlerow.getCell(1);
		String purchaseoparenttitle = purchaseoparenttitlecell.getStringCellValue();
		
		
		
		while(it.hasNext())
		{
			String currenttitle1 = it.next();
			if(currenttitle1.contains(purchaseoparenttitle))
			{
				break;
			}
			
			
		}
		
		
		Row billingaddrow = sh.getRow(12);
		Cell  billingaddcell = billingaddrow.getCell(1);
		String billingadd = billingaddcell.getStringCellValue();
		
		
		driver.findElement(By.name("bill_street")).sendKeys(billingadd+num);
		
		
		
		Row shipaddrow = sh.getRow(13);
		Cell  shipaddcell = shipaddrow.getCell(1);
		String shipadd = shipaddcell.getStringCellValue();
		
		
		driver.findElement(By.name("ship_street")).sendKeys(shipadd+num);
		
		driver.findElement(By.id("searchIcon1")).click();
		
		Set<String> ids2 = driver.getWindowHandles();
		Iterator<String> its = ids2.iterator();
		
		Row productchildtrow = sh.getRow(7);
		Cell  productchildtcell = productchildtrow.getCell(1);
		String productchildt = productchildtcell.getStringCellValue();
		
		while(its.hasNext())
		{
			String currenttitle2 = its.next();
			
			if(currenttitle2.contains(productchildt+num))
			{
				break;
			}
		}
		
		Row productrow = sh.getRow(6);
		Cell  productcell = productrow.getCell(1);
		String product = productcell.getStringCellValue();
		
		driver.findElement(By.id("search_txt")).sendKeys(product+num);
		driver.findElement(By.name("search"));
		driver.findElement(By.id("popup_product_32"));
		
		//Going back to its parent
		while(its.hasNext())
		{
			String currenttitle3 = its.next();
			
			if(currenttitle3.contains(purchaseoparenttitle))
			{
				break;
			}
		}
		
		driver.findElement(By.xpath("((//input[@title='Save [Alt+S]'])[2]")).click();
		driver.findElement(By.id("qty1")).sendKeys("1");
		
		
	}

}
