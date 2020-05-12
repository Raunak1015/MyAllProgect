package com.automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JiraPageObjects {

	private WebDriver driver;
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(css="#login-submit > span > span > span")
	public WebElement submitButtonUserID;

	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(css="#login-submit > span > span > span")
	public WebElement submitButtonLogin;
	
	@FindBy(xpath="//h5[text()='Genpact']")
	public WebElement selectGenpactProject;
	
	@FindBy(xpath="//div[contains(text(),'All issues')]")
	public WebElement allIssueLink;
	

	@FindBy(xpath="//span[contains(text(),'Advanced search')]")
	public WebElement advanceSearchLink;
	
	@FindBy(xpath="//textarea[@id='advanced-search']")
	public WebElement jqlQueryBox;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	public WebElement submitJQLquery;
	
	@FindBy(xpath="//table[@id='issuetable']//tbody/tr")
	public List<WebElement> countOfAllIssue;
	
	@FindBy(xpath="//div[@class='sc-jlyJG ffLtlS']/child::div/child::div/child::div/child::div/child::div/child::div/child::button")
	public WebElement statusOfBug;

	@FindBy(xpath="//a[@class='styled__Link-sc-17jb35i-1 iHqNYf']")
	public WebElement LabelofBug;
	
	@FindBy(xpath="//div[contains(text(),'Unassigned')]")
	public WebElement unassignButtonInIssue;
	
	public JiraPageObjects()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserID(String userid)
	{
		this.username.sendKeys(userid);
	}
	
	public void enterPassword(String password)
	{
		this.password.sendKeys(password);
	}
	
	public void clickOnsubmitButtonUserID(){
		submitButtonUserID.click();
	}
	public void clickOnsubmitButtonLogin(){
		submitButtonLogin.click();
	}
	
	public void clickOnProjectGenpact(){
		selectGenpactProject.click();
	}
	public void clickOnAllIssue(){
		allIssueLink.click();
	}
	
	public void clickOnAdvanceSearchLink(){
		advanceSearchLink.click();
	}
	
	public void clearExistingText()
	{
		jqlQueryBox.clear();
	}
	
	public void enterJQLquery(String jqlQuery)
	{
		this.jqlQueryBox.sendKeys(jqlQuery);
	}
	
	public void submitJQLquery()
	{
		submitJQLquery.click();
	}
	
	public int numberOfIssueListed()
	{
		return countOfAllIssue.size();		
	}

	public String getStatus()
	{
		return statusOfBug.getText();
		
	}
	
	public String getLabel()
	{
		return LabelofBug.getText();
		
	}
	
	public void clickOnBugAssigneeButton()
	{
		unassignButtonInIssue.click();
	}

}
