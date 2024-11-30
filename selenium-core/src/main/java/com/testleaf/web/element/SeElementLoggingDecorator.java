package com.testleaf.web.element;

import java.util.logging.Logger;

public class SeElementLoggingDecorator implements ElementLoggingDecorator{
	
	Element element;
	private static final Logger logger = Logger.getLogger(SeElementLoggingDecorator.class.getName());
	

	public SeElementLoggingDecorator(Element element) {
		super();
		this.element = element;
	}

	@Override
	public boolean isEnabled() {
		logger.info("Checking if element is enabled");
		if (element.isEnabled()) {
			logger.info("element is enabled");
			return true;
		}
		else
		{
			logger.info("element is not enabled");	
			return false;
		}
	}

	@Override
	public boolean isVisible() {
		logger.info("Checking if element is visible");
		if (element.isVisible()) {
			logger.info("element is visible");
			return true;
		}
		else
		{
			logger.info("element is not visible");	
			return false;
		}
	}

	@Override
	public String getAttribute(String attribute) {
		logger.info("Getting attribute of the element");
		 String text = element.getAttribute(attribute);
		 logger.info("Got attribute of the element");
		return text;
	}

}
