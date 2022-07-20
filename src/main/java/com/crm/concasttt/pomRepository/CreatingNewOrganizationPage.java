package com.crm.concasttt.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CreatingNewOrganizationPage  extends WebDriverUtility {
	
WebDriver driver;
	
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement organizationname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savebtn;
	
	@FindBy(className="dvHeaderText")
	private WebElement value;
	
	
	public void createOrganizationWithMandatoryDetailsAndVerify(String Organization, int num)
	{
		organizationname.sendKeys(Organization+num);
		
		savebtn.click();
		String actual = value.getText();
		
		String Expected = Organization;
		
		if(actual.contains(Expected))
		{
			System.out.println(" Organization is inserted Successfully");
		}
		else
		{
			System.out.println("Failed");
		}
	}
	
	
	

//	driver.findElement(By.name("accountname")).sendKeys(Organization+num);
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
//	String actual = driver.findElement(By.className("dvHeaderText")).getText();
//	String Expected = Organization;
//	
//	if(actual.contains(Expected))
//	{
//		System.out.println(" Organization is inserted Successfully");
//	}
//	else
//	{
//		System.out.println("Failed");
//	}
}
