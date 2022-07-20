package com.crm.concasttt.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.concasttt.Genericutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility  {
	
	WebDriver driver;
	
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;

	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;


	public WebElement getUserNameEdt() {
		return userNameEdt;
	}


	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Libraries
	/**
	 * It is used to Launch browser and Login in to Application
	 * @param username
	 * @param password
	 * @param url
	 * @author Pavithra
	 */
	public void LoginToApp(String username,String password, String url)
	{
		
		
	
		driver.get(url);
		waitForElementInDOM(driver);
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
	
	
	
}
