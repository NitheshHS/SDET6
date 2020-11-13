package stepDefinition;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.common.io.Files;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	@Before
	public void setUp(Scenario scenario) {
		System.out.println("initialize property file");
		driver=new ChromeDriver();
		System.out.println(scenario.getName());
	}
	
	
	@After
	public void tearDown(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			EventFiringWebDriver event=new EventFiringWebDriver(driver);
			File src = event.getScreenshotAs(OutputType.FILE);
			File dest=new File("./ScreenShot/"+scenario.getName()+".PNG");
			Files.copy(src, dest);
			
		}
		driver.close();
	}

}
