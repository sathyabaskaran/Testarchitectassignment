package design.pattern.decorators;

import org.openqa.selenium.WebElement;

public interface WebElementActions {
	
	void click(WebElement ele);
	void sendKeys(WebElement ele,CharSequence text);

}
