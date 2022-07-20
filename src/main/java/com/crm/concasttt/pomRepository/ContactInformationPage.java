package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class ContactInformationPage extends WebDriverUtility {
	WebDriver driver;
	 
	public ContactInformationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath="//input[@value='Delete']")
	private WebElement deleteContactImg;
	
	public void deletecontact()
	{
		deleteContactImg.click();
		
		swithToAlertWindowAndAccpectOnly(driver);
	}
	
	/**
	 * @author Pavithra
	 */
	
	
//	String actual = driver.findElement(By.className("dvHeaderText")).getText();
//	String Expected = Lastname;
//	
//	if(actual.contains(Expected))
//	{
//		System.out.println(" Lastname is inserted Successfully");
//	}
//	else
//	{
//		System.out.println("Failed");
//	}
	
	
	@FindBy(className="dvHeaderText")
	private WebElement value;
	
	public void verifycontactcreated(String Lastnamevalue)
	{
		String actual = value.getText();
		if(actual.contains(Lastnamevalue))
			{
				System.out.println(" Lastname is inserted Successfully");
			}
			else
			{
				System.out.println("Failed");
			}
	}

	

	public WebElement getValue() {
		return value;
	}
}