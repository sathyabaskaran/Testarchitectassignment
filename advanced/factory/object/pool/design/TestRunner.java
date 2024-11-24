package advanced.factory.object.pool.design;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestRunner {
	
	private static BrowserFactory browserfactory = new BrowserFactory();
	private static Driverpool driverpool = new Driverpool(browserfactory);
	private static final Logger logger = Logger.getLogger(TestRunner.class.getName());

	public static void main(String[] args) {
	
		
		test1();
		test2();
		test3();
		test4();
		test5();
		driverpool.quitAllDrivers();
		
		
		

	}
	
	public static  void test1()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = driverpool.getDriver(BrowserType.CHROME, options);
		logger.info("returned driver is :"+driver.hashCode());
		driver.get("https://google.com");
		driverpool.releaseDriver(driver);
		
	}
	
	public static  void test2()
	{
		ChromeOptions options2 = new ChromeOptions();
		options2.addArguments("--headless");
		WebDriver driver = driverpool.getDriver(BrowserType.CHROME, options2);
		logger.info("returned driver is :"+driver.hashCode());
		driver.get("https://amazon.com");
		driverpool.releaseDriver(driver);
		
	}
	
	
	public static  void test3()
	{
		FirefoxOptions options3 = new FirefoxOptions();
		options3.addArguments("--headless");
		WebDriver driver = driverpool.getDriver(BrowserType.FIREFOX, options3);
		logger.info("returned driver is :"+driver.hashCode());
		driver.get("https://google.com");
		driverpool.releaseDriver(driver);
		
	}
	
	public static  void test4()
	{
		FirefoxOptions options4 = new FirefoxOptions();
		options4.addArguments("--headless");
		WebDriver driver = driverpool.getDriver(BrowserType.FIREFOX, options4);
		logger.info("returned driver is :"+driver.hashCode());
		driver.get("https://amazon.com");
		driverpool.releaseDriver(driver);
		
	}
	
	public static  void test5()
	{
		ChromeOptions options5 = new ChromeOptions();
		options5.addArguments("--incognito");
		WebDriver driver = driverpool.getDriver(BrowserType.CHROME, options5);
		logger.info("returned driver is :"+driver.hashCode());
		driver.get("https://amazon.com");
		driverpool.releaseDriver(driver);
		
	}

}
