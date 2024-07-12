package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(
				//features = ".//FeaturesFile/Customer.feature",		// path to run a separate feature file
				//features= ".//FeaturesFile/",							// path of Complete folder to run all the feature files
				features = {".//FeaturesFile/LoginFeature.feature",".//FeaturesFile/Customer.feature"},	// path to run feature files 	
			  	glue = "StepDefinition", 	// step definition package name
				dryRun =  false,
				monochrome = true,		// To print output in Readable format
				tags = "@Sanity",		// mentioned tag scenarios will execute 
				plugin = {"pretty", "html:target/Cucumber-Reports/tags.html"}	//  To generate report under Target folder.
				)	

	// plugin = {"pretty","junit:target/Cucumber-Reports/xml_report.xml"}
	// plugin = {"pretty","json:target/Cucumber-Reports/json_report.json"}

public class TestRun extends AbstractTestNGCucumberTests
{
	// This class will be empty.
}



// features = ".//FeaturesFile/LoginFeature.feature",	--> Path of Feature file

// glue = "StepDefinition"   -- > Step Definition package name

// monochrome = true,	 --> To print output in Readable format

// DryRun false   -- > For Execution

// Plugin = {"pretty", report path})   -- > To generate report under Target folder.

// If DryRun true : No Execution
// It will only check if the implementation methods are created in Step Definition file or not for all the steps in feature file.


// Reports Formats :
// xml format : pulgin = {"pretty","junit:target/Cucumber-Reports/xml_report.xml"}
// html format : plugin = {"pretty", "html:target/Cucumber-Reports/reports1.html"})
// json format : plugin = {"pretty", "json:target/Cucumber-Reports/json_report.json"})
// If we want to generate the reports together in different formats we can separate the paths with comma.


// Tags :
// tags = "@Sanity and @Regression"			// will execute Scenarios mentioned with both Regression and Sanity tags.
// tags = "@Sanity or @Regression"			// will execute Scenarios with Sanity or Regression tags.
// tags = "@Sanity and not @Regression"		// will execute Scenarios only  with Sanity tags.




