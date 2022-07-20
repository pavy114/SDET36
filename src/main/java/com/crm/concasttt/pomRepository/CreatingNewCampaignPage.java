package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CreatingNewCampaignPage extends WebDriverUtility {
	
WebDriver driver;
	
	public CreatingNewCampaignPage(WebDriver driver){
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	/**It is used to create Campaign with all the Mandatory Details
	 * @author Pavithra
	 */
	
	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignNameTxtB;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement result;
	

	public void createCampaignWithMandatoryDetails(String campaign,int num )
	{
		
		campaignNameTxtB.sendKeys(campaign+num);
		savebtn.click();
		
		
		String actual = result.getText();
		
		String Expected = campaign+num;
		
			if(actual.contains(Expected))
			{
			System.out.println("Campaign is created successfully");	
			}
			else {
				System.out.println("Failed");
		
			}
		
	}
	

		

}
