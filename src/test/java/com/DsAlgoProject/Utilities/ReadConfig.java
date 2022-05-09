package com.DsAlgoProject.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src = new File("./src/test/resources/Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUserName()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pswd=pro.getProperty("password");
		return pswd;
	}
	public String getExcelPath()
	{
		String exlpath=pro.getProperty("excelPath");
		return exlpath;
	}
}
