package design.pattern.decorators;

import org.openqa.selenium.WebElement;

public class ElementActions implements WebElementActions {

	@Override
	public void click(WebElement ele) {
		ele.click();
		
	}

	@Override
	public void sendKeys(WebElement ele, CharSequence text) {
		ele.sendKeys(text);
		
	}

}
