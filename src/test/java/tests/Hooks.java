package tests;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import web.securepay.framework.Browser;

public class Hooks {
	@Before
	public void beforeScenario() 
	{
		Browser.initDriver();
	} 
		 
	@After
	public void afterScenario()
	{
		Browser.close();
		Browser.driver = null;
	}
}
