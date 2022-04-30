package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class InstanceFactory extends WebdriverUtils{
	
	
	
	
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
	
	public static ExtentReports initalizeExtentReportObject() throws Exception {
		try {
			
			if(extent ==null)
			{
			ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/extent-output/ExtentReport.html"));
			htmlReport.config().setDocumentTitle("Automation Report");
			htmlReport.config().setReportName("Praticse automation");		
			
			extent=new ExtentReports();		
			extent.attachReporter(htmlReport);			
			}
			
			return extent;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
}
