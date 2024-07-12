package StepDefinition;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomer;


// Base Class : To maintain common variables, objects & methods.
// Step Definition classes will extend base class.

public class BaseClass
{

	public static WebDriver driver;		// creating object of Web Driver.
	public LoginPage Loginpg;			// creating object of LoginPage class
	public AddNewCustomer addcustm;		// creating object of AddNewCustomer class
	public SearchCustomer SearchCustom;	// creating object of SearchCustomer class

	public String generateEmailId()		// generate unique email id
	{
		return(RandomStringUtils.randomAlphabetic(5));
		 
	}
	
	public void clickjs(WebElement menu, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",menu);
	}
}
 