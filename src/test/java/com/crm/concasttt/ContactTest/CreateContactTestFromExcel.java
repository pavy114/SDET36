package com.crm.concasttt.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
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
import com.crm.concasttt.pomRepository.ContactInformationPage;
import com.crm.concasttt.pomRepository.ContactsPage;
import com.crm.concasttt.pomRepository.CreatingNewContact;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;

public class CreateContactTestFromExcel {
	public static void main(String[] args) throws Throwable {
//		FileInputStream fis= new FileInputStream("./Testdata/Exceldata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Vtiger");
//		Row row1 = sh.getRow(0);
//		Cell c1 = row1.getCell(1);
//		String url = c1.getStringCellValue();
		
		
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		
		String url=elib.getDataFromExcel("Vtiger", 0, 1);
	
//		Row row2 = sh.getRow(1);
//		Cell c2 = row2.getCell(1);
//		String username = c2.getStringCellValue();
//		
		String username = elib.getDataFromExcel("Vtiger", 1, 1);
		
		
//		Row row3 = sh.getRow(2);
//		Cell c3 = row3.getCell(1);
//		String password = c3.getStringCellValue();
		
		
		String password =elib.getDataFromExcel("Vtiger", 2, 1);
		
//		Row row4 = sh.getRow(3);
//		Cell c4 = row4.getCell(1);
//		String Lastname = c4.getStringCellValue();
//		
		String Lastname =elib.getDataFromExcel("Vtiger", 3, 1);
		
//		Row row5 = sh.getRow(4);
//		Cell c5 = row1.getCell(1);
//		String Organization = c5.getStringCellValue();
//		
		String Organization =elib.getDataFromExcel("Vtiger", 4, 1);
		
		//WebDriver driver= new ChromeDriver();
		
		//driver.get(url);
		
//		Random ran= new Random();
//		int num=ran.nextInt(1000);
		
		int num = jlib.getRandomNumber();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	
	
//	driver.get(url);
//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	//POM  Business Library
		 LoginPage lp= new LoginPage(driver);
			lp.LoginToApp(username, password, url); 
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).click();
	//driver.findElement(By.linkText("Contacts")).click();
			
			
	// Create Contact Business library
			HomePage hp=new HomePage (driver);
			hp.clickContactModule();
			
	//driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			ContactsPage cp= new ContactsPage(driver);
			cp.clickcontactlnk();
//	driver.findElement(By.name("lastname")).sendKeys(Lastname+num);
//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
			CreatingNewContact cnc = new CreatingNewContact(driver);
			cnc.createContactWithMandatoryDetails(Lastname, num);
			
			
			
			//
//	String actual = driver.findElement(By.className("dvHeaderText")).getText();
//	String Expected = Lastname;
//	
//	if(actual.contains(Expected))
//	{
//		System.out.println(" Lastname is inserted Successfully");
//	}
//	else
//	{
//		System.out.println("Failed");
//	}
			
			ContactInformationPage cip= new ContactInformationPage(driver);
			cip.verifycontactcreated(Lastname);
	
	//WebElement dd = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
//	Actions a= new Actions(driver);
//	a.moveToElement(dd).perform();
	
//	wlib.mouseOverOnElement(driver, dd);
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	hp.signout();
	
	}
		
		
	}


