package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class OrganizationsPage extends WebDriverUtility{
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorganization;
	
	public void createOrganizationimage()
	{
		
		
		createorganization.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateorganization() {
		return createorganization;
	}
		
	
	
//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
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
