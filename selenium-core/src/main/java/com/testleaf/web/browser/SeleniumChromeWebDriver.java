package com.testleaf.web.browser;

import java.util.LinkedList;
import java.util.Queue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumChromeWebDriver implements WebDriverProvider {

	private Queue<WebDriver> drivers = new LinkedList<>();
	@Override
	public WebDriver returnDriver() {
		if(!drivers.isEmpty())
			return drivers.poll();
		else
		  return createDriver();	
		
	}

	@Override
	public WebDriver createDriver() {
		
		return new ChromeDriver();
	}

	@Override
	public void releaseDriver(Object driver) {
		
		if(driver instanceof WebDriver)
		{
			WebDriver webdriver = (WebDriver)driver;
		   if(driver != null)
		    {
			   drivers.offer(webdriver);
		    }
		}
		
	}

	@Override
	public void close() {
		while(drivers.isEmpty())
		{
			drivers.poll().quit();
		}
		
	}

}
