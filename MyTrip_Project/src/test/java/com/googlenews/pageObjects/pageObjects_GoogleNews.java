package com.googlenews.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObjects_GoogleNews {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	@FindBy(xpath = "//span[contains(text(),'bike')]//..//following-sibling::div//descendant::span[contains(text(),'Sports')]")
	WebElement sportstab;
	
	@FindBy(xpath = "//span[text()='Latest']//..//..//..//..//..//..//following-sibling::div//span//span[contains(text(),'arrow_right')]")
	WebElement rightarrow;
	
	public void selectSports()
	{
		
		sportstab.click();
	}
	
	public void rightArrow()
	{
		
		js.executeScript("arguments[0].click();", rightarrow);
	}

	
	public pageObjects_GoogleNews(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
