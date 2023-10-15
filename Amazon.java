import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws Throwable {
			WebDriver driver;
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
				
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]")).sendKeys("Mobiles");
			driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
			String parent = driver.getWindowHandle();
			driver.findElement(By.xpath("//span[text()='Redmi Note 12 (Ice Blue, 6GB RAM, 64GB Storage)']")).click();
			Set<String> child = driver.getWindowHandles();
			for(String b:child) {
				driver.switchTo().window(b);
			}
			WebElement price = driver.findElement(By.xpath("//span[@id='productTitle']/ancestor:://span[text()='11,998'])[5]"));
			System.out.println(price.getText());
			Thread.sleep(2000);
			driver.quit();
			}
				
}
