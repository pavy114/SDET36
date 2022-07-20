package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	WebDriver driver;
	
	public HomePage (WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement Contactlnk;
	
	/**It is used to create contact
	 * @author Pavithra
	 */
	
	
	
	
	public void clickContactModule()
	{
		
		Contactlnk.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getContactlnk() {
		return Contactlnk;
	}
	

	
	// To create Organization
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement Organizationlnk;
	
	
	
	
	public void clickOrganizationModule()
	{
		
		Organizationlnk.click();
	}

	public WebElement getOrganizationlnk() {
		return Organizationlnk;
	}

	public void setOrganizationlnk(WebElement organizationlnk) {
		Organizationlnk = organizationlnk;
	}
	
	/**It is used to signout of the Application
	 * @author Pavithra
	 */
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administorlogo;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signout;
	
	public void signout()
	{
		
		

		mouseOverOnElement(driver,administorlogo);
		
		signout.click();
	//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}
	
	//To create Campaign
	@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement more;
	
	//Campaigns
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement Campaignmodule;
	
	public void createCampaign()
	{
	mouseOverOnElement(driver, more);
	Campaignmodule.click();
		
		
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}


	public WebElement getMore() {
		return more;
	}

	public WebElement getCampaignmodule() {
		return Campaignmodule;
	}
	
	
	
	/**It is used to click on product module
	 * @author Pavithra
	 */
	@FindBy(xpath="//a[text()='Products']")
	private WebElement productmodule;
	
	public void clickproductmodule()
	{
		productmodule.click();
	}

	public WebElement getAdministorlogo() {
		return administorlogo;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getProductmodule() {
		return productmodule;
	}
	
	
}
