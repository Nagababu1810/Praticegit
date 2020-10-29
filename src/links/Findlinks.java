package links;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Findlinks {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		//find all links
		System.out.println(driver.findElements(By.tagName("a")).size());
	
		//findout bootm links
		WebElement bottomlinks=driver.findElement(By.id("gf-BIG"));
		
		 System.out.println(bottomlinks.findElements(By.tagName("a")).size());
		
		//findout particular column links
		 WebElement collinks=driver.findElement(By.xpath("*//table/tbody/tr/td[1]/ul"));
		System.out.println(collinks.findElements(By.tagName("a")).size());
		
		
		 
		 for(int i=1;i<=collinks.findElements(By.tagName("a")).size();i++) {
			 
			// collinks.findElements(By.tagName("a")).size().get(i).click();
			 
			 //Thread.sleep(3000);
			String clickonlinktab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			// driver.navigate().back();
			collinks.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			
			Thread.sleep(5000);
			 }
		 //open all the tabs read each window title
		Set<String> abc= driver.getWindowHandles();
		 
		 Iterator <String> it=abc.iterator();
		 while(it.hasNext()) {
			 
			 driver.switchTo().window(it.next());
			 System.out.println(driver.getTitle());
		 }
		 
		 
		 
		
	}

}
