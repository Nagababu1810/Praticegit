package clenderpicker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cleder1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Flight Booking")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("31")).click();
		

	}

}
