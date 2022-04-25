package com.sita.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class contains methods for reading the data from property file
 * @author Ritu
 *
 */
public class ConfigDataProvider {

	Properties pro;
	public ConfigDataProvider()
	{
		File src =new File("./Config/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Not able to load config file"+e.getMessage());
		} 
	}
	
	public String getDataFromConfig( String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	public String getBrowser()
	{
		return pro.getProperty("Browser");

	}
	public String dev_url()
	{
		return pro.getProperty("dev_url");
	}
	public String inventory_url()
	{
		return pro.getProperty("inventory_url");
	}
	}

















