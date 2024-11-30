package com.testleaf.drivers.manager;

import com.testleaf.constants.BrowserTestEngine;
import com.testleaf.constants.BrowserType;
import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserImpl;

public class DriverManager {

	private static Browser browser;
	
	public static Browser getBrowser(BrowserTestEngine browserEngine,BrowserType browsertype) {
		if(browser == null) {
			browser = setupBrowser(browserEngine,browsertype);
		}
		return browser;
	}

	private static Browser setupBrowser(BrowserTestEngine browserEngine,BrowserType browsertype) {
		switch (browserEngine) {
		case SELENIUM: {
			return new SeBrowserImpl(browsertype);
		}
		case PLAYWRIGHT: {
			return new PwBrowserImpl(browsertype);
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + browserEngine);
		}
		
	}
}
