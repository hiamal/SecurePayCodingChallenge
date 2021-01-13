package web.securepay.pages;

import web.securepay.framework.Element;

public class SecurePayPage {
	private Element lnkContactus = new Element("linkText", "Contact us");
	private Element txtFirstName  = new Element("name","firstName");
	
	public void NavigateToContactus()
	{
		lnkContactus.click();
		txtFirstName.waitForElement();
	}
}
	
	
