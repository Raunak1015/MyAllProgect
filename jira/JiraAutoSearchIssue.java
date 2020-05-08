package jira;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JiraAutoSearchIssue {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\computer\\Downloads\\Selenium_Naveen\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
		 //WebDriver driver = new FirefoxDriver(capabilities);
		driver.get("https://id.atlassian.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ite.03garg@gmail.com");
		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
		driver.findElement(By.id("password")).sendKeys("Test#15jan");
		driver.findElement(By.cssSelector("#login-submit > span > span > span")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h5[text()='Genpact']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Genpact')]")).click();
		driver.navigate().refresh();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[contains(text(),'All issues')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[contains(text(),'Advanced search')]")).click();
		driver.findElement(By.xpath("//textarea[@id='advanced-search']")).clear();
		driver.findElement(By.xpath("//textarea[@id='advanced-search']")).sendKeys("project = GEN AND labels in (UserStory, Requirement, HLD_Issue, Enhancement) AND (assignee in (EMPTY) OR assignee not in (5e8d65421008ef0b7ee4d0f5, 5eabd09da4c57d0b8be779df))");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		driver.navigate().refresh();
		Thread.sleep(10000);
		for(int i=0;i<3;i++)
		{
			try
			{
			driver.findElement(By.xpath("//a[contains(text(),'Scenario 8')]")).click();
			break;
		}
			catch(Exception e){
				System.out.println(e.getMessage());
				
			}
		}
		
		String Status=driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).getText();
		if(Status.equals("Unassigned"))
		{
			System.out.println("doen");
			driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
			System.out.println("done2	");
			Thread.sleep(5000);
			WebElement webl = driver.findElement(By.xpath("//div[@data-test-id='issue.views.field.user.assignee']//button[@aria-label='Edit Assignee']"));
			webl.click();
			Thread.sleep(2000);
			webl.clear();
			webl.sendKeys("Ite garg");
			webl.sendKeys(Keys.ENTER);
//			  JavascriptExecutor js = (JavascriptExecutor)driver;
//			  js.executeAsyncScript("arguments[0].value='Ite garg'", webl);


		}
		Thread.sleep(1000);
	}

}
