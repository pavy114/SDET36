package com.crm.concasttt.Genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Pavithra
 * 
 */

public class FileUtility implements IConstants
{
	/**
	 * It is used to read data from Properties file
	 * @param key1
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromProperty(String key) throws Throwable 
	{
		//FileInputstream fis= new FileInputstream("./Testdata/Exceldata.xlsx");
		FileInputStream fis = new FileInputStream(propertyFilePath);
		
		Properties pro=new Properties();
		pro.load(fis);
		
		String value = pro.getProperty(key);
		return value;
	
		
	}

}
