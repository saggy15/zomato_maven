package testclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseclasses.base1;
import pomclasses.LoginPage;

public class ZomatoUserLogin {
	
	static WebDriver driver;
	
	static ExtentHtmlReporter extentReporter;
	
	static ExtentReports report;
	static ExtentTest test;
	LoginPage lp;
	
	@BeforeClass
	public void beforeclass() throws IOException
	{
		extentReporter = base1.gethtmlreporter();
		report = base1.getreport();
		test = base1.getTest("VerifyUserLogin");
		
		driver = base1.getDriver("chrome");
	}
	
	@BeforeMethod
	public void beforemethod()
	{
		lp = new LoginPage(driver);
	}
	
	@Test
	public void VerifyUserCanLogin() throws InterruptedException, IOException
	{
		lp.getloginbtn();
		lp.clickonCWGoption();
		lp.getinputemailoptin();
		lp.clicknextbtn();
		//lp.clickonEmailoptin();
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName() + "Test Passed");
		}
		else 
		{
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL, result.getName() + "Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
		}
		
	}
	
	@AfterClass
	public void afterclass()
	{
		report.flush();
	}
	

}
