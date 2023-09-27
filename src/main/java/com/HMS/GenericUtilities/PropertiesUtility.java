package com.HMS.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility {
	
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis=new FileInputStream(IConstantUtility.propertyFilePath);
		Properties pObj=new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}

}
