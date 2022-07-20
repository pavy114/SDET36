package Sample;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class ContactTest {
	
	@Test (groups = "smoke")
	public void createContact()
	{
		System.out.println("Inside Create Contact");
	}

	
	@Test
	public void createContactWithOrganization()
	{
		System.out.println("Inside Create Contact with Organization");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void createContactAndEdit()
	{
		System.out.println("Inside Create Contact And Edit");
	}
	
	
}
