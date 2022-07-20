package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class ProductsPage extends WebDriverUtility {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement clickproductlink;
	
	public ProductsPage (WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickProductsLink()
	{
		
		clickproductlink.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getClickproductlink() {
		return clickproductlink;
	}
	
	

}
