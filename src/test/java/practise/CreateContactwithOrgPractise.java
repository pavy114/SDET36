package practise;

import org.testng.annotations.Test;

import com.crm.concasttt.Genericutility.BaseClass;
import com.crm.concasttt.Genericutility.ExcelUtility;
import com.crm.concasttt.Genericutility.JavaUtility;
import com.crm.concasttt.pomRepository.ContactsPage;
import com.crm.concasttt.pomRepository.CreatingNewContact;
import com.crm.concasttt.pomRepository.HomePage;

public class CreateContactwithOrgPractise extends BaseClass {
	
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
		
		
	}
}



