package com.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

	public Properties prop;
	public Base(){
		FileInputStream ip;
		try {
			prop=new Properties();
			ip = new FileInputStream(new File("C:\\Users\\madhu\\eclipse-workspace\\RestAPIone\\src\\main\\java\\com\\qa\\config\\config.properties"));
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
