package app.pp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected static  WebDriver driver;
	protected WebDriverWait wait;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		
		wait = new WebDriverWait(driver, 30);
	}
	
	public boolean verifyText(WebElement element , String expectedText) {
		if(element.getText().equalsIgnoreCase(expectedText))
		return true;
	return false;
		
	}
	
	public void waitForElementvisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilelemntIsvisible(String Selector) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Selector)));
	}
	
	public void waitUntilelementIsvisible(String Selector) {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Selector)));
	}
}
	