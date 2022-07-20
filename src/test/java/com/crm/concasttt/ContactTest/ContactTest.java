package com.crm.concasttt.ContactTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.concasttt.Genericutility.BaseClass;
import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;
import com.crm.concasttt.pomRepository.ContactInformationPage;
import com.crm.concasttt.pomRepository.ContactsPage;
import com.crm.concasttt.pomRepository.CreatingNewContact;
import com.crm.concasttt.pomRepository.HomePage;
@Listeners(com.crm.concasttt.Genericutility.ListenerImplementation.class)
public class ContactTest  extends BaseClass{


	@Test// (groups="smoke")//(retryAnalyzer = com.crm.concasttt.Genericutility.RetryTryImplementation.class)
	public void andDeletecontactAndVerifyDeleteTest() throws Throwable
	{

		HomePage hp=new HomePage (driver);
		hp.getContactlnk().click();
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateContactImg().click();
		
		CreatingNewContact cnc= new CreatingNewContact(driver);
		JavaUtility jlib = new JavaUtility();
		int num = jlib.getRandomNumber();
		
		FileUtility flib = new FileUtility();
		String Lastname = flib.getDataFromProperty("Lastname");
		
		cnc.createContactWithMandatoryDetails(Lastname, num);
		ContactInformationPage cip= new ContactInformationPage(driver);
		SoftAssert sa = new SoftAssert();
		
		
		//	Assert.assertEquals("A", "A");
			
			
			//sa.assertEquals("A", "B");
		cip.deletecontact();
		
		cp.searchForContacts(Lastname, num );
		System.out.println("Create contact and Delete contact and Verify");
		System.out.println("Test 1");
		System.out.println("Inside Contact test.1");
		System.out.println("smoke Testscript");
		
		
		System.out.println("Test pass");
		System.out.println("Test pass SoftAssert");
		//Assert.assertTrue("ABC".contains("Z"));
		//sa.assertAll();
	}
	
	
	@Test // (groups="smoke") 
	public void createContactVerifyTest() throws Throwable
	{

		ExcelUtility elib = new ExcelUtility();
		String Lastname =elib.getDataFromExcel("Vtiger", 3, 1);
		String Organization =elib.getDataFromExcel("Vtiger", 4, 1);	
		JavaUtility jlib = new JavaUtility();
		int num = jlib.getRandomNumber();
		// Create Contact Business library
		HomePage hp=new HomePage (driver);
		hp.getContactlnk().click();
		ContactsPage cp= new ContactsPage(driver); 
		cp.getCreateContactImg().click();
		CreatingNewContact cnc = new CreatingNewContact(driver);
		cnc.createContactWithMandatoryDetails(Lastname, num);
		ContactInformationPage cip= new ContactInformationPage(driver);
		cip.verifycontactcreated(Lastname);
		System.out.println("Create contact and Verify");
		System.out.println("Test 2");
		System.out.println("Inside Contact test2");
		System.out.println("smoke Testscript");
	}

	
	@Test  
	public void createContactWithOrganization() throws Throwable
	{
		
		ExcelUtility elib = new ExcelUtility();
		String Lastname =elib.getDataFromExcel("Vtiger", 3, 1);
		String Organization =elib.getDataFromExcel("Vtiger", 4, 1);	
		JavaUtility jlib = new JavaUtility();
		int num = jlib.getRandomNumber();
		// Create Contact Business library
		HomePage hp=new HomePage (driver);
		hp.getContactlnk().click();
		ContactsPage cp= new ContactsPage(driver);
		cp.getCreateContactImg().click();
		CreatingNewContact cnc= new CreatingNewContact(driver);
		cnc.createcontactWithOrganization(Lastname, num, Organization);
		System.out.println("Inside Contact test3");
		System.out.println("Inside Regression Testscript ");


	}
	
	
}








