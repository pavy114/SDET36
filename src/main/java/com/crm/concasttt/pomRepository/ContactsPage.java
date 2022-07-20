package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class ContactsPage extends WebDriverUtility {

	WebDriver driver;
	
	public ContactsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactImg;
	
	public void clickcontactlnk()
	{
		
		createContactImg.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	@FindBy(name="search_text")
	private WebElement SearchFor;
	
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchbtn;
	
	//xpath("//select[@name='search_field']" for ele
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement ele;
	
	
	@FindBy(xpath="//span[@class='genHeaderSmall']")
	private WebElement deletedimg;
	
	
	


	

	
	
	public void searchForContacts(String Lastname,int num )
	
		
	{
		
		
		selectByValue(ele,"lastname");
		SearchFor.sendKeys(Lastname+num);
		searchbtn.click();
		
		boolean textt1 = deletedimg.isDisplayed();
		//boolean textt1 = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).isDisplayed();
		
		
		//textt1.isDisplayed();
		if(textt1==true)
		{
			System.out.println("Successfully Deleted");
		}
		else
			System.out.println("Failed to delete");
		
	
	}

	
	public WebElement getSearchFor() {
		return SearchFor;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public WebElement getEle() {
		return ele;
	}
	

	public WebElement getDeletedimg() {
		return deletedimg;
	}
	
	
	
	
}
