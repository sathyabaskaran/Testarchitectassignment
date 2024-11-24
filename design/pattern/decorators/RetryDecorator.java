package design.pattern.decorators;

import java.util.NoSuchElementException;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

public class RetryDecorator implements WebElementActions{
	
	private WebElementActions actions;
	
	private static final Logger logger = Logger.getLogger(RetryDecorator.class.getName());
	

	public RetryDecorator(WebElementActions actions) {
		this.actions = actions;
	}

	@Override
	public void click(WebElement ele) {
		int attempts = 0;
		int maxretries = 3;
		while(attempts < maxretries)
		{
			try {
				logger.info("element is going to be clicked");
				actions.click(ele);
				break;
			}
			catch(NullPointerException e) {
				attempts++;
				if(attempts == maxretries)
					throw e;
			}
		}
		logger.info("element is clicked");
		
	}

	@Override
	public void sendKeys(WebElement ele, CharSequence text) {
		int attempts = 0;
		int maxretries = 3;
		while(attempts < maxretries) {
			try {
				logger.info("text is going to be entered");
				actions.sendKeys(ele, text);
				break;
			}
			catch(NullPointerException e) {
				attempts++;
				if(attempts == maxretries) {
					throw e;
				}
			}
		}
		logger.info("text is entered");
		
	}

}
