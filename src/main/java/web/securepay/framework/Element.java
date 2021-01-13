package web.securepay.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Element {
	private String locatorType = "", locatorValue = "";
	
	public Element(String locatorType, String locatorValue) {
		this.locatorType = locatorType;
		this.locatorValue = locatorValue;
	}
	
	
	private WebElement element() {
		
		WebElement thisElement = null;
		
		switch(locatorType) {
			case "id":
				thisElement = Browser.driver.findElement(By.id(locatorValue));
				break;
				
			case "class":
				thisElement = Browser.driver.findElement(By.className(locatorValue));
				break;
				
			case "name":
				thisElement = Browser.driver.findElement(By.name(locatorValue));
				break;
				
			case "linkText":
				thisElement = Browser.driver.findElement(By.partialLinkText(locatorValue));
				break;
				
			case "xpath":
				thisElement = Browser.driver.findElement(By.xpath(locatorValue));
				break;
				
			default:
				thisElement = null;
		}
		
		return thisElement;
	}
	
	public void click() {
		element().click();
	}
	
	public void text(String text) {
		element().sendKeys(text);
	}
	
	public String text() {
		return element().getText();
	}
	
	public void select(int index) {
		Select dropdown = new Select(element());
		dropdown.selectByIndex(index);
	}
	
	public void select(String item) {
		Select dropdown = new Select(element());
		dropdown.selectByVisibleText(item);
	}
	
	public String attribute() {
		return element().getAttribute("value");
	}
	
	public String attribute(String attributeType) {
		return element().getAttribute(attributeType);
	}
	
	public void moveTo() {
		Actions action = new Actions(Browser.driver);
		action.moveToElement(element()).perform();
	}
	
	public boolean visible() {
		return element().isDisplayed();
	}
	
	public void waitForElement() {
		new WebDriverWait(Browser.driver, 10)
        .until(ExpectedConditions.visibilityOf(this.element()));
	}

}
