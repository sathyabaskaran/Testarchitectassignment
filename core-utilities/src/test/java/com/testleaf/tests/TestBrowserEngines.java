package com.testleaf.tests;

import com.testleaf.constants.BrowserTestEngine;
import com.testleaf.constants.BrowserType;
import com.testleaf.constants.LocatorType;
import com.testleaf.drivers.manager.ButtonDecoratorFactory;
import com.testleaf.drivers.manager.DriverManager;
import com.testleaf.drivers.manager.EditDecoratorFactory;
import com.testleaf.drivers.manager.LinkDecoratorFactory;
import com.testleaf.web.api.APIClient;
import com.testleaf.web.api.ResponseAPI;
import com.testleaf.web.browser.Browser;
import com.testleaf.web.element.Button;
import com.testleaf.web.element.Edit;
import com.testleaf.web.element.Link;



import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestBrowserEngines {
	
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		// Get the browser
		Browser browser = DriverManager.getBrowser(BrowserTestEngine.PLAYWRIGHT,BrowserType.CHROME);
		APIClient api = (APIClient) browser;
		
				
		// load the url
		browser.navigateTo("http://leaftaps.com/opentaps");
		
		// Find the user name and enter
		Edit username = browser.locateEdit(LocatorType.ID, "username");
		Edit logging = EditDecoratorFactory.createLoggingDecorator(browser, username);
		logging.type("demosalesmanager");
		//username.type("demosalesmanager");
		
		// Find the password and enter
		Edit password = browser.locateEdit(LocatorType.ID, "password");
		logging = EditDecoratorFactory.createLoggingDecorator(browser, password);
		logging.type("crmsfa");
		//password.type("crmsfa");
		
		// Find the login button and click
		Button login = browser.locateButton(LocatorType.CLASS, "decorativeSubmit");
		Button loggingbutton = ButtonDecoratorFactory.createLoggingDecorator(browser, login);
		loggingbutton.click();
		//login.click();
		
		// Print the title
		String title = browser.getTitle();
		System.out.println("The title is "+title);
		
		// Click CRMSFA
		Link crmsfaLink = browser.locateLink(LocatorType.XPATH, "//div[@class='crmsfa']//img");
		Link logginglink = LinkDecoratorFactory.createLoggingDecorator(browser, crmsfaLink);
		logginglink.click();
		//crmsfaLink.click();
		
		// Click on Create lead link
		Link createLeadLink = browser.locateLink(LocatorType.XPATH, "//a[contains(text(),'Create Lead')]");
		 logginglink = LinkDecoratorFactory.createLoggingDecorator(browser, createLeadLink);
		logginglink.click();
		//createLeadLink.click();
		
		// Get the company name, first name and last name from API (test data >> Mockaroo)
		// https://api.mockaroo.com/api/5cd160c0?count=1&key=1b952600
		ResponseAPI responseAPI = api.get("https://api.mockaroo.com/api/5cd160c0?count=1&key=1b952600");
		
		System.out.println(responseAPI.getStatusCode());
		ObjectMapper objectMapper = new ObjectMapper();
		 Map<String, String> testdata = objectMapper.readValue(responseAPI.getBody(), Map.class);
		 System.out.println(testdata.get("company_name"));
		
		
		// Find the Company name and enter
		Edit companyName = browser.locateEdit(LocatorType.ID, "createLeadForm_companyName");
		logging = EditDecoratorFactory.createLoggingDecorator(browser, companyName);
		logging.type(testdata.get("company_name"));
		//companyName.type(testdata.get("company_name"));
		
		// Find the First name and enter
		Edit firstName = browser.locateEdit(LocatorType.ID, "createLeadForm_firstName");
		logging = EditDecoratorFactory.createLoggingDecorator(browser, firstName);
		logging.type(testdata.get("first_name"));
		//firstName.type(testdata.get("first_name"));
		
		// Find the Last name and enter
		Edit lastName = browser.locateEdit(LocatorType.ID, "createLeadForm_lastName");
		logging = EditDecoratorFactory.createLoggingDecorator(browser, lastName);
		logging.type(testdata.get("last_name"));
		//lastName.type(testdata.get("last_name"));
		
		// Close the browser
		browser.closeBrowser();
		
	}

}
