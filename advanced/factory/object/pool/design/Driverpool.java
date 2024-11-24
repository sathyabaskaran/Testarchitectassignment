package advanced.factory.object.pool.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class Driverpool {
	
	private static final Logger logger = Logger.getLogger(Driverpool.class.getName());
	
	private BrowserFactory browserfactory;
	private ConcurrentMap<Map<BrowserType, List<String>>, BlockingQueue<WebDriver>> poolMap = new ConcurrentHashMap<>();
	private ConcurrentMap<WebDriver,Map<BrowserType, List<String>>> poolmapcopy = new ConcurrentHashMap<>();
	
	public Driverpool(BrowserFactory browserfactory) {
		this.browserfactory = browserfactory;
	}
	
	private Map<BrowserType, List<String>> sortedCapabilities(BrowserType browsertype,Capabilities option){
		
         List<String> sortedcaps = new ArrayList<String>();
		 option.asMap().forEach((key,value)->sortedcaps.add(key + "" + value));
		 Collections.sort(sortedcaps);
		
		Map<BrowserType,List<String>> sortedMap = new HashMap<>();
		sortedMap.put(browsertype,sortedcaps);
		
		return sortedMap;
		
	}
	
	
	public WebDriver getDriver(BrowserType browsertype,Capabilities option) {
		
		Map<BrowserType,List<String>> sortedMap = sortedCapabilities(browsertype,option);
		
		poolMap.putIfAbsent(sortedMap, new LinkedBlockingQueue<>());
		Queue<WebDriver> pool = poolMap.get(sortedMap);
		
		if(!pool.isEmpty())
		{
			return pool.poll();
		}
		else
		{
			WebDriver driver = browserfactory.switchBrowser(browsertype, option);
			poolmapcopy.put(driver,sortedMap);
			return driver;
		}
	}
	
	public void releaseDriver(WebDriver driver) {
		
		Map<BrowserType, List<String>> tempmap = poolmapcopy.get(driver);
		Queue<WebDriver> pool = poolMap.get(tempmap);
		pool.offer(driver);
		for(Entry<Map<BrowserType, List<String>>, BlockingQueue<WebDriver>> entry : poolMap.entrySet()) {
			
			logger.info("key : " + entry.getKey());
			logger.info("key : " + entry.getValue());
		}
	}
	
	public void quitAllDrivers()
	{
		for(Queue<WebDriver> drivers : poolMap.values())
		{
			while(!drivers.isEmpty())
			{
				for(WebDriver driver :drivers)
				{
					logger.info("driver in final pool :" + driver.hashCode());
					logger.info("driver is quitting" + drivers.poll().hashCode());
					driver.quit();
					logger.info("driver quit completed");
					
				}
					
			}
		}
	}
	
	

}
