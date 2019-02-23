package app.pp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import app.pp.Page;

public class SingInPage extends Page{
	
	public SingInPage(WebDriver driver) {
		super(driver);
	}

	String pageTitle;
	/**

	 * All WebElements are identified by @FindBy Annotation

	 */

	@FindBy(id="j_username")
	//to store in the cache memory
	@CacheLookup
	WebElement username;

	@FindBy(how = How.ID, using = "j_password")
	WebElement passwordField;

	@FindBy(how = How.ID, using = "login-button")
	WebElement signInButton;

	@FindBy(how = How.CSS, using ="div.auth-left-content-header")
	WebElement logoImg;
	
	@FindBy(css = "a[href='/slm/resetPassword.tr']")
	WebElement clickLink;
	
	@FindBy(css = "form[id='reset_password_form']")
	WebElement isRestpasswordLinkpressed;
	
	@FindBy(css = "div[class='login-error']")
	WebElement loginErrorTitle;

	public boolean getLogo() {
		boolean Logo = logoImg.isDisplayed();
		return Logo; 
	}
	
	public String getLoginErrorTitle() {
		return loginErrorTitle.getText();
	}
	
	public void getLoginCredentials(String userEmail, String password) {
		// Fill username 
		username.sendKeys(userEmail);
		// Fill password
		passwordField.sendKeys(password);
		//click the singIn button
		signInButton.click();
	}

	public boolean validateImage() {
		return logoImg.isDisplayed();
	}

}
