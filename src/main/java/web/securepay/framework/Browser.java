package web.securepay.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver driver;
	
	public static void initDriver() {
		if(driver == null)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	
	public static void openUrl(String url) {
		driver.get(url);
	}
	
	public static void close() {
		driver.quit();
	}
	
	public static String url() {
		return driver.getCurrentUrl();
	}
}