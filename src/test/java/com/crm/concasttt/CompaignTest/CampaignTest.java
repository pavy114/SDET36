package com.crm.concasttt.CompaignTest;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.concasttt.Genericutility.BaseClass;
import com.crm.concasttt.Genericutility.DatabaseUtility;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.FileUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.Genericutility.WebDriverUtility;
import com.crm.concasttt.pomRepository.CampaignsPage;
import com.crm.concasttt.pomRepository.CreatingNewCampaignPage;
import com.crm.concasttt.pomRepository.CreatingNewProduct;
import com.crm.concasttt.pomRepository.HomePage;
import com.crm.concasttt.pomRepository.LoginPage;
import com.crm.concasttt.pomRepository.ProductInformationPage;
import com.crm.concasttt.pomRepository.ProductsPage;

public class CampaignTest  extends BaseClass 


 {
	
	
	@Test//(invocationCount=2)//(groups="smoke")
	public void createCampaign() throws Throwable {
		
		//DatabaseUtility dlib= new DatabaseUtility();
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		 String campaign = flib.getDataFromProperty("Campaign");
		 int num = jlib.getRandomNumber();
		HomePage hp=new HomePage(driver);
		hp.createCampaign();		
		CampaignsPage cp= new CampaignsPage(driver);
		cp.clickcreatecampaign();
		CreatingNewCampaignPage cncp = new CreatingNewCampaignPage(driver);
		cncp.createCampaignWithMandatoryDetails(campaign, num);	


System.out.println("Inside Campaign test1");

//System.out.println("smoke Testscript");
// String Browser = System.getProperty("BROWSER");
// System.out.println("browser="+ Browser);
// 
// String url = System.getProperty("URL");
// System.out.println("URL is ="+ url);
// 
// String Domain = System.getProperty("DOMAIN");
//  System.out.println("Domain="+ Domain);
//  
//  String Application = System.getProperty("APP");
//  System.out.println("Application="+ Application);


}
	
	
	}


	
	


