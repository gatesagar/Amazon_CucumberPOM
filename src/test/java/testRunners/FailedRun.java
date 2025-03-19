package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = { "@target/failedrerun.txt" }, 
		glue = { "stepDefinitions", "hooks" }, 
		plugin= {"pretty", "html:target/cucumber-reports.html", 
				"json:target/cucumber-reports/cucumber.json",
				 "rerun:target/failedrerun.txt"},
	
	    monochrome = true,
		dryRun = false

)
public class FailedRun {

}
