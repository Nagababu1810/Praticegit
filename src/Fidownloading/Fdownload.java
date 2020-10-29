package Fidownloading;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Fdownload {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		driver.manage().window().maximize();
		
		
		driver.findElement(By.id("textbox")).sendKeys("Nagababu this is my file");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='createTxt']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Download")).click();
		System.out.println("file is successful dowunloaded");
		
		File f=new File("C:\\Users\\Nag\\Downloads");
		
		/*
		 * if(f.exists()) { System.out.println("file is created"); } else {
		 * System.out.println("file not executed"); f.delete(); }
		 */
		
		
		if(!f.exists())
		{
			System.out.println("file existed");
		}
		else if(f.delete()) {
				System.out.println("file deleted");
				
			
		}
	}
	
	

}
