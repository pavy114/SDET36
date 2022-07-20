package com.crm.concasttt.CompaignTest;

import java.io.FileInputStream;
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
import com.crm.concasttt.pomRepository.CampaignsPage;
import com.crm.concasttt.pomRepository.CreatingNewCampaignPage;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;

public class CreateCompaignTest {
	public static void main(String[] args) throws Throwable {
		
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		
	
	
//	FileInputStream fis=new FileInputStream("./Testdata/commondata.properties");
//	Properties pro=new Properties();
//	pro.load(fis);
//	String url = pro.getProperty("url");
//	String username = pro.getProperty("username");
//	String password = pro.getProperty("password");
//    String Campaign = pro.getProperty("Campaign");
    
		
		
		String url = flib.getDataFromProperty("url");
		String username = flib.getDataFromProperty("username");
		String password = flib.getDataFromProperty("password");
		 String campaign = flib.getDataFromProperty("Campaign");
//		
//    Random ran= new Random();
//	int num=ran.nextInt(1000);
		 
		int num = jlib.getRandomNumber();
WebDriver driver= new ChromeDriver();
driver.manage().window().maximize();
//driver.get(Url);

//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

wlib.waitForElementInDOM(driver);
//driver.findElement(By.name("user_name")).sendKeys(Username);
//driver.findElement(By.name("user_password")).sendKeys(Password);
//driver.findElement(By.id("submitButton")).click();

//POM  Business Library
	 LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(username, password, url); 
		
		HomePage hp=new HomePage(driver);
		hp.createCampaign();
		
		CampaignsPage cp= new CampaignsPage(driver);
		cp.clickcreatecampaign();
//WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));

//Actions a1= new Actions(driver);
//
//a1.moveToElement(ele).perform();
//wlib.mouseOverOnElement(driver, ele);
//driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(campaign+num);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//
//WebElement result = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
//
//
//
//
//String actual = result.getText();
//
//String Expected = campaign+num;
//
//if(actual.contains(Expected))
//{
//System.out.println("Campaign is created successfully");	
//}
//else {
//	System.out.println("Failed");
//
//}
//	
		
		
		
		CreatingNewCampaignPage cncp = new CreatingNewCampaignPage(driver);
		cncp.createCampaignWithMandatoryDetails(campaign, num);
	
//WebElement dd = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
//	Actions a2= new Actions(driver);
//	a2.moveToElement(dd).perform();
//
//wlib.mouseOverOnElement(driver, dd);
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//	
		
		
hp.signout();
}
}