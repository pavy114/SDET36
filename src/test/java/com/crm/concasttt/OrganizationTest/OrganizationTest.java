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
import org.testng.annotations.Test;

import com.crm.concasttt.Genericutility.BaseClass;
import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;
import com.crm.concasttt.pomRepository.CreatingNewOrganizationPage;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;
import com.crm.concasttt.pomRepository.OrganizationsPage;

public class OrganizationTest  extends BaseClass {

	@Test  (groups="regression")
	public void createOrganization() throws Throwable
	{
		
		DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		int num = jlib.getRandomNumber();
	


	String Lastname =flib.getDataFromProperty("Lastname");
	String Organization=flib.getDataFromProperty("Organization");
	wlib.waitForElementInDOM(driver);
	
	HomePage hp= new HomePage(driver);
	hp.clickOrganizationModule();
	OrganizationsPage op=new  OrganizationsPage(driver);
	op.createOrganizationimage();
	
	CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
	cnop.createOrganizationWithMandatoryDetailsAndVerify(Organization, num);
	
	hp.signout();
	System.out.println("Inside Organization test1");
	System.out.println("Inside regression Test");
	
	}
	

}


