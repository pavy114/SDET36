package com.crm.concasttt.ContactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateContactTest {

	//private static WebElement ele;

	public static void main(String[] args) throws Throwable {

		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		
		//		Random ran= new Random();
//		int num=ran.nextInt(1000);
		
		int num = jlib.getRandomNumber();
		
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
//	FileInputStream fis = new FileInputStream("./Testdata/commondata.properties");
//	Properties pro= new Properties();
//	pro.load(fis);
//	String url = pro.getProperty("url");
//	String username = pro.getProperty("username");
//	String password = pro.getProperty("password");
//	String Lastname = pro.getProperty("Lastname");
	 String url = flib.getDataFromProperty("url");
	
	 String username = flib.getDataFromProperty("username");
	 String password = flib.getDataFromProperty("password");
	 String Lastname = flib.getDataFromProperty("Lastname");
	 
	 
//	driver.get(url);
//	wlib.waitForElementInDOM(driver);
	 
	 
	 
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).click();
	 
	 
	//POM  Business Library
	 LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(username, password, url); 

	 
	
	
		HomePage hp=new HomePage (driver);
		hp.clickContactModule();
	 
	//driver.findElement(By.linkText("Contacts")).click();
	//driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	
		System.out.println("Before clicking create contact");
		ContactsPage cp=new ContactsPage(driver);
		cp.clickcontactlnk();
		
		System.out.println("After clicking create contact");
		//clickcontactlnk
		
		
//	driver.findElement(By.name("lastname")).sendKeys(Lastname+num);
//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"][1]")).click();
		
		CreatingNewContact cnc= new CreatingNewContact(driver);
		cnc.createContactWithMandatoryDetails(Lastname, num);
		
//	String actual = driver.findElement(By.className("dvHeaderText")).getText();
	
	
	//driver.findElement(By.xpath("//input[@value='Delete']")).click();
	
	ContactInformationPage cip= new ContactInformationPage(driver);
	cip.deletecontact();
	System.out.println("Contact Deleted");
//	Alert a1= driver.switchTo().alert();
//	a1.accept();
	
//	wlib.swithToAlertWindowAndAccpectOnly(driver);
	//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(Lastname+num);
	//WebElement element = driver.findElement(By.xpath("//select[@name='search_field']"));
	
	
	
	
//	Select s = new Select(element);
//	
//	s.selectByValue("lastname");
	
//	wlib.select(element,"lastname" );
//	driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
	
	
	cp.searchForContacts(Lastname, num );
	//System.out.println("search button clicked");
//	 boolean textt1 = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).isDisplayed();
//	
//	
//	//textt1.isDisplayed();
//	if(textt1==true)
//	{
//		System.out.println("Successfully Deleted");
//
//	else
//		System.out.println("Failed to delete");
	
	
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
	
	
	//cp.verifyDelete();
	//WebElement dd = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
//	Actions a= new Actions(driver);
////	a.moveToElement(dd).perform();
//	wlib.mouseOverOnElement(driver, dd);
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	hp.signout();
	}
	

}

