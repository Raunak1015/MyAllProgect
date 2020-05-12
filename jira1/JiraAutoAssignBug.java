package jira;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class JiraAutoAssignBug {
public static void main(String[] args) throws InterruptedException, FilloException {
		
		List<String> Assignee=new ArrayList<>();

		Fillo file=new Fillo();
		Connection connection=file.getConnection("D:\\New.xlsx");		
		String strQuery="Select Assignee from Test_Scenarios_NEW where Status='Deferred' and Label='Requirement'";
		Recordset rs=connection.executeQuery(strQuery);
		System.out.println("Total Row Count="+rs.getCount());
		while(rs.next())
		{
			System.out.println("Assignee Name--"+rs.getField("Assignee"));
			Assignee.add(rs.getField("Assignee"));
		}
		rs.close();
		connection.close();
		String NewAssignee=Assignee.get(0);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\computer\\Downloads\\Selenium_Naveen\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 driver.manage().deleteAllCookies();
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
		driver.findElement(By.xpath("//textarea[@id='advanced-search']")).sendKeys("assignee in (EMPTY) ORDER BY assignee DESC, status ASC, created DESC");
		driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
		Thread.sleep(5000);
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='issuetable']//tbody/tr"));
		String beforxpath="//table[@id='issuetable']//tbody/tr[";
		String afterxpath="]/td[2]";
		for(int i=1;i<rows.size();i++)
		{
			String ActualXpath=beforxpath+i+afterxpath;
			for(int j=0;j<3;i++)
			{
				try
				{
					WebElement ele=driver.findElement(By.xpath(ActualXpath));
					System.out.println(ele.getText());
					ele.click();
					Thread.sleep(5000);
					String status=driver.findElement(By.xpath("//button[@class='elro8wh2 css-1iy307c']")).getText();
					String label=driver.findElement(By.xpath("//a[@class='styled__Link-sc-17jb35i-1 iHqNYf']")).getText();
					if(status.equalsIgnoreCase("Open") && label.equalsIgnoreCase("UserStory"))
					{
						driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
					}
					
					else if (status.equalsIgnoreCase("Resolved") && label.equalsIgnoreCase("Testing"))
					{
						driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
					}
					else if (status.equalsIgnoreCase("Open") && label.equalsIgnoreCase("Database"))
					{
						driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
					}
					else if (status.equalsIgnoreCase("Open") && label.equalsIgnoreCase("Production"))
					{
						driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
					}
					else if (status.equalsIgnoreCase("Resolved") && label.equalsIgnoreCase("None"))
					{
						driver.findElement(By.xpath("//div[contains(text(),'Unassigned')]")).click();
					}


					driver.get("https://genpactbench.atlassian.net/issues/?filter=-4&jql=assignee%20in%20(EMPTY)%20ORDER%20BY%20assignee%20DESC%2C%20status%20ASC%2C%20created%20DESC");
					Thread.sleep(5000);

				break;
			}
				catch(Exception e){
					System.out.println(e.getMessage());
					
				}
		}
		
	}

}
}
