 package app.pp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testdata{
	
	public static  WebDriver driver;
	public static  Properties prop;
	
	public Testdata() {
	
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream("C:/Users/vivth/RallyUpdated/config.txt");
			prop.load(input);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "B:\\Driver\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
	    } else if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.FirefoxDriver.driver", "B:\\Driver\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("URL"));
		
	}
}
		
		


