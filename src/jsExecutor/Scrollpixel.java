package jsExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollpixel {

	public static void main(String[] args) throws InterruptedException {
		
		

		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();

		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("scrollBy(0,2500)");
		System.out.println("scrolling the down side");
		
		Thread.sleep(3000);
		
		js.executeScript("scrollBy(1000,0)");
		System.out.println("scrolling up side");
		
		
	}

}
