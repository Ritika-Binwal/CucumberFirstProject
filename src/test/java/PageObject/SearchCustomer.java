package PageObject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer 
{
	
	WebDriver driver;
	
	public SearchCustomer(WebDriver remotedriver)
	{
		driver = remotedriver;		// assign object
		PageFactory.initElements(driver, this);		
	}
	
	
	@FindBy(id = "SearchEmail")
	WebElement EmailId;
	
	@FindBy(id = "search-customers")
	WebElement SearchBtn;
	
	@FindBy(id = "customers-grid")
	// (xpath = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement tableGrid;
	
	@FindBy(xpath= "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//@FindBy(xpath= "//table[@id='customers-grid']//tbody/tr[1]/td")
	//List<WebElement> tableColumns;
	
	
	@FindBy(id = "SearchFirstName")
	WebElement FName;
	
	@FindBy(id = "SearchLastName")
	WebElement LName;
	
	
	
	//// Actions Methods for web elements ////
	
	//////////// Search Customer By Email /////////////

	public void EnterCustomerEmail(String email)
	{
		EmailId.sendKeys(email);
	}
	
	public void clickSearch()
	{
		SearchBtn.click();
	}
	
	
	public boolean SearchByEmail(String expectedEmail)
	{
		boolean found = false;
		
		int totalrows = tableRows.size();
		//int totalcols = tableColumns.size();
		
		for(int r = 1; r<=totalrows; r++)
		{
			WebElement findEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + r + "]/td[2]"));
		
			String actualEmail = findEmail.getText();
			
			if(actualEmail.equals(expectedEmail))
			{
				found = true;
				break;
			}
	
		}
		
		return found;
		
	}
	
	
	//////////// Search Customer By Name /////////////

	
	public void ByFirstName(String firstname)
	{
		FName.sendKeys(firstname);
			
	}
	
	public void ByLastName(String lastname)
	{
		LName.sendKeys(lastname);
			
	}

	public boolean SearchByName(String expectedName)
	{
		boolean found = false;
		
		int totalrows = tableRows.size();
		//int totalcols = tableColumns.size();
		
		for(int r = 1; r<= totalrows; r++)
		{
			WebElement findName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + r + "]/td[3]"));
		
			String actualName = findName.getText();
			
			if(actualName.equals(expectedName))
			{
				found = true;
				break;
			}
	
		}
		
		return found;
		
	}
	
}
