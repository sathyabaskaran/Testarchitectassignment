package advanced.factory.object.pool.design;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public interface BrowserSetup {
	
	WebDriver setupBrowser(Capabilities option);

}
