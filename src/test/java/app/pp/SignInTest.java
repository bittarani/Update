package app.pp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.pp.Homepage;
import app.pp.SingInPage;

public class SignInTest  extends Testdata {
	SingInPage Login = null;
	Homepage homepage;
	
	public SignInTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		initialization();
		Login = PageFactory.initElements(driver, SingInPage.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	//Close the browser
	public void shutDownPage() {
		driver.close();
	}
	
	//verify the page title
	@Test(priority =1)
	public void verifyPagetitle() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "CA Agile Central Login");
	}
	
	@Test(priority = 2)
	public void isLogoimageDisplayed() {
		boolean image = Login.validateImage();
		Assert.assertTrue(image);
	}
	
	@Test(priority=3, enabled = false)
	public void loginWithInValidemail() {
		Login.getLoginCredentials(prop.getProperty("userEmail"), prop.getProperty("passwordField"));
		Assert.assertEquals(Login.getLoginErrorTitle().contains("The username or password you entered is incorrect."), true);
	}
	
	// sign in successfully
	@Test(priority = 4,description = "Perform a sucessfull login")
	public void fillLogindetails() {
	     Login.getLoginCredentials(prop.getProperty("username"), prop.getProperty("passwordField"));	
		
	}
	
}
