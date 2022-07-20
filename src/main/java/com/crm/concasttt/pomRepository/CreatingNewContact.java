
package com.crm.concasttt.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CreatingNewContact extends WebDriverUtility {
	
	WebDriver driver;
	
	public CreatingNewContact(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="lastname")
	private WebElement LastnameTxtB;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savebtn;
	
	public void createContactWithMandatoryDetails(String Lastname,int num)
	{
		LastnameTxtB.sendKeys(Lastname+num);
		savebtn.click();
	}
	
	
	// To create Contact with Organization
		@FindBy(xpath="//img[@src='themes/softed/images/select.gif'][1]")
		private WebElement imgclckorg;
		
		
		@FindBy(id="search_txt")
		private WebElement searchtxt;
		
		public WebElement getSearchtxt() {
			return searchtxt;
		}

		public void setSearchtxt(WebElement searchtxt) {
			this.searchtxt = searchtxt;
		}

		public WebElement getSearchnow() {
			return searchnow;
		}

		public void setSearchnow(WebElement searchnow) {
			this.searchnow = searchnow;
		}

		public WebElement getSearchele() {
			return searchele;
		}

		public void setSearchele(WebElement searchele) {
			this.searchele = searchele;
		}

		@FindBy(name="search")
		private WebElement searchnow;
		
		@FindBy(xpath="//a[@href='javascript:window.close();']")
		private WebElement searchele;
		
		public void createcontactWithOrganization (String Lastname,int num,String Organization  )
		{
			LastnameTxtB.sendKeys(Lastname+num);
			imgclckorg.click();
			swithToWindow(driver,"Accounts&action");
			searchtxt.sendKeys(Organization+num);
			searchnow.click();
			searchele.click();
			swithToWindow(driver, "Contacts");
			savebtn.click();
			
		}

}
