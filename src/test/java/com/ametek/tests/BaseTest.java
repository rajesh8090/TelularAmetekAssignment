package com.ametek.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ametek.generic.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/*
 * This class is used to handle the common repeated steps.
 * @author Rajesh Kumar
 */
public class BaseTest {
	
	public static WebDriver driver;
	ExtentReports extent;
	ExtentSparkReporter spark;
	
	@BeforeSuite
	public void config() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./reports/index.html");
		spark.config().setReportName("Ametek Assignment Extent Report");
		spark.config().setDocumentTitle("Amazon Automation Report");
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent.attachReporter(spark);
		extent.setSystemInfo("Browser", Utils.getValueFromPropFile("browser"));
		extent.setSystemInfo("OS", System.getProperty("os.name"));
    	extent.setSystemInfo("Environment", "Production");
		spark.config().setTheme(Theme.DARK);
	}
	
	@BeforeClass
	public void openBrowser()
	{
		String browser=Utils.getValueFromPropFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","./exe/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver","./exe/geckodriver.exe");
        driver=new FirefoxDriver();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void openApplication()
	{
		String url=Utils.getValueFromPropFile("url");
		driver.get(url);
	}
	
	@AfterSuite
	public void configAS() {
		extent.flush();
	}
	
}
