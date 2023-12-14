package runner;

//for running via cucumber runner
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(features = { "src/test/resources/features/Search.feature" }, glue = { "steps",
//		"pages.base" }, plugin = { "html:target/HTML.html", "json:target/JSON.json",
//				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", // to generate extent report and
//																						// give path where it reside
//				"timeline:test-output-thread/" }, dryRun = false, publish = true, monochrome = true)
//public class Runner {
//}

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
//@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/features/0_Login.feature"},
glue={"steps","pages.base"},
plugin= {"pretty",
		"html:target/HTMLReport.html",
		"json:target/JSONReport.json",
		"junit:target/stepReport.xml",
		"rerun:target/failedrerun.txt",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/ExtentReport.html"},
monochrome =true)
public class Runner extends AbstractTestNGCucumberTests{
	
}