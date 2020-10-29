package Fileuploading;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileuploadingAutoit {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.pdf2go.com/pdf-to-word");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("[id*='fileUploadButton']")).click();
		
		Runtime.getRuntime().exec("C:\\Users\\Nag\\Documents\\fileupload.exe");
		System.out.println("file uploaded successful");
		
		
		
		
	}

}
