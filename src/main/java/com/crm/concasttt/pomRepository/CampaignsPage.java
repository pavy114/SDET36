package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CampaignsPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public CampaignsPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcampaignimg;
	
	public void clickcreatecampaign()
	{
		createcampaignimg.click();
		
		
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreatecampaignimg() {
		return createcampaignimg;
	}
	
	

}
