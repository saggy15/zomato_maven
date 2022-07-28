package pomclasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilclasses.Util1;

public class LoginPage extends Util1 {

	WebDriver driver;
	@FindBy (xpath="//a[text()='Log in']")
	private WebElement loginbtn;
	
	@FindBy (xpath="//span[text()='Continue with Google']")
	private WebElement clickonCWG;
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement inputemail;
	
	@FindBy (xpath="//span[text()='Next']")
	private WebElement nextbtn;
	
	
	@FindBy (xpath="(//li[@class='JDAKTe ibdqA W7Aapd zpCp3 SmR8'])[1]")
	private WebElement clickonEmail;
	
	//constructor 
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void getloginbtn()
	{
		loginbtn.click();
	}
	
	public void clickonCWGoption() throws InterruptedException
	{
		Thread.sleep(4000);
		//explicitwait(driver, clickonCWG);
		//PopupHandle(driver);
		driver.switchTo().frame(1);
		clickonCWG.click();
	}
	
	public void getinputemailoptin() throws InterruptedException, IOException
	{
		Thread.sleep(1000);
		PopupHandle(driver);
		inputemail.sendKeys(getProperty("email"));
	}
	
	public void clicknextbtn()
	{
		nextbtn.click();
	}
	public void clickonEmailoptin()
	{
		explicitwait(driver, clickonEmail);
		PopupHandle(driver);
		clickonEmail.click();
	}
}
