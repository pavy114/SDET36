package Sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertTest1 {
	@Test
	public void createCustomer()
	{
		System.out.println("A");
		System.out.println("B");
		Assert.assertEquals("A", "A");
		System.out.println("C");
		System.out.println("D");
	}

}
