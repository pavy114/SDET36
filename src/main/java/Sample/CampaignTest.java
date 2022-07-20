package Sample;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class CampaignTest {
	
	@Test(groups = "smoke")
	public void createCampaign()
	{
		System.out.println("Inside Create Campaign");
	}

	
	@Test (groups = "regression")
	public void createCampaignWithOrganization()
	{
		System.out.println("Inside Create Campaign with Organization");
	}
	
	@Test (groups = {"smoke", "regression"})
	public void createCampaignAndEdit()
	{
		System.out.println("Inside Create Campaign And Edit");
	}
	

}
