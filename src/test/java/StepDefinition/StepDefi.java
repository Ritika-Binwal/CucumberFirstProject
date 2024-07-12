package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AddNewCustomer;
import PageObject.LoginPage;
import PageObject.SearchCustomer;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class StepDefi extends BaseClass
{
	
	@Before("@Sanity")
	public void setup1()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();					
		System.out.println("Setup-1 Sanity method executed");
	}
	
	
	@Before("@Regression")
	public void setup2()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();					
		System.out.println("Setup-2 Regression method executed");
	}

	
	
///// We can declare multiple Before & After methods
	
   ///////////// Login //////////////
	
	@Given("User Launch Chrome Browser")
	public void launchbrowser() 
	{
	   
	   Loginpg = new LoginPage(driver);		 		// Initialize the object of LoginPage class
	   addcustm = new AddNewCustomer(driver); 		// Initialize the object of AddNewCustomer class
	   SearchCustom = new SearchCustomer(driver);	// Initialize the object of SearchCustomer class
	}
	
	@When("User enter URL {string}")
	public void enterurl(String url) 
	{
		driver.manage().window().maximize();
	    driver.get(url);
	}

	@When("User enter Email as {string} and Password as {string}")
	public void enterdetails(String email, String password)
	{
	   Loginpg.EnterEmail(email);
	   Loginpg.EnterPassword(password);
	}

	@When("User Click on Login")
	public void clicklogin() 
	{
	   Loginpg.ClickLogin();
	}

	@Then("Page Title should be {string}")
	public void pagetitle(String title)
	{
	   String actitle = driver.getTitle();
	   if(actitle.equals(title))
	   {
		   Assert.assertTrue(true);
	   }
	   
	   else
	   {
		   Assert.assertTrue(false);
	   }	
	 
	}

	@When("User click on Logout link")
	public void clicklogout() 
	{
	    Loginpg.ClickLogout();
	}
	
	
	/*@Then("Close Browser")			// Shifted to 
	public void close_browser() 
	{
	   driver.close();
	   //driver.quit();
	}*/	
	
	//////////// Add new Customer ///////////
		
	@Then("User land on Dashboard")
	public void Dashboard()
	{
		String acTitle = addcustm.getPageTitle();
		String exTitile = "Dashboard / nopCommerce administration";
		 
		if(acTitle.equals(exTitile))
		   {
			   Assert.assertTrue(true);
		   }
		   
		   else
		   {
			   Assert.assertTrue(false);
		   }	
		
	}

	@When("User click on Customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException 
	{
		addcustm.clickOnCustomersMenu();
		Thread.sleep(2000);
	}

	@When("Click on Customers option")
	public void click_on_customers_option() throws InterruptedException
	{
		addcustm.clickOnCustomersMenuItem(); 
		Thread.sleep(2000);
	}

	@When("Click on Add new button")
	public void click_on_add_new_button() 
	{
		addcustm.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page()
	{
	    String actitle = addcustm.getPageTitle();
	    String extitile = "Add a new customer / nopCommerce administration";
	    if(actitle.equals(extitile))
		   {
			   Assert.assertTrue(true);
		   }
	    
		   
		   else
		   {
			   Assert.assertTrue(false);
		   }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() 
	{
		//addcustm.enterEmail("june@gmail.com");
		addcustm.enterEmail(generateEmailId() + "@gmail.com");	// method call (generate random email)
		addcustm.enterPassword("testnew");
		addcustm.enterFirstName("Ritika");
		addcustm.enterLastName("BinwalP");
		addcustm.enterGender("Female");
		addcustm.enterDob("9/01/1992");
		addcustm.enterCompanyName("IT Services");
		addcustm.enterManagerOfVendor("Vendor 1");
		addcustm.enterAdminContent("Admin Content");
		
	}

	@When("Click on Save button")
	public void click_on_save_button()
	{
		addcustm.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message)
	{
	    String bodyTag = driver.findElement(By.tagName("Body")).getText();
	    
	    if(bodyTag.contains(message))
	    {
	    	Assert.assertTrue(true);	//pass
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
	}

	
	//////////// Search Customer By Email /////////////
	
	@When("Enter customer Email")
	public void enter_customer_email() 
	{
		SearchCustom.EnterCustomerEmail("victoria_victoria@nopCommerce.com");
	}

	@When("CLick on Search button")
	public void click_on_search_button() throws InterruptedException 
	{
		SearchCustom.clickSearch();
		Thread.sleep(2000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() 
	{
	    String ExpectedEmail = "victoria_victoria@nopCommerce.com";
	    //Assert.assertTrue(SearchCustom.SearchByEmail(ExpectedEmail));    
	    
	    if(SearchCustom.SearchByEmail(ExpectedEmail)==true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);

	    }
	}

	
	//////////// Search Customer By Name /////////////

	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		SearchCustom.ByFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name()
	{
		SearchCustom.ByLastName("Terces");
	}
	    

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() 
	{

		String ExpectedName = "Victoria Terces";
	    
	    //Assert.assertTrue(SearchCustom.SearchByName(ExpectedName)); 
	    
	    if(SearchCustom.SearchByName(ExpectedName)== true)
	    {
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	Assert.assertTrue(false);
	    }
		
	}

	
	// To verify the test status of a scenario and capture the screenshot if it is failed
	// Create object of scenario class
	
	@After
	public void teardown(Scenario sc) throws IOException
	{
		if(sc.isFailed()==true)
		{
			String Path = "C:\\Users\\Ritika\\eclipse-workspace\\CucumberFramework\\Screenshot\\failedss.png";
			TakesScreenshot capture = ((TakesScreenshot)driver);
			File source = capture.getScreenshotAs(OutputType.FILE);
			File dest = new File(Path);
			FileUtils.copyFile(source, dest);
		}
		System.out.println("Tear Down method executed");
		driver.quit();
	}
	
	
	
	/*@BeforeStep
	public void beforeStepDemo() 
	{
		System.out.println("This is Before Step.. ");

	}
	
	@AfterStep
	public void afterStepDemo() 
	{
		System.out.println("This is After step.. ");
	}*/

}


//Hooks :
	// @BeforeStep : executes before each step mentioned in feature file
	// @AfterStep : executes after each step mentioned in feature file
	// Conditional Hook : @Before("@Sanity")