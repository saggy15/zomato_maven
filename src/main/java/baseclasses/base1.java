package baseclasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utilclasses.Util1;

public class base1 {
	static WebDriver driver = null;
	static ExtentHtmlReporter extentReporter = null;
	static ExtentReports report = null;
	static ExtentTest test = null;
	
	public static WebDriver getDriver(String browser) throws IOException
	{
		if (driver == null)
		{
			if(browser.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
				 driver = new ChromeDriver();
			}
			else if (browser.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
				 driver = new FirefoxDriver();
			}
			
			driver.get(Util1.getProperty("url"));
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			return driver;
		}
		
		else 
			
		{
			return driver;
		}
		
	}



	public static ExtentHtmlReporter gethtmlreporter()
	{
		if (extentReporter == null)
		{
			extentReporter = new ExtentHtmlReporter("ExtentReport.html");
		}
		return extentReporter;
	}
	
	public static ExtentReports getreport()
	{
		if (report == null )
		{
			report = new ExtentReports();
			report.attachReporter(extentReporter);
		}

		return report; 
	}
	
	public static ExtentTest getTest(String testName)
	{
			test = report.createTest(testName);
			return test;
	}
	
}