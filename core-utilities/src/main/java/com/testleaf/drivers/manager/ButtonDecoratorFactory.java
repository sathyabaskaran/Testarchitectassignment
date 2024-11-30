package com.testleaf.drivers.manager;

import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserImpl;
import com.testleaf.web.element.Button;
import com.testleaf.web.element.ButtonLoggingDecorator;
import com.testleaf.web.element.PwButtonLoggingDecorator;
import com.testleaf.web.element.SeButtonLoggingDecorator;


public class ButtonDecoratorFactory {
	
public static ButtonLoggingDecorator createLoggingDecorator(Browser browser,Button button) {
		
		if(browser instanceof SeBrowserImpl)
			return new SeButtonLoggingDecorator(button);
		else if(browser instanceof PwBrowserImpl)
			return new PwButtonLoggingDecorator(button);
		else
			throw new IllegalArgumentException("Unsupported browser");

		
	}

}
