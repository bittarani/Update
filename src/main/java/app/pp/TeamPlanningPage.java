package app.pp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class TeamPlanningPage extends Page {
	
	WebDriver driver;
	
	public TeamPlanningPage(WebDriver driver) {
		super(driver);
	}

    /**
    * All WebElements are identified by @FindBy Annotation
    */
	@FindBy(css = "a[title='Team Planning']")
	WebElement teamPlanningbutton;
	    
	@FindBy(css = "h1[class='smb-HeaderGroup-title']")
	WebElement getTitle;
	
	@FindBy(css = "button[class ='smb-Button smb-Button--primary smb-Button--xs chr-AddNew-expand']")
    WebElement addNewuserStory;
	
	@FindBy(css = "span.chr-AddNew-label")
	WebElement findNewkeyword;
	
	@FindBy(css = "span[class='smb-Select-selectedValue']")
	WebElement selectStory;
	
	@FindBy(css = "button[aria-label='Filter']")
	WebElement filterButton;
	
	@FindBy(xpath = "//h3[text()='Sample Project Plan']")
	WebElement textIsPresent;
	/**
	* WebElements for Adding new Button is clicked identified by @FindBy Annotation
	*/
	
	@FindBy(css = "span.chr-AddNew-label")
	WebElement verifyText;
	
	@FindBy(css = "//span[text()='Defect']")
	WebElement addNewtype;
	
	@FindBy(css = "span[aria-label='Collapse']")
	WebElement navigateBackfromaddNewtype;
	/**
	* WebElements for Adding new Story by entering details identified by @FindBy Annotation
	*/
	
	@FindBy(css = "button[aria-label='Add with Details']")
	WebElement creatingNewStory;
	
	@FindBy(css = "a.chr-QuickDetailFormattedId-link")
	WebElement AddnewDetailsText;
	
	public String clickTeamplanningButton() {
		teamPlanningbutton.click();
		return getTitle.getText();
	}
	
	public boolean verifyAddnewbuttonisDisplayed() {
		return addNewuserStory.isDisplayed();
	}
	
	public boolean verifyFilterbutton() {
		return filterButton.isDisplayed();
	}
	
	public boolean verifySelectDropdownListButton() {
		return selectStory.isDisplayed();
	}
	
	public String verifyText() {
		return textIsPresent.getText();
	}
	
	//The addNew button is clicked 
	public String isAddnewButtonClicked() {
		addNewuserStory.click();
		return verifyText.getText();
	}
	
	public boolean selectDropdownlistOfstory(String story) {
		Select userStory = new Select(selectStory);
		userStory.selectByVisibleText(story);
		return true;
	}
	
	public void clickFilterbutton() {
		filterButton.click();
	}
	
	public void selectstoryTypefromList(String text) {
		Select addtype = new Select(addNewtype);
		addtype.selectByVisibleText(text);
	}
	
	public void navigateBack() {
		navigateBackfromaddNewtype.click();
	}
	// creating a new story 
	public void addStorytypeWithdetails() {
		creatingNewStory.click();
	}
	
	public String addNewtext() {
		return AddnewDetailsText.getText();
	}
	
}
