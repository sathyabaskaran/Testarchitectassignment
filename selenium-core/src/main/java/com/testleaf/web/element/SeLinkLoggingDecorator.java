package com.testleaf.web.element;

import java.util.logging.Logger;

public class SeLinkLoggingDecorator extends SeElementLoggingDecorator implements LinkLoggingDecorator{
	
	

    private Link link;
    private Logger logger = Logger.getLogger(SeLinkLoggingDecorator.class.getName());
    
	public SeLinkLoggingDecorator(Link link) {
		super(link);
		this.link = link;
	}

	@Override
	public void click() {
		logger.info("link  is about to be clicked");
		link.click();
		logger.info("link is clicked");
		
	}

	@Override
	public String getText() {
		logger.info("getting text from the link");
		String text = link.getText();
		logger.info("got text from the link");
		return text;
	}

	@Override
	public String getHref() {
		logger.info("getting href from the link");
		String href = link.getHref();
		logger.info("got href from the link");
		return href;
	}

}
 