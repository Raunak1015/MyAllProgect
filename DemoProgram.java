package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class DemoProgram {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 //driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		
		Eyes eyes=new Eyes();
		eyes.setApiKey("RnnKWV7tcG5HtzF4bM0QiFC1ar3N6LqBBFqbqPVfcVQ110");
		try
		{
		eyes.open(driver, "Hello World!","My First Selenium Java test!",new RectangleSize(800,600));	
		driver.get("https://applitools.com/helloworld");
		eyes.checkWindow("Hello!");
		driver.findElement(By.tagName("button")).click();
		eyes.checkWindow("Click!");
		eyes.close();
		}
		finally
		{
			driver.quit();
			eyes.abortIfNotClosed();
			
		}
		

	}

}