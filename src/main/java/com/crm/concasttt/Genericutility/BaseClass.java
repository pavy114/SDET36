package com.crm.concasttt.Genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;

public class BaseClass  {

	/**
	 * It contains all the BaseClass components
	 * @author Pavithra
	 */
public  WebDriver driver;
public static WebDriver sdriver;
	DatabaseUtility dlib= new DatabaseUtility();
	ExcelUtility elib = new ExcelUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	//WebDriver driver=null;
	
	@BeforeSuite // (groups="smoke")
	public void configBs()
	{
		System.out.println("===========Before TestSuite==============");
		System.out.println("===============Connect to DB==========");
	}
	
	//@Parameters("browser")
	@BeforeClass //(groups="smoke")
	public void configBC( )//(String browser)
	{
		
//		if(browser.equals("chrome"))
//		{
//			driver= new ChromeDriver();
//		}
//		else if(browser.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else
//		{
			driver= new ChromeDriver();
		//}
		System.out.println("============Before Class============");
		System.out.println("===============Lauch the Browser=======");
		
		sdriver=driver;
		wlib.waitForElementInDOM(driver);
		driver.manage().window().maximize();
	}
	
	
	@BeforeMethod //(groups="smoke")
	public void configBM() throws Throwable
	{
		/* Common data*/
		System.out.println("Before Method");
		String USERNAME = flib.getDataFromProperty("username");
		String PASSWORD = flib.getDataFromProperty("password");
		String URL = flib.getDataFromProperty("url");
	
		
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD, URL);
	}
	
	@AfterMethod //(groups="smoke")
	public void configAM()
	{
		/* Logout */
		System.out.println("============After Method========");
		HomePage hp= new HomePage(driver);
		hp.signout();
	}
	@AfterClass //(groups="smoke")
	public void configAC()
	{
		System.out.println("==========After Class=========");
		driver.quit();
	}
	
	@AfterSuite //(groups="smoke")
	public void configAS()
	{
		System.out.println("===========After Test suite=============");
		System.out.println("===============close the DB================");
	}
}
