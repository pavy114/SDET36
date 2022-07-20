package Sample;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class OrganizationTest {
	
	@Test (groups = "smoke")
	public void createOrganization()
	{
		System.out.println("Inside Create Contact");
	}

	
	@Test
	public void createOrganizationWithVendor()
	{
		System.out.println("Inside Create Organization with Vendor");
	}
	
	@Test(groups = {"smoke", "regression"})
	public void createOrganizationAndEdit()
	{
		System.out.println("Inside Create Organization And Edit");
	}
	

}
