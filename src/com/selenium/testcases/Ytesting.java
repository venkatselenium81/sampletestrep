package com.selenium.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.xls.Xls_Reader;

public class Ytesting {

	WebDriver driver;
	public Xls_Reader suiteXLS;
	
	
	@BeforeClass
	public void setup(ITestContext  context) throws IOException{
		
		String browser=context.getCurrentXmlTest().getParameter("browser");
		String base_URL=context.getCurrentXmlTest().getParameter("baseURL");
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setBrowserName(browser);
		
		String machinename=context.getCurrentXmlTest().getParameter("machineIP");
		
		driver= new RemoteWebDriver(new URL(machinename), cap);
	
		driver.get(base_URL);
		
		
	}
	
	@Test
	public void testexe() throws IOException{
		
		System.out.println("test execution");
		Properties pro = new Properties();
		FileInputStream f = new FileInputStream("C:\\Workspace\\SeleniumGrid\\src\\com\\selenium\\config\\or.properties");
		pro.load(f);
		
		suiteXLS = new Xls_Reader("C:\\Workspace\\SeleniumGrid\\src\\com\\selenium\\xls\\Suite.xlsx");
			
		String searchG=suiteXLS.getCellData("1_Login_Admin", "searchTXT", 2);
		driver.findElement(By.xpath(pro.getProperty("yahooS_txt_xpath"))).sendKeys(searchG);
		
	}


	
}
