package com.testleaf.drivers.manager;

import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserImpl;
import com.testleaf.web.element.Link;
import com.testleaf.web.element.LinkLoggingDecorator;
import com.testleaf.web.element.PwLinkLoggingDecorator;
import com.testleaf.web.element.SeLinkLoggingDecorator;


public class LinkDecoratorFactory {
	
public static LinkLoggingDecorator createLoggingDecorator(Browser browser,Link link) {
		
		if(browser instanceof SeBrowserImpl)
			return new SeLinkLoggingDecorator(link);
		else if(browser instanceof PwBrowserImpl)
			return new PwLinkLoggingDecorator(link);
		else
			throw new IllegalArgumentException("Unsupported browser");

		
	}

}
