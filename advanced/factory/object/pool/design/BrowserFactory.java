package advanced.factory.object.pool.design;

import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class BrowserFactory {
	
	private static final Logger logger = Logger.getLogger(BrowserFactory.class.getName());
	
	public WebDriver switchBrowser(BrowserType browsertype, Capabilities option) {
		
		switch(browsertype)
		{
		  case CHROME:
			  logger.info("returning chrome driver with requested options");
			  return new ChromeBrowsersetup().setupBrowser(option);
		  case FIREFOX:
			  logger.info("returning firefox driver with requested options");
			  return new FirefoxBrowsersetup().setupBrowser(option);
		  default:
			  throw new IllegalArgumentException("Unsupported browser type");
		}
	}

}
