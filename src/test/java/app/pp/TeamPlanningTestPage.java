package app.pp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import app.pp.Homepage;
import app.pp.SingInPage;
import app.pp.TeamPlanningPage;

public class TeamPlanningTestPage extends Testdata {
	
	SingInPage Login;
	Homepage homepage = null;
	TeamPlanningPage teamplanningTab = null;
	
	@BeforeTest
	public void setUp() {
		initialization();
		Login = PageFactory.initElements(driver, SingInPage.class);
		Login.getLoginCredentials(prop.getProperty("username"), prop.getProperty("passwordField"));	
		homepage = PageFactory.initElements(driver, Homepage.class);
		teamplanningTab = PageFactory.initElements(driver, TeamPlanningPage.class);
	}
	
	@AfterTest
	//Close the browser
	public void shutDownPage() {
		driver.close();
	}
	
	@Test(priority =1)
	public void clickMenubutton() {
		homepage.clickMenuButton();
	}
	
	@Test(priority = 2)
	public void isTeamplanningButtonclicked() {
		teamplanningTab.clickTeamplanningButton();
	}
	
	/**
	* Checking the functionality of the Add New Button
	*/

	@Test(priority = 3)
	public void isAddnewButtonDisplayed() {
		boolean addNewbutton = teamplanningTab.verifyAddnewbuttonisDisplayed();
		Assert.assertTrue(addNewbutton);
	}
	
	@Test(priority = 4)
	public void isFilterButtonisDisplayed() {
		boolean filterButton = teamplanningTab.verifyFilterbutton();
		Assert.assertTrue(filterButton);
	}
	
	@Test(priority = 5)
	public void isSelectdDropdownListPresent() {
		boolean selectStory = teamplanningTab.verifySelectDropdownListButton();
		Assert.assertTrue(selectStory);
	}
	
	@Test(priority = 6 , enabled = false)
	public void verifyText() {
		String text = teamplanningTab.verifyText();
		Assert.assertEquals(text, "Sample Project Plan");
	}
	
	@Test(priority = 7)
	public void isAddNewbuttonClicked() {
		teamplanningTab.isAddnewButtonClicked();
	}
	
	@Test(priority = 8, enabled = false)
	public void isStorytypeSelected() {
		boolean valueselectedFromDropdownList = teamplanningTab.selectDropdownlistOfstory("Defect");
		Assert.assertTrue(valueselectedFromDropdownList);
	}
	
	@Test(priority = 9)
	public void isAddwithDetailsButtonclicked() {
		teamplanningTab.addStorytypeWithdetails();
	}
}
