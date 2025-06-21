package Test_Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", // path to .feature files
		glue = {"Stepdefinition"}, // package with step definitions
		plugin = { "pretty", "summary", "html:target/cucumber-report.html",
				"json:target/cucumber-report.json" }, 
		monochrome = true, 
		dryRun = false, 
		tags = "@Tag2")
public class TestRunner {

}