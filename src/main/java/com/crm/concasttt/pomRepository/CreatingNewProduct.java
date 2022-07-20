package com.crm.concasttt.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class CreatingNewProduct extends WebDriverUtility  {
	
WebDriver driver;
	
	
	
	public CreatingNewProduct (WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='productname']")
	private WebElement productnametxtB;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]'])[1]")
	private WebElement savebtn;
	//driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(Product+num);
	
	public void createProduct(String Product,int num)
	{
		
		productnametxtB.sendKeys(Product+num);
		savebtn.click();
	}

	public WebDriver getDriver() {
		return driver;
	}

	

	public WebElement getProductnametxtB() {
		return productnametxtB;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	

}
