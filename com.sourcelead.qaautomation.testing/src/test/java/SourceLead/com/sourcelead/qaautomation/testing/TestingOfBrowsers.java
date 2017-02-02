package SourceLead.com.sourcelead.qaautomation.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestingOfBrowsers {

	public static void main(String[] args) {
		for(int i=0;i<=4;i++){
		// Opera
		/*System.setProperty("webdriver.opera.driver",
				"D:\\SourceLead\\Selenium Jar Files\\operadriver_win64\\operadriver.exe");
		WebDriver driver4 = new OperaDriver();*/
		
		// chromedriver
		System.setProperty("webdriver.chrome.driver",
				"C:\\QA\\SourceLead\\SeleniumJar\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Firefox Driver
		System.setProperty("webdriver.gecko.driver",
				"C:\\QA\\SourceLead\\SeleniumJar\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		WebDriver driver1 = new FirefoxDriver();
		 

	/*	// IEDriver
		System.setProperty("webdriver.ie.driver",
				"D:\\SourceLead\\Selenium Jar Files\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
		WebDriver driver2 = new InternetExplorerDriver();
		
		//EdgeDriver
		System.setProperty("webdriver.edge.driver",
				"D:\\SourceLead\\Selenium Jar Files\\MicrosoftWebDriver.exe");
		WebDriver driver3 = new EdgeDriver();*/
		
		
		driver.get("http://www.google.com");
		driver1.get("http://www.google.com");
	/*	driver2.get("http://www.google.com");
		driver3.get("http://www.google.com");*/
	//	driver4.get("http://www.google.com");
		}
	}

}
