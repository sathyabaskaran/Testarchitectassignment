package com.testleaf.web.element;

import java.util.logging.Logger;

public class SeButtonLoggingDecorator extends SeElementLoggingDecorator implements ButtonLoggingDecorator{
	
	private static final Logger logger = Logger.getLogger(SeButtonLoggingDecorator.class.getName());
	private Button button;
    

	public SeButtonLoggingDecorator(Button button) {
		super(button);
		this.button = button;
	}

	@Override
	public void click() {
		
			logger.info("Button is about to be clicked");
			button.click();
			logger.info("Button is clicked");
				
	}

}
