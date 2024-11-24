package advanced.factory.object.pool.design;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowsersetup implements BrowserSetup {
	
	@Override
	public WebDriver setupBrowser(Capabilities option) {
		FirefoxOptions options = (FirefoxOptions)option;
		return new FirefoxDriver(options);
	}


}
