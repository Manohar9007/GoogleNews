package com.googlenews.executeTestCase;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.googlenews.pageObjects.pageObjects_GoogleNews;

public class googleNewsExecution {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://news.google.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		
		WebElement sports = driver.findElement(By.xpath("//span[contains(text(),'bike')]//..//following-sibling::div//descendant::span[contains(text(),'Sports')]"));
		js.executeScript("arguments[0].click();", sports);
		Thread.sleep(2000);
		WebElement latest = driver.findElement(By.xpath("//span[text()='Latest']"));
		Actions element = new Actions(driver);
		element.click(latest).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 1; i++) {
			element.sendKeys(Keys.ARROW_LEFT).build().perform();
		    Thread.sleep(2000);
		}
		
		Thread.sleep(3000);
		element.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		
		//List<WebElement> elementsRoot = driver.findElements(By.xpath("(//main)[3]/div/div"));
		
		//List<WebElement> elementsRoot = driver.findElements(By.xpath("//div[article[@data-n-ham='true' and @data-n-vlb=\"0\"]]"));
		
		List<WebElement> elementsRoot = driver.findElements(By.xpath("//div[article[@data-n-ham='true' and @data-n-vlb='0'] | img[@aria-label='Image'] ]"));
		
		int size = elementsRoot.size();
			
		System.out.println(size);
		
		int i=0;
		for(WebElement disp:elementsRoot) {
			if(disp.isDisplayed()) {
				
				i++;
				
				
			}
			
			
			
		}
		
		System.out.println(i);
		System.out.println(i-1);
		
		Object req = js.executeScript("arguments[0].scrollIntoView(true);", elementsRoot.get(i-1));
		
		System.out.println(req.toString());
		
//		for(int j =1;j>i;j--) {
//			js.executeScript("arguments[0].click();", elementsRoot.get(j));
//			//elementsRoot.get(j).click();
//		}
//		
		
//		for(int i =1;i>size;i--) {
//			
//			String newsheadline = elementsRoot.get(i).getText();
//			System.out.println(newsheadline);
//			elementsRoot.get(i).click();
//		}
		
		
		
	}

}
