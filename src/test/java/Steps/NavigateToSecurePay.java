package Steps;

import org.junit.Assert;
import web.securepay.pages.SecurePayPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import web.securepay.pages.GoogleSearchPage;
import web.securepay.framework.Browser;

public class NavigateToSecurePay {	
	GoogleSearchPage googlePage = new GoogleSearchPage();
    SecurePayPage securepay;
	
	@Given("^I am on the Google Search Page$")
	public void I_am_on_the_Google_Search_Page()
	{	
		Browser.driver.get("https://www.google.com.au");
		googlePage.search("SecurePay");
	}
	
	@When("^I click on a SecurePay link$")
	public void I_click_on_a_SecurePay_link()
	{		
		googlePage.clickSecurePaySearchResult();			
	}
		
	@Then("^I should be redirected to the SecurePay website$")
	public void I_should_be_redirected_to_the_SecurePay_website()
	{
		securepay = new SecurePayPage();
		Assert.assertEquals(Browser.url(), "https://www.securepay.com.au/");
	}
}