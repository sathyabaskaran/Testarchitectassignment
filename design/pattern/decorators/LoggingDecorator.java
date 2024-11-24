package design.pattern.decorators;

import java.util.logging.Logger;

import org.openqa.selenium.WebElement;

public class LoggingDecorator implements WebElementActions {
	
	private WebElementActions actions;
	
	private static final Logger logger = Logger.getLogger(LoggingDecorator.class.getName());
	
	public LoggingDecorator(WebElementActions actions) {
		this.actions = actions;
	}

	@Override
	public void click(WebElement ele) {
		logger.info("element is going to be clicked");
		actions.click(ele);
		logger.info("element is clicked");
		
	}


	@Override
	public void sendKeys(WebElement ele, CharSequence text) {
		logger.info("text to be passed in the element");
		actions.sendKeys(ele,text);
		logger.info("text is passed");
		
	}

}
