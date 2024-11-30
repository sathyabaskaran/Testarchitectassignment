package com.testleaf.web.browser;

public interface WebDriverProvider {
	
	public Object createDriver();
	public Object returnDriver();
	public void releaseDriver(Object driver);
	public void close();

}
