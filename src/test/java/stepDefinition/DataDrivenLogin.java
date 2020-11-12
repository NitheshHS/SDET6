package stepDefinition;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DataDrivenLogin {
	@When("^user enter username and password and click on login$")
	public void user_enter_username_and_password_and_click_on_login(DataTable dataTable) throws Throwable {
	   
		List<Map<String, String>> map = dataTable.asMaps(String.class, String.class);
		System.out.println(map.get(0).get("admin"));
		System.out.println(map.get(0).get("manager"));
		System.out.println(map.get(1).get("admin"));
		System.out.println(map.get(1).get("manager"));
		
		//List<List<String>> list = dataTable.asLists(String.class);
	 // String username = list.get(0).get(0);
	//  String password = list.get(0).get(1);
	 // System.out.println(username);//admin
	 // System.out.println(password);//manager
	  
	 // System.out.println(list.get(1).get(0));//admin123
	  //System.out.println(list.get(1).get(1));//manager
	  //
	//  System.out.println(list.get(2).get(0));//admin
	 // System.out.println(list.get(2).get(1));//manager123
	}

	@Then("^home page should display$")
	public void home_page_should_display() throws Throwable {
	    System.out.println("home page");
	}

}
