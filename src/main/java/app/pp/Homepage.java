package app.pp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Page {
	
	public Homepage() {
		super(driver);
	}
    /**

	 * All WebElements are identified by @FindBy Annotation

	 */
	
	@FindBy(css = "span[aria-label='Open Sidebar']")
	WebElement menuButton;
	
	@FindBy(css = "h1.chr-ComponentsSideBar-headerTitle")
	WebElement verifyMenuButtonisClicked;
	
	@FindBy(css = "h1.smb-HeaderGroup-title")
	WebElement homePagetitle;
	
	//click invite user button
	
	@FindBy(css = "button[aria-label='Invite Users']")
	WebElement inviteUserButton;
	
	//to verify the text if invite user button is clicked
	
	@FindBy(css = "span.chr-InviteUsersModal-prompt")
	WebElement checkForText;
	
	@FindBy(css = "h1[class='smb-HeaderGroup-title']")
	WebElement dashboardPage;
	
	@FindBy(css = "button.smb-Button.smb-Button--icon.smb-Button--sm.chr-NavigationHelpMenu-button")
	WebElement helpButton;
	
	@FindBy(css = "img.chr-NavigationProfileMenu-avatar")
	WebElement mySettingButton;
	
	@FindBy(css = "span.smb-Icon.smb-Icon--unpinned")
	WebElement pinIcon;
	
	@FindBy(xpath = "//h3[contains(text(),'Getting Started for Organizers')]")
	WebElement verifyText;
	
	public String verifySuccessfullyLogin() {
		return homePagetitle.getText();
	}
	
	public String clickMenuButton() {
		menuButton.click();
		return verifyMenuButtonisClicked.getText();
	}
	
	public boolean isInviteuserButtonDisplayed() {
		return inviteUserButton.isDisplayed();
	}
	
	public boolean isHelpButtonDisplayed() {
		return helpButton.isDisplayed();
	}
	
	public boolean isSettingbuttonDisplayed() {
		return mySettingButton.isDisplayed();
	}
	
	public boolean isPiniconDisplayed() {
		return pinIcon.isDisplayed();
	}
	
	public String isTextDisplayed() {
		return verifyText.getText();
	}
}
