package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class InstanceFactory {
	
	
	
	
	public static Properties intilializePropertyFile(String path)
	{
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
}
