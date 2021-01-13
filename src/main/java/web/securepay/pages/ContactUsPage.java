package web.securepay.pages;

import web.securepay.framework.*;

public class ContactUsPage {
	
	private Element txtFirstName  = new Element("name","firstName");
	private Element txtLastName  = new Element("name","lastName");
	private Element txtEmail  = new Element("name","email");
	private Element txtPhone  = new Element("name","phone");
	private Element txtWebsite = new Element("name","website");
	private Element txtCompany = new Element("name","company");
	private Element cboAmountProcessedPerYear = new Element("name","amount");
	private Element txtMessage = new Element("name","message");
	
	public void FillContactUsForm(Customer customer)
	{
		txtFirstName.text(customer.firstName);
		txtLastName.text(customer.lastName);
		txtEmail.text(customer.email);
		txtPhone.text(customer.phone);
		txtWebsite.text(customer.url);
		txtCompany.text(customer.company);
		cboAmountProcessedPerYear.select("$100,000 to $250,000");
		txtMessage.text(customer.message);
	}
	
	public Customer getCustomerDetails(){
		Customer customer = new Customer();
		customer.firstName = txtFirstName.attribute();
		customer.lastName = txtLastName.attribute();
		customer.email = txtEmail.attribute();
		customer.phone = txtPhone.attribute();
		customer.company = txtCompany.attribute("value");
		customer.message = txtMessage.attribute("value");
		customer.url = txtWebsite.attribute("value");
		return customer;
	}
}
