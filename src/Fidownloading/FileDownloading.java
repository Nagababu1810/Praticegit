package Fidownloading;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileDownloading {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver","E:\\SeleniumResource\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.pdf2go.com/pdf-to-word");
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("[id*='fileUploadButton']")).click();
		
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\Nag\\Documents\\fileupload.exe");
		System.out.println("file uploaded successful");
		
		Wait <WebDriver>  wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(("//*[@id=\"page_function_container\"]/div[1]/button/strong"))));
		driver.findElement(By.xpath("//*[@id=\"page_function_container\"]/div[1]/button/strong")).click();
		System.out.println("successful download");
		

	}

}
