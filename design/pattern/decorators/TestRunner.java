package design.pattern.decorators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {

	public static void main(String[] args) {
		
		WebElementActions actions = new ElementActions();
		LoggingDecorator logging = new LoggingDecorator(actions);
		RetryDecorator retry = new RetryDecorator(actions);
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://practicetest.staging.myfreshworks.dev");
		
		
		WebElement username = driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement signinbutton = driver.findElement(By.xpath("//button[@data-testid='login-button']"));
		WebElement dummy = null;
		
		retry.sendKeys(dummy, "test@test.com");
		retry.sendKeys(password, "password");
		retry.click(signinbutton);
		driver.quit();
		
		

	}

}
