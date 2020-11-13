package cukeRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = {".\\src\\test\\java\\feature\\OrderingOfHook.feature"},
	glue = {"stepDefinition"},
	dryRun = false,
	monochrome = true,
	//tags = {"@SmokeTest","@Regression"},
	plugin = {"pretty",
				"html:target/cucucumber-reports",
				"json:target/Destination/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class Runner{
	
	private TestNGCucumberRunner runner;
	
	@BeforeClass(alwaysRun = true)
	public void setup() {
		runner=new TestNGCucumberRunner(this.getClass());
	}
	
	@DataProvider
	public Object[][] feature() {
		return runner.provideFeatures();
	}
	
	@Test(dataProvider = "feature")
	public void scenario(CucumberFeatureWrapper wrapper) {
		runner.runCucumber(wrapper.getCucumberFeature());
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		Reporter.loadXMLConfig(".\\src\\test\\java\\extent-config.xml");
		runner.finish();
	}

}
//tags = {"@SmokeTest,@Regression"} OR 
//tags = {"@SmokeTest","@Regression"} AND
//tags = {"~@SmokeTest,@Regression"} exclude tag