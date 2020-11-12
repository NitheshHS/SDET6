package cukeRunner;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@Test
@CucumberOptions(features = {".\\src\\test\\java\\feature"},
	glue = {"stepDefinition"},
	dryRun = false,
	monochrome = true,
	tags = {"@Regression"},
	plugin = {"pretty",
				"html:target/cucucumber-reports",
				"json:target/Destination/cucumber.json"})

public class Runner extends AbstractTestNGCucumberTests{

}
//tags = {"@SmokeTest,@Regression"} OR 
//tags = {"@SmokeTest","@Regression"} AND
//tags = {"~@SmokeTest,@Regression"} exclude tag