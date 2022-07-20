package com.crm.concasttt.Genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	public void onTestFailure(ITestResult result) {
		String testname= result.getMethod().getMethodName();
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		
		String date= new Date().toString().replaceAll(":","-");
		
		try {
			File dest= new File("./Screenshot/"+testname+date+".png");
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("Screen shot taken");
		}
	}
	
 
	
	
}
