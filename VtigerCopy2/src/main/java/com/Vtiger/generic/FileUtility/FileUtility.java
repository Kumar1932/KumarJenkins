package com.Vtiger.generic.FileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.Vtiger.ConstantPaths.iPathConstants;

public class FileUtility 
{
public String getDataFromPropertiesFile(String key) throws Exception
{
	FileInputStream fis=new FileInputStream(iPathConstants.filePath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String data = pObj.getProperty(key);
	return data;
}
}
