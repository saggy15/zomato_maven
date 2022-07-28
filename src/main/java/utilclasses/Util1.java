package utilclasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {
	
	public static WebElement explicitwait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement newelement = wait.until(ExpectedConditions.visibilityOf(element));
		return newelement;
	}
	
	public static String getProperty(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("configuration\\config.properties");
		Properties p = new Properties();
		p.load(file);
		String property = p.getProperty(key);
		return property;
	}
	
	public static String getScreenshot(WebDriver driver, String sName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = "Screenshot\\"+sName+".jpg";
		File dest = new File(path);
		FileHandler.copy(source, dest);
		
		return path;
	}
	
	public static void PopupHandle(WebDriver driver)
	{
		Set<String> add = driver.getWindowHandles();
		List<String> addlist = new ArrayList<>(add);
		driver.switchTo().window(addlist.get(1));
	}

}
