package com.crm.concasttt.OrganizationTest;







import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.crm.concasttt.pomRepository.CreatingNewOrganizationPage;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;
import com.crm.concasttt.pomRepository.OrganizationsPage;

public class CreateOrganizationTest  {

	public static void main(String[] args) throws Throwable {
		
		
		
		
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
//		Random ran= new Random();
//		int num=1+ran.nextInt(1000);
		
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
//	String Organization=pro.getProperty("Organization");
	String url = flib.getDataFromProperty("url");
	String username =flib.getDataFromProperty("username");
	String password = flib.getDataFromProperty("password");
	String Lastname =flib.getDataFromProperty("Lastname");
	String Organization=flib.getDataFromProperty("Organization");
	
//	
//	driver.get(url);
	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	wlib.waitForElementInDOM(driver);
//	driver.findElement(By.name("user_name")).sendKeys(username);
//	driver.findElement(By.name("user_password")).sendKeys(password);
//	driver.findElement(By.id("submitButton")).click();
	
	//POM  Business Library
	LoginPage lp= new LoginPage(driver);
	lp.LoginToApp(username, password, url); 
	//driver.findElement(By.linkText("Organizations")).click();
	HomePage hp= new HomePage(driver);
	hp.clickOrganizationModule();
	OrganizationsPage op=new  OrganizationsPage(driver);
	op.createOrganizationimage();
	//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//	driver.findElement(By.name("accountname")).sendKeys(Organization+num);
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
//	String actual = driver.findElement(By.className("dvHeaderText")).getText();
//	String Expected = Organization;
//	
//	if(actual.contains(Expected))
//	{
//		System.out.println(" Organization is inserted Successfully");
//	}
//	else
//	{
//		System.out.println("Failed");
//	}
//	
	
	
	
	CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
	cnop.createOrganizationWithMandatoryDetailsAndVerify(Organization, num);
	//WebElement dd = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	
//	Actions a= new Actions(driver);
//	a.moveToElement(dd).perform();
	
//	wlib.mouseOverOnElement(driver, dd);
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	hp.signout();
	
	}
	

}

