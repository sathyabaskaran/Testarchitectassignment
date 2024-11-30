package com.testleaf.drivers.manager;

import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.PwBrowserImpl;
import com.testleaf.web.browser.SeBrowserImpl;
import com.testleaf.web.element.Edit;
import com.testleaf.web.element.EditLoggingDecorator;
import com.testleaf.web.element.PwEditLoggingDecorator;
import com.testleaf.web.element.SeEditLoggingDecorator;



public class EditDecoratorFactory {
	
	
public static EditLoggingDecorator createLoggingDecorator(Browser browser,Edit edit) {
		
		if(browser instanceof SeBrowserImpl)
			return new SeEditLoggingDecorator(edit);
		else if(browser instanceof PwBrowserImpl)
			return new PwEditLoggingDecorator(edit);
		else
			throw new IllegalArgumentException("Unsupported browser");

		
	}

}
