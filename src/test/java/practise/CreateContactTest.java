package practise;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

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

	public class CreateContactTest extends BaseClass{

			@Test
			public void createcontactAndVerifyDeleteTest() throws Throwable
			{
		
			HomePage hp=new HomePage (driver);
			hp.clickContactModule();
			System.out.println("Before clicking create contact");
			ContactsPage cp=new ContactsPage(driver);
			cp.clickcontactlnk();
			System.out.println("After clicking create contact");
			CreatingNewContact cnc= new CreatingNewContact(driver);
			JavaUtility jlib = new JavaUtility();
			int num = jlib.getRandomNumber();
			FileUtility flib = new FileUtility();
			 String Lastname = flib.getDataFromProperty("Lastname");
			cnc.createContactWithMandatoryDetails(Lastname, num);
			ContactInformationPage cip= new ContactInformationPage(driver);
		cip.deletecontact();
		System.out.println("Contact Deleted");
		cp.searchForContacts(Lastname, num );
	
		}
			@Test 
			public void createContactVerifyTest() throws Throwable
			{
				ExcelUtility elib = new ExcelUtility();
				String Lastname =elib.getDataFromExcel("Vtiger", 3, 1);
				String Organization =elib.getDataFromExcel("Vtiger", 4, 1);	
				JavaUtility jlib = new JavaUtility();
				int num = jlib.getRandomNumber();
			// Create Contact Business library
					HomePage hp=new HomePage (driver);
					hp.clickContactModule();
					ContactsPage cp= new ContactsPage(driver);
					cp.clickcontactlnk();
					CreatingNewContact cnc = new CreatingNewContact(driver);
					cnc.createContactWithMandatoryDetails(Lastname, num);
					ContactInformationPage cip= new ContactInformationPage(driver);
					cip.verifycontactcreated(Lastname);
			
			}
	}
	





