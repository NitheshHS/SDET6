package stepDefinition;

import cucumber.api.java.en.When;

public class DataDrivenTest {
	
	@When("^user enter address home number \"([^\"]*)\" and postal pin \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enter_address_home_number_and_postal_pin_and(String arg1, String arg2, String arg3) throws Throwable {
	    System.out.println(arg1+"|"+arg2+"|"+arg3);
	}
}
