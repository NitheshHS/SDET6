package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDef {
	WebDriver driver;
	@Given("^user launches the browser and enter the url$")
	public void user_launches_the_browser_and_enter_the_url() throws Throwable {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");

	}

	@When("^user enter username and password and click on login button$")
	public void user_enter_username_and_password_and_click_on_login_button() throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
	}

	@Then("^Home page should display$")
	public void home_page_should_display() throws Throwable {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		driver.close();
	}

	@When("^user enter wrong username and password$")
	public void user_enter_wrong_username_and_password() throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys("admin123");
		driver.findElement(By.name("user_password")).sendKeys("manager");
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
		driver.findElement(By.id("submitButton")).click();
	}

	@Then("^error message should display$")
	public void error_message_should_display() throws Throwable {
		String msg = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "You must specify a valid username and password.");
		driver.close();
	}

	@Given("^user launches the browser and enter the url \"([^\"]*)\"$")
	public void user_launches_the_browser_and_enter_the_url(String url) throws Throwable {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8888/");
	}

	@When("^user enter username \"([^\"]*)\" and password  \"([^\"]*)\" and click on login button$")
	public void user_enter_username_and_password_and_click_on_login_button(String username, String password) throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

	}

	@When("^user enter wrong username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enter_wrong_username_and_password(String username, String password) throws Throwable {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
	}


}
