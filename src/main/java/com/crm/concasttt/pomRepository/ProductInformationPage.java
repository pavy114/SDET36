package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class ProductInformationPage extends WebDriverUtility
{

	
WebDriver driver;
	
	public ProductInformationPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//To create Campaign
		@FindBy(xpath="//img[@src='themes/softed/images/menuDnArrow.gif']")
		private WebElement more;
		
		//Campaigns
		
		@FindBy(xpath="//a[text()='Campaigns']")
		private WebElement Campaignmodule;
	


		public WebElement getMore() {
			return more;
		}

		public WebElement getCampaignmodule() {
			return Campaignmodule;
		}
		
		
}
