package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver driver;
	
	public LoginPage(WebDriver remotedriver)	// Constructor
	{
		driver = remotedriver;		// assign object
		PageFactory.initElements(driver,this);		// initElements method will create all web elements
	}
	
	
	//Find web elements on the web page 
	
	@FindBy(id = "Email")
	WebElement email;
	
	@FindBy(id = "Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement Logout;
	
	
	// Actions Methods for web elements :
	
	public void EnterEmail(String emailid)
	{
		email.clear();
		email.sendKeys(emailid);
	}
	
	public void EnterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		LoginBtn.click();
	}
	
	public void ClickLogout()
	{
		Logout.click();
	}
	
}
