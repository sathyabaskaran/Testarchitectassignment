package com.testleaf.web.element;

import java.util.logging.Logger;

public class SeEditLoggingDecorator extends SeElementLoggingDecorator implements EditLoggingDecorator{
	
	private static final Logger logger = Logger.getLogger(SeEditLoggingDecorator.class.getName());
	private Edit edit;

	public SeEditLoggingDecorator(Edit edit) {
		super(edit);
		this.edit = edit;
	}

	@Override
	public void type(String text) {

			logger.info("text going to be enetered");
			edit.type(text);
			logger.info("text is enetered");
		
		
	}

	@Override
	public String getValue() {
		
			logger.info("value going to be returned");
			return edit.getValue();
	}

	@Override
	public void clear() {
		
		
			logger.info("text going to be cleared");
			edit.clear();
			logger.info("text is cleared");
	
	}

}
