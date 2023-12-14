package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
//@RunWith(Cucumber.class)
@CucumberOptions(features= {"@target/failedrerun.txt"},
glue={"steps","pages.base"},
plugin= {"pretty",
		"html:target/Failed/HTMLReport-Failed.html",
		"json:target/Failed/JSONReport-Failed.json",
		"junit:target/Failed/StepReport-Failed.xml",
		"rerun:target/failedrerun.txt",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/Failed/ExtentReport-Failed.html"},
monochrome =true)
public class RunnerFailed extends AbstractTestNGCucumberTests{
	
}