package Steps;

import org.testng.Assert;
import web.securepay.pages.SecurePayPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import web.securepay.pages.ContactUsPage;
import web.securepay.framework.Browser;

public class NavigateToContactUs {
	web.securepay.pages.SecurePayPage securePayPage;
	ContactUsPage contactUsPage;
	
	@Given("^I am on the SecurePay Website$")
	public void I_am_on_the_SecurePay_Website()
	{
		String SiteUrl = "https://www.securepay.com.au";
	    Browser.driver.get(SiteUrl);		
	}
	
	@When("^I click on Contact us link$")
	public void I_click_on_Contact_us_link()
	{
		securePayPage = new SecurePayPage();
		securePayPage.NavigateToContactus();
		
	}
		
	@Then("^I should be navigated to the Contact us page$")
	public void I_should_be_navigated_to_the_contact_us_page() throws InterruptedException
	{
		Assert.assertEquals(Browser.url(), "https://www.securepay.com.au/help-and-support/contact-sales");
	}

}
