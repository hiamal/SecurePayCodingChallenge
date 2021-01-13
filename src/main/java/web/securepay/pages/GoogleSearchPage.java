package web.securepay.pages;

import org.openqa.selenium.Keys;

import web.securepay.framework.*;


public class GoogleSearchPage {
	private Element searchBox = new Element("name","q");
	private Element lnkSearchResult = new Element("xpath","//*[contains(text(), 'SecurePay | Trusted Online Payment Gateway Provider')][1]");
	
	public void search(String text) {
		Browser.initDriver();
		Browser.openUrl("https://www.google.com/");
        searchBox.text(text+Keys.ENTER);
	}

	public void clickSecurePaySearchResult() {
    	lnkSearchResult.click();
	}
	
	public boolean searchResultPresent() {
		return lnkSearchResult != null? true : false;
	}
}