package cukeRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = {".\\src\\test\\java\\feature"},
glue = {"stepDefinition"},
dryRun = false,
monochrome = true,
tags = {"@SmokeTest","@Regression"},
plugin = {"pretty",
			"html:target/cucucumber-reports",
			"json:target/Destination/cucumber.json"})
public class MyRunner {
	
	private TestNGCucumberRunner runner;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		runner=new TestNGCucumberRunner(this.getClass());
	}
	@DataProvider
	public Object[][] features(){
		return runner.provideFeatures();
	}
	
	@Test(dataProvider = "features")
	public void scenario(CucumberFeatureWrapper wrap) {
		runner.runCucumber(wrap.getCucumberFeature());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		runner.finish();
	}

}
