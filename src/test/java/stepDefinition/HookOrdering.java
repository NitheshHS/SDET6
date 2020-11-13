package stepDefinition;

import cucumber.api.java.en.When;

public class HookOrdering {
	
	@When("^Exceute Hooks based on orders$")
	public void exceute_Hooks_based_on_orders() throws Throwable {
	   System.out.println("======================");
	   System.out.println("======Hook======");
	   System.out.println("======================");
	}

}
