package jsExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zoom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\Chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		
		//ZoomIn and ZoomOut
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 System.out.println("Successful started");
		 js.executeScript("document.body.style.zoom='200';");
		 
		 Thread.sleep(5000);
		 js.executeScript("document.body.style.zoom='50';");
		 Thread.sleep(3000);
		 js.executeScript("document.body.style.zoom='100';");
		 Thread.sleep(3000);
		 System.out.println("successful ended");
		 driver.close();
		 
	}

}
