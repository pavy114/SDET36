package com.crm.concasttt.CompaignTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;
import com.crm.concasttt.pomRepository.CreatingNewProduct;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;
import com.crm.concasttt.pomRepository.ProductInformationPage;
import com.crm.concasttt.pomRepository.ProductsPage;

public class CreateCampaignWithProductTest {
	public static void main(String[] args) throws Throwable {
		
	DatabaseUtility dlib= new DatabaseUtility();
	ExcelUtility elib = new ExcelUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	
	
	
//		FileInputStream fis = new FileInputStream("./Testdata/commondata.properties");
//		
//		Properties pro=new Properties();
//		pro.load(fis);
//		
//		String value = pro.getProperty("url");
//		System.out.println(value);
//		
	
		
	//}
	
	
//	FileInputStream fis=new FileInputStream("./Testdata/commondata.properties");
//	Properties pro=new Properties();
//	pro.load(fis);
		
//	String url = pro.getProperty("url");
//	String username = pro.getProperty("username");
//	String password = pro.getProperty("password");
//	  String campaign = pro.getProperty("Campaign");
	
	//Url=elib.getDataFromExcel("url");
	// String Url = flib.getDataFromProperty("url");
	String url = flib.getDataFromProperty("url");

	//String Url = flib.getDataFromProperty("url");
	String username = flib.getDataFromProperty("username");
	
	System.out.println(username);
	String password = flib.getDataFromProperty("password");
	
	System.out.println(password);
  String campaign = flib.getDataFromProperty("Campaign");
	
	System.out.println(campaign);
	
//	FileInputStream fisi=new FileInputStream("./Testdata/Exceldata.xlsx");
//	Workbook wb=WorkbookFactory.create(fisi);
//	Sheet sh = wb.getSheet("Vtiger");
//	Row prow = sh.getRow(6);
//	Cell cell = prow.getCell(1);
//	String Product = cell.getStringCellValue();
	
  
  //For getting Product
  String Product = elib.getDataFromExcel("Vtiger", 6, 1);
  
 
  
	// For Getting Title
	
//	Row trow = sh.getRow(7);
//	Cell cell2 = trow.getCell(1);
//	String title = cell2.getStringCellValue();
	
  
  String title = elib.getDataFromExcel("Vtiger", 7, 1);
  
  
	
	//ParentTitle
	
	//Row ptrow = sh.getRow(8);
	//Cell cell3 = ptrow.getCell(1);
	//String ParentTitle = cell3.getStringCellValue();
  String ParentTitle = elib.getDataFromExcel("Vtiger", 8, 1);
  
  
  //for Javautility
  int num=jlib.getRandomNumber();
//	Random ran= new Random();
//	int num=ran.nextInt(1000);
  
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();

System.out.println("Be");




////driver.get(Url);
//driver.get("http://localhost:8888/");
//
//System.out.println("Ae");
//
////driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//wlib.waitForElementInDOM(driver);
//
//
//driver.findElement(By.name("user_name")).sendKeys(username);
//driver.findElement(By.name("user_password")).sendKeys(password);
//driver.findElement(By.id("submitButton")).click();



LoginPage lp= new LoginPage(driver);
lp.LoginToApp(username, password, url);


//driver.findElement(By.xpath("//a[text()='Products']")).click();
HomePage pg= new HomePage(driver);
pg.clickproductmodule();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

ProductsPage pp = new ProductsPage(driver);
pp.clickProductsLink();

//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product+num);
//.sendKeys(Product+num);
//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

CreatingNewProduct cnp= new CreatingNewProduct(driver);
cnp.createProduct(Product, num);


ProductInformationPage pip= new ProductInformationPage(driver);
WebElement more = pip.getMore();
wlib.mouseOverOnElement(driver, more);

pip.getCampaignmodule().click();
//////
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
//Actions a1= new Actions(driver);
//
//a1.moveToElement(ele).perform();
//wlib.mouseOverOnElement(driver, ele);
//mouseOverOnElement(WebDriver driver , WebElement elemnet);

//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();

////////////////
driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign+num);

driver.findElement(By.xpath("//img[@title='Select']")).click();
//Set<String> ids = driver.getWindowHandles();
//Iterator<String> it = ids.iterator();
//
//
//while(it.hasNext())
//{
//	String wid = it.next();
//	driver.switchTo().window(wid);
//	String currenttitle = driver.getTitle();
//	if(currenttitle.contains(title))
//	{
//		break;
//	}
//	
//}

wlib.swithToWindow(driver, title);

driver.findElement(By.id("search_txt")).sendKeys(Product+num);
driver.findElement(By.className("small")).click();
driver.close();

////Set<String> idparent = driver.getWindowHandles();
//Iterator<String> itt = ids.iterator();
//System.out.println("Success3");


//ParentWindowTitle
//Row ptrow = sh.getRow(8);
//Cell cell3 = ptrow.getCell(1);

String ParenttTitle=elib.getDataFromExcel("Vtiger", 8, 1);

//String ParentTitle = cell3.getStringCellValue();

//	while(itt.hasNext())
//	{
//		String pwid = itt.next();
//		
//		//ParentTitle
//		driver.switchTo().window(pwid);
//		String currenttitle2 = driver.getTitle();
//		if(currenttitle2.contains(ParentTitle))
//			//
//		{
//			break;
//		}
//	}
	

wlib.swithToWindow(driver, ParenttTitle);

	System.out.println("Success2");
	String titlecurrent = driver.getTitle();
	System.out.println(titlecurrent);
	
WebElement d1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
//WebElement d1 = driver.findElement(By.xpath("//img[@src=themes/softed/images/user.PNG]"));
//System.out.println("Success9");
//	
//	//Actions a2= new Actions(driver);
//	
//	a1.moveToElement(d1).perform();

wlib.mouseOverOnElement(driver, d1);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	System.out.println("Success1");
	
		
}
}
