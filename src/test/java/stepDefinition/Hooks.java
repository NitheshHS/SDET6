package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	@Before
	public void setUp() {
		System.out.println("execute before scenario");
		
	}
	
	@After
	public void tearDown() {
		
		System.out.println("execute after scenario");
	}

}
