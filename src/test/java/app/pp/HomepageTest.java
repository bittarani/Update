package app.pp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.pp.Homepage;
import app.pp.SingInPage;


public class HomepageTest extends Testdata {

	SingInPage Login;
	Homepage homepage;
	
	@BeforeTest
	public void setUp() {
		initialization();
		Login = PageFactory.initElements(driver, SingInPage.class);
	    Login.getLoginCredentials(prop.getProperty("username"), prop.getProperty("passwordField"));	
		homepage = PageFactory.initElements(driver, Homepage.class);
	}

	@AfterTest
	//Close the browser
	public void shutDownPage() {
		driver.close();
	}
	// test cases are independent of each other
	// before each test runs the user is logged in with valid credential

	@Test(priority = 1)
	public void verifySuccessfulLogin() {
		homepage.verifySuccessfullyLogin();
		Assert.assertTrue(homepage.verifySuccessfullyLogin().contains("My Dashboard"));
	}
	
	@Test(priority = 2)
	public void isInviteuserButtonseen() {
		boolean inviteuserButton = homepage.isInviteuserButtonDisplayed();
		Assert.assertTrue(inviteuserButton);
	}
	
	@Test(priority = 3)
	public void isMenubuttonClicked() {
		String menu = homepage.clickMenuButton();
		Assert.assertEquals(menu,"CA Agile Central");
	}
	
	@Test(priority = 4)
	public void isHelpbuttonDisplayed() {
		Assert.assertTrue(homepage.isHelpButtonDisplayed());
	}
	
	@Test(priority = 5)
	public void isSettingimageButtonDisplayed() {
		Assert.assertTrue(homepage.isSettingbuttonDisplayed());
	}
	
	@Test(priority = 6)
	public void isPinbuttonDisplayed() {
		Assert.assertTrue(homepage.isPiniconDisplayed());
	}
	
	@Test(priority = 7, enabled = false)
	public void verifyText() {
		homepage.isTextDisplayed();
		Assert.assertEquals(homepage.isTextDisplayed().equalsIgnoreCase("Getting Started for Contributors"), true);
	}
}
