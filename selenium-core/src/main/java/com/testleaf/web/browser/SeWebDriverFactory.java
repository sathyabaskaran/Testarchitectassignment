package com.testleaf.web.browser;

import org.openqa.selenium.WebDriver;

import com.testleaf.constants.BrowserType;

public class SeWebDriverFactory {
	
	public static WebDriver returnBrowser(BrowserType browserTypes)
	{
		switch(browserTypes)
		{
		 case CHROME:
			 return new SeleniumChromeWebDriver().returnDriver();
		 case FIREFOX:
			 return new SeleniumFirefoxWebDriver().returnDriver();	
		 default:		
	    	 throw new IllegalArgumentException("invalid browser type"); 	 
		}
		
		
	}

}
