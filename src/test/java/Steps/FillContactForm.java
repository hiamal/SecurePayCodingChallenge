package Steps;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import web.securepay.pages.ContactUsPage;
import web.securepay.pages.Customer;
import web.securepay.pages.GoogleSearchPage;
import web.securepay.pages.SecurePayPage;
import web.securepay.framework.Browser;

public class FillContactForm {
	GoogleSearchPage googleSearchPage;
    SecurePayPage securePayPage;
    ContactUsPage contactUsPage;
    
    Customer customer, customerDetailsFromPage;
	
	@Given("^I am at the Contact us page of the SecurePay Website$")
	public void I_am_at_the_Contact_us_page_of_the_SecurePay_Website()
	{
		Browser.openUrl("https://www.securepay.com.au");
		securePayPage = new SecurePayPage();
		new SecurePayPage().NavigateToContactus();			
	}
	
	@Given("^I am at the Contact us page of the SecurePay Website from a google search$")
	public void I_am_at_the_Contact_us_page_of_the_SecurePay_Website_from_a_google_search()
	{
		Browser.openUrl("https://www.google.com.au");
		googleSearchPage = new GoogleSearchPage();
		googleSearchPage.search("SecurePay");
		googleSearchPage.clickSecurePaySearchResult();
		securePayPage = new SecurePayPage();
		securePayPage.NavigateToContactus();		
	}
	
	@When("^I enter details for all the fields$")
	public void I_enter_details_for_all_the_fields()
	{
		customer = new Customer();
		customer.firstName = RandomStringUtils.randomAlphabetic(15);
		customer.lastName = RandomStringUtils.randomAlphabetic(15);
		customer.email = RandomStringUtils.randomAlphabetic(15) + "@securepay.com";
		customer.phone = RandomStringUtils.randomNumeric(10);
		customer.url = RandomStringUtils.randomAlphabetic(15) + ".com.au";
		customer.company = RandomStringUtils.randomAlphabetic(15);
		customer.message = RandomStringUtils.randomAlphabetic(25);
		contactUsPage = new ContactUsPage();
		contactUsPage.FillContactUsForm(customer);
		customerDetailsFromPage = contactUsPage.getCustomerDetails();
	}
		
	@Then("^I should be able to see the data I entered$")
	public void I_should_be_able_to_see_the_data_I_entered()
	{
		Assert.assertTrue(customer.equals(customerDetailsFromPage));
	}
}
