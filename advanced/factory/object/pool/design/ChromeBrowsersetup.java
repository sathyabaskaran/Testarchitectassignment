package advanced.factory.object.pool.design;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowsersetup implements BrowserSetup{

	@Override
	public WebDriver setupBrowser(Capabilities option) {
		ChromeOptions options = (ChromeOptions)option;
		return new ChromeDriver(options);
	}

}
