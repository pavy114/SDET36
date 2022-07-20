package practise;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertiesTest {
	public static void main(String[] args) throws Throwable {
		
		
		 FileInputStream fis = new FileInputStream("./Testdata/commondata.properties");
		 Properties pro= new  Properties();
		 pro.load(fis);
		 String url = pro.getProperty("url");
		 String username = pro.getProperty("username");
		 String password = pro.getProperty("password");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		 driver.get(url);
		 driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 Thread.sleep(5000);
		 driver.close();
		 
	}

}
