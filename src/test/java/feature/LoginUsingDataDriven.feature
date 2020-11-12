Feature: login datadriven feature

@SmokeTest @Regression
Scenario: user login to application
When user enter username and password and click on login
		|admin|manager|	
		|admin123|manager|
		|admin|manager123|
Then home page should display

