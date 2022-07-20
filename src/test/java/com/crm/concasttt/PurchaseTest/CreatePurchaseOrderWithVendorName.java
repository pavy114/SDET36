package com.crm.concasttt.PurchaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;
import com.crm.concasttt.pomRepository.LoginPage;

public class CreatePurchaseOrderWithVendorName {
	public static void main(String[] args) throws Throwable {
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		
		
		int num = jlib.getRandomNumber();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		String url = flib.getDataFromProperty("url");
		String username =flib.getDataFromProperty("username");
		String password = flib.getDataFromProperty("password");
		String Lastname =flib.getDataFromProperty("Lastname");
		String Organization=flib.getDataFromProperty("Organization");
		
		
//		driver.get(url);
		
		
		
		wlib.waitForElementInDOM(driver);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();

		
		//POM  Business Library
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(username, password, url); 
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));

		
		wlib.mouseOverOnElement(driver, ele);
		
		driver.findElement(By.name("Purchase Order")).click();
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
		
	}

}
