package com.testleaf.drivers.manager;

import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserImpl;
import com.testleaf.web.element.Element;
import com.testleaf.web.element.ElementLoggingDecorator;
import com.testleaf.web.element.PwElementLoggingDecorator;
import com.testleaf.web.element.SeElementLoggingDecorator;

public class ElementDecoratorFactory {
	
	public static ElementLoggingDecorator createLoggingDecorator(Browser browser,Element element) {
		
		if(browser instanceof SeBrowserImpl)
			return new SeElementLoggingDecorator(element);
		else if(browser instanceof PwBrowserImpl)
			return new PwElementLoggingDecorator(element);
		else
			throw new IllegalArgumentException("Unsupported browser");

		
	}

}
